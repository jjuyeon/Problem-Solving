-- 중복 제거하기(NULL인 경우 제거, 중복되는 이름 제거)
-- 중복 제거된 속성의 갯수를 구하고 싶으면 COUNT(DISTINCT ~) **순서 조심**

SELECT COUNT(DISTINCT NAME) AS 'count' FROM ANIMAL_INS WHERE NAME IS NOT NULL;