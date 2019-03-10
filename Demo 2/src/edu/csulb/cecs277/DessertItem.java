package edu.csulb.cecs277;

public abstract class DessertItem implements Comparable
{
	String name;
	
	/**
	 * Compares two objects and returns an integer to state whether the passed object is more
	 * or less expensive than the original object
	 */
	public int compareTo(Object arg) 
	{
		DessertItem otherDessert = (DessertItem) arg;
		if (getCost() < otherDessert.getCost())
			{
				return -1;
			}
		else if (getCost() > otherDessert.getCost())
			{
				return 1;
			}
		else
			{
				return 0;
			}
		
	}

	/**
	 * Returns a string that names the dessert
	 */
	public String toString()
	{
		return getName();
	}
	
	/**
	 * returns the name of the object
	 * @return String - the name of the object
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Allows the name variable to be set.
	 * @param name - the desired name for the object
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Abstract method to get the cost of a dessert
	 * @return double - the cost of a dessert
	 */
	public abstract double getCost();
}
