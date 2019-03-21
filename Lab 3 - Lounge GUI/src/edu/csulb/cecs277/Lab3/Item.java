package edu.csulb.cecs277.Lab3;

public abstract class Item
{
	String name;
	double cost;
	
	/**
	 * Default constructor for the item that instantiates no values
	 */
	protected Item() {
		
	}
	
	/**
	 * Constructs the generic item object
	 * @param nameString - The string describing the item name
	 * @param costDouble - the cost of the Item 
	 */
	protected Item(String nameString, double costDouble) {
		name = nameString;
		cost = costDouble;
	}
	
	/**
	 * Sets the name of the Item object
	 * @param nameString - The name of the item
	 */
	public void setName(String nameString) {
		name = nameString;
	}
	 
	/**
	 * sets the cost of the item
	 * @param costDouble - the cost of the item
	 */
	public void setCost(double costDouble) {
		cost = costDouble;
	}
	 
	/**
	 * Returns the name of the object
	 * @return String - the name of the object
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the cost of the object
	 * @return double - the cost of the object
	 */
	public double getCost() {
		cost = calculateCost();
		return cost;
	}
	
	/**
	 * Abstract method that determines the cost of an object
	 * @return double - the cost of the object
	 */
	public abstract double calculateCost();
}
