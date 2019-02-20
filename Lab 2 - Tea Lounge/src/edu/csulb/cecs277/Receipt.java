package edu.csulb.cecs277;

import java.lang.Math;
import java.text.DecimalFormat;
import java.util.*;

public class Receipt
{
	ArrayList<DrinkItem> Drinks = new ArrayList<DrinkItem>();
	ArrayList<DessertItem> Desserts = new ArrayList<DessertItem>();
	int numberOfItems;
	DecimalFormat df = new DecimalFormat("#.00");
	double subTotal, grandTotal, amountPaid = 0, changeDue;
	
	//TODO coupon imple
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
			GenerateGrandTotal();
			System.out.println("Subtotal : $" + df.format(subTotal) + " for " + getNumberOfItems() + " item(s)");
			System.out.println("Grand Total : $" + df.format(grandTotal));
			if (amountPaid != 0)
			{
				System.out.println("Amount Paid : $" + df.format(amountPaid));
				System.out.println("Change Due : $" + df.format(changeDue));
			}
			
			System.out.println();
		}
		
	}
	
	
	private void setSubTotal() 
	{
		subTotal = 0;
		ArrayList<String> receipt = GenerateReceipt();
		for (int i = 0; i < receipt.size(); i++)
		{
			String[] moneySplit = receipt.get(i).split("\\$");
			String amountString = (moneySplit[moneySplit.length-1]);
			Double amount = Double.parseDouble(amountString);
			//amount = Double.parseDouble(df.format(amount));
			subTotal = subTotal + amount;
		}
	}
	
	
	private void GenerateGrandTotal() {
		setSubTotal();
		double grandTotalTemp = subTotal + (subTotal*0.0775);
		grandTotal = Math.round(grandTotalTemp* 100.0 )/100.0;
	}
	
	
	public void FinalizeOrder(IOshortcut io)
	{
		
		if (numberOfItems == 0)
		{
			System.out.println("There is nothing on this order, the order is now closed");
			return;
		}
		System.out.print("Is there a coupon to apply? [Y]es/[N]o : ");
		boolean hasCoupon = io.YesOrNo();
		PrintReceipt();
		System.out.println();
		if (hasCoupon)
		{
			ArrayList<Coupon> coupons = new ArrayList<Coupon>();
			System.out.print("Is there more than one coupon? [Y]es/[N]o");
			boolean multipleCoupons = io.YesOrNo();
			if (multipleCoupons)
			{
				System.out.print("Enter number of coupons :");
				int couponCount = io.intIn();
				for (int i = 0; i < couponCount; i++)
				{
					System.out.print("Enter coupon type : ");
					String couponType = io.input();
					System.out.print("Enter discount % as a double (e.g. 50% discount = input 50) : ");
					double discountPercent = (io.doubleInEx(0, 100))/100;
					coupons.add(new Coupon(couponType, discountPercent));
				}
			}
			else
			{
				System.out.print("Enter coupon type : ");
				String couponType = io.input();
				System.out.print("Enter discount % as a double (e.g. 50% = input 50) : ");
				double discountPercent = (io.doubleInEx(0, 100))/100;
				coupons.add(new Coupon(couponType, discountPercent));
			}
			ApplyCoupon(coupons);
		}
		Pay(io);
		System.out.println();
	}
	
	
	private void ApplyCoupon(ArrayList<Coupon> couponApplied)
	{
		//Are there multiple coupons?
		//Get kind of coupon
		//Get most expensive Item
		//Get difference
		//grandTotal - difference;
		//
	}
	
	private void Pay(IOshortcut io)
	{
		System.out.println("You owe $" + df.format(grandTotal));
		System.out.print("Amount Paid : $");
		amountPaid = Math.round(io.doubleInLowInc(grandTotal)* 100.0 )/100.0 ;
		changeDue = amountPaid - grandTotal;
		System.out.println("  $" + df.format(amountPaid) 
					   + "\n- $" + df.format(grandTotal) 
					   + "\n________" 
					   + "\n  $" + df.format(changeDue));
		
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
		return subTotal;
	}
	
	
	
	public double getGrandTotal()
	{
		return grandTotal;
	}
	
	
	public void Clear() {
		numberOfItems = 0;
		Drinks.clear();
		Desserts.clear();
		
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
				Macaroon macItem = ((Macaroon)item);
				if (macItem.hasTrio())
					{
						double trioCost = macItem.getTrioCount() * macItem.getTrioCost();
						double unitCost = macItem.getUnitCount() * macItem.getUnitCost();
						if (macItem.getUnitCount() > 0)
							{
								formattedDessert = macItem.getTrioCount() + " - " + macItem.getName() +  " @ " +
										df.format(macItem.getTrioCost()) + " for 3 : $" + 
										df.format(trioCost) + "\n" + macItem.getUnitCount() + " - " + item.getName() + " @ " 
										+ df.format(macItem.getUnitCost()) + " each : $" + df.format(unitCost) + "\n" +
										 "\t Total for " + (macItem.getTotalCount()) + " " + item.getName() + "s : $" + 
										df.format(macItem.getCost());
							}
						else
							{
								formattedDessert = macItem.getTrioCount() + " - " + item.getName() +  " @ " +
										df.format(macItem.getTrioCost()) + " for 3 : $" + 
										df.format(trioCost);
							}
					}
				else
					{
						double unitCost = macItem.getUnitCount() * macItem.getUnitCost();	
						formattedDessert = macItem.getUnitCount() + " - " + item.getName() +  " @ " +
								df.format(macItem.getUnitCost()) + " for each : $" + 
								df.format(unitCost);
					}
			}
		else if (item instanceof Cookie) //TODO Continue from here with new implementation
			{
				Cookie cookItem = ((Cookie)item);
				if (cookItem.hasDozen())
					{
						double dozenCost = cookItem.getDozenCount()* cookItem.getDozenCost();
						double unitCost = cookItem.getUnitCount() * cookItem.getCost();
						if (cookItem.getUnitCount() > 0)
							{
								formattedDessert = cookItem.getDozenCount() + " - " + item.getName() +  " @ " +
										df.format(cookItem.getDozenCost()) + " for 12 : $" + 
										df.format(dozenCost) + "\n" +  + " - " + item.getName() + " @ " 
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
	
	
	public int getNumberOfDrinks()
	{
		return Drinks.size();
	}
	
	public int getNumberOfDesserts()
	{
		return Desserts.size();
	}
	
	public int getNumberOfItems() {
		return numberOfItems;
	}

	
	public static void max()
	{
		
	}
	
	/**
	 * Checks all Desserts on the receipt and finds the most expensive
	 * @return DessertItem - the most expensive single item on the order
	 */
	public static DessertItem MaxDessert(ArrayList<DessertItem> desserts)
	{
		return Collections.max(desserts);
	}
	
	
	/**
	 * Checks all Drinks on the receipt and finds the most expensive
	 * @return DrinkItem - the most expensive single item on the order
	 */
	public static DrinkItem MaxDrink(ArrayList<DrinkItem> drinks)
	{
		return Collections.max(drinks);
	}


	
	
}
