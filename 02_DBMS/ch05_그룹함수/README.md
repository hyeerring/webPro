## [05] 그룹함수

**💡그룹함수란?**

하나 이상의 행을 그룹으로 묶어 연산하여 총합, 평균 등 하나의 결과로 나타낸다.

| 함수     | 설명             |
| -------- | ---------------- |
| SUM      | 그룹의 누적 합계 |
| AVG      | 그룹의 평균      |
| COUNT    | 그룹의 총 갯수   |
| MAX      | 그룹의 최대값    |
| MIN      | 그룹의 최소값    |
| STDDEV   | 그룸의 표준편차  |
| VARIANCE | 그룹의 분산      |

### GROUP BY절

- 같은 값을 가진 행을 그룹짓는 SQL 명령어
- GROUP BY는 COUNT(), MAX(), MIN(), SUM(), AVG() 등 집계 함수와 함께 사용된다.
- GROUP BY절은 각 그룹의 하나만을 리턴한다.
- GROUP BY 절 다음에는 칼럼의 별칭을 사용할 수 없으며, 반드시 칼럼명을 기술해야 한다.

```sql
-- ex. 부서번호별 최대 급여, 평균 급여 / 부서번호 순 정렬
SELECT DEPTNO, MAX(SAL), AVG(SAL) 
    FROM EMP 
    GROUP BY DEPTNO 
    ORDER BY DEPTNO;
```



### HAVING절

```SQL
SELECT column, group_function
[ FROM table ]
[ WHERE search_condition ]
[ GROUP BY group_by_expression ]
[ HAVING group_condition ]
[ ORDER BY column ];
```

- SELECT 절에 조건을 사용하여 결과를 제한할 때는 WHERE 절을 사용하지만 그룹의 결과를 제한할 때에는 HAVING 절을 사용한다.
- HAVING 절은 GROUP BY 절 앞에 기술 가능하지만 GROUP BY 절 다음에 기술하는 것이 논리적으로 권장되고 있다. HAVING 절이 SELECT 절에 있는 그룹에 적용되기 전에 그룹이 구성된다.