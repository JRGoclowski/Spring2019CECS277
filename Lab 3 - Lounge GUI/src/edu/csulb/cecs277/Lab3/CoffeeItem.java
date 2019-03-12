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
	
	public double calculateCost() {
		double total = 0;
		switch (size) {
			case "S": total += 1.00;
			case "M": total += 1.50;
			case "L": total += 2.00;
			default: total += 2.00 ;
		}
		if (temperature.equals("Blended")) {
				total += 0.25;
			}
		if (!getMilk().equals("No Milk"))
			{
				total += 0.25;
			}
		return total;
	}
	
	public String toString() {
		String coffeeName = getFlavor() + temperature + " Coffee (" + getSize() + ")"
				+ " - " + getSweetness() + " Teaspoon(s) Sugar, with " + getMilk();
		if (!specialInstructions.equals(null)) {
			coffeeName += ", " + specialInstructions;
		}
		return coffeeName;
		/*return getFlavor() + temperature + " Coffee (" + getSize() + ")"*/
	}
}
