-- 오름차순: asc, 내림차순 desc => order by와 함께 사용하기!
select ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPER_INFOS
where SKILL_1 = "Python" or SKILL_2 = "Python" or SKILL_3 = "Python"
order by ID ASC;