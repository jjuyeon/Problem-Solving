-- 0~23시 각 시간대별로 입양이 몇 건 발생했는지 조회 & 시간대 순으로 정렬

-- Reference: https://chanhuiseok.github.io/posts/db-6/
-- ** 알아야 할 것 **
-- 쿼리문에서 로컬 변수를 활용하는 문제
-- SQL에서 변수를 선언하는 SET
-- 프로시저가 끝나도 계속 유지되는 @ 변수
--  PL/-SQL 문법에서 :=은 대입 연산을 의미(비교 연산자 =과 혼동을 피하기 위함)

SET @HOUR = -1; -- 변수 선언
SELECT (@HOUR := @HOUR+1) AS HOUR, 
(SELECT COUNT(*) FROM ANIMAL_OUTS WHERE HOUR(DATETIME) = @HOUR) AS COUNT
FROM ANIMAL_OUTS
WHERE @HOUR<23;