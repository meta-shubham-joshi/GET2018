import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {

	public int total;

	List<Product> cart = new ArrayList<Product>();

	/*
	 * Add an item to the cart.
	 * 
	 * @params pId- Product Id
	 * 
	 * @params pName- Name of the product.
	 * 
	 * @params quantity- Quantity of the product.
	 * 
	 * @params price- Price of the product.
	 */
	public void addItem(int pId, String pName, int quantity, int price) {
		cart.add(new Product(pId, pName, quantity, price));
		System.out.println("Item Added");
	}

	/*
	 * Display items in the cart.
	 */
	public void display() {
		for (Product p : cart) {
			System.out.println(p.pId + "\t" + p.pName + "\t" + p.quantity + "\t" + p.price);
		}
	}

	/*
	 * Generating the bill amount.
	 * 
	 * @return Returns the bill amount.
	 */
	public int bill() {
		int total = 0;
		for (Product p : cart) {
			total += p.quantity * p.price;
		}
		return total;
	}

	public static void main(String[] args) {
		
		ShoppingCart sc = new ShoppingCart();
		
		sc.addItem(1, "cookie", 2, 10);
		sc.addItem(2, "hanky", 3, 15);
		
		sc.display();
		
		System.out.println("Total bill is " + sc.bill());
	}

}
