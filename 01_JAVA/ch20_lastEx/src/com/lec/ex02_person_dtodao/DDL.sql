-- 테이블 생성 & dummy data
DROP TABLE PERSON;
DROP TABLE JOB;
DROP SEQUENCE PERSON_PNO_SQ;

-- 테이블 생성
CREATE TABLE JOB(
    jNO     NUMBER(2),
    jNAME   VARCHAR2(50) NOT NULL,
    PRIMARY KEY(jNO));
    
CREATE TABLE PERSON(
    pNO     NUMBER(5),
    pNAME   VARCHAR2(50) NOT NULL,
    jNO     NUMBER(2) NOT NULL,
    KOR     NUMBER(3) CHECK(KOR >= 0),
    ENG     NUMBER(3) CHECK(ENG >= 0),
    MAT     NUMBER(3) CHECK(MAT >= 0),
    PRIMARY KEY(pNO),
    FOREIGN KEY(jNO) REFERENCES JOB(jNO));

CREATE SEQUENCE PERSON_PNO_SQ
    MAXVALUE 99999
    NOCACHE
    NOCYCLE;
    
-- 데이터 INSERT / 직업 3개
INSERT INTO JOB VALUES (10, '배우');
INSERT INTO JOB VALUES (20, '가수');
INSERT INTO JOB VALUES (30, '스태프');
SELECT * FROM JOB;

INSERT INTO PERSON VALUES (PERSON_PNO_SQ.NEXTVAL, '정우성', 10, 90, 80, 81);
INSERT INTO PERSON VALUES (PERSON_PNO_SQ.NEXTVAL, '박세영', 10, 80, 90, 80);
INSERT INTO PERSON VALUES (PERSON_PNO_SQ.NEXTVAL, '배수지', 20, 20, 90, 90);
INSERT INTO PERSON VALUES (PERSON_PNO_SQ.NEXTVAL, '설수현', 20, 95, 95, 95);
INSERT INTO PERSON VALUES (PERSON_PNO_SQ.NEXTVAL, '송혜교', 10, 100, 100, 100);
SELECT * FROM PERSON;

COMMIT;