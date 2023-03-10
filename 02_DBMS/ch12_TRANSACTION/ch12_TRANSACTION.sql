-- [12] 트랜젝션 명령어
-- COMMIT: 트랜젝션 반영
-- ROLLBACK: 트랜젝션 취소
-- SAVEPOINT: 트랜젝션 분할

DROP TABLE DEPT01;
CREATE TABLE DEPT01 AS SELECT * FROM DEPT;
COMMIT;

-- 새로운 트랜젝션 시작
SELECT * FROM DEPT01;

DELETE FROM DEPT01 WHERE DEPTNO = 20;
DELETE FROM DEPT01 WHERE DEPTNO = 30;

ROLLBACK;

-- 새로운 트랜젝션
SELECT * FROM DEPT01;

DELETE FROM DEPT01 WHERE DEPTNO = 40;

COMMIT;

-- 새로운 트랜젝션
SELECT * FROM DEPT01; -- 10, 20, 30

DELETE FROM DEPT01 WHERE DEPTNO = 30;

SELECT * FROM DEPT01; -- 10, 20

SAVEPOINT C1; -- ■ C1시점: 10, 20
DELETE FROM DEPT01 WHERE DEPTNO = 20;

SAVEPOINT C2; -- ■ C2시점: 10
DELETE FROM DEPT01 WHERE DEPTNO = 10;

SELECT * FROM DEPT01; -- 현재 시점: NULL
ROLLBACK TO C2; -- 10
ROLLBACK TO C1; -- 10, 20
