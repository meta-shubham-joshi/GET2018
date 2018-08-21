package dbmsSession5.orderdetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dbmsSession5.connection.JDBCConnection;

/**
 * Class for fetching order details
 * @author User28
 *
 */
public class OrderDetails {

	private static Connection connection;

	/**
	 * Methods for fetching details of the user.
	 * @param userId - id of the user
	 * @return the list
	 * @throws SQLException
	 */
	public List<OrderDetailsPOJO> getOrderDetailsOfUser(int userId)
			throws SQLException {

		connection = JDBCConnection.getDatabaseConnection("StoreFront", "root",
				"");

		String queryToGetOrderDetails = "SELECT Order_Id, Order_Date, Order_Amount"
				+ " FROM User_Order WHERE (User_Id="
				+ userId
				+ " AND Order_Status LIKE \"%shipped%\") ORDER BY Order_Date DESC";

		PreparedStatement preparedStatement = connection
				.prepareStatement(queryToGetOrderDetails);
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			resultSet.previous();

			while (resultSet.next()) {

				OrderDetailsPOJO.addToResultList(new OrderDetailsPOJO(resultSet
						.getString("Order_Id"), resultSet
						.getString("Order_Date"), resultSet
						.getString("Order_Amount")));

			}
		} else {
			System.out.println("No Orders information for this User !\n");
		}
		connection.close();
		return OrderDetailsPOJO.getOrderDetailsResultList();
	}
}
