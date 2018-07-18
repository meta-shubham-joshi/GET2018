import java.util.Calendar;

public class FixedOrderPromotion implements Promotion{		// class implementing interface Promotion
	double minimumPrice;
	double fixedDiscount;
	
	public FixedOrderPromotion(double minBill){
		setMinimumPrice(minBill);					// Initialising value of bil
		setFixedDiscount();							// Discount value
	}
	
	public double getMinimumPrice(){				// retrieving minimum price
		return minimumPrice;
	}
	
	public void setMinimumPrice(double price){		// setting minimum price
		minimumPrice = price;
	}
	
	public double getFixedDiscount(){				// retrieving fixed discount
		return fixedDiscount;
	}
	
	public void setFixedDiscount(){
		fixedDiscount = 0.05;						// 5% discount is given 
	}
	
	public boolean isPromotionApplicable(double billAmount, String userCode){ 			//  Amount and promo code as parameter
		if(billAmount>=getMinimumPrice()){												// To check whether discount is available or not
		Calendar cal = Calendar.getInstance();
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
			for(PromotionEnum promo : PromotionEnum.values())
				if(userCode.equals(promo.getPromoCode())){
					if(dayOfMonth>=promo.getStartDate()&&dayOfMonth<=promo.getEndDate())
						return true;
					else{
						System.out.println("SORRY!!! This promo-code is not active now.");
						return false;
					}
				}
				System.out.println("SORRY!!! This promo-code doesn't exist.");
		}
		return false;
	}

}