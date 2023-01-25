-- 01. 회원가입
-- 전화번호와 이름을 입력받아 회원가입
    -- public int insertCustomer(String ctel, String cname)
    -- public int insertCustomer(CustomerDto dto)
INSERT INTO CUSTOMER(CID, CTEL, CNAME)
    VALUES (SUPERMARKET_CUSTOMER_SQ.NEXTVAL, '01055551111', '뷔');
    
COMMIT;
ROLLBACK;
-- 02. 핸드폰 뒷자리 4자리 검색
-- 핸드폰 뒷자리 4자리 또는 FULL번호를 입력받아 고객정보
-- (cid, ctel, cname, cpoint, camount, levelnaeme, forLevelUp)
    -- public ArrayList<CustomerDto> ctelGetCustomers(String searchTel)
SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, HIGH + 1 - CAMOUNT FORLEVELUP
    FROM CUSTOMER, LEVELGRADE
    WHERE CUSTOMER.LEVELNO = LEVELGRADE.LEVELNO; -- 최고레벨일 때 잘못 출력
    
SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 
    (SELECT HIGH + 1 - CAMOUNT FROM CUSTOMER WHERE LEVELNO != 50 AND CID = C.CID) FORLEVELUP 
    FROM CUSTOMER C, LEVELGRADE
    WHERE C.LEVELNO = LEVELGRADE.LEVELNO AND CTEL LIKE '%' || '2222'; 

-- VVIP FORLEVELUP = NULL

-- 03. 물품구입
-- 고객 id번호와 물품구매가격을 입력받아 구매처리
-- 03_1. (cid, price 입력받아 cpoint, camount, levelno update)
    -- public int buy(int cid, int price)
-- 03_2. (cid, ctel, cname, cpoint, camount, levelnaeme, forLevelUp) 출력
    -- public CustomerDto getcustomer(int cid)
    
-- 1) CAMOUNT, CPOINT 수정
UPDATE CUSTOMER SET CAMOUNT = CAMOUNT + 150000, CPOINT = CPOINT + (150000*0.05)
    WHERE CID = 2;

-- 2) 수정된 CAMOUNT에 따라 LEVEL 조정   
SELECT LEVELNO
    FROM CUSTOMER, LEVELGRADE
    WHERE CAMOUNT BETWEEN LOW AND HIGH
    AND CID = 2;
    
UPDATE CUSTOMER
    SET LEVELNO = (SELECT LEVELNO FROM CUSTOMER, LEVELGRADE
    WHERE CAMOUNT BETWEEN LOW AND HIGH AND CID = 2);

-- 3) 변경될 구매 누적 금액에 따라 고객의 레벨이 상향 조정될 경우 고객 레벨이 향상
UPDATE CUSTOMER
    SET CAMOUNT = CAMOUNT + 150000, 
    CPOINT = CPOINT + (150000 * 0.05),
    LEVELNO = (SELECT L.LEVELNO FROM CUSTOMER, LEVELGRADE L
               WHERE CAMOUNT + 150000 BETWEEN LOW AND HIGH AND CID = 2)
    WHERE CID = 2;
    
-- 4) 3번 후 바뀐 고객 정보를 출력 (cid, ctel, cname, cpoint, camount, levelname, forLevelUp)
    -- public CustomerDto getCustomer(int cid)
SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 
     (SELECT HIGH + 1 - CAMOUNT FROM CUSTOMER WHERE LEVELNO!=50 AND CID=C.CID) forLevelUp
  FROM CUSTOMER C, LEVELGRADE L
  WHERE C.LEVELNO=L.LEVELNO AND CID=3;
  
-- 04. 고객 등급별 출력
-- 04_1. 고객 등급 이름 확인
    -- public ArrayList<String> getLevelNamse()
SELECT LEVELNAME FROM LEVELGRADE;

-- 04_2. 조회를 원하는 등급을 입력받아 해당 레벨의 고객 정보 출력
-- ID, 전화번호, 이름, 포인트, 구매누적액, 고객레벨, 다음단계를 위한 구매금액)을 구매 누적액 순으로 출력
    -- public ArrayList<customerDto> levelNameGetCustomers(String levelName)
SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 
    (SELECT HIGH + 1 - CAMOUNT FROM CUSTOMER WHERE LEVELNO != 50 AND CID = C.CID) FORLEVELUP 
    FROM CUSTOMER C, LEVELGRADE
    WHERE C.LEVELNO = LEVELGRADE.LEVELNO AND LEVELNAME = 'VVIP'
    ORDER BY CAMOUNT DESC;  
    
-- 05. 전체 출력
-- 전체 고객 정보를 구매 누적액 순으로 출력
    -- public ArrayList<customerDto> getCustomers()
SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 
    (SELECT HIGH + 1 - CAMOUNT FROM CUSTOMER WHERE LEVELNO != 50 AND CID = C.CID) FORLEVELUP 
    FROM CUSTOMER C, LEVELGRADE
    WHERE C.LEVELNO = LEVELGRADE.LEVELNO
    ORDER BY CAMOUNT DESC;  
    
-- 06. 회원탈퇴
-- 전화번호를 입력받아 탈퇴처리
    -- public int deleteCustomer(String ctel)
DELETE FROM CUSTOMER WHERE CTEL = '01044444444';