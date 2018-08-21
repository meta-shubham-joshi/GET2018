package dbmsSession5.orderdetails;

import java.util.ArrayList;
import java.util.List;

/**
 * POJO class for order details
 *
 */
public class OrderDetailsPOJO {

	private static List<OrderDetailsPOJO> orderdetailsresultlist = new ArrayList<OrderDetailsPOJO>();

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
	 * Method to add result to the list
	 * @param list- input list to be added
	 */
	public static void addToResultList(OrderDetailsPOJO list) {
		orderdetailsresultlist.add(list);
	}

	/**
	 * Method to get order details
	 * @return the list
	 */
	public static List<OrderDetailsPOJO> getOrderDetailsResultList() {
		return orderdetailsresultlist;
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
