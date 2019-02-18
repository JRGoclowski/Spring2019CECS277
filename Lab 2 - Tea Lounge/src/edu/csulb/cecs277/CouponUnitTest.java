package edu.csulb.cecs277;

public class CouponUnitTest {
	
	public static void main(String[] args) {
		Coupon c = new Coupon(); //an invalid coupon
		System.out.println(c);
		Coupon drinkCoupon = new Coupon("drink", .25); //25% off any drink item
		Coupon pastryCoupon = new Coupon("pastry", .50); //50% off any pastry item
		
		System.out.println(drinkCoupon); //Printing drink coupon
		//printing pastry discount
		System.out.printf("Pastry discount: %1.0f%% off.", pastryCoupon.getDiscount()*100 );
	}

}
