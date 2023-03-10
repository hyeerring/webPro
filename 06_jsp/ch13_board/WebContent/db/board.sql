-- DROP TABLE
DROP TABLE BOARD;

-- CREATE
CREATE TABLE BOARD(
    NUM NUMBER(5,0) PRIMARY KEY,    -- 글번호
    WRITER VARCHAR2(30) NOT NULL,   -- 작성자
    SUBJECT VARCHAR2(100) NOT NULL, -- 글 제목
    CONTENT VARCHAR2(4000) NOT NULL,    -- 본문
    EMAIL VARCHAR2(50),             -- 작성자 이메일
    READCOUNT NUMBER(5) DEFAULT 0,  -- HIT 수(조회 수)
    PW VARCHAR2(30) NOT NULL,       -- 삭제 시 비밀번호
    REF NUMBER(5,0) NOT NULL,       -- 글 그룹(원 글의 경우 글번호 / 답변글의 경우 원 글의 REF)
    RE_STEP NUMBER(3) NOT NULL,     -- 글 그룹 내 출력 순서(원글 0)
    RE_INDENT NUMBER(3) NOT NULL,   -- 글 LIST 출력 시 글 제목 들여쓰기 정도(원글 0)
    IP VARCHAR2(30) NOT NULL,       -- 작성 시 컴퓨터 IP주소
    RDATE DATE DEFAULT SYSDATE      -- 작성 시점
);

SELECT * FROM BOARD;

-- 1. 글 갯수
SELECT COUNT(*) FROM BOARD;

-- 2. 글 목록(글 그룹이 최신인 글이 위로 가도록)
SELECT * FROM BOARD ORDER BY REF DESC;

-- 3. 글쓰기(원글쓰기)
-- 글쓴이, 글 제목, 본문, 이메일, 비밀번호
    -- 글 번호를 생성
    SELECT NVL(MAX(NUM),0)+1 FROM BOARD;
    
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES((SELECT NVL(MAX(NUM),0)+1 FROM BOARD), '김길동', '제목1', '본문', 'test@test.co.kr', '111',
          (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), 0, 0, '192.168.0.1');

INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES((SELECT NVL(MAX(NUM),0)+1 FROM BOARD), '이길동', '제목2', '본문', 'test@test.co.kr', '222',
          (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), 0, 0, '192.168.0.1');

COMMIT;
-- 4. 글 번호로 글 상세보기 내용(DTO) 가져오기
    -- (+) 글 수정 시에도 사용
SELECT  * FROM BOARD WHERE NUM = 2;

-- 5. 조회 수 올리기
UPDATE BOARD SET READCOUNT = READCOUNT +1 WHERE NUM = 1;
    -- (+) 조회 수 조작
    UPDATE BOARD SET READCOUNT = READCOUNT +10 WHERE NUM = 2;

-- 6. 글 수정
UPDATE BOARD SET SUBJECT = '수정된 제목1',
                 CONTENT = '수정된 본문',
                 EMAIL = 'test111@test.co.kr',
                 PW = '111',
                 IP = '127.0.0.1'
    WHERE NUM = '1';

-- 7. 글 삭제(비밀번호를 맞게 입력한 경우만 삭제)
DELETE FROM BOARD WHERE NUM = 1 AND PW = '111';

ROLLBACK;
COMMIT;
