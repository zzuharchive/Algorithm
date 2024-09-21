--  QUARTER함수를 사용해 분기를 나눌 수 있다.

select CONCAT(QUARTER(DIFFERENTIATION_DATE),'Q') QUARTER, count(id) ECOLI_COUNT
from ecoli_data
group by quarter
order by quarter asc;