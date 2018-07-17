import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {
	
int total;
	
	List<Product> cart = new ArrayList<Product>();
	
	void addItem(int pId,String pName,int quantity,int price) {
		cart.add(new Product(pId, pName, quantity, price));
		System.out.println("Item Added");
	}
	
	void display() {
		for(Product p : cart) {
			System.out.println(p.pId + "\t" + p.pName + "\t" + p.quantity + "\t" + p.price );
		}
	}
	
	int bill() {
		int total = 0;
		for(Product p : cart) {
			total += p.quantity * p.price;
		}
		return total;
	}
	
	/*void removeItem(int prodId)
	{
		for(Product p : cart) {
			if(p.pId == prodId) {
				p.remove();
			}
		}
	}
	*/
	
	
	public static void main(String[] args)
	{
		ShoppingCart sc = new ShoppingCart();
		sc.addItem(1, "cookie", 2, 10);
		sc.addItem(2, "hanky", 3, 15);
		sc.display();
		System.out.println("Total bill is " + sc.bill());
		//sc.removeItem(2);
	}

}
