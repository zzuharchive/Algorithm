-- DISTINCT는 함수가 아니다.
-- EXTRACT를 통해 원하는 날짜 데이터를 추출할 수 있다.
-- 여기에 입력되어 있는 날짜 데이터가 SQL의 날짜 형식과 맞지 않아 수정한 후, 데이터 추출 진행
SELECT DISTINCT COUNT(FISH_TYPE) AS FISH_COUNT, EXTRACT(MONTH FROM DATE_FORMAT(TIME, "%Y-%m-%d")) AS MONTH
FROM FISH_INFO 
GROUP BY MONTH
ORDER BY MONTH ASC;
