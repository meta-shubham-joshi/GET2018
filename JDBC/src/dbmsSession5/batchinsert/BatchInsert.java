package dbmsSession5.batchinsert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import dbmsSession5.connection.JDBCConnection;

/**
 * class for inserting images.
 * Class containing method to get number of child categories Created on August 21, 2018
 */
public class BatchInsert {

	/**
	 * function to add images.
	 * @return no of images added.
	 */
	public int addImages() {
		int[] resultset = null;

		try {
			JDBCConnection jdbcconnection = new JDBCConnection();
			// For security reasons Password field is empty.You have to enter the password of your database.
			Connection con = jdbcconnection.getDatabaseConnection("storefront",
					"root", "");
			try {

				String strInsert = "insert into Image (Image_Id, Product_Id, Image_URL) values(?,?,?)";

				PreparedStatement preparedstatement;
				preparedstatement = con.prepareStatement(strInsert);

				con.setAutoCommit(false);

				for (int i = 1; i <= 7; i++) {
					preparedstatement.setInt(1, 10112 + i);
					preparedstatement.setInt(2, 10);
					preparedstatement.setString(3, "urlImage" + "10112" + i);
					preparedstatement.addBatch();
				}

				resultset = preparedstatement.executeBatch();
				con.commit();

			} catch (SQLException ex) {
				ex.printStackTrace();
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultset.length;
	}
}
