-- PERSON DML

-- 00. 등록 가능한 직업명 LIST 출력
SELECT JNAME FROM JOB;

-- 01. PNAME, JNAME, KOR, ENG, MAT 입력 후 DATA INSERT
-- SELECT JNO FROM JOB WHERE JNAME = '배우';

INSERT INTO PERSON VALUES (PERSON_PNO_SQ.NEXTVAL, 'SAMPLE', 
    (SELECT JNO FROM JOB WHERE JNAME = '배우'), 20, 20, 20);

ROLLBACK;
-- 02. JNAME 입력받아 RANK, PNAME(PNO) JNAME, KOR, ENG, MAT, SUM 출력
    -- SUM 순 내림차순
    
SELECT PNAME, PNO, JNAME, KOR, ENG, MAT, KOR + ENG + MAT SUM
    FROM PERSON P, JOB J
    WHERE P.JNO = J.JNO
    ORDER BY SUM DESC;
    
SELECT ROWNUM RANK, A.*
    FROM(SELECT CONCAT(PNAME, '('||PNO||')') PNAME, JNAME, KOR, ENG, MAT, KOR + ENG + MAT SUM
    FROM PERSON P, JOB J WHERE P.JNO = J.JNO AND JNAME = '배우' ORDER BY SUM DESC) A;

-- 03. 모든 정보 출력
    -- SUM 순 내림차순
SELECT ROWNUM RANK, A.*
    FROM(SELECT CONCAT(PNAME, '('||PNO||')') PNAME, JNAME, KOR, ENG, MAT, KOR + ENG + MAT SUM
    FROM PERSON P, JOB J WHERE P.JNO = J.JNO ORDER BY SUM DESC) A;