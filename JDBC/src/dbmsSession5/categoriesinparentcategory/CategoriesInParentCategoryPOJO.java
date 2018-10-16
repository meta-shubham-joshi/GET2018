package dbmsSession5.categoriesinparentcategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for storing results of OrderDetails
 * Created on August 21, 2018
 */
public class CategoriesInParentCategoryPOJO {
	
	private String categoryName;
	private int categoryCount;

	public CategoriesInParentCategoryPOJO(String categoryName, int categoryCount) {
		this.categoryName = categoryName;
		this.categoryCount = categoryCount;
	}

	/**
	 * Method to get category name.
	 * @return the name of category.
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * Method to get category count.
	 * @return the category count.
	 */
	public int getCategoryCount() {
		return categoryCount;
	}

}
