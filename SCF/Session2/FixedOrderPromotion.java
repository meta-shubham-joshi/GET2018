import java.util.Calendar;

public class FixedOrderPromotion implements Promotion {
	public double minimumPrice;
	public double fixedDiscount;

	/*
	 * Initialising value of bill.
	 */
	public FixedOrderPromotion(double minBill) {
		setMinimumPrice(minBill);
	}

	/*
	 * Returns minimum price.
	 */
	public double getMinimumPrice() {
		return minimumPrice;
	}

	/*
	 * Setting Minimum price
	 */
	public void setMinimumPrice(double price) {
		minimumPrice = price;
	}

	/*
	 * Getting the fixed discount.
	 */
	public double getFixedDiscount() {
		return fixedDiscount;
	}

	/*
	 * Setting the fixed discount.
	 */
	public void setFixedDiscount(int disc) {
		this.fixedDiscount = disc;
	}

	/*
	 * Returns boolean value.
	 * 
	 * @params billAmount- Bill value
	 * 
	 * @params userCode- Code applied by user
	 * 
	 * @ @return Return whether promocode is applicable or not.
	 */
	public boolean isPromotionApplicable(double billAmount, String userCode) {
		if (billAmount >= getMinimumPrice()) { // To check whether discount is
												// available or not
			Calendar cal = Calendar.getInstance();
			int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
			for (PromotionEnum promo : PromotionEnum.values())
				if (userCode.equals(promo.getPromoCode())) {
					if (dayOfMonth >= promo.getStartDate() && dayOfMonth <= promo.getEndDate())
						return true;
					else {
						System.out.println("SORRY!!! This promo-code is not active now.");
						return false;
					}
				}
			System.out.println("SORRY!!! This promo-code doesn't exist.");
		}
		return false;
	}

}
