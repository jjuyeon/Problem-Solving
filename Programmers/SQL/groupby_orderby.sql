-- 고양이와 개를 그룹화하여 출력 & 고양이를 개보다 먼저 조회
SELECT ANIMAL_TYPE, COUNT(ANIMAL_TYPE) AS "count" FROM ANIMAL_INS GROUP BY ANIMAL_TYPE ORDER BY ANIMAL_TYPE;