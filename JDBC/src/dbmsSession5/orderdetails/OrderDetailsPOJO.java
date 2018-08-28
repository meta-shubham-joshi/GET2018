package dbmsSession5.orderdetails;

import java.util.ArrayList;
import java.util.List;

/**
 * POJO class for order details
 *
 */
public class OrderDetailsPOJO {

	

	private String Order_Id;
	private String Order_Date;
	private String Order_Amount;

	public OrderDetailsPOJO(String Order_Id, String Order_Date,
			String Order_Amount) {
		this.Order_Id = Order_Id;
		this.Order_Date = Order_Date;
		this.Order_Amount = Order_Amount;
	}

	/**
	 * Method to get the order id.
	 * @return the order id
	 */
	public String getOrderId() {
		return Order_Id;
	}

	/**
	 * Method to get the order date
	 * @return the date
	 */
	public String getOrderDate() {
		return Order_Date;
	}

	/**
	 * Method to get the order amount
	 * @return the order amount
	 */
	public String getOrderAmount() {
		return Order_Amount;
	}

}
