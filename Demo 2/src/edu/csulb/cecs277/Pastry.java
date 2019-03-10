package edu.csulb.cecs277;

public class Pastry extends DessertItem
{
	//quantity, unit price, and heating option
	//Cost determined by unit price and quantity
	//Need at least two different
	double unitPrice;
	boolean heated;
	 
	/**
	  * Constructs a pastry object 
	  * @param choice - the integer form for the choice 
	  * @param heatChoice - boolean whether or not it is heated
	  */
	public Pastry(int choice, boolean heatChoice)
	{
		String name;
		switch(choice)
		{
			case 0: name = "Cinnamon Roll"; unitPrice = 3.00; break;
			case 1: name = "Croissant"; unitPrice = 2.70; break;
			case 2: name = "Bagel"; unitPrice = 2.90; break;
			case 3: name = "Muffin"; unitPrice = 3.10; break;
			default: name = "Cinnamon Roll"; unitPrice = 3.00; break; 
		}
		heated = heatChoice;
		if (heated)
			{
				name += ", heated";
			}
		else
			{
				name +=", unheated";
			}
		super.setName(name);
	}
	
	/**
	 * Returns the cost of the item
	 * @return double - the cost of the item
	 */
	public double getCost()
	{
		if (heated == true)
			{
				return (unitPrice + 0.25);
			}
		return unitPrice;
	}
}
