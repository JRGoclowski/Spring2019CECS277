package edu.csulb.cecs277;

public class Cookie extends DessertItem
{
	//Has quantity and price per dozen
	//cost is quantity and price per dozen
	double unitCost, dozenCost;
	
	public Cookie()
	{
		
	}
	public Cookie(int choice)
	{
		switch (choice)
		{
			case 0: super.setName("Chocolate Chip Cookie");
				unitCost = 0.50; dozenCost = 5.00; break;
			case 1: super.setName("Oatmeal Cookie"); 
				unitCost = 0.75; dozenCost = 7.50; break;
			case 2: super.setName("Peanut Butter Cookie"); 
				unitCost = 0.80; dozenCost = 8.50; break;
 		}
	}
	
	public double getCost()
	{
		return unitCost;
	}
	
	public double getDozenCost()
	{
		return dozenCost;
	}
}
