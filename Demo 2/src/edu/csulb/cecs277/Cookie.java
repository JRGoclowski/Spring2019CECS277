package edu.csulb.cecs277;

public class Cookie extends DessertItem implements Comparable
{
	//Has quantity and price per dozen
	//cost is quantity and price per dozen
	double unitCost, dozenCost;
	int dozenCount, unitCount;
	
	public Cookie()
	{
		
	}
	
	/**
	 * Implements the compareTo method for the max Dessert function
	 * @param arg - the object to compare to the cookie
	 */
	public int compareTo(Object arg) 
	{
		DessertItem otherDessert = (DessertItem) arg;
		if (hasDozen())
			{
				if (getDozenCost() < otherDessert.getCost())
					{
						return -1;
					}
				else if (getDozenCost() > otherDessert.getCost())
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
	 * Constructor for the cookie
	 * @param choice - the integer to decide which cookie to make
	 * @param quantity - the number of cookies desired for the object
	 */
	public Cookie(int choice, int quantity)
	{
		switch (choice)
		{
			case 0: super.setName("Chocolate Chip Cookie");
				unitCost = 0.50; dozenCost = 5.00; break;
			case 1: super.setName("Oatmeal Cookie"); 
				unitCost = 0.75; dozenCost = 7.50; break;
			case 2: super.setName("Peanut Butter Cookie"); 
				unitCost = 0.80; dozenCost = 8.00; break;
 		}
		
		if (quantity >= 12)
			{
				dozenCount = quantity / 12;
				unitCount = quantity % 12;
			}
		else
			{
				unitCount = quantity;
			}
	}
	
	/**
	 * Returns the total cost of the cookie Object for the whole quantity
	 * @return double - the total cost for all cookies in the object
	 */
	public double getCost()
	{
		return ((dozenCost*dozenCount) + (unitCost*unitCount));
	}
	
	/**
	 * whether or not there is at least 12 cookies, and a dozen bundle
	 * @return boolean - whether or not there is a dozen cookies
	 */
	public boolean hasDozen()
	{
		return (dozenCount>0);
	}
	
	/**
	 * Returns the cost of a dozen cookies
	 * @return double - the cost of a dozen cookies
	 */
	public double getDozenCost()
	{
		return dozenCost;
	}
	
	/**
	 * Returns the Unit Cost Of a single cookie
	 * @return double -  the cost of a single cookie
	 */
	public double getUnitCost()
	{
		return unitCost;
	}
	
	/**
	 * Returns how many cookies in total are in the object
	 * @return int - the total number of cookies
	 */
	public int getTotalCount()
	{
		return (dozenCount*12 + unitCount);
	}
	
	/**
	 * Returns how many dozens are in the object
	 * @return int - the number of dozens
	 */
	public int getDozenCount()
	{
		return dozenCount;
	}
	
	/**
	 * Returns the number of individual cookies not included in a bundle
	 * @return int - the number of individual cookies
	 */
	public int getUnitCount()
	{
		return unitCount;
	}
}
