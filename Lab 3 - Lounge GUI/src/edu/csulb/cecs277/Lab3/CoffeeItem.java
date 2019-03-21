package edu.csulb.cecs277.Lab3;

public class CoffeeItem extends DrinkItem
{
	String temperature, specialInstructions;
	
	/**
	 * Default Constructor, initializing values to the super default values
	 */
	protected CoffeeItem() {
		super();
		temperature = "N/A";
		specialInstructions = null;
	}
	
	/**
	 * Creates a coffee item with the desired values
	 * @param size - Single letter representation of size (S,M or L)
	 * @param flavor - Single word, (e.g. "Vanilla") to describe the type of tea.
	 * @param sweetness - A string that represents the number of teaspoons of sweetener
	 * @param milk - The kind of milk that the drink has
	 * @param temp - String form the temperature for the drink
	 * @param instruct - String form of any special instructions
	 */
	protected CoffeeItem(String size, String flavor, String sweetness, String milk, String temp, String instruct) {
		super("Coffee", size, flavor, sweetness, milk);
		temperature = temp;
		specialInstructions = instruct;
	}
	
	/**
	 * Returns the cost of the drink based on the object's values
	 */
	public double calculateCost() {
		double total = 0;
		switch (size) {
			case "S": total += 1.00; break;
			case "M": total += 1.50; break;
			case "L": total += 2.00; break;
			default: total += 2.00 ; break;
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
	
	/**
	 * Returns the string form of the temperature of the drink
	 * @return String - the temperature of the drink
	 */
	public String getTemperature() {
		return temperature;
	}
	
	/**
	 * Returns the string form of the special instructions of the drink
	 * @return String - the special instructions of the drink
	 */
	public String getSpecialInstructions() {
		return specialInstructions;
	}
	
	/**
	 * Returns a simple string form of the drink that describes its flavor and size
	 */
	public String toString() {
		return getFlavor() + " Coffee (" + getSize() + ")";
	}
}
