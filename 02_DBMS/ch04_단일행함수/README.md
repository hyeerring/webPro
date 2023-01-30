## [03] 단일행 함수

**💡단일행함수와 그룹함수의 차이**

- **단일행 함수(INPUT 1행 -> OUTPUT 1행)**

  오직 단일 행에서만 적용 가능하며 행별로 하나의 결과를 리턴. 문자, 숫자, 날짜 형변환 함수 등

- **그룹 함수(INPUT n행 -> OUTPUT 1행)**

  여러개의 행을 조작하여 행의 그룹당 하나의 결과를 리턴



**💡DUAL 테이블**

산술연산결과를 한줄로 얻기 위해 오라클에서 제공하는 테이블 DUAL은 테스트하기 위한 용도의 oracle 내장 객체, 한 행으로 출력된다. 주로, 연산, 함수적용내용 확인 시 활용.



### 숫자 함수

숫자를 처리하는 함수. 절대값, 수학함수(sin, cos, tan…), 올림(ceil), 반올림(round), 내림(trunc), 나머지(mod) 등

```sql
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
```



### 문자처리함수

```sql
-- 대소문자 관련
SELECT INITCAP('welcome to oracle') FROM DUAL;-- 첫문자만 대문로
SELECT UPPER('ABCabc') FROM DUAL; -- 대문자로
SELECT LOWER('ABCabc') FROM DUAL; -- 소문자로

-- ||연산자 / CONCAT: 문자 연결
SELECT 'AB'||'CD'||'EF'||'GH' FROM DUAL; -- ABCDEFGH
SELECT CONCAT(CONCAT('AB','CD'), CONCAT('EF','GH')) FROM DUAL; -- ABCDEFGH

-- SUBSTR(STR, 시작 위치, 문자 바이트 수): STR을 시작위치부터 문자갯수만큼 문자 추출
-- 시작위치가 1부터, 시작위치가 음수이면 끝부터 자리수를 센다.
SELECT SUBSTR('ORACLE', 3, 2) FROM DUAL; -- 3번째 글자부터 2글자 추출
SELECT SUBSTR('ORACLE', -2, 2) FROM DUAL; -- 마지막 글자 2글자 추출

-- LENGTH(STR): STR의 글자수
-- LENGTHB(STR): STR의 바이트 수
SELECT LENGTH('오라클') FROM DUAL; -- 글자 수 : 3
SELECT LENGTHB('오라클') FROM DUAL; -- 바이트 수 : 9

-- INSTR(STR, 찾을문자): STR에서 첫번째 문자부터 찾을문자가 나오는 위치(없으면 0)
--  INSTR(STR, 찾을문자, 시작위치): STR에서 시작위치 문자부터 찾을문자가 나오는 위치
SELECT INSTR('ABCABC', 'B') FROM DUAL; -- 처음부터 찾아서 처음나오는 B의 위치 : 2
SELECT INSTR('ABCABC', 'B', 3) FROM DUAL; -- 3번째 문자부터 찾아서 처음 나오는 B의 위치 : 5

-- LPAD(STR, 자리수, 채울문자): STR을 자리수만큼 확보하고 왼쪽 빈자리에 채울문자로 출력
--  LPAD(STR, 자리수): STR을 자리수만큼 확보하고 왼쪽 빈자리에 ' '로 출력
--  RPAD(STR, 자리수, 채울문자): STR을 자리수만큼 확보하고 오른쪽 빈자리에 채울문자로 출력
--  RPAD(STR, 자리수): STR을 자리수만큼 확보하고 오른쪽 빈자리에 ' '로 출력
SELECT LPAD('ORACLE', 10, '#') FROM DUAL;
SELECT RPAD('ORACLE', 10, '*') FROM DUAL;

-- TRIM(STR), LTRIM(STR), RTRIM(STR): 여백제거
SELECT '    ORACLE   ' MSG FROM DUAL;
SELECT TRIM('   ORACLE   ') MSG FROM DUAL; -- ORACLE
```



### 날짜관련 함수

```sql
-- SYSDATE: 시스템 저장된 현재 날짜를 반환 / SYSTIMESTAMP
SELECT SYSDATE FROM DUAL;
SELECT SYSTIMESTAMP FROM DUAL;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';

-- 날짜 계산: 오라클 타입(문자, 숫자, 날짜) 중 숫자, 날짜도 연산 가능
-- ex. 반납예정일 
SELECT SYSDATE + 14 FROM DUAL;

-- MONTHS_BETWEEN(시점1, 시점2): 두 시점간의 개월 수를 반환(시점1을 큰 시점)
-- ex. 이름, 입사일, 근무월수
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) MONTH FROM EMP;

-- ADD_MONTHS(특정 시점, 개월수): 특정 날짜에 개월 수를 더한다
-- ex. 이름, 입사일, 수습종료시점(수습시간 6개월)
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 6) FROM EMP;

-- NEXT_DAY(특정시점, '토'): 특정 날짜에서 최초로 도래하는 인자로 받은 요일의 날짜를 반환
SELECT NEXT_DAY(SYSDATE, '토') FROM DUAL;

-- LAST_DAY(특정시점): 해당 달의 마지막 날짜를 반환
SELECT LAST_DAY(SYSDATE) FROM DUAL;

-- ROUND(날짜, XX): 인자로 받은 날짜를 특정 기준으로 반올림(xx: YEAR, MONTH, DAY)
```



### 형변환 함수

오라클을 사용하다 보면 숫자, 문자, 날짜의 데이터 형을 다른 데이터형으로 변환하는 함수

### TO_CHAR : 날짜형 혹은 숫자형을 문자형으로 변환

**TO_CHAR(날짜데이터, ‘출력형식’);**

| 함수 | 설명                  | 함수 | 설명         |
| ---- | --------------------- | ---- | ------------ |
| YYYY | 연도. 4자리           | YY   | 연도.  2자리 |
| MM   | 월. 2자리 숫자로 표시 | MON  | 월.          |
| DD   | 일. 2자리수로 표시    | DAY  | 일.          |
| DAY  | 요일.  (토요일)       | DY   | 요일. (토)   |
| HH24 | 24시간                | HH12 | 12시간       |
| MI   | 분                    | SS   | 초           |

**TO_CHAT(숫자데이터, ‘출력형식’);**

| 함수 | 설명                                                    |
| ---- | ------------------------------------------------------- |
| 0    | 자릿수를 나타내며 자릿수가 맞지 않을 경우 0으로 채운다. |
| 9    | 자릿수를 나타내며 자릿수가 맞지 않아도 채우지 않는다.   |
| L    | 각 지역별 통화 기호를 앞에 표시한다.                    |



### TO_DATE : 문자형을 날짜형으로 변환

**TO_DATE(‘문자’, ‘FORMAT’);**

```sql
SELECT TO_DATE('20221227 14:53', 'YYYYMMDD HH24:MI') FROM DUAL;
```



### TO_NUMBER : 문자형을 숫자형으로 변환

```sql
SELECT TO_NUMBER('3,456', '9,999')+1 FROM DUAL;
```

----



### NULL을 다른 값으로 변환하는 NVL 함수

```sql
-- NVL(널일수도있는데이터, 널이면대신할 값) 매개변수 2개의 타입 일치해야 한다
-- ex. 사원이름, 직속상사이름(직속상사가 없으면 CEO로 출력)
SELECT W.ENAME, NVL(M.ENAME, 'CEO')
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+);
-- ex. 사원이름, 직속상사의 사번(직속상사가 없으면 'CEO'로 출력)
SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO') MGR FROM EMP;
DESC EMP;
```

