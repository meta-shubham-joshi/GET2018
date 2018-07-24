import java.util.Calendar;

interface Promotion{
	enum PromotionEnum{
		get5("GET05",1,5),free5("FREE05",15,20),less5("LESS05",25,30);  
		String promoCode;
		double discount;
		int startDate,endDate;
		
		private PromotionEnum(String code,int start,int end){	
			promoCode = code;
			startDate = start;
			endDate = end;
		}
		
		public String getPromoCode(){
			return promoCode;
		}
		
		public int getStartDate(){
			return startDate;
		}
		
		public int getEndDate(){
			return endDate;
		}
	}
}

public class FixedProductPromotion implements Promotion{		
	int minQuantity;
	double minimumPrice;
	double fixedDiscount;
	
	/*
	*
	*/
	public FixedProductPromotion(int minProducts, double minBill){
		setMinimumPrice(minProducts,minBill);				
		setFixedDiscount();										
	}
	
	public double getMinQuantity(){
		return minQuantity;
	}
	
	public double getMinimumPrice(){
		return minimumPrice;
	}
	
	public void setMinimumPrice(int quantity, double price){
		minQuantity = quantity;
		minimumPrice = price;
	}
	
	public double getFixedDiscount(){
		return fixedDiscount;
	}
	
	public void setFixedDiscount(int disc){
		this.fixedDiscount = disc;	
	}
	
	public boolean isPromotionApplicable(int productInBill,double billAmount, String userCode){ 
		Calendar cal = Calendar.getInstance();													// @return boolean variable to show discount availability
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		if(billAmount>=getMinimumPrice())
			if(productInBill>=getMinQuantity()){
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
			else
				System.out.println("You don't have the minimum number of products to avail any offers.");
		else
			System.out.println("You don't reach minimum bill amount to avail any offers.");
		return false;
	}

}
