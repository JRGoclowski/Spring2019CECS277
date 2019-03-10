package edu.csulb.cecs277.Lab3;

public class CoffeeItem extends DrinkItem
{
	String temperature, specialInstructions;
	
	protected CoffeeItem() {
		super();
		temperature = "N/A";
		specialInstructions = null;
	}
	
	protected CoffeeItem(String size, String flavor, String sweetness, String milk, String temp, String instruct) {
		super("Coffee", size, flavor, sweetness, milk);
		temperature = temp;
		specialInstructions = instruct;
	}
	
	public double getCost() {
		double total = 0;
		total = getBasePrice();
		if (temperature.equals("Blended"))
			{
				total += 0.25;
			}
		if (!getMilk().equals("No Milk"))
			{
				total += 0.25;
			}
		return total;
	}
	
	private double getBasePrice() {
		switch (size) {
			case "S": return 1.00;
			case "M": return 1.50;
			case "L": return 2.00;
			default: return 2.00 ;
		}
	}

	public String toString() {
		String coffeeName = getFlavor() + temperature + " Coffee (" + getSize() + ") "
				+ " - " + getSweetness() + " Teaspoon(s) Sugar, with " + getMilk();
		if (!specialInstructions.equals(null)) {
			coffeeName += ", " + specialInstructions;
		}
		return coffeeName;
	}
}
