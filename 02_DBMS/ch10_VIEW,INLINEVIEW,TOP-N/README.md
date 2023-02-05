## [10] VIEW, INLINEVIEW, TOP-N



## VIEW

### VIEW의 개념

- 행과 컬럼으로 구성된 가상 테이블.
- 이미 존재하고 있는 테이블에 제한적으로 접근하도록 하기 위함
- 물리적인 저장공간과 데이터를 가지지 않고 다른 테이블이나 뷰에서 파생된 논리적인 테이블
- 기본 테이블의 데이터가 변경되면 뷰에도 반영된다.

### VIEW의 장점

- 뷰를 이용한 기본 테이블의 액세스 제한을 통한 데이터에 대한 보안 기능 제공
- 기본 테이블에 영향을 주지 않을 수도 있다.
- 여러 개의 기본 테이블로 정의된 뷰가 하나의 테이블인 것처럼 인식
- 기본테이블에 대한 복잡한 형태의 질의를 뷰로 정의하여 간단하게 표현 가능

### VIEW의 종류

**단순뷰**

- 하나의 테이블로 구성한 뷰
- `INSERT`, `DELETE`, `UPDATE`와 같은 DML 명령문을 실행하여 기본 테이블의 데이터 조작 가능
- 함수나 그룹 데이터는 사용 가능
- `CREATE OR REPLACE VIEW EMPv0 AS SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP;`

**복합뷰**

- 하나 이상의 기본 테이블로 구성한 뷰
- DML문을 제한적으로 사용
- 함수나 그룹데이터는 사용 가능
- `CREATE OR REPLACE VIEW EMPv0 AS SELECT EMPNO, ENAME, JOB, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO;`

### VIEW의 제한 조건

- 테이블에 `NOT NULL`로 만든 컬럼들이 뷰에 다 포함되어 있어야 된다
- `WITH READ ONLY`옵션을 설정한 뷰는 갱신 불가
- `WITH CHECK OPTION`을 설정한 뷰는 뷰의 조건에 해당되는 데이터만 삽입, 삭제, 수정을 할 수 있다.

### VIEW 생성 문법

```sql
CREATE [OR REPLACE] VIEW view_name
	AS subquery
	[WITH CHECK OPTION]
	[WITH READ ONLY]
```

- **WITH CHECK OPTION** : INSERT나 UPDATE시 서브쿼리의 조건을 만족할 경우에 처리, DELETE가능. 조건 불만족시 에러.
- **WITH READ ONLY** : 읽기 전용 뷰 생성. 데이터를 조작하는 작업은 불가능하다.



## INLINE-VIEW

- SQL문장 내의 서브쿼리는 SELECT 절에도, FROM절에도 WHERE절에도 어디든 사용 가능.
- FROM 절 상의 서브쿼리를 inline view라 하며, FROM 절에 오는 서브쿼리는 VIEW 처럼 작용한다.

### INLINE-VIEW의 문법

```sql
SELECT column_list
	FROM (Sub Query) alias
	WHERE condition

-- 급여가 2000을 초과하는 사원의 평균 급여 출력
SELECT AVG(SAL) 
	FROM (SELECT SAL FROM EMP WHERE SAL>2000) INV_EMP;
```

**💡VIEW의 수정**

`ALTER VIEW` 사용은 뷰의 수정보다 재컴파일하거나 유효성을 재검사하기 위해 사용되고, `CREATE OR REPLACE VIEW` 명령문을 이용한다. 실제로는 기존 뷰에 대한 정의를 삭제하고 재정의 하는 것.



## TOP-N

상위 n개의 데이터를 추출하는 쿼리

### TOP-N쿼리의 문법

```sql
-- 급여를 기준으로 상위 6등 ~ 10등 사원의 모든 필드
SELECT * FROM EMP ORDER BY SAL DESC; -- 1단계

SELECT ROWNUM, A.*
  FROM (SELECT * FROM EMP ORDER BY SAL DESC) A; -- 2단계
  
SELECT ROWNUM, B.*
  FROM (SELECT ROWNUM, A.*
        FROM (SELECT * FROM EMP ORDER BY SAL DESC) A) B
  WHERE RN BETWEEN 6 AND 10;  -- 3단계 (TOP-N)
```