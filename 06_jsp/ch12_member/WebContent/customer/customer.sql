-- TABLE DROP & CREATE
DROP TABLE CUSTOMER;

-- CREATE TABLE
CREATE TABLE CUSTOMER(
    cID VARCHAR2(50) PRIMARY KEY,
    cPW VARCHAR2(50) NOT NULL,
    cNAME VARCHAR2(50) NOT NULL,
    cTEL VARCHAR2(50),
    cEMAIL VARCHAR2(50),
    cADDRESS VARCHAR2(250),
    cBIRTH DATE,
    cGENDER VARCHAR2(1) CHECK(cGENDER = 'M' OR cGENDER = 'F'),
    cRDATE DATE DEFAULT SYSDATE NOT NULL
    );
    
SELECT * FROM CUSTOMER;
-- 1. 회원가입 시 ID 중복체크
-- public int confirmId(String cid)
-- SELECT * FROM CUSTOMER WHERE CID='AAA';
SELECT COUNT(*) CNT FROM CUSTOMER WHERE CID='AAA';

-- 2. 회원가입
--  public int joinCustomer(CustomerDto dto)
INSERT INTO CUSTOMER (cID, cPW, cNAME, cTEL, cEMAIL, cADDRESS, cBIRTH, cGENDER)
    VALUES ('AAA', '111', '일길동', '010-1111-1111', 'aaa@test.co.kr', '강원도 강릉시', 
    '1995-01-01', 'M');

-- 3. 로그인
-- public int loginCheck(String cid, String cpw);
-- SELECT * FROM MEMBER WHERE cID = 'AAA' AND cPW = '111';
SELECT cID, cPW FROM CUSTOMER WHERE cID='AAA' AND cPW='111';

-- 4. cID로 DTO가져오기
-- 회원정보 수정 시 회원 정보 가져오기
-- public CustomerDto getCustomer(String cid)
SELECT * FROM CUSTOMER WHERE cID='AAA';

-- 5. 회원정보수정
-- public int modifyCustomer(CustomerDto dto)
UPDATE CUSTOMER SET
    cPW = '111',
    cNAME = '김길동',
    cTEL = '010-1111-1111',
    cEMAIL = 'aaa@test.com',
    cADDRESS = '강원도 강릉시',
    cBIRTH = '1995-01-01',
    cGENDER = 'M'
    WHERE cID = 'AAA';
    
COMMIT;