package edu.csulb.cecs277;

public class Cookie extends DessertItem
{
	//Has quantity and price per dozen
	//cost is quantity and price per dozen
	double unitCost, dozenCost;
	int dozenCount, unitCount;
	
	public Cookie()
	{
		
	}
	
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
	
	public double getCost()
	{
		return ((dozenCost*dozenCount) + (unitCost*unitCount));
	}
	
	public boolean hasDozen()
	{
		return (dozenCount>0);
	}
	
	public double getDozenCost()
	{
		return dozenCost;
	}
	
	public double getUnitCost()
	{
		return unitCost;
	}
	
	public int getTotalCount()
	{
		return (dozenCount*12 + unitCount);
	}
	
	public int getDozenCount()
	{
		return dozenCount;
	}
	
	public int getUnitCount()
	{
		return unitCount;
	}
}
