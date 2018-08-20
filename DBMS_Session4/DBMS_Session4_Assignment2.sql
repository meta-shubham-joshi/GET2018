USE StoreFront;
SHOW Tables;

# SQL Query to create a Stored procedure to retrieve average sales of each product in a month. Month and year will be input parameter to function.

delimiter //
CREATE PROCEDURE Average_Sales(IN order_month INT, IN order_year INT)
BEGIN
SELECT po.Product_Id,SUM(po.Quantity) AS Average_Sales_Of_Product
FROM User_Order o 
INNER JOIN
Product_In_Order_Type po
ON o.Order_Id = po.Order_Id
WHERE MONTH(o.Order_Date) = order_month AND YEAR(o.Order_Date) = order_year
GROUP BY po.Product_Id;

END//

CALL Average_Sales('08','2018');


/*SQL Query to create a stored procedure to retrieve table having order detail with status for a given period. 
Start date and end date will be input parameter. Put validation on input dates like start date is less than end date.
If start date is greater than end date take first date of month as start date.
*/

delimiter //

CREATE PROCEDURE Order_Details_With_Stats(IN start_date DATE,IN end_date DATE)

BEGIN
SET start_date = IF(start_date < end_date, start_date ,end_date - INTERVAL DAY(end_date)-1 DAY);

SELECT Order_Id,Order_Date,Order_Amount,Shipping_Address,Order_Status 
FROM User_Order

WHERE Order_Date BETWEEN start_date AND end_date;
END//

delimiter

CALL Order_Details_With_Stats("2018-07-10","2018-08-20");



