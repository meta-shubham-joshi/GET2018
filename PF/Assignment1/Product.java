import java.util.*;

public class Product {

	public int pId;
	public String pName;
	public int quantity;
	public int price;

	/*
	 * Constructor to initialise the values.
	 * 
	 * @params pId- Id of the product.
	 * 
	 * @params pName- Name of the product.
	 * 
	 * @params quantity- Quantity of product.
	 * 
	 * @params price- Price of the product.
	 */
	public Product(int pId, String pName, int quantity, int price) {
		this.pId = pId;
		this.pName = pName;
		this.quantity = quantity;
		this.price = price;
	}

}
