package edu.csulb.cecs277;
import java.util.*;

public class BobaDrink extends DrinkItem
{
	//base tea can be green, black, jasmine green, rose, or oolong tea
	//sweetness can be 3/4, 1/2, 1/4 or unsweetened
	//toppings boba, popping boba, grass jelly, lyche jelly, coconut jelly, and mini mochi
	//milk can be whole, half and half, almond milk, coconut milk, or none
	//cost determined by size and number of toppings
	String[] options = {/*0*/"Boba",/*1*/ "Popping Boba",/*2*/ 
			"Grass Jelly",/*3*/ "Lyche Jelly",/*4*/ "Coconut Jelly",/*5*/ "Mini Mochi"};
	ArrayList<String> toppings = new ArrayList<String>();
	String baseTea, baseMilk;
	
	/**
	 * Basic Drink constuctor for Tea Drinks. Generates a basic name without toppings at first. Name will need to be
	 * updated if any toppings are added
	 * @param size - character representing the desired size of the drink	
	 * @param base - the base tea that will be used to make the drink in a single word string
	 * @param sweetness - an integer to determine the sweetness from unsweetened to full sweetened from 0 - 4
	 * @param milk - The desired milk for the drink, in a single word string
	 */
	public BobaDrink(char size, String base, int sweetness, String milk, ArrayList<Integer> chosenToppings)
	{
		char sizeChoice = Character.toUpperCase(size);
		switch(base)
		{
			case "Green": baseTea = base + " Tea"; break;
			case "Black": baseTea = base + " Tea"; break;
			case "Jasmine": baseTea = base + " Green Tea"; break;
			case "Rose": baseTea = base + " Tea"; break;
			case "Oolong": baseTea = base + " Tea"; break;
			default: baseTea = "Green Tea"; break;
		}
		
		switch (sizeChoice) 
		{
			case 'S': super.setSize("Small");break;
			case 'M': super.setSize("Medium");break;
			case 'L': super.setSize("Large");break;
			default: super.setSize("Medium");break;
		}
		
		switch (milk)
		{
			case "Whole": baseMilk = milk + " milk"; break;
			case "Half and Half": baseMilk = milk; break;
			case "Almond": baseMilk = milk + " milk"; break;
			case "Coconut": baseMilk = milk + " milk"; break;
			case "None": baseMilk = "No Milk"; break; 
			default: baseMilk = "Water"; break;
		}
		
		switch (sweetness)
		{
			case 0: super.setSweetness("Unsweetened");
			case 1: super.setSweetness("1/4 sweetened");
			case 2: super.setSweetness("1/2 sweetened");
			case 3: super.setSweetness("3/4 sweetened");
			case 4: super.setSweetness("Sweetened");
			default: super.setSweetness("Unsweetened");
		}
		for (int i = 0; i < chosenToppings.size();i++)
			{
				addTopping(options[chosenToppings.get(i)]);
			}
		updateName();
	}
	
	public String[] getOptions() {
		return options;
	}

	/**
	 * updates the name of drink to include any changes. 
	 */
	private void updateName()
	{
		String name = super.getSize() + " " + super.getSweetness() + " " + baseTea + " with " + baseMilk + " and";
		if (toppings.isEmpty())
		{
			name += " no toppings";
		}
		else if (toppings.size() == 1)
		{
			name += " " + toppings.get(0);
		}
		else
		{
			for (int i = 0; i < toppings.size() - 1 ; i ++)
			{
				name += (" " + toppings.get(i)) + ",";
			}
			name += (" and " + toppings.get(toppings.size() - 1));
		}
		
		super.setName(name);
	}
	
	/**
	 * Adds toppings to the array list of toppings
	 * @param topping - the topping to be added to the drink
	 * @return boolean - returns true if the topping is not already included and added. 
	 */
	public boolean addTopping(String topping)
	{
		if (!Arrays.asList(options).contains(topping)) {return false;}
		
		if (toppings.contains(topping))
		{
			return false;
		}
		else
		{
			toppings.add(topping);
			return true;
		}
	}
	
	/**
	 * Returns the total cost of the drink
	 * 
	 */
	public double getCost()
	{
		double cost = (0.80 * toppings.size());
		switch (super.getSize())
		{
			case "Small": cost += 2.50; return cost;
			case "Medium": cost += 2.90; return cost;
			case "Large": cost += 3.20; return cost;
			default: cost += 2.90; return cost;
		}
		
	}
}
