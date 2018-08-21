package dbmsSession5.deleteproduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbmsSession5.connection.JDBCConnection;
import dbmsSession5.orderdetails.OrderDetailsPOJO;

/**
 * class for deleting a product.
 *
 */
public class DeleteProduct {

	/**
	 * Method for deleting a product.
	 * @return no of products deleted.
	 */
	public int deleteProduct() {
		int result = 0;
		try {
			JDBCConnection jdbcconnection = new JDBCConnection();
			Connection connection = jdbcconnection.getDatabaseConnection(
					"storefront", "root", "");

			String queryForDeletingProducts = "UPDATE PRODUCT SET Product_Status=\"Inactive\" WHERE Product_Id NOT IN" + 
			"(SELECT Product_Id FROM Product_In_Order_Type po LEFT JOIN User_Order o ON po.Order_Id = o.Order_Id WHERE DATEDIFF(NOW(),o.Order_Date)<=365)";

			PreparedStatement preparedStatement3 = connection
					.prepareStatement(queryForDeletingProducts);

			result = preparedStatement3.executeUpdate();

			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return result;
	}

}
