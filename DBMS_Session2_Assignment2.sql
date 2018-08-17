USE StoreFront;
SHOW Tables;

LOAD DATA LOCAL INFILE 'C:/Users/User28/Desktop/sql_file/category.txt' INTO TABLE Category FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (Category_Name,Parent_Category);
LOAD DATA LOCAL INFILE 'C:/Users/User28/Desktop/sql_file/product.txt' INTO TABLE Product FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (Product_Title,Product_Description,Unit_Price,Stock_Quantity,Product_Added_Date);
LOAD DATA LOCAL INFILE 'C:/Users/User28/Desktop/sql_file/user.txt' INTO TABLE User FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (User_Name,User_Mail,Birth_Date,Contact_No);
LOAD DATA LOCAL INFILE 'C:/Users/User28/Desktop/sql_file/image.txt' INTO TABLE Image FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (Image_Id,Product_Id,Image_URL);
LOAD DATA LOCAL INFILE 'C:/Users/User28/Desktop/sql_file/address.txt' INTO TABLE Address FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (User_Id,Area,City,ZipCode,State,Country);
LOAD DATA LOCAL INFILE 'C:/Users/User28/Desktop/sql_file/login.txt' INTO TABLE Login FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (User_Id,Password,User_Role);
LOAD DATA LOCAL INFILE 'C:/Users/User28/Desktop/sql_file/userrole.txt' INTO TABLE User_Role FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (UserRole,User_Id);
LOAD DATA LOCAL INFILE 'C:/Users/User28/Desktop/sql_file/productcategory.txt' INTO TABLE Product_Category FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (Product_Id,Category_Id);
LOAD DATA LOCAL INFILE 'C:/Users/User28/Desktop/sql_file/productinordertype.txt' INTO TABLE Product_In_Order_Type FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (Order_Id,Product_Id,Quantity,Status);
LOAD DATA LOCAL INFILE 'C:/Users/User28/Desktop/sql_file/userorder.txt' INTO TABLE User_Order FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (Order_Id,User_Id,Order_Date,Order_Amount,Shipping_Address,Order_Status);

# SQL Query to insert sample data in StoreFront tables by using SQL files
SELECT * FROM Category;
SELECT * FROM Product;
SELECT * FROM User;
SELECT * FROM Image;
SELECT * FROM Address;
SELECT * FROM Login;
SELECT * FROM User_Role;
SELECT * FROM Product_Category;
SELECT * FROM Product_In_Order_Type;
SELECT * FROM User_Order;


# SQL Query to display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top
SELECT p.Product_Id, p.Product_Title,c.Category_Name,p.Unit_Price,p.Product_Added_Date 
FROM Product p
INNER JOIN Product_Category pc
ON p.Product_Id = pc.Product_Id
INNER JOIN Category c
ON pc.Category_Id = c.Category_Id
WHERE p.Stock_Quantity>0
ORDER BY p.Product_Added_Date LIMIT 2;


# SQL Query to display the list of products which don't have any images
SELECT Product_Id FROM Product WHERE Product_Id NOT IN (SELECT Product_Id FROM Image);

# SQL Query to display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category Title and then Category Title
SELECT c.Category_Id, c.Category_Name,
IF (c.Parent_Category=0, "TOP CATEGORY", c1.Category_Name) as Parent_Category_Name
FROM Category c
LEFT JOIN Category c1
ON c.Parent_category = c1.category_Id
ORDER BY Parent_Category_Name;

# SQL Query to display Id, Title, Parent Category Title of all the leaf Categories 
SELECT c.Category_Id,c.Category_Name, c1.Category_Name as Parent_Category_Name
FROM Category c
LEFT JOIN Category c1
ON c.Parent_Category = c1.Category_Id
WHERE c.Category_Id NOT IN(c1.Category_ID);

# SQL Query to display Product Title, Price & Description which falls into particular category Title
SELECT p.Product_Title,p.Product_Description,p.Unit_Price 
FROM Product p
INNER JOIN Product_Category c
ON ((p.Product_Id = c.Product_Id) AND c.Category_Id = 7);

# SQL Query to display the list of Products whose Quantity on hand (Inventory) is under 50
SELECT Product_Id,Product_Title,Product_Description,Unit_Price,Product_Id
FROM Product
WHERE (Stock_Quantity<50);

# SQL Query to increase the Inventory of all the products by 100
SET SQL_SAFE_UPDATES = 0;
UPDATE Product 
SET Stock_Quantity = Stock_Quantity + 100;
SELECT Product_Id,Product_Title,Stock_Quantity FROM Product;


