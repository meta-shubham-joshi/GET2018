USE StoreFront;
SHOW Tables;

# SQL Query to display Shopper’s information along with number of orders he/she placed during last 30 days.
SELECT u.User_Id,u.User_Name,u.User_Mail,u.Birth_Date,u.Contact_No,o.Order_Date,COUNT(o.Order_Id) as Number_Of_Orders
FROM User u
LEFT JOIN
User_Order o
ON u.User_Id = o.User_Id
WHERE (DATEDIFF(NOW(),o.Order_Date) < 30)
GROUP BY u.User_Id HAVING ((COUNT(o.Order_Id)>=0));

# SQL Query to display the top 3 Shoppers who generated maximum number of revenue in last 30 days.
SELECT u.User_Id,u.User_Name,SUM(o.Order_Amount) as Total_Order_Amount
FROM User u
LEFT JOIN
User_Order o
ON u.User_Id = o.User_Id
WHERE (DATEDIFF(NOW(),o.Order_Date) < 30)
GROUP BY u.User_Id 
ORDER BY Total_Order_Amount DESC LIMIT 3;

# SQL Query to display top Products which are ordered most in last 10 days along with numbers.
SELECT po.Product_Id, SUM(po.Quantity) as Total_Units
FROM User_Order o
INNER JOIN 
Product_In_Order_Type po
ON o.Order_Id = po.Order_Id
WHERE (DATEDIFF(NOW(),o.Order_Date) < 10)
GROUP BY po.Product_Id 
ORDER BY Total_Units DESC;

# SQL Query to display Monthly sales revenue of the StoreFront for last 2 months. It should display each month’s sale.
SELECT Month,SUM(Order_Amount) AS Sales_Revenue FROM
    (SELECT Order_Amount,
    CASE WHEN DATEDIFF(NOW(),Order_Date)  BETWEEN 1 AND 30 then 'last 1 month' 
        WHEN DATEDIFF(NOW(),Order_Date)  BETWEEN 30 AND 60 then 'last 2 month'
        WHEN DATEDIFF(NOW(),Order_Date)  BETWEEN 60 AND 90 then 'last 3 month'
    end AS Month
FROM User_Order WHERE DATEDIFF(NOW(),Order_Date) <=90 )a
GROUP BY Month;

# SQL Query to mark the products as Inactive which are not ordered in last 90 days
ALTER TABLE Product
ADD Product_Status VARCHAR(10) DEFAULT 'ACTIVE';

SET SQL_SAFE_UPDATES = 0;
UPDATE Product 
SET Product_Status = "INACTIVE"
WHERE Product_Id NOT IN(
SELECT po.Product_Id FROM User_Order o
INNER JOIN Product_In_Order_Type po
ON o.Order_Id = po.Order_Id
WHERE DATEDIFF(NOW(),o.Order_Date) BETWEEN 1 AND 90); 

# SQL Query for given a category search keyword, display all the Products present in this category/categories. 

SELECT c.Category_Id,c.Category_Name,COUNT(pc.Product_Id) as Number_Of_Products
FROM Category c
LEFT JOIN
Product_Category pc
ON c.category_Id = pc.Category_Id
GROUP BY (c.Category_Name) HAVING COUNT(pc.Product_Id)>=0;

# SQL Query to display top 10 Items which were cancelled most.
INSERT INTO Product_In_Order_Type(Order_Id,Product_Id,Quantity,Status) values
    ('1102','2','1','cancelled'),
    ('1103','2','2','cancelled'),
    ('1104','3','1','cancelled'),
    ('1105','2','1','cancelled'),
    ('1106','4','1','cancelled'),
    ('1103','5','1','cancelled'),
    ('1102','1','1','cancelled'),
    ('1101','2','1','cancelled');
    
SELECT p.Product_Id,p.Product_Title,COUNT(po.Product_Id) AS Status_Count_Cancelled
FROM Product_In_Order_Type po
LEFT JOIN Product p
ON po.Product_Id = p.Product_Id
WHERE po.Status LIKE "%cancelled%" 
GROUP BY(po.Product_Id)
ORDER BY Status_Count_Cancelled DESC LIMIT 3;


