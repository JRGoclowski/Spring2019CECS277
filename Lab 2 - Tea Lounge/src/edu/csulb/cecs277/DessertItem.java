package edu.csulb.cecs277;

public abstract class DessertItem implements Comparable
{
	String name;
	
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
	
	public static DessertItem max(DessertItem check) 
	{
		DessertItem max = check;
		return max;
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
	
	public abstract double getCost();
}
