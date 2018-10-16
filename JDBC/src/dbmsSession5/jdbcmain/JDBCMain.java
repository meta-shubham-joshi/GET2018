package dbmsSession5.jdbcmain;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dbmsSession5.batchinsert.BatchInsert;
import dbmsSession5.categoriesinparentcategory.CategoriesInParentCategory;
import dbmsSession5.categoriesinparentcategory.CategoriesInParentCategoryPOJO;
import dbmsSession5.deleteproduct.DeleteProduct;
import dbmsSession5.orderdetails.OrderDetails;
import dbmsSession5.orderdetails.OrderDetailsPOJO;

/**
 * Class for JDBC Operations to perform.
 * Created on August 21, 2018
 */
public class JDBCMain {

	public static void main(String args[]) throws SQLException {
		try {
			while (true) {

				Scanner sc = new Scanner(System.in);
				int choice;

				System.out.println("Enter the operation you want to perform:");
				System.out.println("1: Order_Details");
				System.out.println("2: Add_Image");
				System.out.println("3: Delete_Products");
				System.out.println("4: Display_Category_Title");

				choice = sc.nextInt();

				switch (choice) {

				case 1:
					OrderDetails orderdetails = new OrderDetails();
					System.out.print("Enter the User_Id: ");
					int userid = sc.nextInt();
					try {
						List<OrderDetailsPOJO> orderdetailsresultlist = orderdetails
								.getOrderDetailsOfUser(userid);

						for (int i = 0; i < orderdetailsresultlist.size(); i++) {
							System.out.print(orderdetailsresultlist.get(i)
									.getOrderId() + "  ");
							System.out.print(orderdetailsresultlist.get(i)
									.getOrderDate() + "  ");
							System.out.println(orderdetailsresultlist.get(i)
									.getOrderAmount());
						}
					} catch (SQLException e) {
						System.out.println("SQL Exception occured in main!!..");
					}
					break;

				case 2:
					BatchInsert batchinsert = new BatchInsert();
					int no_of_rows = batchinsert.addImages();
					System.out.println("The number of rows inserted: "
							+ no_of_rows);
					System.out.println("");
					break;

				case 3:
					DeleteProduct deleteProduct = new DeleteProduct();
					int no_Of_Products_Deleted = deleteProduct.deleteProduct();
					System.out.println(no_Of_Products_Deleted);
					break;

				case 4:
					CategoriesInParentCategory categoriesInParentCategory = new CategoriesInParentCategory();
					List<CategoriesInParentCategoryPOJO> list = categoriesInParentCategory
							.getChildCategoryCount();
					for (CategoriesInParentCategoryPOJO val : list) {
						System.out.println(val.getCategoryName() + "  "
								+ val.getCategoryCount());
					}
					break;

				case 5:
					System.out.println("Program Terminated !");
					System.exit(0);

				default:
					System.out.println("Invalid choice entered !\n");

				}
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception Occurred!!..");
		}

	}
}
