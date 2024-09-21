select b.category CATEGORY, sum(bs.sales) TOTAL_SALES
from book b
inner join book_sales bs
on b.book_id = bs.book_id
where date_format(bs.sales_date,"%Y-%m") = "2022-01"
group by category
order by category asc;