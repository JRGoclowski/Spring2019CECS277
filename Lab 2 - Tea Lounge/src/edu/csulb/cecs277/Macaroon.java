package edu.csulb.cecs277;

public class Macaroon extends Cookie
{
	// has quantity, unit price, price per three (cheaper in 3s)
	// Cos is calculated by threes and remainder by types
	double unitCost, trioCost;
	
	public Macaroon(int choice)
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
		
	}
	public double getCost()
	{
		return unitCost;
	}
	
	public double getTrioCost()
	{
		return trioCost;
	}
}
