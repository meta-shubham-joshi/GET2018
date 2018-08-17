USE StoreFront;

# SQL Query to Display Recent 5 Orders placed
SELECT Order_Id,Order_Date,Order_Amount 
FROM User_Order
ORDER BY Order_Date DESC LIMIT 5;

# SQL Query to display 6 most expensive orders
SELECT Order_Id,Order_Amount
FROM User_Order
ORDER BY Order_Amount DESC LIMIT 6;

# SQL Query to display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped
SELECT o.Order_Id,o.Order_Date,o.Order_Amount
FROM User_Order o
INNER JOIN Product_In_Order_Type p
ON o.Order_Id = p.Order_Id
WHERE p.status LIKE "%placed%" AND DATEDIFF(NOW(),o.Order_Date) > 10;

# SQL Query to display list of shoppers which haven't ordered anything since last month.
SELECT u.User_Id 
FROM User u
LEFT JOIN 
User_Order o
ON u.User_Id = o.User_Id
WHERE DATEDIFF(NOW(),o.Order_Date) > 30;

# SQL Query to display list of shopper along with orders placed by them in last 15 days. 
SELECT u.User_Id, u.User_Name,o.Order_Id
FROM User u
INNER JOIN 
User_Order o
ON u.User_Id = o.User_Id
WHERE DATEDIFF(NOW(),o.Order_Date) < 15;

# SQL Query to get products under shipped state in particular order
SELECT p.Product_Title,p.Product_Id,pc.Order_Id,pc.status 
FROM Product p
RIGHT JOIN Product_IN_Order_Type pc 
ON p.Product_Id=pc.Product_Id
WHERE pc.status LIKE "%shipped%" AND pc.Order_Id=1103;

# SQL Query to get order items whose price is in between 500 to 1000 
SELECT p.Product_Id, p.Product_Title,p.Unit_Price,o.Order_Id,o.Order_Date 
FROM Product p
INNER JOIN Product_In_Order_Type po
ON p.Product_Id = po.Product_Id
INNER JOIN User_Order o
ON po.Order_Id = o.Order_Id
WHERE p.Unit_Price BETWEEN 500 AND 1000;

# SQL Query to update the status of products to shipped
UPDATE Product_In_Order_Type
INNER JOIN User_Order ON Product_In_Order_Type.Order_ID = User_Order.Order_ID
SET Product_In_Order_Type.Status = 'Shipped'
WHERE User_Order.Order_Date = '2018-08-03';

