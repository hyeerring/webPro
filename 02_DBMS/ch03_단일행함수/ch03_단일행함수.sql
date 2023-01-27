-- [ IV ] 단일행함수
-- 함수 = 단일행함수 + 그룹함수(집계함수)
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YYYY-MM-DD') FROM EMP; -- 단일행 단일행 적용
SELECT ENAME, INITCAP(ENAME) FROM EMP; -- 단일행함수(INPUT 1행 -> OUTPUT 1행)
SELECT SUM(SAL), AVG(SAL) FROM EMP; -- 그룹함수(INPUT n행 -> OUTPUT 1행)
SELECT DEPTNO, AVG(SAL) FROM EMP GROUP BY DEPTNO;-- 그룹함수(INPUT n행 -> OUTPUT 1행)

-- ★ 단일행함수의 종류 : 숫자관련함수, 문자관련함수, 날짜관련함수, 형변환함수, NVL(), ETC...
-- 1. 숫자관련함수 
    -- DUAL테이블 : 오라클에서 제공한 1행1열짜리 DUMMY TABLE
SELECT * FROM DUAL;
DESC DUAL;
SELECT * FROM DUMMY;
DESC DUMMY;
SELECT ABS(-1) FROM DUMMY; -- 절대값
SELECT FLOOR(34.5678) FROM DUAL; -- 소수점에서 내림(버림)
SELECT FLOOR(34.5678*100)/100 FROM DUAL; -- 소수점 두번째 자리에서 내림(버림)
SELECT TRUNC(34.5678, 2) FROM DUAL; -- 소수점 두번째 자리에서 내림(버림)
SELECT TRUNC(34.5678) FROM DUAL;    -- 소수점에서 내림(버림)
SELECT TRUNC(34.5678, -1) FROM DUAL; -- 일의 자리에서 내림(버림)
    -- ex. EMP테이블에서 이름, 급여(십의 자리에서 내림)
SELECT ENAME, SAL, TRUNC(SAL, -2) FROM EMP;
SELECT CEIL(34.5678) FROM DUAL; -- 소수점에서 올림

SELECT ROUND(34.5678) FROM DUAL; -- 소수점에서 반올림
SELECT ROUND(34.5678, 2) FROM DUAL; -- 소수점 두번째 자리까지 나오도록 반올림
SELECT ROUND(34.5678, -1) FROM DUAL;   -- 일의 자리에서 반올림

SELECT MOD(9,2) FROM DUAL; -- 나머지 연산자 (9%2)
    -- ex. 홀수년도에 입사한 사원의 모든 정보 출력
SELECT * FROM EMP WHERE MOD(TO_CHAR(HIREDATE, 'RR'), 2) = 1;

-- 2. 문자관련함수 
-- ① 대소문자 관련
SELECT INITCAP('WELCOME TO ORACLE') FROM DUAL; -- 첫문자만 대문로
SELECT INITCAP('welcome to oracle') FROM DUAL;
SELECT UPPER('ABCabc') FROM DUAL; -- 대문자로
SELECT LOWER('ABCabc') FROM DUAL; -- 소문자로
    -- ex. 이름이 SCOTT 인 직원의 모든 필드
SELECT * FROM EMP WHERE UPPER(ENAME)='SCOTT';
SELECT * FROM EMP WHERE INITCAP(ENAME)='Scott';
    -- ex. job이 MANAGER 인 직원의 모든 필드
SELECT * FROM EMP WHERE UPPER(JOB) = 'MANAGER';
SELECT * FROM EMP WHERE INITCAP(JOB) = 'Manager';
SELECT * FROM EMP WHERE LOWER(JOB) = 'manager';

-- ② 문자연결(concat함수, ||연산자)
SELECT 'AB'||'CD'||'EF'||'GH' FROM DUAL;
SELECT CONCAT(CONCAT('AB','CD'), CONCAT('EF','GH')) FROM DUAL;
    -- ex. SMITH는 manager다
SELECT CONCAT(CONCAT(ENAME, '는 '), CONCAT(JOB, '다')) FROM EMP;
SELECT ENAME || '는 ' || JOB || '다' FROM EMP;

-- ③ SUBSTR(STR, 시작위치, 문자갯수) : STR을 시작위치부터 문자갯수만큼 문자 추출
                    -- (시작위치가 1부터, 시작위치가 음수이면 끝부터 자리수를 셉니다)
  -- SUBSTRB(STR, 시작바이트위치, 문자바이트수)
SELECT SUBSTR('ORACLE', 3, 2) FROM DUAL; -- 3번째 글자부터 2글자 추출
SELECT SUBSTRB('ORACLE', 3, 2) FROM DUAL;-- 3번째 바이트부터 2바이트 추출
SELECT SUBSTR('데이터베이스', 4, 3) FROM DUAL; -- 4번째 글자부터 3글자 추출(베이스)
SELECT SUBSTRB('데이터베이스', 4, 3) FROM DUAL;-- 4번째 바이트부터 3바이트 추출(이)
    -- O R A C L E
    -- 1 2 3 4 5 6(위치)
    ---6-5-4-3-2-1(위치)
SELECT SUBSTR('WELCOME TO ORACLE', -1, 1) FROM DUAL; -- -1번째 글자부터 한글자 추출
SELECT SUBSTR('ORACLE', -2, 2) FROM DUAL; -- 마지막 글자 2글자 추출
SELECT SUBSTR(123, 2, 1) FROM DUAL; -- 숫자도 가능(숫자를 문자로 바꿔 2번째 부터 1글자 추출)
    -- ex. 9월에 입사한 사원의 모든 필드 'RR/MM/DD'
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 4, 2)='09'; -- DATE형도 가능
SELECT * FROM EMP WHERE SUBSTR(TO_CHAR(HIREDATE,'RR/MM/DD'), 4, 2)='09';
    -- ex. 9일에 입사한 사원의 모든 필드 'RR/MM/DD'
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, -2, 2) = '09';
SELECT * FROM EMP WHERE SUBSTR(TO_CHAR(HIREDATE,'RR/MM/DD'), -2, 2) = '09';

-- ④ LENGTH(STR) : STR의 글자수
   -- LENGTHB(STR) : STR의 바이트 수
SELECT LENGTH('ABCD') FROM DUAL; -- 글자수
SELECT LENGTHB('ABCD') FROM DUAL; -- 바이트수
SELECT LENGTH('오라클') FROM DUAL; -- 결과 : 3
SELECT LENGTHB('오라클') FROM DUAL; -- 결과 : 9

-- ⑤ INSTR(STR, 찾을문자) : STR에서 첫번째 문자부터 찾을문자가 나오는 위치(없으면 0)
  --  INSTR(STR, 찾을문자, 시작위치) : STR에서 시작위치 문자부터 찾을문자가 나오는 위치
SELECT INSTR('ABCABC', 'B') FROM DUAL; -- 처음부터 찾아서 처음나오는 B의 위치 : 2
SELECT INSTR('ABCABC', 'B', 3) FROM DUAL; --3번째문자부터 찾아서 처음 나오는 B의 위치 : 5
SELECT INSTR('ABCABC', 'B', -3) FROM DUAL;--뒤3번째부터 뒤로 찾아 처음 나오는 B의 위치 : 2
SELECT INSTR('ABCABCABC', 'B', -3) FROM DUAL; -- 뒤3번째부터 뒤로 찾아 처음 나오는 B위치 : 5
    -- 9월에 입사한 사원(INSTR이용) 'RR/MM/DD'
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 4)=4;
SELECT * FROM EMP WHERE INSTR(TO_CHAR(HIREDATE,'RR/MM/DD'), '09', 4)=4;
    -- 9일에 입사한 사원의 모든 필드(INSTR이용)
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 7) = 7;
    -- 9일 아닌 다른 날에 입사한 사원의 모든 필드(INSTR이용)
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09' ,7) = 0;

-- ⑥ LPAD(STR, 자리수, 채울문자) : STR을 자리수만큼 확보하고 왼쪽 빈자리에 채울문자로 출력
  --  LPAD(STR, 자리수) : STR을 자리수만큼 확보하고 왼쪽 빈자리에 ' '로 출력
  --  RPAD(STR, 자리수, 채울문자) : STR을 자리수만큼 확보하고 오른쪽 빈자리에 채울문자로 출력
  --  RPAD(STR, 자리수) : STR을 자리수만큼 확보하고 오른쪽 빈자리에 ' '로 출력
SELECT LPAD('ORACLE', 10, '#') FROM DUAL;
SELECT RPAD('ORACLE', 10, '*') FROM DUAL;
SELECT ENAME, SAL FROM EMP;
DESC EMP; -- 이름은 10문자까지 SAL은 5자리까지 입력 가능
SELECT RPAD(ENAME, 11, '-'), LPAD(SAL, 6, '*') FROM EMP;
     -- ex. 사번, 이름(7369 S**** / 7654 M***** / 7521 W*** ..) - SUBSTR, LENGTH, RPAD
SELECT EMPNO, RPAD(SUBSTR(ENAME, 1, 1), LENGTH(ENAME), '*') NAME
    FROM EMP;
    -- ex. 사번, 이름, 직책(9자리확보), 입사일 -- LPAD, SUBSTR, LENGTH, ||, CONCAT, ...
      -- (7369 SMITH ____****K 80/12/**)
      -- (7499 ALLEN __******N 81/02/**)
      -- (7566 JONES ___*****R 81/02/**)
SELECT EMPNO, ENAME, LPAD(LPAD(SUBSTR(JOB, -1, 1), LENGTH(JOB), '*'), 9) JOB,
        SUBSTR(HIREDATE, 1, 6) || '**'
    FROM EMP;
SELECT EMPNO, ENAME, LPAD(LPAD(SUBSTR(JOB, -1, 1), LENGTH(JOB), '*'), 9) JOB,
        RPAD(SUBSTR(HIREDATE, 1, 6), LENGTH(HIREDATE), '*')
    FROM EMP;
SELECT EMPNO, ENAME, LPAD(LPAD(SUBSTR(JOB, -1, 1), LENGTH(JOB), '*'), 9) JOB,
        TO_CHAR(HIREDATE, 'RR/MM/') || '**'
    FROM EMP;    
    
    -- ex. 이름의 세번째 자리 글자가 R인 사원의 모든 필드 출력(LIKE이용, INSTR이용, SUBSTR이용)
SELECT * FROM EMP WHERE ENAME LIKE '__R%';
SELECT * FROM EMP WHERE INSTR(ENAME, 'R', 3) = 3; -- RARA까지 출력되기 위해 3번째글자부터 검색
SELECT * FROM EMP WHERE SUBSTR(ENAME, 3, 1) = 'R'; -- RARA

-- ⑦ 여백제거 : TRIM(STR), LTRIM(STR), RTRIM(STR)
SELECT '    ORACLE   ' MSG FROM DUAL;
SELECT TRIM('   ORACLE   ') MSG FROM DUAL;
SELECT LTRIM('   ORACLE   ') MSG FROM DUAL;
SELECT RTRIM('   ORACLE   ') MSG FROM DUAL;

-- ⑧ REPLACE(STR, 바꿔야할문자, 바꿀문자) : STR에서 바꿔야할문자를 바꿀문자로 교체
SELECT REPLACE(ENAME, 'A', 'XX') FROM EMP;
SELECT REPLACE(SAL, '0', 'X') FROM EMP;
SELECT REPLACE(HIREDATE, '0', 'X') FROM EMP;

-- 3. 날짜관련함수 및 예약어
-- ① SYSDATE : 지금 / SYSTIMESTAMP
SELECT SYSDATE FROM DUAL;
SELECT SYSTIMESTAMP FROM DUAL;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD HH24:MI:SS';
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD'; -- DATE 포맷 원상 복귀
-- ② 날짜 계산 : 오라클 타입(문자, 숫자, 날짜) 중 숫자, 날짜도 연산 가능
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD HH24:MI:SS';
SELECT SYSDATE-1 어제이시간, SYSDATE, SYSDATE+1 내일이시간 FROM DUAL;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD'; -- 원상복귀
    -- ex. 반납예정일 
    SELECT SYSDATE+14 FROM DUAL;
    -- ex. 개강시점 ~ 현재까지의 몇일 지났나?
    SELECT FLOOR(SYSDATE-TO_DATE('22/11/28 09:30', 'RR/MM/DD HH24:MI')) DAY FROM DUAL;
    SELECT TRUNC(SYSDATE-TO_DATE('22/11/28 09:30', 'RR/MM/DD HH24:MI')) DAY FROM DUAL;
    -- ex. 현재 ~ 수료일까지 몇일 남았는지?
    SELECT TRUNC(TO_DATE('230512 12:20', 'RRMMDD HH24:MI')-SYSDATE) DAY FROM DUAL;
    -- ex. emp에서 이름, 입사일, 근무일수
    SELECT ENAME, HIREDATE, TRUNC(SYSDATE-HIREDATE) DAY FROM EMP;
    -- ex. 이름, 입사일, 근무일수, 근무주수, 근무년수
SELECT ENAME, HIREDATE, TRUNC(SYSDATE-HIREDATE) DAY, 
    TRUNC((SYSDATE-HIREDATE)/7) WEEK, TRUNC((SYSDATE-HIREDATE)/365) YEAR
    FROM EMP;
    
-- ③ MONTHS_BETWEEN(시점1, 시점2) : 두 시점간의 개월수(시점1을 큰 시점)
    -- ex. 이름, 입사일, 근무월수
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) MONTH FROM EMP;
    -- ex. 이름, 입사한 이후 회사에서 받은 돈(SAL은 1년에 12번, COMM은 2번)을 출력
SELECT ENAME, SAL*TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) +
    NVL(COMM,0)*2*TRUNC((SYSDATE-HIREDATE)/365) MONTH
    FROM EMP;

-- ④ ADD_MONTHS(특정 시점, 개월수) ; 특정시점부터 몇개월후
    -- ex. 이름, 입사일, 수습종료시점(수습시간 6개월)
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 6) FROM EMP;
    -- 입사일이 81/08/30이면 수습 종료시점 81/02/28
INSERT INTO EMP VALUES (9999, 'HONG', 'MANAGER', NULL, '81/08/30', NULL, NULL, 40);
ROLLBACK;

-- ⑤ NEXT_DAY(특정시점, '수') : 특정시점부터 처음 도래하는 수요일
SELECT NEXT_DAY(SYSDATE, '토') FROM DUAL;

-- ⑥ LAST_DAY(특정시점) : 특정시점의 말일(28,29,30,31)
SELECT LAST_DAY(SYSDATE) FROM DUAL;
    -- ex. 이름, 입사일, 첫월급날(월급날은 말일)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) FROM EMP;

-- ⑦ ROUND(날짜, XX) : 날짜 반올림 (xx: YEAR, MONTH, DAY)
  --  TRUNC(날짜, XX) : 날짜 버림
SELECT ROUND(34.5678, 2) FROM DUAL;
SELECT ROUND(SYSDATE, 'YEAR') FROM DUAL ; -- 결과 : 가까운 1월1일
SELECT ROUND(SYSDATE, 'MONTH') FROM DUAL; -- 결과 : 가까운 1일 (1~15일까지는 이번달1일/16일 이후는 다음달 1일)
SELECT ROUND(SYSDATE, 'DAY') FROM DUAL; -- 결과 : 가까운 일요일
SELECT ROUND(SYSDATE) FROM DUAL; -- 결과 : 가까운 0시0분
SELECT TRUNC(SYSDATE, 'YEAR') FROM DUAL; -- 같은해 1월1일
SELECT TRUNC(SYSDATE, 'MONTH') FROM DUAL; -- 같은달 1일
SELECT TRUNC(SYSDATE, 'DAY') FROM DUAL; -- 지난 일요일
SELECT TO_CHAR(TRUNC(SYSDATE), 'RR/MM/DD HH24:MI') FROM DUAL; -- 오늘 0시0분
    -- ex1. 이름, 입사일, 첫월급날(11일) : 10일이전:이번달11 / 11일이후면 다음달11
                       -- ROUND의 기준은 15,16을 10,11로 
SELECT ENAME, HIREDATE, ROUND(HIREDATE+5, 'MONTH')+10 FROM EMP; -- 월급날 11일
    -- ex2. 월급날 10일 : 9일까지는 이번달, 10일부터는 다음달
SELECT ENAME, HIREDATE, ROUND(HIREDATE+6, 'MONTH')+9 FROM EMP;
    -- ex3. 월급날 25일 : 24일까지는 이번달, 25일부터는 다음달
SELECT ENAME, HIREDATE, ROUND(HIREDATE-9, 'MONTH')+24 FROM EMP;

-- 4. 형변환 함수 (TO_CHAR:문자로 변환하는 함수, TO_DATE:날짜형으로 변환하는 함수)
-- (1) TO_CHAR(날짜형, '출력형식')
    -- YYYY 년도4자리 / RR 년도2자리 / MM 월 / DD 일 / DY 요일 
    -- HH24 / HH12 / AM이나 PM / MI 분 / SS초
    -- 출력형식에 문자를 포함할 경우 ""
SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD HH24:MI:SS') FROM EMP;
SELECT TO_CHAR(SYSDATE, 'YYYY"년"MM"월"DD"일" DY"요일" AM HH12"시"MI"분"SS"초"') FROM DUAL;
SELECT TO_CHAR(SYSTIMESTAMP, 'RR-MM-DD AM HH12:MI:SS:FF') FROM DUAL;

-- (2) TO_CHAR(숫자, '출력형식')
    -- 0 : 자릿수, 출력형식의 자릿수가 많으면 0으로 채움
    -- 9 : 자릿수, 출력형식의 자릿수가 많아도 숫자만큼만 출력
    -- , : 세자리마다 , 가능
    -- . : 소수점
    -- $ : 통화단위 $추가하고자 할 때
    -- L : 지역통화단위를 추가하고자 할 때
SELECT TO_CHAR(12345678, '000,000,000.00') FROM DUAL; -- 012,345,678
SELECT TO_CHAR(12345678, '999,999,999.99') FROM DUAL; -- 12,345,678
SELECT TO_CHAR(100.76, '999.9') FROM DUAL; -- 소수점 자리수가 부족할 경우 반올림
SELECT TO_CHAR(1200, 'L9,999') FROM DUAL;
DESC EMP; -- SAL NUMBER(7,2) ; 전체 자리수는 7자리
SELECT ENAME, SAL, TO_CHAR(SAL, '$99,999') FROM EMP;

-- (3) TO_DATE(문자, '패턴') 
SELECT TO_DATE('20221227 14:53', 'YYYYMMDD HH24:MI') FROM DUAL;
    -- 81/5/1 ~ 83/5/1 사이에 입사한 직원의 모든 필드
SELECT * FROM EMP
    WHERE HIREDATE BETWEEN TO_DATE('81/05/01','RR/MM/DD') 
        AND TO_DATE('83/05/01', 'RR/MM/DD');

-- (4) TO_NUMBER(문자, "패턴")
SELECT '3456'+1 FROM DUAL;
SELECT TO_NUMBER('3,456', '9,999')+1 FROM DUAL;

-- 5. NVL(널일수도있는데이터, 널이면대신할 값) - 매개변수 2개의 타입 일치
    -- ex. 사원이름, 직속상사이름(직속상사가 없으면 CEO로 출력)
SELECT W.ENAME, NVL(M.ENAME, 'CEO')
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+);
    -- ex. 사원이름, 직속상사의 사번(직속상사가 없으면 'CEO'로 출력)
SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO') MGR FROM EMP;
DESC EMP;

-- 6. ETC
-- (1) EXTRACT ; 년도, 월, 일만 추출하고자 할 때
SELECT HIREDATE, EXTRACT(YEAR FROM HIREDATE) FROM EMP; -- 년도만 숫자로 추출함
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YYYY') FROM EMP;  -- 년도4자리를 문자로 추출함
SELECT SYSDATE, EXTRACT(MONTH FROM SYSDATE) FROM DUAL; -- 월만 숫자로 추출
SELECT SYSDATE, TO_CHAR(SYSDATE, 'MM') FROM DUAL; -- 월2주리를 문자로 추출함
SELECT SYSDATE, EXTRACT(DAY FROM SYSDATE) FROM DUAL; -- 일만 숫자로 추출
SELECT SYSDATE, TO_CHAR(SYSDATE, 'DD') FROM DUAL;    -- 일 두자리를 문자로 추출
-- (2) 레벨별 출력
SELECT * FROM EMP;
SELECT LPAD('ㄴ', LEVEL*2) || ENAME FROM EMP
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO=MGR;

-- ★ <총 연습문제> ★
-- 1. 현재 날짜를 출력하고 TITLE에 “Current Date”로 출력하는 SELECT 문장을 기술하시오.
SELECT SYSDATE "Current Date" FROM DUAL;
-- 2. EMP 테이블에서 현재 급여에 15%가 증가된 급여를 계산하여,
-- 사원번호,이름,업무,급여,증가된 급여(New Salary),증가액(Increase)를 출력하는 SELECT 문장
SELECT EMPNO, ENAME, JOB, SAL, SAL*1.15 "New Salary", SAL*0.15 Increase 
    FROM EMP;
--3. 이름, 입사일, 입사일로부터 6개월 후 돌아오는 월요일 구하여 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, HIREDATE, 
        NEXT_DAY(ADD_MONTHS(HIREDATE, 6), '월')
    FROM EMP;
--4. 이름, 입사일, 입사일로부터 현재까지의 개월수, 급여, 입사일부터 현재까지의 받은 급여의 총계를 
    -- 출력
SELECT ENAME, HIREDATE,
    TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)), SAL, 
    TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))*SAL*12 FROM EMP;
SELECT ENAME, HIREDATE,
        TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)), SAL, 
        TO_CHAR(TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))*SAL*12, '$99,999,999')
    FROM EMP;    
--5. 모든 사원의 이름과 급여(15자리로 출력 좌측의 빈 곳은 “*”로 대치)를 출력
SELECT ENAME, LPAD(SAL, 15, '*') FROM EMP;
--6. 모든 사원의 정보를 이름,업무,입사일,입사한 요일을 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DY"요일"') from EMP;
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DAY') from EMP;
--7. 이름의 길이가 6자 이상인 사원의 정보를 이름,이름의 글자수,업무를 출력
SELECT ENAME, LENGTH(ENAME), JOB FROM EMP WHERE LENGTH(ENAME)>= 6;
--8. 모든 사원의 정보를 이름, 업무, 급여, 보너스, 급여+보너스를 출력
SELECT ENAME, JOB, SAL, COMM, SAL+NVL(COMM, 0) FROM EMP;
-- 9.사원 테이블의 사원명에서 2번째 문자부터 3개의 문자를 추출하시오. 
SELECT SUBSTR(ENAME, 2, 4) FROM EMP;
--10. 사원 테이블에서 입사일이 12월인 사원의 사번, 사원명, 입사일을 검색하시오. 
--  시스템에 따라 DATEFORMAT 다를 수 있으므로 아래의 방법도 알아보자
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE EXTRACT(MONTH FROM HIREDATE)=12;
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = '12';
--11. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
--EMPNO		ENAME		급여
--7369		SMITH		*******800
--7499		ALLEN		******1600
--7521		WARD		******1250
--……. 
SELECT EMPNO, ENAME, LPAD(SAL, 10, '*') 급여 FROM EMP;
-- 12. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
-- EMPNO	 ENAME 	입사일
-- 7369	  SMITH		1980-12-17
-- ….
SELECT EMPNO, ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD') 입사일 FROM EMP;
--13. 사원 테이블에서 부서 번호가 20인 사원의 사번, 이름, 직무, 급여를 출력하시오.
    --(급여는 앞에 $를 삽입하고3자리마다 ,를 출력한다)
-- SAL NUMBER 자리수 확인
DESC EMP; 
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL, '$99,999') FROM EMP WHERE DEPTNO=20;
ROLLBACK;
INSERT INTO EMP VALUES (9999,'HONG', NULL, NULL, NULL, 90000, 90000, 20);
