package edu.csulb.cecs277;

public abstract class DrinkItem implements Comparable
{
	String name, sweetness, size;

	/**
	 * Compares two objects and returns an integer to state whether the passed object is more
	 * or less expensive than the original object
	 */
	public int compareTo(Object arg) 
	{
		DrinkItem otherDessert = (DrinkItem) arg;
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
	 * Returns a string that names the drink
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
	 * Allows for the object to be named
	 * @param name - the desired name for the object
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Returns the string form of how sweet the drink is
	 * @return String - a term to describe how sweet the drink is
	 */
	public String getSweetness()
	{
		return sweetness;
	}
	
	/**
	 * Allws for the object to have it's sweetness set
	 * @param sweetness - the String desired to represent the sweetness.
	 */
	public void setSweetness(String sweetness)
	{
		this.sweetness = sweetness;
	}
	
	/**
	 * returns the size of the drink, small, medium, or large.
	 * @return String - The size of the drink
	 */
	public String getSize()
	{
		return size;
	}
	
	/**
	 * Allows for the object to have its size set
	 * @param size - String form of the desired size
	 */
	public void setSize(String size)
	{
		this.size = size;
	}
	
	/**
	 * Abstract method to get the cost of a drink
	 * @return double - the cost of a drink
	 */
	public abstract double getCost();
	
		
}
