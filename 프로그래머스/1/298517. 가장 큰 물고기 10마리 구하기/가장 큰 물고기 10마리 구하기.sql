-- limit: 출력개수 제한
select ID, LENGTH
from FISH_INFO
order by LENGTH desc, ID asc
limit 10;
