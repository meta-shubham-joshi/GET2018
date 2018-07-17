import java.util.*;
public class Product {
	
	int pId;
	String pName;
	int quantity;
	int price;

	public Product(int pId,String pName,int quantity,int price)
	{
		this.pId = pId;
		this.pName  = pName;
		this.quantity = quantity;
		this.price = price;
	}
	
	/*public void display()
	{
		System.out.println(this.pId + "\t" + this.pName + "\t" + this.quantity + "\t" + this.price );
	}*/

}
