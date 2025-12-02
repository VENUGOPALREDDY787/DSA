# Write your MySQL query statement below
SELECT prices.product_id, IFNULL(average_price, 0) as average_price FROM (
    SELECT innerTable.product_id, ROUND(SUM(innerTable.totalPrice) / SUM(innerTable.units), 2) AS average_price FROM (
    SELECT unitsSold.product_id,unitsSold.units, (unitsSold.units * prices.price) as totalPrice, prices.price as sold_price FROM 
UnitsSold as unitsSold
LEFT JOIN Prices as prices
ON unitsSold.product_id = prices.product_id AND unitsSold.purchase_date BETWEEN prices.start_date AND prices.end_date
) as innerTable
GROUP BY innerTable.product_id
) as resultTable
RIGHT JOIN Prices as prices
ON prices.product_id = resultTable.product_id
GROUP BY prices.product_id;