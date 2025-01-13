-- * 상위 n개 레코드 추출하기 *
-- from절 subquery에 
-- RANK() OVER (PARTITION BY 그룹컬럼 ORDER BY 정렬기준컬럼) 사용
SELECT NAME
FROM (
    SELECT
        name, 
        RANK() OVER (ORDER BY DATETIME) rnk
    FROM ANIMAL_INS
) sub
WHERE rnk = 1