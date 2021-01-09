USE StoreFront;
SHOW Tables;

#SQL Query to display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
SELECT p.Product_Id,p.Product_Title, COUNT(p.Product_Title) as Number_Of_Category
FROM Product p
RIGHT JOIN Product_Category pc ON pc.Product_Id=p.Product_Id
GROUP BY p.Product_Id HAVING COUNT(p.Product_Title)>1;

# SQL Query to display Count of products as per range.
SELECT Range_In_Rs, COUNT(Product_Id) AS Count FROM
   (SELECT Product_Id,
   case when Unit_Price between 0 and 100 then '0-100'
        when Unit_Price between 500 and 1000 then '500-1000'
        when Unit_Price > 1000 then 'Above 1000'
   end AS Range_In_Rs
   FROM Product)a
   GROUP BY Range_In_Rs;

# SQL Query to display the Categories along with number of products under each category
SELECT c.Category_Id,c.Category_Name,COUNT(pc.Product_Id) as Number_Of_Products
FROM Category c
LEFT JOIN
Product_Category pc
ON c.category_Id = pc.Category_Id
GROUP BY (c.Category_Name) HAVING COUNT(pc.Product_Id)>=0;

