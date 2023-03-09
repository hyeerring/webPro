-- DROP
DROP TABLE FRIEND;
DROP SEQUENCE FRIEND_NO_SEQ;

-- CREATE
CREATE SEQUENCE FRIEND_NO_SEQ
    START WITH 1
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;
    
CREATE TABLE FRIEND(
    NO      NUMBER(4) PRIMARY KEY,
    NAME    VARCHAR2(50) NOT NULL,
    TEL     VARCHAR2(50)
    );


-- 1. ģ�� �߰�
-- public int joinFriend(FriendDto dto)
INSERT INTO FRIEND (NO, NAME, TEL) VALUES 
    (FRIEND_NO_SEQ.NEXTVAL, '�ϱ浿', '010-1111-1111');
INSERT INTO FRIEND (NO, NAME, TEL) VALUES (FRIEND_NO_SEQ.NEXTVAL, '�̱浿', '010-2222-2222');

COMMIT;

-- 2. ģ�� ��� ���
-- public FriendDto getFriend()
SELECT * FROM FRIEND;

-- 3. ģ�� �˻�
-- public ArrayList<FriendDto> getSchFriend()
SELECT * FROM FRIEND
    WHERE NAME LIKE '%'||'��'||'%' AND TEL LIKE '%'||'11'||'%';

