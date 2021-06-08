-- 보호소 중성화X -> 보호소를 나갈 때 중성화O 된 동물의 아이디, 생물 종, 이름을 조회 & 아이디 순으로 조회
-- 중성화를 거치지 않은 동물은 성별 및 중성화 여부에 Intact, 중성화를 거친 동물은 Spayed 또는 Neutered라고 표시

-- 특정 문자열 포함된 데이터 검색: "칼럼 명" LIKE '%A%' // 앞, 뒤 문자열 상관없이 중간에 A를 포함한 데이터 가져옴
-- 특정 문자열의 데이터 검색: "칼럼 명" = 'A'
-- 특정 문자열 제외한 데이터 검색: NOT "칼럼 명" = 'A'

SELECT I.ANIMAL_ID, I.ANIMAL_TYPE, I.NAME
FROM ANIMAL_INS AS I
JOIN ANIMAL_OUTS AS O USING (ANIMAL_ID)
WHERE SEX_UPON_INTAKE LIKE 'Intact %' AND NOT SEX_UPON_OUTCOME LIKE 'Intact %'
ORDER BY I.ANIMAL_ID;