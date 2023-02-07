## [13] MySQL

### MySQL의 특징

- SQL에 기반을 둔 관계형 DBMS 중 하나
- Oracle, IBM, Infomix 등의 데이터베이스는 고가이지만 MySQL 은 무료(배포판)
- 리눅스, 유닉스, 윈도우 등 거의 모든 운영체제에서 사용가능
- 처리 속도가 상당히 빠르고 대용량의 데이터 처리 용이
- 설치방법이 쉽고 초보자도 익히기 쉬움.
- 보안성이 우수



## DCL

```mysql
-- DCL(계정생성, 권한부여, 권한박탈, 계정삭제)
create user user01 identified by 'password'; -- 계정 생성
grant all on *.* to user_name; -- 권한 부여
grant all privileges on *.* to user_name;
flush privileges;
revoke all privileges on *.* from user_name; -- 권한 박탈
drop user user01; -- 계정 삭제

-- 데이터베이스 안으로 들어감
show databases;
create database database_name; -- 새로운 데이터 베이스 생성
use database_name;
select database(); -- 현재 들어와 있는 데이터 베이스 확인
show tables;
```



## DDL

```mysql
-- DDL(제약조건, 시퀀스없음)
-- emp 테이블 생성
create table emp(
	empno		numeric(4) primary key,
    ename		varchar(20) not null,
    nickname	varchar(20) unique, -- null 포함
    sal			numeric(7, 2) check(sal>0), -- null 포함
    comm		numeric(7, 2) default 0
    );
    
desc emp;
drop table if exists emp;
```

----



### 오라클 함수와 다른 점

```mysql
-- concat()의 매개변수 갯수의 제한이 없다.
-- ||는 연결연산자가 아닌 or의 의미를 가진다.
select concat(pname, '는 ',job,'이다') msg from personal;

-- from 절 없이 실행 가능
select round(3.1415);

-- 시스템으로부터 현재 시점, 현재 날짜, 현재 시간
select sysdate();
select now();
select year(sysdate()); -- 연도만 출력
select year(sysdate()), month(sysdate()), day(sysdate()), 
	hour(sysdate()), minute(sysdate()), second(sysdate());
-- 시스템으로부터 현재 날짜
select current_date();
select curdate();
-- 시스템으로부터 현재 시간
select current_time();
select curtime();

-- ■ format(숫자, 소수점자릿수) --> 문자
select pname, format(pay,2) from personal; -- 소수점 2자리까지 나오도록

-- ■ top-n 구문(rownum 대신 limit 이용)
select pname, pay from personal order by pay desc;
-- limit
select pname, pay from personal order by pay desc limit 5;
-- limit n1, n5(n1번째부터 n2개/ 0번째부터 시작)
select pname, pay from personal order by pay desc limit 0, 5; -- 1등부터 5개
select pname, pay from personal order by pay desc limit 5, 5; -- 6등부터 5개
```
