package dbmsSession5.categoriesinparentcategory;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dbmsSession5.orderdetails.OrderDetails;
import dbmsSession5.orderdetails.OrderDetailsPOJO;

public class CategoriesInParentCategoryTest {

	/**
	 * Method to test get child category count success.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testGetChildCategoryCount_Success() throws SQLException {
		List<CategoriesInParentCategoryPOJO> resultlist = new CategoriesInParentCategory().getChildCategoryCount();
		assertEquals(4, resultlist.size());
	}
	
	/**
	 * Method to test get child category count Failure.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testGetChildCategoryCount_Failure() throws SQLException {
		List<CategoriesInParentCategoryPOJO> resultlist = new CategoriesInParentCategory().getChildCategoryCount();
		assertNotEquals(2, resultlist.size());
	}

}
