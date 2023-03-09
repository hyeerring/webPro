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
-- 1. ȸ������ �� ID �ߺ�üũ
-- public int confirmId(String cid)
-- SELECT * FROM CUSTOMER WHERE CID='AAA';
SELECT COUNT(*) CNT FROM CUSTOMER WHERE CID='AAA';

-- 2. ȸ������
--  public int joinCustomer(CustomerDto dto)
INSERT INTO CUSTOMER (cID, cPW, cNAME, cTEL, cEMAIL, cADDRESS, cBIRTH, cGENDER)
    VALUES ('AAA', '111', '�ϱ浿', '010-1111-1111', 'aaa@test.co.kr', '������ ������', 
    '1995-01-01', 'M');

-- 3. �α���
-- public int loginCheck(String cid, String cpw);
-- SELECT * FROM MEMBER WHERE cID = 'AAA' AND cPW = '111';
SELECT cID, cPW FROM CUSTOMER WHERE cID='AAA' AND cPW='111';

-- 4. cID�� DTO��������
-- ȸ������ ���� �� ȸ�� ���� ��������
-- public CustomerDto getCustomer(String cid)
SELECT * FROM CUSTOMER WHERE cID='AAA';

-- 5. ȸ����������
-- public int modifyCustomer(CustomerDto dto)
UPDATE CUSTOMER SET
    cPW = '111',
    cNAME = '��浿',
    cTEL = '010-1111-1111',
    cEMAIL = 'aaa@test.com',
    cADDRESS = '������ ������',
    cBIRTH = '1995-01-01',
    cGENDER = 'M'
    WHERE cID = 'AAA';
    
COMMIT;