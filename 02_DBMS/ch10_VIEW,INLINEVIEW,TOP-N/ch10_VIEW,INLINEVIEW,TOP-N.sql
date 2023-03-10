-- [X] View, In-Line View, TOP-N

-- ① VIEW : 가상의 테이블 (1)단순뷰 (2)복합뷰
-- 1)단순뷰 : 하나의 테이블을 이용하여 만든 뷰
-- 물리적인 저장공간과 데이터를 가지는 테이블
DROP TABLE EMP1;
CREATE TABLE EMP1 AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP;
SELECT * FROM EMP1;
INSERT INTO EMP1 (EMPNO, ENAME, JOB, DEPTNO) VALUES (1111,'홍', 'ITMANAGER',40);
SELECT * FROM EMP1 WHERE EMPNO=1111;
SELECT * FROM EMP WHERE EMPNO=1111;
SELECT * FROM USER_TABLES WHERE TABLE_NAME LIKE 'EMP%';
DROP TABLE EMP1;

-- 가상의 테이블 : 물리적인 저장공간과 데이터가 없다
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP;
SELECT * FROM EMPv0;
SELECT * FROM USER_TABLES WHERE TABLE_NAME LIKE 'EMP%'; -- EMPv0은 없음
SELECT * FROM USER_VIEWS;
DROP VIEW EMPv0;

    -- ex. EMP테이블의 EMPNO, ENAME, JOB, DEPTNO 필드만 가상의 테이블 뷰, EMPv0
    CREATE OR REPLACE VIEW EMPv0
        AS SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP;
      INSERT INTO EMPv0 VALUES (1111, '홍', 'ITMANAGER', 40); -- 뷰에 INSERT
      SELECT * FROM EMPv0;
      SELECT * FROM EMP WHERE EMPNO=1111;
      UPDATE EMPv0 SET JOB='ANALYST' WHERE EMPNO=1111; -- 뷰 UPDATE
      SELECT * FROM EMP WHERE EMPNO=1111;
      DELETE FROM EMPv0 WHERE EMPNO=1111; -- 뷰 DELETE
      SELECT * FROM EMP WHERE EMPNO=1111;
  
    -- EMPv0이라는 VIEW = EMP의 30번 부서만
    CREATE OR REPLACE VIEW EMPv0
        AS SELECT * FROM EMP WHERE DEPTNO=30;
    SELECT * FROM USER_VIEWS;
    SELECT * FROM EMPv0;
    INSERT INTO EMPv0 VALUES (1111,'홍',NULL, NULL, SYSDATE, NULL, NULL, 40); -- 가능
    SELECT * FROM EMPv0;
    SELECT * FROM EMP;
    INSERT INTO EMPv0 VALUES (1112,'홍',NULL, NULL, SYSDATE, NULL, NULL, 30); -- SELECT 보임
    SELECT * FROM EMPv0;
    SELECT * FROM EMP WHERE EMPNO<1113;
    DELETE FROM EMPv0 WHERE EMPNO<1113; -- 30번부서의 WHERE조건이 만족하는 행만 DELETE
  
    -- 단순뷰에서 INSERT 불가한 경우 : 뷰생성시 NOT NULL 필드를 미포함한 경우
    CREATE OR REPLACE VIEW EMPv0 AS SELECT ENAME, JOB FROM EMP;
    INSERT INTO EMPv0 VALUES ('홍', 'MANAGER');
    DELETE FROM EMP WHERE EMPNO<1113;
    COMMIT;
    SELECT * FROM EMP;

-- VIEW의 제한조건
-- WITH CHECK OPTION 추가 : 뷰의 조건에 해당되는 데이터만 삽입, 수정, 삭제가 가능
-- WITH READ ONLY 추가 : 읽기 전용 뷰

    -- ex. emp테이블의 30번 부서의 가상의 테이블(30번만 INSERT 가능)
    CREATE OR REPLACE VIEW EMPv0
        AS SELECT * FROM EMP WHERE DEPTNO=30
        WITH CHECK OPTION;
    INSERT INTO EMPv0 (EMPNO, ENAME, DEPTNO) VALUES (1111, '홍', 30);
    INSERT INTO EMPv0 (EMPNO, ENAME, DEPTNO) VALUES (1112, '홍', 40); -- 제한조건으로 에러
    SELECT * FROM EMP WHERE ENAME='SMITH'; -- 20번 부서 사원
    DELETE FROM EMPv0 WHERE ENAME='SMITH';

    -- READ ONLY
    CREATE OR REPLACE VIEW EMPv0
        AS SELECT * FROM EMP WHERE DEPTNO=20 WITH READ ONLY;
    INSERT INTO EMPv0 (EMPNO, ENAME, DEPTNO) VALUES (1113, '홍', 20); -- READ ONLY라 에러

-- 2) 복합뷰 : 2개 이상의 테이블로 구성한 뷰, 가상의 필드를 이용한 경우. DML문을 제한적으로만 사용

-- 1. 2개 이상의 테이블를 이용한 복합뷰
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, DNAME FROM DEPT D, EMP E WHERE E.DEPTNO=D.DEPTNO;
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES (1112, 'HONG', 'MANAGER', 'SALES');
-- 2. 가상의 필드를 이용한 뷰 (컬럼에 별칭을 사용)
CREATE OR REPLACE VIEW EMPv0
  AS SELECT EMPNO, ENAME, SAL*12 YEAR_SAL FROM EMP WHERE DEPTNO=10; -- 별칭을 필드에
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES (1113, 'HONG', 12000);

CREATE OR REPLACE VIEW EMPv0 (EMPNO, ENAME, YEAR_SAL) -- 별칭만 따로
  AS SELECT EMPNO, ENAME, SAL*12 FROM EMP WHERE DEPTNO=10;

    -- ex1. 사번, 이름, 급여, 10의 자리에서 반올림한 급여를 뷰로 생성(EMPv0)
    CREATE OR REPLACE VIEW EMPv0
        AS SELECT EMPNO, ENAME, SAL, ROUND(SAL, -2) ROUNDSAL FROM EMP;
    SELECT * FROM EMPv0;
    INSERT INTO EMPv0 VALUES (1114, 'KIM', 1800, 2000); -- 복합 INSERT 불가
  
     -- ex2. 중복이 제거된 job, deptno를 뷰로 생성(EMPv0)
    CREATE OR REPLACE VIEW EMPv0
        AS SELECT DISTINCT JOB, DEPTNO FROM EMP;
  
    -- ex3. 부서번호, 최소급여, 최대급여, 부서평균급여를 포함한 EMPv0 뷰를 생성
    CREATE OR REPLACE VIEW EMPv0 (DNO, MINSAL, MAXSAL, AVGSAL)
        AS SELECT DEPTNO, MIN(SAL), MAX(SAL), AVG(SAL) FROM EMP GROUP BY DEPTNO;
    SELECT * FROM EMPv0;
  
    -- 부서명, 최소급여, 최대급여, 평균급여를 포함함 DEPTv0 뷰를 생성
    CREATE OR REPLACE VIEW DEPTv0 (DNAME, MINSAL, MAXSAL, AVGSAL)
        AS SELECT DNAME, MIN(SAL), MAX(SAL), AVG(SAL)
            FROM EMP E, DEPT D
            WHERE E.DEPTNO=D.DEPTNO
            GROUP BY DNAME;
    SELECT * FROM DEPTv0;
  
--------------------------------------------------------------------------------
-- ② inline-view : FROM절의 서브쿼리를 INLINE VIEW라 하며, FROM 절에 오는 서브쿼리는 VIEW 작용

    -- ex. 급여가 2000을 초과하는 사원의 평균 급여
    SELECT AVG(SAL) FROM EMP WHERE SAL>2000;
    SELECT AVG(SAL) FROM (SELECT SAL FROM EMP WHERE SAL>2000);
    -- ex. 부서 평균 월급보다 월급이 높은 사원을 사번, 이름, 급여, 부서번호, 해당부서의 평균(반올림)
    SELECT EMPNO, ENAME, E.DEPTNO, ROUND(AVGSAL)
        FROM EMP E, (SELECT DEPTNO, AVG(SAL) AVGSAL FROM EMP GROUP BY DEPTNO) A
        WHERE E.DEPTNO=A.DEPTNO AND SAL>AVGSAL;
    -- INLINE VIEW 문법
    -- SELECT 필드1, 필드2, ...
    --    FROM 테이블1, (서브쿼리) 별칭
    --    WHERE 조인조건

--------------------------------------------------------------------------------
-- ③ TOP-N 구문 (TOP 1~10등, 11~20등, ..)
-- 함수를 이용한 RANK 출력(1~꼴등)
SELECT ENAME, RANK() OVER(ORDER BY SAL DESC) RANK,
        DENSE_RANK() OVER(ORDER BY SAL DESC) DENSE_RANK,
        ROW_NUMBER() OVER(ORDER BY SAL DESC) ROW_NUMBER
        FROM EMP;
        
-- ROWNUM(테이블로부터 가져온 순서)과 INLINE-VIEW를 이용한 TOP-N
SELECT ROWNUM, ENAME FROM EMP WHERE DEPTNO=20;
SELECT ROWNUM, ENAME, SAL FROM EMP;
SELECT ROWNUM, ENAME, SAL   -- 2
    FROM EMP                -- 1
    ORDER BY SAL;           -- 3.
SELECT ROWNUM RK, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL); -- 1등 ~ 꼴찌

    -- SAL을 기준으로 1등 ~ 5등
SELECT ROWNUM RK, A.*
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL) A
    WHERE ROWNUM < 6;
    -- SAL을 기준으로 6등 ~ 10등
SELECT ROWNUM RK, ENAME, SAL
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL)
    WHERE ROWNUM BETWEEN 6 AND 10;

-- ■ TOP-N 구문
SELECT * FROM EMP ORDER BY SAL; -- 1단계

SELECT ROWNUM RN, A.*
    FROM (SELECT * FROM EMP ORDER BY SAL) A; -- 2단계
  
SELECT ROWNUM, B.*
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT * FROM EMP ORDER BY SAL) A) B
    WHERE RN BETWEEN 6 AND 10;  -- 3단계 (TOP-N)
  
    -- ex. 이름을 알파벳 순서대로 정렬해서 6번째부터 10번째 출력
        -- 순서, 이름, 사번, JOB, MGR, HIREDATE
SELECT ROWNUM RN, ENAME, EMPNO, JOB, MGR, HIREDATE 
    FROM (SELECT * FROM EMP ORDER BY ENAME);
  
SELECT *
    FROM (SELECT ROWNUM RN, ENAME, EMPNO, JOB, MGR, HIREDATE 
        FROM (SELECT * FROM EMP ORDER BY ENAME))
    WHERE RN BETWEEN 6 AND 10;
    
    -- ex. 입사 순으로 11번째부터 15번째인 사원의 모든 필드를 출력
SELECT ROWNUM RN, A.*
    FROM(SELECT * FROM EMP ORDER BY HIREDATE);
    
SELECT B.*
    FROM (SELECT ROWNUM RN, A.*
    FROM(SELECT * FROM EMP ORDER BY HIREDATE) A) B 
    WHERE RN BETWEEN 11 AND 15;


-- QUIZ

-- 1. 부서명과 사원명을 출력하는 용도의 뷰, DNAME_ENAME_VU 를 작성하시오
CREATE OR REPLACE VIEW DNAME_ENAME_VU
    AS SELECT DNAME, ENAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO;
        
SELECT * FROM DNAME_ENAME_VU;

-- 2. 사원명과 직속상관명을 출력하는 용도의 뷰, WORKER_MANAGER_VU를 작성하시오
CREATE OR REPLACE VIEW WORKER_MANAGER_VU
    AS SELECT W.ENAME WORKER, M.ENAME MANAGER FROM EMP W, EMP M
        WHERE W.MGR = M.EMPNO;
        
SELECT * FROM WORKER_MANAGER_VU;

-- 3. 부서별 급여합계 등수를 출력하시오(부서번호, 급여합계, 등수)
SELECT ROWNUM RN, DEPTNO, SUMSAL
    FROM (SELECT DEPTNO, SUM(SAL) SUMSAL FROM EMP GROUP BY DEPTNO);
    
-- 3_1. 부서별 급여합계 등수가 2~3등인 부서번호, 급여합계, 등수를 출력하시오.
SELECT *
    FROM (SELECT ROWNUM RN, DEPTNO, SUMSAL
        FROM (SELECT DEPTNO, SUM(SAL) SUMSAL FROM EMP GROUP BY DEPTNO))
    WHERE RN BETWEEN 2 AND 3;

-- 4. 사원테이블에서 사번, 사원명, 입사일을 입사일이 최신에서 오래된 사원 순으로 정렬하시오
SELECT *
    FROM (SELECT ROWNUM RN, EMPNO, ENAME, HIREDATE
        FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC));

-- 5. 사원테이블에서 사번, 사원명, 입사일을 입사일이 최신에서 오래된 사원 5명을 출력하시오
SELECT *
    FROM (SELECT ROWNUM RN, EMPNO, ENAME, HIREDATE
        FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC))
    WHERE RN BETWEEN 1 AND 5;

-- 6. 사원 테이블에서 사번, 사원명, 입사일을 최신부터 오래된 순으로 6번째로 늦은 사원부터 10번째 사원까지 출력
SELECT *
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC) A)
    WHERE RN BETWEEN 6 AND 10;

  