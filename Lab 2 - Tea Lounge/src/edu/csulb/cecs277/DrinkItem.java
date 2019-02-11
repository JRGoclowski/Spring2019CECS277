package edu.csulb.cecs277;

public abstract class DrinkItem {
	
	String drinkName, sweetness, size;

	
	public String getDrinkName() {
		return drinkName;
	}



	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}



	public String getSweetness() {
		return sweetness;
	}



	public void setSweetness(String sweetness) {
		this.sweetness = sweetness;
	}



	public String getSize() {
		return size;
	}



	public void setSize(String size) {
		this.size = size;
	}



	public abstract double getCost();
}
