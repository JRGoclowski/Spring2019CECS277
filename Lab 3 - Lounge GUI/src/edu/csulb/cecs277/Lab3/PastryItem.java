package edu.csulb.cecs277.Lab3;

public class PastryItem extends Item
{
	String flavor;
	boolean isHeated;
	static final double HEAT_PRICE = 0.25;
	
	protected PastryItem(String name, String flavorString, boolean heated) {
		super.setName(name);
		flavor = flavorString;
		isHeated = heated;
	}
	
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
	
	public String toString() {
		return flavor + super.getName();
		/*
		 * String nameString = getName() +  " (" 
		 * if (isHeated) {
		 * 		nameString += "heated)"
		 * }
		 * else {
		 * 		nameString += "unheated)"
		 * }*/
	}
	
}
