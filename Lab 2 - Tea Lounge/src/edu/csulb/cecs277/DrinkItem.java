package edu.csulb.cecs277;

public abstract class DrinkItem implements Comparable
{
	String name, sweetness, size;

	
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
	
	public String toString() 
	{
			return getName();
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSweetness()
	{
		return sweetness;
	}

	public void setSweetness(String sweetness)
	{
		this.sweetness = sweetness;
	}

	public String getSize()
	{
		return size;
	}

	public void setSize(String size)
	{
		this.size = size;
	}

	public abstract double getCost();
	
		
}
