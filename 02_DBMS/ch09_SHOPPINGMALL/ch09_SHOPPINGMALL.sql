-- [IX] 쇼핑몰 DB

DROP TABLE CART;
DROP TABLE ORDER_DETAIL;
DROP TABLE ORDERS;
DROP TABLE MEMBER;
DROP TABLE PRODUCT;

CREATE TABLE MEMBER(
    mID     VARCHAR2(20),
    mNAME   VARCHAR2(50) NOT NULL,
    mADDR   VARCHAR2(255),
    mTEL    VARCHAR2(40),
    mMAIL   VARCHAR2(40) NOT NULL,
    PRIMARY KEY(mID));
    
CREATE TABLE PRODUCT(
    pCODE   VARCHAR2(5),
    PNAME   VARCHAR(50) NOT NULL,
    PRICE   NUMBER(6) NOT NULL CHECK(PRICE > 0),
    pSTOCK  NUMBER(3) NOT NULL CHECK(pSTOCK >= 0),
    PRIMARY KEY(pCODE));

DROP SEQUENCE CART_SEQ;
CREATE SEQUENCE CART_SEQ
    MAXVALUE 999999999
    NOCACHE;
    
CREATE TABLE CART(
    cNO     NUMBER(9),
    mID     VARCHAR2(10) NOT NULL,
    pCODE   VARCHAR2(5) NOT NULL,
    QTY     NUMBER(3) NOT NULL CHECK(QTY > 0),
    COST    NUMBER(9),
    PRIMARY KEY(cNO),
    FOREIGN KEY(mID) REFERENCES MEMBER(mID),
    FOREIGN KEY(pCODE) REFERENCES PRODUCT(pCODE));
    
DROP SEQUENCE ORDERS_SEQ;
CREATE SEQUENCE ORDERS_SEQ
    MAXVALUE 999
    NOCACHE;
    
CREATE TABLE ODERS(
    oNO     NUMBER(9),
    mID     VARCHAR2(10) NOT NULL,
    oNAME   VARCHAR2(50) NOT NULL,
    oADDR   VARCHAR2(255) NOT NULL,
    oDATE   DATE DEFAULT SYSDATE,
    PRIMARY KEY(oNO),
    FOREIGN KEY(mID) REFERENCES MEMBER(mID));
    
DROP SEQUENCE ORDER_DETAIL_SEQ;
CREATE SEQUENCE ORDER_DETAIL_SEQ
    MAXVALUE 999999999
    NOCYCLE
    NOCACHE;
    
CREATE TABLE ORDER_DETAIL(
    odNO    NUMBER(9),
    oNO     NUMBER(9) NOT NULL,
    pCODE   VARCHAR2(5) NOT NULL,
    QTY     NUMBER(3) NOT NULL CHECK(QTY > 0),
    COST    NUMBER(9),
    PRIMARY KEY(odNO),
    FOREIGN KEY(oNO) REFERENCES ORDERS(oNO),
    FOREIGN KEY(pCODE) REFERENCES PRODUCT(pCODE));

-- 회원 정보 입력
INSERT INTO MEMBER VALUES ('abc','홍길동','서울 서대문구','010-9999-9999','hong@hong.com');
INSERT INTO MEMBER VALUES ('def','김김동','경기도 수원시','010-8888-8888','kim@kim.com');
SELECT * FROM MEMBER;

-- 상품 정보 입력
INSERT INTO PRODUCT VALUES ('A1', '맥주', 3000, 200);
INSERT INTO PRODUCT VALUES ('A2', '마스크', 200, 500);
INSERT INTO PRODUCT VALUES ('B1', '땅콩', 3000, 200);
INSERT INTO PRODUCT VALUES ('B2', '오징어', 5000, 200);
INSERT INTO PRODUCT VALUES ('C1', '소독약', 7000, 200);
SELECT * FROM PRODUCT;    

-- 주문번호
-- '230102' || '001' --> '230102001'
SELECT TO_CHAR(SYSDATE,'RRMMDD')||TRIM(TO_CHAR(ORDERS_SEQ.NEXTVAL, '000')) oNO FROM DUAL;
-- 주문번호 초기화
DROP SEQUENCE ORDERS_SEQ;
CREATE SEQUENCE ORDERS_SEQ MAXVALUE 999 NOCACHE;

    
-- ■ 홍길동 주문서
INSERT INTO CART VALUES (CART_SEQ.NEXTVAL, 
    'abc', 'A1', 3, (select price from product where pcode='A1')*3);
INSERT INTO CART VALUES (CART_SEQ.NEXTVAL, 
    'abc', 'B1', 1, (select price from product where pcode='B1')*1);

-- cart 확인
SELECT ORDER_DETAIL_SEQ.NEXTVAL odNO, 
        TO_CHAR(SYSDATE, 'RRMMDD')||TRIM(TO_CHAR(ORDERS_SEQ.CURRVAL, '000')) ono, 
        pcode, qty, cost 
    FROM CART 
    WHERE MID = 'abc';
    
-- ORDERS(주문)테이블
INSERT INTO ORDERS (ONO, MID, ONAME, OADDR, OTEL)
    VALUES (TO_CHAR(SYSDATE, 'RRMMDD')||TRIM(TO_CHAR(ORDERS_SEQ.NEXTVAL, '000')),
            'abc', '홍길동', '서울시 서대문구', '010-9999-9999');
            
-- ORDER_DETAIL(주문상세) 테이블
INSERT INTO ORDER_DETAIL (odNO, oNO, pCODE, QTY, COST)
    SELECT ORDER_DETAIL_SEQ.NEXTVAL, 
        TO_CHAR(SYSDATE, 'RRMMDD')||TRIM(TO_CHAR(ORDERS_SEQ.CURRVAL, '000')) ono, 
        pcode, qty, cost 
    FROM CART  WHERE MID='abc'; -- 서브쿼리 이용하여 장바구니의 모든 상품을 주문할 경우    
    
-- 일부 상품만 구매할 경우 서브쿼리를 이용하지 않고 따로 따로 입력

-- A1, 맥주, 3000, 2개
INSERT INTO ORDER_DETAIL (odNO, oNO, pCODE, QTY, COST)
    VALUES (ORDER_DETAIL_SEQ.NEXTVAL,
    TO_CHAR(SYSDATE, 'RRMMDD')||TRIM(TO_CHAR(ORDERS_SEQ.CURRVAL, '000')),
    'A1', 
    2, 
    (SELECT PRICE FROM PRODUCT WHERE pCODE='A1')*2);

UPDATE PRODUCT SET pSTOCK = pSTOCK-2 WHERE pCODE='A1'; -- 재고 수량 수정

-- B1, 땅콩, 3000, 1개
INSERT INTO ORDER_DETAIL (odNO, oNO, pCODE, QTY, COST)
    VALUES
    (ORDER_DETAIL_SEQ.NEXTVAL, 
    TO_CHAR(SYSDATE, 'RRMMDD')||TRIM(TO_CHAR(ORDERS_SEQ.CURRVAL, '000')), 
    'B1',
    1, 
    (SELECT PRICE FROM PRODUCT WHERE pCODE='B1')*1);
    
UPDATE PRODUCT SET pSTOCK = pSTOCK-1 WHERE pCODE='B1';-- 재고 수량 수정

-- C1, 소독약, 7000, 1개
INSERT INTO ORDER_DETAIL (odNO, oNO, pCODE, QTY, COST)
    VALUES
    (ORDER_DETAIL_SEQ.NEXTVAL, 
    TO_CHAR(SYSDATE, 'RRMMDD')||TRIM(TO_CHAR(ORDERS_SEQ.CURRVAL, '000')), 
    'C1',
    1, 
    (SELECT PRICE FROM PRODUCT WHERE pCODE='C1')*1);
    
UPDATE PRODUCT SET pSTOCK = pSTOCK-1 WHERE pCODE = 'C1';-- 재고 수량 수정

DELETE FROM CART WHERE MID = 'abc';-- 장바구니 비우기
DELETE FROM CART WHERE pCODE = 'A1' and MID = 'abc'; -- 특정 상품만 구매한 경우 장바구니 비우기

-- 주문서에 필요한 데이터 출력
-- 현재 주문번호만 SELECT절에 현재 시퀀스값을 이용하여 가져올 수 있으나 시퀀스.
    -- CURRVAL은 WHERE절에서 사용할 수 없음
SELECT TO_CHAR(SYSDATE, 'RRMMDD')||TRIM(TO_CHAR(ORDERS_SEQ.CURRVAL, '000')) ONO FROM DUAL; 

SELECT * FROM ORDERS WHERE ONO = 230102003;

SELECT O.PCODE, PNAME, PRICE, QTY, COST
    FROM ORDER_DETAIL O, PRODUCT P
    WHERE O.PCODE = P.PCODE AND
        ONO = 230102003;
        
SELECT * FROM ORDERS;
SELECT * FROM ORDER_DETAIL;
SELECT * FROM PRODUCT;