## [07] DDL, DML, DCL 

### **SQL문의 종류**

**DML (Data Manipulation Language)**  데이터 조작어 : 데이터 검색, 수정 등

- **INSERT** : 데이터베이스 객체에 데이터를 입력	
- **DELETE** : 데이터베이스 객체에 데이터를 삭제	
- **UPDATE** : 기존에 존재하는 데이터베이스 객체 안의 데이터수정	
- **SELECT** : 데이터베이스 객체로부터 데이터를 검색

**DDL (Data Definition Language)**  데이터 정의어 : 데이터와 그 구조를 정의

- **CREATE** : 데이터 베이스 객체 생성		
- **DROP** : 데이터 베이스 객체를 삭제		
- **ALTER** : 기존에 존재하는 데이터베이스 객체를 다시 정의		
- **TRUNCATE** : 데이터베이스 객체 내용 삭제

**DCL (Data Control Language)**  데이터 제어어 : 데이터베이스 사용자의 권한 제어

- **GRANT** : 데이터 베이스 객체에 권한 부여
- **REVOKE** : 이미 부여된 데이터베이스 객체의 권한을 취소

**TCL (Transaction Control Language)**  트랜젝션 제어어 : 논리적인 작업의 단위를 묶어서 DML에 의해 조작된 결과를 작업단위(트랜잭션) 별로 제어

- **COMMIT : 트랜잭션 확정** (TCL)
- **ROLLBACK : 트랜잭션 취소** (TCL)
- **SAVEPOINT : 복귀지점 설정** (TCL)



## 데이터형

데이터베이스에는 문자, 숫자, 날짜, 이미지 등과 같은 다양한 형태의 데이터가 저장된다. 다음은 오라클에서 제공되는 데이터 형의 종류이다.

| 데이터형           | 설명                                                         |
| ------------------ | ------------------------------------------------------------ |
| CHAR(size)         | 고정 길이 문자 데이터. VARCHAR2와 동일한 형태의 자료를 저장할 수 있고, 입력된 자료의 길이와는 상관없이 정해진 길이만큼 저장 영역을 차지한다. |
| **VARCHAR2(size)** | Up to 4000 Bytes 가변 길이 문자 데이터. 실제 입력된 문자열의 길이만큼 저장 영역을 차지. 최대 크기는 명시해야 한다. |
| **NUMBER**         | Internal Number Format 최고 40자리까지의 숫자를 저장할 수 있다. 이때 소수점이나 부호는 길이에 포함되지 않는다. |
| **NUMBER(w)**      | w자리까지의 수치로 최대 38자리까지 가능하다.                 |
| **NUMBER(w, d)**   | w는 전체 길이, d는 소수점 이하 자릿수이다. 소수점은 자릿수에 포함되지 않는다. |
| **DATE**           | BC 4712년 1월 1일~AD 4712년 12월 31일까지의 날짜             |
| LOB(Large OBject)  | 2GB까지의 가변 길이 바이너리 데이터를 저장시킬 수 있다. 이미지 문서, 실행 파일을 저장할 수 있다. |
| - BLOB             | 그래픽 이미지, 동영상, 사운드와 같은 구조화되지 않은 데이터를 저장하기 위해 사용 |
| - CLOB             | e-BOOK과 같은 대용량의 텍스트 데이터를 저장하기 위해서 사용  |
| - NCLOB            | 국가별 문자셋 데이터를 저장하고, BFILE은 바이너리 데이터를 파일 형태로 저장한다. |
| ROWNUM             | 테이블에서 행의 논리적인 순서                                |



## DDL

1. **테이블 생성(CREATE TABLE 테이블명) : 테이블 구조를 정의**

```sql
CREATE TABLE BOOK (
    BOOKID		NUMBER(4),		-- BOOKID 필드의 타입은 숫자 4자리
    BOOKNAME	VARCHAR2(20),	-- BOOKNAME필드의 타입은 문자 20BYTE
    PUBLISHER	VARCHAR2(20),	-- PUBLISHER 필드의 타입은 문자 20BYTE
    RDATE		DATE,        	-- RDATE 필드의 타입은 DATE형
    PRICE		NUMBER(8, 2),	-- PRICE필드의 타입은 숫자 전체 8자리, 소수점 2, 소수점앞 6.
    PRIMARY KEY(BOOKID) -- 제약조건 : BOOKID필드가 주키(PRIMARY KEY : NOT NULL, UNIQUE)
);

DROP TABLE BOOK; -- 테이블 삭제
```

2. **테이블 구조 변경 (ALTER TABLE 테이블명 ADD || MODIFY || DROP )**

```sql
-- (1) 필드 추가(ADD)
ALTER TABLE EMP03 ADD (COMM NUMBER(7,2));

-- (2) 필드 수정(MODIFY)
ALTER TABLE EMP03 MODIFY (EMPNO VARCHAR2(5)); -- 숫자데이터가 들어있어서 숫자로만 변경 가능.
ALTER TABLE EMP03 MODIFY (EMPNO NUMBER(4)); -- 숫자 데이터는 줄이기 안됨
ALTER TABLE EMP03 MODIFY (SAL VARCHAR2(10)); -- NULL 필드는 마음대로 수정 가능
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(20)); -- 문자데이터 늘리거나 줄이기 가능

-- (3)필드 삭제(DROP)
ALTER TABLE EMP03 DROP COLUMN JOB;
```

3. **테이블 삭제 (DROP TABLE 테이블명)**

```sql
DROP TABLE EMP;
```

4. **테이블의 모든 행 제거 (TRUNCATE TABLE 테이블명)**
5. **테이블명 변경(RENAME 테이블명 TO 바꿀테이블명)**
6. **데이터 딕셔너리(접근불가) / 데이터딕셔너리 뷰(접근용)**

```sql
-- (1) USER_XXX : 현 계정이 소유하고 있는 객체(테이블, 제약조건, 뷰, 인덱스)
-- USER_TABLES, USER_CONSTRAINTS, USER_INDEXES, USER_VIEWS
SELECT * FROM USER_TABLES;
SELECT * FROM USER_CONSTRAINTS;
SELECT * FROM USER_INDEXES;
SELECT * FROM USER_VIEWS;

-- (2) ALL_XXX : 현 계정에서 접근 가능한 객체(테이블, 제약조건, 뷰, 인덱스)
-- ALL_TABLES, ALL_CONSTRAINTS, ALL_INDEXES, ALL_VIEWS
SELECT * FROM ALL_TABLES;
SELECT * FROM ALL_VIEWS;

-- (3) DBA_XXX : DBA권한에서만 접근가능. DBMS의 모든 객체
-- DBA_TABLES, DBA_CONSTRAINTS, DBA_INDEXES, DBA_VIEWS
SELECT * FROM DBA_TABLES;
```



## DML

1. INSERT INTO 테이블명 VALUES (값1, 값2, ... )

```sql
INSERT INTO DEPT01 VALUES (50, 'ACCOUNTING', 'NEW YORK');
```

2. UPDATE 테이블명 SET 필드명1 = 값1 [ 필드명2 = 값2, 필드명N = 값N] [WHERE 조건] ;

```sql
-- ex. 부서번호를 30으로 수정
UPDATE EMP01 SET DEPTNO=30;
```

3. DELETE FROM 테이블명 [WHERE 조건] ;

```sql
-- ex. emp01에서 30부서 직원만 삭제
DELETE FROM EMP01 WHERE DEPTNO=30;
    SELECT * FROM EMP01;
```

