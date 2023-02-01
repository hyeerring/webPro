## [06] SUBQUERY

### 서브 쿼리의 개념

- 서브 쿼리는 하나의 SQL 문장의 절 안에 포함된 또 하나의 SELECT 문장이다.
- 서브 쿼리를 포함하고 있는 쿼리문을 메인 쿼리, 포함된 쿼리를 서브 쿼리라고 한다.
- 서브 쿼리는 비교 연산자의 오른쪽에 기술하며 반드시 괄호로 감싸야 한다.
- 서브 쿼리는 메인 쿼리가 실행되기 이전에 한번만 실행된다.



### 단일행 SUBQUERY

- 단일 행(Single Row) 서브 쿼리는 수행 결과가 오직 하나의 로우(행, row)만을 반환하는 서브 쿼리를 갖는 것을 말한다.
- 단일 행 서브 쿼리문에서는 오직 하나의 로우(행, row)로 반환되는 서브 쿼리의 결과를 메인 쿼리에 보내게 되는데, 이때 메인 쿼리의 WHERE 절에서는 단일 행 비교 연산자인 `=, >, >=, <, <=, <>`를 사용해야 한다.

```sql
SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'; -- 서브쿼리
SELECT DNAME FROM DEPT 
    WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'); -- 메인 쿼리

SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME = 'SCOTT'; -- JOIN이용
```



### 다중행 SUBQUERY

서브 쿼리에서 반환되는 결과가 하나 이상의 행일 때 사용

| 종류      | 설명                                                         |
| --------- | ------------------------------------------------------------ |
| IN        | 메인 쿼리의 비교 조건( `=`연산자로 비교할 경우 )이 서브 쿼리의 결과 중에서 하나라도 일치하면 참 |
| ANY, SOME | 메인 쿼리의 비교 조건이 서브 쿼리의 검색 결과와 하나 이상이 일치하면 참 |
| ALL       | 메인 쿼리의 비교 조건이 서브 쿼리의 검색 결과와 모든 값이 일치하면 참 |
| EXISTS    | 메인 쿼리의 비교 조건이 서브 쿼리의 결과 중에서 만족하는 값이 하나라도 존재하면 참 |

```sql
-- (1) IN : 서브쿼리 결과 중 하나라도 일치하면 참
-- 부서별 입사일이 가장 늦은 사람의 이름, 입사일, 부서번호
SELECT ENAME, HIREDATE, DEPTNO FROM EMP
    WHERE (DEPTNO, HIREDATE) IN
    (SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO);
    
-- (2) ALL : 서브쿼리 결과가 모두 만족하면 참
-- 30번 부서직원 모두의 급여보다 큰 직원의 모든 필드
SELECT SAL FROM EMP WHERE DEPTNO=30; -- 950, 1250, 1500, 1600, 2850 서브쿼리
SELECT * FROM EMP
	WHERE SAL > ALL (SELECT SAL FROM EMP WHERE DEPTNO=30); -- 다중행서브쿼리 이용

-- (3) ANY = SOME ; 서브쿼리 결과가 하나라도 만족하면 참
-- 30번 부서직원 하나만이라도 급여가 큰 직원의 모든 필드
SELECT SAL FROM EMP WHERE DEPTNO=30; -- 다중행 단일열 서브쿼리
SELECT * FROM EMP
	WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO=30); -- 다중행 서브쿼리 이용

-- (4) EXISTS : 서브쿼리 결과가 존재하면 참
-- 직속부하가 있는 직원들의 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL FROM EMP MANAGER
	WHERE EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO=MGR); -- 서브쿼리 이용
```

