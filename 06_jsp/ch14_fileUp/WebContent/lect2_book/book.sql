-- ch14_FILEUP ����
DROP TABLE BOOK;
DROP SEQUENCE BOOK_SEQ;

-- VARCHAR2(4000)�� �ִ� / �� �̻��� CLOB
CREATE TABLE BOOK(
    bID         NUMBER(7) PRIMARY KEY, 
    bTITLE      VARCHAR2(100) NOT NULL, -- å �̸�
    bPRICE      NUMBER(6) NOT NULL, -- å ����
    bIMAGE1     VARCHAR2(100) NOT NULL, -- ��ǥ�̹���
    bIMAGE2     VARCHAR2(100) NOT NULL, -- �߰��̹���
    bCONTENT    VARCHAR2(4000), -- å ����
    bDISCOUNT   NUMBER(3) NOT NULL, -- ������
    bRDATE      DATE DEFAULT SYSDATE NOT NULL -- �����
);

SELECT * FROM BOOK;

CREATE SEQUENCE BOOK_SEQ
    MAXVALUE 9999999
    NOCACHE
    NOCYCLE;

-- å ���
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '�̰��� �ڹٴ�', 25000, 'noImg.png', 'nothing.png', '�ڹ� ���ʺ��� źź�ϰ�', 10);

INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '�̰��� HTML�̴�', 22000, 'noImg.png', 'nothing.png', 'HTML ���ʺ��� źź�ϰ�', 0);
    
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '����źź �ڹ�', 24000, 'noImg.png', 'nothing.png', '���ʺ��� źź�ϰ�', 15);
    
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '����źź JSP', 32000, 'noImg.png', 'nothing.png', 'JSP ���ʺ��� źź�ϰ�', 20);
    
ROLLBACK;
COMMIT;

-- LIST ���
-- > PAGING ����
SELECT * FROM BOOK ORDER BY bRDATE DESC;

-- > PAGING �߰�
SELECT * FROM (SELECT ROWNUM RN, A.* 
         FROM (SELECT * FROM BOOK ORDER BY bRDATE DESC) A)
    WHERE RN BETWEEN 1 AND 3;
-- (+ ��ϵ� å ����)
SELECT COUNT(*) FROM BOOK;
-- �󼼺���(bID�� å ���� ��������)
SELECT * FROM BOOK WHERE bID = 2;

UPDATE BOOK SET BTITLE = '3�� ������� ��ȣ' WHERE BID ='2';
