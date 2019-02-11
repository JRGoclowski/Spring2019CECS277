package edu.csulb.cecs277;

public abstract class DessertItem
{
	String name;
	
	public static DessertItem max(DessertItem check) 
	{
		DessertItem max = check;
		return max;
	}
	
	
	public String toString()
	{
		return "x";
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
