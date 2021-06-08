-- 각 시간대별로 몇 건 발생하는지 조회 & 시간대 순으로 정렬
-- 시간에서 시간대를 추출하는 HOUR 함수 사용

-- DATETYPE 이란? 날짜와 시간 표시(년-월-일 시:분:초)
-- *날짜 데이터에서 원하는 데이터만 추출하는 함수*
-- YEAR() / MONTH() / DAY() / HOUR() / MINUTE() / SECOND()

-- 계속 틀린 이유: HAVING으로 '9시부터 19시까지 조회'하는 예외처리를 안함
SELECT HOUR(DATETIME) HOUR, COUNT(DATETIME) COUNT
FROM ANIMAL_OUTS
GROUP BY HOUR(DATETIME)
HAVING HOUR >= 9 and HOUR <= 19
ORDER BY HOUR