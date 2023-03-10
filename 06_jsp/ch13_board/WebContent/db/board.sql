-- DROP TABLE
DROP TABLE BOARD;

-- CREATE
CREATE TABLE BOARD(
    NUM NUMBER(5,0) PRIMARY KEY,    -- �۹�ȣ
    WRITER VARCHAR2(30) NOT NULL,   -- �ۼ���
    SUBJECT VARCHAR2(100) NOT NULL, -- �� ����
    CONTENT VARCHAR2(4000) NOT NULL,    -- ����
    EMAIL VARCHAR2(50),             -- �ۼ��� �̸���
    READCOUNT NUMBER(5) DEFAULT 0,  -- HIT ��(��ȸ ��)
    PW VARCHAR2(30) NOT NULL,       -- ���� �� ��й�ȣ
    REF NUMBER(5,0) NOT NULL,       -- �� �׷�(�� ���� ��� �۹�ȣ / �亯���� ��� �� ���� REF)
    RE_STEP NUMBER(3) NOT NULL,     -- �� �׷� �� ��� ����(���� 0)
    RE_INDENT NUMBER(3) NOT NULL,   -- �� LIST ��� �� �� ���� �鿩���� ����(���� 0)
    IP VARCHAR2(30) NOT NULL,       -- �ۼ� �� ��ǻ�� IP�ּ�
    RDATE DATE DEFAULT SYSDATE      -- �ۼ� ����
);

SELECT * FROM BOARD;

-- 1. �� ����
SELECT COUNT(*) FROM BOARD;

-- 2. �� ���(�� �׷��� �ֽ��� ���� ���� ������)
SELECT * FROM BOARD ORDER BY REF DESC;

-- 3. �۾���(���۾���)
-- �۾���, �� ����, ����, �̸���, ��й�ȣ
    -- �� ��ȣ�� ����
    SELECT NVL(MAX(NUM),0)+1 FROM BOARD;
    
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES((SELECT NVL(MAX(NUM),0)+1 FROM BOARD), '��浿', '����1', '����', 'test@test.co.kr', '111',
          (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), 0, 0, '192.168.0.1');

INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES((SELECT NVL(MAX(NUM),0)+1 FROM BOARD), '�̱浿', '����2', '����', 'test@test.co.kr', '222',
          (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), 0, 0, '192.168.0.1');

COMMIT;
-- 4. �� ��ȣ�� �� �󼼺��� ����(DTO) ��������
    -- (+) �� ���� �ÿ��� ���
SELECT  * FROM BOARD WHERE NUM = 2;

-- 5. ��ȸ �� �ø���
UPDATE BOARD SET READCOUNT = READCOUNT +1 WHERE NUM = 1;
    -- (+) ��ȸ �� ����
    UPDATE BOARD SET READCOUNT = READCOUNT +10 WHERE NUM = 2;

-- 6. �� ����
UPDATE BOARD SET SUBJECT = '������ ����1',
                 CONTENT = '������ ����',
                 EMAIL = 'test111@test.co.kr',
                 PW = '111',
                 IP = '127.0.0.1'
    WHERE NUM = '1';

-- 7. �� ����(��й�ȣ�� �°� �Է��� ��츸 ����)
DELETE FROM BOARD WHERE NUM = 1 AND PW = '111';

ROLLBACK;
COMMIT;
