-- TABLE DROP & CREATE
DROP TABLE MEMBER;

CREATE TABLE MEMBER(
	ID VARCHAR2(30) PRIMARY KEY,
	PW VARCHAR2(30) NOT NULL,
	NAME VARCHAR2(30) NOT NULL,
	PHONE1 VARCHAR2(5),
	PHONE2 VARCHAR2(5),
	PHONE3 VARCHAR2(5),
	GENDER VARCHAR2(1),
	EMAIL VARCHAR2(30),
	BIRTH DATE,
	ADDRESS VARCHAR2(255),
	RDATE DATE NOT NULL
	);
    
    SELECT * FROM MEMBER;
    
    -- 1. ȸ������ �� ID �ߺ�üũ
    -- public int confirmId(String id)
    SELECT * FROM MEMBER WHERE ID = 'TEST';
    
    -- 2. ȸ������
    --  public int joinMember(MemberDto dto)
    INSERT INTO MEMBER (ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, ADDRESS, RDATE)
        VALUES ('AAA', '111', 'ȫ�浿', '02', '1234', '5678', 'M', 'TEST@GOOGLE.COM', '1995-01-01', '������ ������', SYSDATE);
        
    -- 3. �α���
    -- public int loginCheck(String id, String pw);
    -- SELECT * FROM MEMBER WHERE ID = 'AAA' AND PW = '111';
    SELECT * FROM MEMBER WHERE ID = 'AAA';
    SELECT * FROM MEMBER WHERE PW = '111';
    
    SELECT ID, PW FROM MEMBER WHERE ID = 'AAA';
    
    -- 4. ID�� DTO ��������
    -- �α��� ���� �� session�� setAttribute
    -- ȸ������ ���� �� ȸ�� ���� ��������
    -- public MemberDto getMember(String id)
    SELECT * FROM MEMBER WHERE ID = 'AAA';

    -- 5. ȸ����������
    -- public int modifyMember(MemberDto dto)
    UPDATE MEMBER SET PW = '111',
        NAME = '�ϱ浿',
        PHONE1 = '010',
        PHONE2 = '1111',
        PHONE3 = '1111',
        GENDER = 'M',
        EMAIL = 'aaa@test.com',
        BIRTH = '1995-01-01',
        ADDRESS = '������ ������'
        WHERE ID = 'AAA';
    
    COMMIT;
    