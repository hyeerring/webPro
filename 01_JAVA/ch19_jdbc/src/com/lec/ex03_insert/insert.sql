-- ex.01
select * from dept;

INSERT INTO DEPT VALUES (50, 'IT', 'SEOUL');

-- ex.02 중복체크
-- SELECT * FROM DEPT WHERE DEPTNO = 10;

SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO = 10; -- 무조건 한줄
INSERT INTO DEPT VALUES (50, 'IT', 'SEOUL');

rollback;

delete from dept where deptno = 50;