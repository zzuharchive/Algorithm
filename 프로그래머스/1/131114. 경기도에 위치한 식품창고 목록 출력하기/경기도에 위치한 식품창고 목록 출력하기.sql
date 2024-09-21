select WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, ifnull(FREEZER_YN, "N") FREEZER_YN
from FOOD_WAREHOUSE
where warehouse_name like "%경기%"
order by WAREHOUSE_ID asc;
