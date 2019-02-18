package edu.csulb.cecs277;

import java.lang.Math;
import java.text.DecimalFormat;
import java.util.*;

public class Receipt
{
	static ArrayList<DrinkItem> Drinks = new ArrayList<DrinkItem>();
	static ArrayList<DessertItem> Desserts = new ArrayList<DessertItem>();
	static int numberOfItems;
	DecimalFormat df = new DecimalFormat("#.00");
	
	public void PrintReceipt()
	{
		if (numberOfItems == 0)
		{
			System.out.println("The order is empty!\nAdd items to the order first!");
		}
		else
		{
			ArrayList<String> itemAssortment = GenerateReceipt();
			System.out.println();
			for (int i = 0; i < itemAssortment.size(); i++)
			{
				System.out.println(itemAssortment.get(i));
			}
			double subTotal = getSubtotal();
			System.out.println("Subtotal : " + df.format(subTotal));
			double grandTotal = getGrandTotal();
			System.out.println("Grand Total : " + grandTotal);
		}
		
	}
	
	private ArrayList<String> GenerateReceipt() 
	{
		Sort();
		ArrayList<String> receipt = new ArrayList<String> (); 
		ArrayList<String> addedItems = new ArrayList<String>();
		for (int i = 0 ; i < Drinks.size(); i++)
			{
				if (addedItems.contains(Drinks.get(i).toString()))
					
					{
						continue;
					}
				else
					{
						receipt.add(GenerateLine(Drinks.get(i)));
						addedItems.add(Drinks.get(i).toString());
					}
			}
		for (int i = 0 ; i < Desserts.size(); i++)
			{
				if (addedItems.contains(Desserts.get(i).toString()))
					{
						continue;
					}
				else
					{
						receipt.add(GenerateLine(Desserts.get(i)));
						addedItems.add(Desserts.get(i).toString());
					}
			}
		return receipt;
	}
	
	public double getSubtotal()
	{
		double subtotal = 0;
		ArrayList<String> receipt = GenerateReceipt();
		for (int i = 0; i < receipt.size(); i++)
		{
			String[] moneySplit = receipt.get(i).split("\\$");
			String amountString = (moneySplit[moneySplit.length-1]);
			Double amount = Double.parseDouble(amountString);
			//amount = Double.parseDouble(df.format(amount));
			subtotal = subtotal + amount;
		}
		return subtotal;
	}
	
	
	private double getGrandTotal()
	{
		double subTotal = getSubtotal();
		double grandTotal = subTotal + (subTotal*0.0775);
		grandTotal = Math.round(grandTotal* 100.0 )/100.0;
		return grandTotal;
	}
	
	
	/**
	 * Sorts the items on the receipt to be organized by class
	 */
 	private void Sort()
	{
		Collections.sort(Drinks);
		Collections.sort(Desserts);
		
	}
	
	
 	/**
	 * counts how many of a given drink item are on the order
	 * @param item - the item to be counted
	 * @return int - how many of that item are in the order
	 */
	private int GetNumberOf(DrinkItem item)
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
	
	
	/**
	 * counts how many of a given dessert item are on the order
	 * @param item - the item to be counted
	 * @return int - how many of that item are in the order
	 */
	private int GetNumberOf(DessertItem item)
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
	
	
	/**
	 * Generates a string to be printed on the receipt with the count of the drink,
	 * the name of the drink, how much it is per drink, and the total.
	 * @param item - the item to have printed
	 * @return String - A string in the format of count of items, name, cost per, and total
	 */
	private String GenerateLine(DrinkItem item)
	{
		int countOfItem = GetNumberOf(item);
		double totalCost = countOfItem * item.getCost();
		String lineOrder = countOfItem + " - " + item.getName() + " @ " 
				+ df.format(item.getCost()) + " each : $" + df.format(totalCost);
		return lineOrder;
	}
	
	
	/**
	 * Generates a string to be printed on the receipt with the count of the dessert,
	 * the name of the dessert, how much it is per dessert (accounting for bundle deals), and the total.
	 * @param item - the item to have printed
	 * @return String - A string in the format of count of items, name, cost per, and total
	 */
	private String GenerateLine(DessertItem item)
	{
		int countOfItem = GetNumberOf(item);
		String formattedDessert = "";
		if (item instanceof Macaroon)
			{
				if (countOfItem >= 3)
					{
						int trioBundles = countOfItem / 3;
						int unitAmount = countOfItem % 3;
						double trioCost = trioBundles * ((Macaroon) item).getTrioCost();
						double unitCost = unitAmount * ((Macaroon) item).getCost();
						if (unitAmount > 0)
							{
								formattedDessert = trioBundles + " - " + item.getName() +  " @ " +
										df.format(((Macaroon) item).getTrioCost()) + " for 3 : $" + 
										df.format(trioCost) + "\n" + unitAmount + " - " + item.getName() + " @ " 
										+ df.format(((Macaroon) item).getCost()) + " each : $" + df.format(unitCost) + "\n" +
										 "\t Total for " + countOfItem + " " + item.getName() + "s : $" + 
										df.format((unitCost + trioCost));
							}
						else
							{
								formattedDessert = trioBundles + " - " + item.getName() +  " @ " +
										df.format(((Macaroon) item).getTrioCost()) + " for 3 : $" + 
										df.format(trioCost);
							}
					}
				else
					{
						double unitCost = countOfItem * ((Macaroon) item).getCost();	
						formattedDessert = countOfItem + " - " + item.getName() +  " @ " +
								df.format(((Macaroon) item).getCost()) + " for each : $" + 
								df.format(unitCost);
					}
			}
		else if (item instanceof Cookie)
			{
				if (countOfItem >= 12)
					{
						int dozens = countOfItem / 12;
						int unitAmount = countOfItem % 12;
						double dozenCost = dozens * ((Cookie) item).getDozenCost();
						double unitCost = unitAmount * ((Cookie) item).getCost();
						if (unitAmount > 0)
							{
								formattedDessert = dozens + " - " + item.getName() +  " @ " +
										df.format(((Cookie) item).getDozenCost()) + " for 12 : $" + 
										df.format(dozenCost) + "\n" + unitAmount + " - " + item.getName() + " @ " 
										+ df.format(((Cookie) item).getCost()) + " each : $" + df.format(unitCost) + "\n" +
										 "\t Total for " + countOfItem + " " + item.getName() + "s : $" + 
										df.format((unitCost + dozenCost));
							}
						else
							{
								formattedDessert = dozens + " - " + item.getName() +  " @ " +
										df.format(((Cookie) item).getDozenCost()) + " for 12 : $" + 
										df.format(dozenCost);
							}
					}
				else
				{
					double totalCost = countOfItem * item.getCost();
					formattedDessert = countOfItem + " - " + item.getName() + " @ " 
							+ df.format(item.getCost()) + " each : $" + df.format(totalCost);
				}
			}
		else
			{
				double totalCost = countOfItem * item.getCost();
				formattedDessert = countOfItem + " - " + item.getName() + " @ " 
						+ df.format(item.getCost()) + " each : $" + df.format(totalCost);
			}
		
		return formattedDessert;
	}

	
	/**
	 * Adds a drink to the drink arrayList
	 * @param addition - the drink to be added
	 */
	public void AddDrink(DrinkItem addition)
	{
		Drinks.add(addition);
		numberOfItems++;
		if (addition instanceof BobaDrink);//TODO figure out what's going on here
	}
	
	
	/**
	 * Adds a dessert to the dessert arrayList
	 * @param addition - the dessert to be added
	 */
	public void AddDessert(DessertItem addition)
	{
		Desserts.add(addition);
		numberOfItems++;
	}
	
	
	public int getNumberOfItems() {
		return numberOfItems;
	}

	
	/**
	 * Checks all Desserts on the receipt and finds the most expensive
	 * @return DessertItem - the most expensive single item on the order
	 */
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
	
	
	/**
	 * Checks all Drinks on the receipt and finds the most expensive
	 * @return DrinkItem - the most expensive single item on the order
	 */
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
