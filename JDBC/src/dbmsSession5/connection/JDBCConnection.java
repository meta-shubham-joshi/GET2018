package dbmsSession5.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * class for connection establishment.
 *
 */
public class JDBCConnection {

	private static Connection connection;

	/**
	 * Method for connection establishment.
	 * @param databaseName - name of the database.
	 * @param username - user name.
	 * @param password - password.
	 * @return
	 */
	public static Connection getDatabaseConnection (String databaseName,String username,String password) {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databaseName,username,password);
		} catch(ClassNotFoundException cne) {
		System.out.println("Class not found ! Exception in generating Connection.");
		} catch(SQLException se) {
		System.out.println("SQL Exception ! Exception in generating Connection.");
		}
		return connection;
		}

}
