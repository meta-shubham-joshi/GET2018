USE StoreFront;
SHOW Tables;

# SQL Query for creating a function to calculate number of orders in a month. Month and year will be input parameter to function.

DELIMITER $$

CREATE FUNCTION calculate_No_Of_Orders_In_Month(order_month int, order_year int)
RETURNS int DETERMINISTIC

BEGIN 
    DECLARE Count_Of_Orders int;
    SET Count_Of_Orders = (SELECT COUNT(*) FROM User_Order WHERE MONTH(Order_Date) = order_month AND YEAR(Order_Date) = order_year);
    RETURN Count_Of_Orders;
END $$

SELECT calculate_No_Of_Orders_In_Month(08, 2018);


# SQL Query for creating a function to return month in a year having maximum orders. Year will be input parameter.

DELIMITER $$

CREATE FUNCTION month_Having_Max_Order(order_year int)
RETURNS int DETERMINISTIC

BEGIN
    DECLARE Month_Having_Max_Order int;
    SET Month_Having_Max_Order =  (SELECT MONTH(Order_Date) FROM User_Order WHERE YEAR(Order_Date) = order_year
    GROUP BY MONTH(Order_Date)
    ORDER BY COUNT(Order_ID) DESC LIMIT 1) ;
    RETURN Month_Having_Max_Order;
END $$

SELECT month_Having_Max_Order(2018);












