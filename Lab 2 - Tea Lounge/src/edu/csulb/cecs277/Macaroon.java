package edu.csulb.cecs277;

public class Macaroon extends Cookie implements Comparable
{
	// has quantity, unit price, price per three (cheaper in 3s)
	// Cos is calculated by threes and remainder by types
	double unitCost, trioCost;
	int trioCount, unitCount;
	
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
	public double getCost()
	{
		
		return ((trioCost*trioCount) + (unitCost*unitCount));
	}
	
	public boolean hasTrio()
	{
		return (trioCount>0);
	}
	public double getTrioCost()
	{
		return trioCost;
	}
	
	public double getUnitCost()
	{
		return unitCost;
	}
	
	public int getTotalCount()
	{
		return (trioCount*3 + unitCount);
	}
	
	public int getTrioCount()
	{
		return trioCount;
	}
	public int getUnitCount()
	{
		return unitCount;
	}
}
