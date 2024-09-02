-- round: 반올림
-- ifnull: 길이가 null인 경우, 10으로 치환

select ROUND(AVG(ifnull(length, 10)), 2) as AVERAGE_LENGTH
from FISH_INFO;


