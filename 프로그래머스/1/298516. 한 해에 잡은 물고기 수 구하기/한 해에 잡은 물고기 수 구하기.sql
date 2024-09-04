-- date 작성 시, 따옴표로 묶어주기

select COUNT(ID) as FISH_COUNT
from FISH_INFO
where date_format(TIME, '%Y-%m-%d') between '2021-01-01' and '2021-12-31';