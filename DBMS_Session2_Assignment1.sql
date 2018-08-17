DROP DATABASE StoreFront;
CREATE DATABASE StoreFront;
USE StoreFront;

CREATE TABLE Category( 
Category_Id INT NOT NULL AUTO_INCREMENT,
Category_Name VARCHAR(20),
Parent_Category INT,

PRIMARY KEY(Category_Id)
);

CREATE TABLE Product(
Product_Id INT NOT NULL AUTO_INCREMENT,
Product_Title VARCHAR(100),
Product_Description VARCHAR(200),
Unit_Price INT,
Stock_Quantity INT,
Product_Added_Date DATE,
PRIMARY KEY(Product_Id)
);

CREATE TABLE Product_Category (
   Id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
   Product_Id INT NOT NULL,
   Category_Id INT NOT NULL,
   FOREIGN KEY(Product_Id) REFERENCES Product(Product_Id),
   FOREIGN KEY(Category_Id) REFERENCES Category(Category_Id)
);

CREATE TABLE Image(
Image_Id INT NOT NULL,
Product_Id INT,
Image_URL VARCHAR(30),
FOREIGN KEY(Product_Id) REFERENCES Product(Product_Id),
PRIMARY KEY(Image_Id)
); 

CREATE TABLE User(
User_Id INT NOT NULL AUTO_INCREMENT,
User_Name VARCHAR(30),
User_Mail VARCHAR(70),
Birth_Date DATE,
Contact_No INT,
PRIMARY KEY(User_Id)
);

CREATE TABLE Address(
Address_Id INT NOT NULL AUTO_INCREMENT,
User_Id INT,
Area VARCHAR(100),
City VARCHAR(50),
ZipCode INT,
State VARCHAR(30),
Country VARCHAR(30),
FOREIGN KEY(User_Id) REFERENCES User(User_Id),
PRIMARY KEY(Address_Id)
);

CREATE TABLE Login(
User_Id INT,
Password VARCHAR(30),
User_Role VARCHAR(30),
FOREIGN KEY(User_Id) REFERENCES User(User_Id)
);

CREATE TABLE User_Role(
UserRole_Id INT NOT NULL AUTO_INCREMENT,
UserRole VARCHAR(30),
User_Id INT,
PRIMARY KEY (UserRole_Id)
);

CREATE TABLE User_Order(
Order_Id INT NOT NULL,
User_Id INT,
Order_Date DATE,
Order_Amount INT,
Shipping_Address VARCHAR(100),
Order_Status VARCHAR(30),
FOREIGN KEY(User_Id) REFERENCES User(User_Id),
PRIMARY KEY(Order_Id)
);

CREATE TABLE Product_In_Order_Type(
Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
Order_Id INT,
Product_Id INT,
Quantity INT,
status VARCHAR(12)
);

DROP TABLE Image;
DROP TABLE Product_Category;
DROP TABLE Product;

CREATE TABLE Product(
Product_Id INT NOT NULL AUTO_INCREMENT,
Product_Title VARCHAR(100),
Product_Description VARCHAR(200),
Unit_Price INT,
Stock_Quantity INT,
Product_Added_Date DATE,
PRIMARY KEY(Product_Id)
);

CREATE TABLE Image(
Image_Id INT,
Product_Id INT,
Image_URL VARCHAR(30),
FOREIGN KEY(Product_Id) REFERENCES Product(Product_Id),
PRIMARY KEY(Image_Id)
); 

CREATE TABLE Product_Category (
   Id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
   Product_Id INT NOT NULL,
   Category_Id INT NOT NULL,
   FOREIGN KEY(Product_Id) REFERENCES Product(Product_Id),
   FOREIGN KEY(Category_Id) REFERENCES Category(Category_Id)
);


