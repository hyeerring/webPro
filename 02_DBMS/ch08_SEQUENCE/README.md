## [08] SEQUENCE

**💡시퀀스란?**

순차적인 번호를 자동으로 생성하는 객체로 테이블과 독립적으로 생성 및 저장 가능

### 시퀀스(Sequence)의 특징

- 시퀀스에서 생성되는 번호는 유일하기 때문에 주로 본 테이블에서 인조 Primary Key 생성시 사용
- 여러 테이블에 의해 공유 가능
- 시퀀스는 테이블과 관계없이 생성, 저장
- 오라클 내부 루틴에 의해 발생, 증가, 감소된다.

### 시퀀스(Sequence) 문법

```sql
CREATE SEQUENCE sequence_name 
[START WITH n]
[INCREMENT BY n] 
[MAXVALUE n]
[MINVALUE n]
[CYCLE | NOCYCLE]
[CACHE n | NOCACHE];

CREATE SEQUENCE FRIEND_SEQ
	START WITH 1       -- 1부터 시작
    INCREMENT BY 1     -- 1씩 증가
    MAXVALUE 9999      -- 최대값
    MINVALUE 1         -- 최소값
    NOCACHE
    NOCYCLE;
    
-- 시퀀스 삭제
DROP SEQUENCE sequence_name;

-- 시퀀스 수정
ALTER SEQUENCE sequence_name [INCREMENT BY n] [START WITH n] [MAXVALUE n][MINVALUE n];
```

