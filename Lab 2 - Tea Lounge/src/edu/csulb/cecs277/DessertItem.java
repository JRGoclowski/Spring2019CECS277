package edu.csulb.cecs277;

public abstract class DessertItem {
	
	String name;
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public abstract double getCost();
}
