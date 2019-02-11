package edu.csulb.cecs277;

public abstract class DrinkItem //implements Comparable
{
	String name, sweetness, size;
	
	public static DrinkItem max(DrinkItem check) 
	{
		double valueOfComparison
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
