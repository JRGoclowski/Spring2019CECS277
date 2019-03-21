package edu.csulb.cecs277.Lab3;

import java.util.*;

public class TeaItem extends DrinkItem
{
	ArrayList <String> toppings = new ArrayList<String>();
	
	/**
	 * Default Constructor, initializing values to the super default values
	 */
	public TeaItem() {
		super();
	}
	
	/**
	 * Constructs a tea item, without any toppings
	 * @param size - Single letter representation of size (S,M or L)
	 * @param flavor - Single word, (e.g. "Green") to describe the type of tea.
	 * @param sweetness - A string that represents the fraction of sweetness
	 * @param milk - The kind of milk that the drink has
	 */
	public TeaItem(String size, String flavor, String sweetness, String milk) {
		super("Tea", size, flavor, sweetness, milk);
	}
	
	/**
	 * Adds a topping to the drink
	 * @param addition - String representation of the topping to be added
	 */
	public void addTopping(String addition) {
		toppings.add(addition);
	}
	
	/**
	 * Returns the ArrayList of added toppings
	 * @return ArrayList<String> - The toppings added
	 */
	public ArrayList<String> getToppings() {
		return toppings;
	}

	/**
	 * Returns the cost of the drink based on the object's values
	 */
	public double calculateCost() {
		double total = 0;
		switch (getSize()) {
			case "S": total += 2.50; break;
			case "M": total += 3.00; break;
			case "L": total += 3.50; break;
			default : total += 3.00; break;
		}
		if (!getMilk().equals("No Milk")) {
			total += 0.25;
		}
		total += toppings.size()*0.25;
		return total;
	}
	
	/**
	 * Returns a simple string form of the drink that describes its flavor and size
	 */
	public String toString() {
		return getFlavor() + " Tea (" + getSize() + ")";
	}
}
