package dbmsSession5.deleteproduct;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dbmsSession5.orderdetails.OrderDetails;
import dbmsSession5.orderdetails.OrderDetailsPOJO;

/**
 * Class containing Junit Test methods Created on August 21, 2018
 */
public class DeleteProductTest {

	/**
	 * Method to test whether the product is deleted or not.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testDeletingProduct_Success() {
		int result = new DeleteProduct()
		.deleteProduct();
		assertEquals(19, result);
	}
	
	/**
	 * Method to test whether the product is deleted or not.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testDeletingProduct_Failure() {
		int result = new DeleteProduct()
		.deleteProduct();
		assertNotEquals(1, result);
	}

}
