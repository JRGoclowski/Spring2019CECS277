package edu.csulb.cecs277.Lab3;

import java.util.*;

public class TeaItem extends DrinkItem
{
	ArrayList <String> toppings = new ArrayList<String>();
	
	public TeaItem() {
		super();
	}
	
	/**
	 * 
	 * @param size
	 * @param flavor - Single word, (e.g. "Green") to describe the type of tea.
	 * @param sweetness
	 * @param milk
	 */
	public TeaItem(String size, String flavor, String sweetness, String milk) {
		super("Tea", size, flavor, sweetness, milk);
	}
	
	public void addTopping(String addition) {
		toppings.add(addition);
	}
	
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
					teaName += (toppings.get(i)) + ", ";
				}
				teaName += ("and " + toppings.get(toppings.size() - 1));
			}
		return teaName;
		/*return flavor + " Tea (" + getSize() + ")"*/
	}
}
