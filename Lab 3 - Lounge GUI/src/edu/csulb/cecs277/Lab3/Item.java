package edu.csulb.cecs277.Lab3;

public abstract class Item
{
	String name;
	double cost;
	
	protected Item() {
		
	}
	
	protected Item(String name, double cost) {
	
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
	
	public abstract double getCost();
}
