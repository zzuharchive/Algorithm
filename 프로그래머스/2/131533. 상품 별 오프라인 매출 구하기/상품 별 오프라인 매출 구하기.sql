SELECT p.PRODUCT_CODE, SUM(p.price * o.sales_amount) SALES
FROM PRODUCT p
INNER JOIN OFFLINE_SALE o
ON p.product_id = o.product_id
GROUP BY p.PRODUCT_CODE
ORDER BY SALES desc, p.product_code asc;