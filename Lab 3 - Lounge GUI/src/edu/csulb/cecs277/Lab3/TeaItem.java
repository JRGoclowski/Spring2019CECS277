package edu.csulb.cecs277.Lab3;

import java.util.*;

public class TeaItem extends DrinkItem
{
	ArrayList <String> toppings;
	
	public TeaItem() {
		super();
	}
	
	public TeaItem(String size, String flavor, String sweetness, String milk) {
		super("Tea", size, flavor, sweetness, milk);
	}
	
	public void addTopping(String addition) {
		toppings.add(addition);
	}
	
	public double getCost() {
		double total = 0;
		total += getBasePrice(getSize());
		if (!getMilk().equals("No Milk")) {
			total += 0.25;
		}
		total += toppings.size()*0.25;
		return total;
	}
	
	public double getBasePrice(String sizeString) {
		switch (sizeString) {
			case "S": return 2.50; 
			case "M": return 3.00;
			case "L": return 3.50;
			default : return 3.00;
		}
	}
	
	public String toString() {
		String teaName = getSize() + " " + getFlavor() + " Tea " + getSweetness() + " with " + getMilk () + " and "; 
		if (toppings.isEmpty())
			{
				teaName += "no toppings";
			}
		else if (toppings.size() == 1)
			{
				teaName += toppings.get(0);
			}
		else
			{
				for (int i = 0; i < toppings.size() - 1 ; i ++)
				{
					teaName += (" " + toppings.get(i)) + ",";
				}
				teaName += (" and " + toppings.get(toppings.size() - 1));
			}
		return teaName;
	}
}
