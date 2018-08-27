package dbmsSession5.categoriesinparentcategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dbmsSession5.connection.JDBCConnection;

/**
 * Class containing method to get number of child categories Created on August 21, 2018
 */
public class CategoriesInParentCategory {
	private Connection connection;

	/**
	 * Method to get child category count.
	 * @return the list of child categories.
	 * @throws SQLException
	 */
	public List<CategoriesInParentCategoryPOJO> getChildCategoryCount()
			throws SQLException {
		// For security reasons password field is empty. You have to enter the password of your database.
		connection = JDBCConnection.getDatabaseConnection("StoreFront", "root",
				"");

		String queryToGetChildCategoryCount = "SELECT c.Category_Name, Count(c1.Category_Id) AS count_Of_Child FROM category c "
				+ "LEFT JOIN category c1 ON c.category_Id=c1.Parent_category "
				+ "WHERE c.Parent_category=0 GROUP BY c.category_Name "
				+ "ORDER BY c.Category_Name";

		PreparedStatement preparedStatement = connection
				.prepareStatement(queryToGetChildCategoryCount);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultset.next()){
			do{
				CategoriesInParentCategoryPOJO
					.addToResultList(new CategoriesInParentCategoryPOJO(
							resultSet.getString("Category_Name"), resultSet
									.getInt("count_Of_Child")));
			}while (resultSet.next())
		}
		connection.close();
		return CategoriesInParentCategoryPOJO.getResultList();
	}
}
