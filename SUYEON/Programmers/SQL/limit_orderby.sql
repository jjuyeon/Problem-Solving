-- 입양을 못간 동물 중, 가장 오래 보호소에 있었던 동물 3마리의 이름과 보호 시작일을 조회 & 보호 시작일 순으로 조회
-- ※ 입양을 가지 못한 동물이 3마리 이상인 경우만 입력으로 주어짐

-- 상위 N개 출력: 쿼리 마지막에 LIMIT N(EX. 5)
-- 하위 N개 출력: ORDER BY (기준 컬럼) ASC LIMIT N; - 내림차순 후 LIMIT 절

SELECT I.NAME, I.DATETIME
FROM ANIMAL_INS AS I
LEFT JOIN ANIMAL_OUTS AS O
ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE O.ANIMAL_ID IS NULL
ORDER BY I.DATETIME ASC
LIMIT 3;