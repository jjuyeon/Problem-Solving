-- 동명 동물 수 출력(두 번 이상 쓰인 이름, 해당 이름이 쓰인 횟수) & 이름이 없는 동물은 제외 & 이름 순 정렬
SELECT NAME, COUNT(NAME) AS "COUNT" FROM ANIMAL_INS GROUP BY NAME HAVING COUNT(NAME)>1 ORDER BY NAME;