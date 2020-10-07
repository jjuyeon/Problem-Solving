-- 보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회 & 보호 시작일이 빠른 순으로 조회
-- 보호시작일: ANIMAL_INS / 입양일: ANIMAL_OUTS

-- NATURAL JOIN: INNER JOIN 조건이 '='일 때 동일한 속성이 두 번 나타나게 되는데, 이 중 중복을 제거하여 같은 속성을 한번만 표시
-- NATURAL JOIN의 단점: 동일한 이름을 가지는 칼럼이 둘 이상인 경우 NATURAL JOIN 사용 불가능
-- USING(): 단점을 해결하기 위해 USING문을 사용하면 칼럼을 선택해서 조인할 수 있음 / **NATURAL 절과 USING 절은 함께 사용할 수 없음**
-- *(여러 테이블 간 조인 & NATURAL, USING 모두 사용가능)*? 가독성이 좋은 USING 절을 이용하는 방법을 추천

SELECT I.ANIMAL_ID, I.NAME
FROM ANIMAL_INS AS I
JOIN ANIMAL_OUTS AS O USING (ANIMAL_ID)
WHERE I.DATETIME > O.DATETIME
ORDER BY I.DATETIME;