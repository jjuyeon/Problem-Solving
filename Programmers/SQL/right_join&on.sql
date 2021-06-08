-- 보호소에 들어온 기록이 없는 동물의 ID와 이름을 ID 순으로 조회

-- JOIN(=INNER JOIN) : 교집합
-- LEFT JOIN : 왼쪽 테이블을 중심으로 오른쪽 테이블 매치
-- RIGHT JOIN: 오른쪽 테이블을 중심으로 왼쪽 테이블 매치
-- OUTER JOIN : LEFT+RIGHT JOIN // 잘 사용 x

-- ON: 무엇을 기준으로 두 관계를 JOIN할 건지 정의 (WHERE과 비슷)

-- NATURAL JOIN: INNER JOIN 조건이 '='일 때 동일한 속성이 두 번 나타나게 되는데, 이 중 중복을 제거하여 같은 속성을 한번만 표시
-- NATURAL JOIN의 단점: 동일한 이름을 가지는 칼럼이 둘 이상인 경우 NATURAL JOIN 사용 불가능
-- USING(): 단점을 해결하기 위해 USING문을 사용하면 칼럼을 선택해서 조인할 수 있음 / **NATURAL 절과 USING 절은 함께 사용할 수 없음**
-- *(여러 테이블 간 조인 & NATURAL, USING 모두 사용가능)*? 가독성이 좋은 USING 절을 이용하는 방법을 추천

SELECT O.ANIMAL_ID, O.NAME 
FROM ANIMAL_INS AS I 
RIGHT JOIN ANIMAL_OUTS AS O 
ON I.ANIMAL_ID = O.ANIMAL_ID 
WHERE I.ANIMAL_ID IS NULL;