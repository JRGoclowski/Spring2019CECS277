package edu.csulb.cecs277.Lab3;

public class PastryItem extends Item
{
	String flavor;
	boolean isHeated;
	static final double HEAT_PRICE = 0.25;
	
	/**
	 * Constructs a Pastry Item using the super consructor, and assigning the other
	 * instance variables
	 * @param name - The name describing the type of pastry
	 * @param flavorString - The flavor chosen of the pasrty
	 * @param heated - the boolean showing if the item is heated or not
	 */
	protected PastryItem(String name, String flavorString, boolean heated) {
		super.setName(name);
		flavor = flavorString;
		isHeated = heated;
	}
	
	/**
	 * Returns the cost of the pastry item based on it's instance variables
	 */
	public double calculateCost() {
		double cost = 0;
		switch (name) {
			case "Muffin": cost = 2.00; break;
			case "Cookie": cost = 1.50; break;
			case "Danish": cost = 2.50; break;
			case "Cheesecake":
				switch (flavor) {
					case "Regular": cost = 4.00; break;
					case "Cherry": cost = 4.50; break;
					case "Blueberry": cost = 4.50; break;
				}; break;
			default: cost = 2.00; break;
		}
		if (isHeated) { cost += HEAT_PRICE; }
		return cost;
	}
	
	/**
	 * Returns whether or not the item is heated
	 * @return boolean - whether or not the item is heated
	 */
	public boolean isHeated() {
		return isHeated;
	}
	
	/**
	 * Returns the flavor of the item
	 * @return String - the flavor of the item
	 */
	public String getFlavor() {
		return flavor;
	}
	
	/**
	 * Returns a string form of the Item's description
	 */
	public String toString() {
		return flavor + super.getName();
	}
	
}
