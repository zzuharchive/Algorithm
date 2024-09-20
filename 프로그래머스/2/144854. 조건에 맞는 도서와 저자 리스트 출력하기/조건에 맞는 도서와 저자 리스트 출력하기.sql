select b.BOOK_ID, a.AUTHOR_NAME, DATE_FORMAT(b.PUBLISHED_DATE, "%Y-%m-%d") PUBLISHED_DATE
from author a
right join book b
on b.author_id = a.author_id
where b.category = "경제"
order by PUBLISHED_DATE ASC;