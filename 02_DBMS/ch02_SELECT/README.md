## [02] SELECT문

**💡SELECT 구문 형식**

```sql
SELECT select_list [ INTO new_table ]  
[ FROM table_source ]
[ WHERE search_condition ]  
[ GROUP BY group_by_expression ]  
[ HAVING search_condition ]  
[ ORDER BY order_expression [ ASC | DESC ] ]  
```



### SELECT문 조회

```SQL
SHOW USER;
SELECT * FROM TAB; -- 현 계정이 가지고 있는 테이블 정보
SELECT * FROM EMP; -- EMP테이블의 모든 열(필드), 모든 행
SELECT * FROM DEPT; -- DEPT 테이블의 모든 열(필드), 모든 행
SELECT * FROM SALGRADE;
```

```SQL
DESC EMP; -- EMP테이블의 구조
```

- **not null**  null값이 있으면 안 된다.
- **number(4)**  부서코드는 정수 4자리
- **number(7, 2)**  총 자리수 7자리 숫자 중 소수점 이하는 2자리



### WHERE 조건과 비교연산자

비교연산자는 숫자, 문자, 날짜형 모두 가능하다.

| 연산자   | 설명        |
| -------- | ----------- |
| =        | 같다        |
| != ^= <> | 다르다      |
| <        | 작다        |
| <=       | 작거나 같다 |
| >        | 크다        |
| >=       | 크거나 같다 |

```sql
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL = 3000; -- 같다
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL != 3000; -- 다르다
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL ^= 3000; -- 다르다
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL <> 3000; -- 다르다
```



### 연결연산자 ||

필드나 문자를 연결하는 연산자

```sql
SELECT ENAME || '의 직업은' || JOB EMPLOYEE FROM EMP;
```



### 중복제거 DISTINCT

```sql
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;
```



## SQL 논리 연산자

| 연산자  | 설명                                                         |
| ------- | ------------------------------------------------------------ |
| ALL     | 하나의 값을 다른 값들의 집합의 모든 값들과 비교할 때 사용    |
| AND     | SQL 문의 WHERE 절에 여러 개의 조건이 존재할 수 있도록 연     |
| BETWEEN | 최소값과 최대값을 지정한 값의 범위 내에 있는 값들을 검색 (A, B값 포함 / A: 작은 값, B: 큰 값) |
| IN      | 어떤 값을 구체화된 리터럴 값의 목록과 비교하기 위해 사용     |
| LIKE    | 와일드카드 연산자를 사용하여 해당 값과 유사한 값을 찾으려 할 때 사용 |
| NOT     | 사용하려는 논리 연산자의 의미를 반전.                        |
|         | 예시: NOT EXISTS, NOT BETWEEN, NOT IN                        |
| OR      | SQL 문의 WHERE 절에서 여러 조건을 합치기 위해 사용           |
| IS NULL | 해당 값을 NULL 값과 비교할 때 사용                           |
| UNIQUE  | UNIQUE 연산자는 유일성을 가지도록 구체화된 테이블의 모든 행을 검색합니다. (중복 불허) |

