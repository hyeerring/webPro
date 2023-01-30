## [03] JOIN

**💡JOIN의 필요성**

특정 부서 번호에 대한 부서 이름은 DEPT 테이블에 있기 때문에 특정 사원의 부서명을 알아내기 위해서는 DEPT테이블에서 정보를 가져와야 한다. 이때 JOIN을 통해 두개 이상의 테이블을 결합하여 한번의 질의로 원하는 결과를 얻어낼 수 있다.

### EQUI JOIN

EQUI JOIN은 가장 많이 사용하는 조인 방법으로서 조인 대상이 되는 두 테이블에서 공통적으로 존재하는 컬럼의 값이 일치되는 행을 연결하여 결과를 생성하는 조인 방법이다.

```sql
SELECT EMPNO, ENAME, E.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
```

- 사원(EMP) 테이블과 부서(DEPT) 테이블의 공통 컬럼인 DEPTNO의 값이 일치(=)되는 조건을 WHERE 절에 기술하여 사용. 
- 테이블을 조인하려면 일치되는 공통 컬럼을 사용해야 하고, 컬럼의 이름이 같게 되면 혼동이 오기 때문에 컬럼 이름 앞에 테이블 이름을 기술.



### NON-EQUI JOIN

Non-Equi Join은 조인 조건에 특정 범위 내에 있는지를 조사하기 위해서 WHERE 절에 조인 조건을 = 연산자 이외의 비교 연산자를 사용한다.

```sql
-- 모든 직원의 급여등급을 조회
SELECT * FROM ENAME, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL;
```



## SELF-JOIN

두 개 이상의 서로 다른 테이블을 서로 연결하는 것뿐만 아니라, 하나의 테이블 내에서 조인을 해야만 원하는 자료를 얻는 경우 자기 자신과의 조인하는 방법.

```sql
-- 모든 사원의 사번, 이름, 상사 사번, 상사 이름
SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;
```



### OUTER JOIN

조인 조건에 만족하지 못하였더라도 해당 로우를 나타내고 싶을 때에 사용하는 것이 외부 조인(Outer Join)이다.

- 외부 조인(Outer Join)은 NULL 값이기에 배제된 행을 결과에 포함시킬 수 있으며 다음과 같이 `(+)` 기호를 조인 조건에서 정보가 부족한 칼럼 이름 뒤에 덧붙인다.

```sql
-- 상사가 없을 경우 '없다'를 출력
SELECT W.ENAME || '의 상사는 ' || NVL(M.ENAME, '없다')
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);
```

- 사원 번호(EMPNO)가 NULL인 사원은 없으므로 manager.empno 뒤에 `(+)` 기호를 덧붙인다.
