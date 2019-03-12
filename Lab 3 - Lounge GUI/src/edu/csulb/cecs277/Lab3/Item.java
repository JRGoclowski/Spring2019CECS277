package edu.csulb.cecs277.Lab3;

public abstract class Item
{
	String name;
	double cost;
	
	protected Item() {
		
	}
	
	protected Item(String nameString, double costDouble) {
		name = nameString;
		cost = costDouble;
	}
	
	public void setName(String nameString) {
		name = nameString;
	}
	
	public void setCost(double costDouble) {
		cost = costDouble;
	}
	
	public String getName() {
		return name;
	}
	
	public double getCost() {
		calculateCost();
		return cost;
	}
	
	public abstract double calculateCost();
}
