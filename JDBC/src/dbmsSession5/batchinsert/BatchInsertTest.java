package dbmsSession5.batchinsert;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dbmsSession5.categoriesinparentcategory.CategoriesInParentCategory;
import dbmsSession5.categoriesinparentcategory.CategoriesInParentCategoryPOJO;

public class BatchInsertTest {

	/**
	 * Method to test add image success.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testaddImages_Success() throws SQLException {
		int length = new BatchInsert().addImages();
		assertEquals(7, length);
	}
	
	/**
	 * Method to test add image Failure.
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testaddImages_Failure() throws SQLException {
		int length = new BatchInsert().addImages();
		assertEquals(5, length);
	}

}
