package edu.csulb.cecs277;

public class Macaroon extends Cookie implements Comparable
{
	// has quantity, unit price, price per three (cheaper in 3s)
	// Cos is calculated by threes and remainder by types
	double unitCost, trioCost;
	int trioCount, unitCount;
	
	/**
	 * Implements the compareTo function for the special case of macaroons
	 */
	public int compareTo(Object arg) 
	{
		DessertItem otherDessert = (DessertItem) arg;
		if (hasTrio())
			{
				if (getTrioCost() < otherDessert.getCost())
					{
						return -1;
					}
				else if (getTrioCost() > otherDessert.getCost())
					{
						return 1;
					}
				else
					{
						return 0;
					}
			}
		else
			{
				if (getUnitCost() < otherDessert.getCost())
					{
						return -1;
					}
				else if (getUnitCost() > otherDessert.getCost())
					{
						return 1;
					}
				else
					{
						return 0;
					}
			}
		
		
	}
	
	/**
	 * Constructor for a macaroon
	 * @param choice - the integer form the of the chosen macaroon
	 * @param quantity - the quantity of macaroons desired
	 */
	public Macaroon(int choice, int quantity)
	{
		switch(choice) 
		{
			case 0: super.setName("Green Tea Macaroon");
				unitCost = 1.00; trioCost = 2.50; break;
			case 1: super.setName("Chocolate Macaroon");
				unitCost = 1.25; trioCost = 3.00; break;
			case 2: super.setName("Mango Macaroon");
				unitCost = 1.50; trioCost = 4.00; break;
			case 3: super.setName("Strawberry Macaroon");
				unitCost = 1.50; trioCost = 4.00; break;
		}
		
		if (quantity >= 3)
			{
				trioCount = quantity / 3;
				unitCount = quantity % 3;
			}
		else
			{
				unitCount = quantity;
			}
	}
	
	/**
	 * Returns the total cost of the object
	 * @return double - the total cost of the Object
	 */
	public double getCost()
	{
		
		return ((trioCost*trioCount) + (unitCost*unitCount));
	}
	
	/**
	 * Returns whether or not there is a trio bundle for the object 
	 * @return boolean - if there is a trio bundle
	 */
	public boolean hasTrio()
	{
		return (trioCount>0);
	}

	/**
	 *Returns the cost for a trio of the macaroon 
	 * @return double - the cost for a trio
	 */
	public double getTrioCost()
	{
		return trioCost;
	}
	
	/**
	 * Returnst the unit cost of a single macaroon
	 * @return double - the cost of a single macaroon
	 */
	public double getUnitCost()
	{
		return unitCost;
	}
	
	/**
	 * Returns how many macaroons there are in total
	 * @return int - the number of macaroons in the item
	 */
	public int getTotalCount()
	{
		return (trioCount*3 + unitCount);
	}
	
	/**
	 * returns the number of trio bundles of the objects
	 * @return int - the number of trios
	 */ 
	public int getTrioCount()
	{
		return trioCount;
	}
	
	/**
	 * The number of single macaroons not included in bundles
	 * @return int - the number of unbundled macaroons
	 */
	public int getUnitCount()
	{
		return unitCount;
	}
}
