package edu.csulb.cecs277;

import java.text.DecimalFormat;
import java.util.*;

public class Receipt
{
	static ArrayList<DrinkItem> Drinks = new ArrayList<DrinkItem>();
	static ArrayList<DessertItem> Desserts = new ArrayList<DessertItem>();
	DecimalFormat df = new DecimalFormat("#.00");
	
	//@SuppressWarnings("unchecked")//TODO check if this is necessary
	public void Sort()
	{
		Collections.sort(Drinks);
		Collections.sort(Desserts);
		
	}
	
	public int GetNumberOf(DrinkItem item)
	{
		Sort();
		int count = 0;
		for (int i = 0 ; i < Drinks.size(); i++)
			{
				if (!Drinks.get(i).getName().equals(item.getName()))
					{
						continue;
					}
				else
					{
						count++;
					}
			}
		return count;
	}
	
	public int GetNumberOf(DessertItem item)
	{
		Sort();
		int count = 0;
		for (int i = 0 ; i < Desserts.size(); i++)
			{
				if (!Desserts.get(i).getName().equals(item.getName()))
					{
						continue;
					}
				else
					{
						count++;
					}
			}
		return count;
	}
	
	private String GenerateLine(DrinkItem item)
	{
		int countOfItem = GetNumberOf(item);
		double totalCost = countOfItem * item.getCost();
		String lineOrder = countOfItem + " - " + item.getName() + " @ " 
				+ df.format(item.getCost()) + " each : " + df.format(totalCost);
		return lineOrder;
	}
	
	private String GenerateLine(DessertItem item)
	{
		int countOfItem = GetNumberOf(item);
		double totalCost;
		String formattedDessert;
		if (item instanceof Macaroon)
			{
				if (countOfItem >= 3)
					{
						int trioBundles = countOfItem / 3;
						int unitAmount = countOfItem % 3;
						if (unitAmount > 0)
							{
								formattedDessert = trioBundles + " - " item.getName() ;
							}
					}
			}
		
		String lineOrder = countOfItem + " - " + item.getName() + " @ " 
				+ df.format(item.getCost()) + " each : " + df.format(totalCost);
		return lineOrder;
	}

	
	public void AddDrink(DrinkItem addition)
	{
		Drinks.add(addition);
		
		if (addition instanceof BobaDrink);
	}
	
	public void AddDessert(DessertItem addition)
	{
		Desserts.add(addition);
	}
	
	public static DessertItem MaxDessert()
	{
		int numberOfDesserts = Desserts.size();
		DessertItem currentMax = Desserts.get(0);
		for (int i = 0; i < numberOfDesserts; i++)
			{
				int temp = currentMax.compareTo(Desserts.get(i));
				if (temp == 1)
					{
						currentMax = Desserts.get(i);
					}
			}
		return currentMax;
	}
	
	public static DrinkItem MaxDrink()
	{
		int numberOfDrinks = Drinks.size();
		DrinkItem currentMax = Drinks.get(0);
		for (int i = 0; i < numberOfDrinks; i++)
			{
				int temp = currentMax.compareTo(Drinks.get(i));
				if (temp == 1)
					{
						currentMax = Drinks.get(i);
					}
			}
		return currentMax;
	}
	
}
