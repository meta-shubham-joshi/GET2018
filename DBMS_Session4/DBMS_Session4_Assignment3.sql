USE StoreFront;
SHOW Tables;

ALTER TABLE Product ADD INDEX Product_Index(Product_Id);
Show Index from Product;

ALTER TABLE User_Order ADD INDEX Order_Index(Order_Id);
Show Index from User_Order;

ALTER TABLE Category ADD INDEX Category_Index(Category_Id);
Show Index from Category;