## [08] SEQUENCE

**π‘μνμ€λ?**

μμ°¨μ μΈ λ²νΈλ₯Ό μλμΌλ‘ μμ±νλ κ°μ²΄λ‘ νμ΄λΈκ³Ό λλ¦½μ μΌλ‘ μμ± λ° μ μ₯ κ°λ₯

### μνμ€(Sequence)μ νΉμ§

- μνμ€μμ μμ±λλ λ²νΈλ μ μΌνκΈ° λλ¬Έμ μ£Όλ‘ λ³Έ νμ΄λΈμμ μΈμ‘° Primary Key μμ±μ μ¬μ©
- μ¬λ¬ νμ΄λΈμ μν΄ κ³΅μ  κ°λ₯
- μνμ€λ νμ΄λΈκ³Ό κ΄κ³μμ΄ μμ±, μ μ₯
- μ€λΌν΄ λ΄λΆ λ£¨ν΄μ μν΄ λ°μ, μ¦κ°, κ°μλλ€.

### μνμ€(Sequence) λ¬Έλ²

```sql
CREATE SEQUENCE sequence_name 
[START WITH n]
[INCREMENT BY n] 
[MAXVALUE n]
[MINVALUE n]
[CYCLE | NOCYCLE]
[CACHE n | NOCACHE];

CREATE SEQUENCE FRIEND_SEQ
	START WITH 1       -- 1λΆν° μμ
    INCREMENT BY 1     -- 1μ© μ¦κ°
    MAXVALUE 9999      -- μ΅λκ°
    MINVALUE 1         -- μ΅μκ°
    NOCACHE
    NOCYCLE;
    
-- μνμ€ μ­μ 
DROP SEQUENCE sequence_name;

-- μνμ€ μμ 
ALTER SEQUENCE sequence_name [INCREMENT BY n] [START WITH n] [MAXVALUE n][MINVALUE n];
```

