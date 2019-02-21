package edu.csulb.cecs277;

import java.lang.Math;
import java.text.DecimalFormat;
import java.util.*;

/**
 * 
 * @author Jonathan Goclowski
 *
 */
public class Receipt
{
	ArrayList<DrinkItem> Drinks = new ArrayList<DrinkItem>();
	ArrayList<DessertItem> Desserts = new ArrayList<DessertItem>();
	int numberOfItems;
	DecimalFormat df = new DecimalFormat("#.00");
	double subTotal, grandTotal, amountPaid = 0, changeDue;
	Coupon coupon = null;
	
	/**
	 * Prints out to the console the full receipt
	 * The form of the receipt will change depending on the presence of varaibles such as coupons or amountPaid
	 */
	public void PrintReceipt()
	{
		
		if (numberOfItems == 0)
		{
			System.out.println("The order is empty!\nAdd items to the order first!");
		}
		else
		{
			Sort();
			ArrayList<String> itemAssortment = GenerateReceipt();
			System.out.println();
			for (int i = 0; i < itemAssortment.size(); i++)
			{
				System.out.println(itemAssortment.get(i));
			}
			setSubTotal(itemAssortment);
			GenerateGrandTotal();
			String discount = null;
			if (coupon != null)
			{
				discount = ApplyCoupon();
			}
			System.out.println("Subtotal : $" + df.format(subTotal) + " for " + getNumberOfItems() + " item(s)");
			if (coupon!=null)
			{
				System.out.println(discount);
				GenerateGrandTotal();
			}
			System.out.println("Grand Total : $" + df.format(grandTotal));
			if (amountPaid != 0)
			{
				System.out.println("Amount Paid : $" + df.format(amountPaid));
				System.out.println("Change Due : $" + df.format(changeDue));
			}
			
			System.out.println();
		}
		
	}
	
	/**
	 * sets the subtotal for the given arraylist string
	 * @param receipt - The string arraylist to represent the desired receipt
	 */
	private void setSubTotal(ArrayList<String> receipt ) 
	{
		subTotal = 0;
		for (int i = 0; i < receipt.size(); i++)
		{
			String[] moneySplit = receipt.get(i).split("\\$");
			String amountString = (moneySplit[moneySplit.length-1]);
			Double amount = Double.parseDouble(amountString);
			//amount = Double.parseDouble(df.format(amount));
			subTotal = subTotal + amount;
		}
	}
	
	/**
	 * Generates the grand total by applying tax to the subtotal
	 */
	private void GenerateGrandTotal() {		
		double grandTotalTemp = subTotal + (subTotal*0.0775);
		grandTotal = Math.round(grandTotalTemp* 100.0 )/100.0;
	}
	
	/**
	 * Applys the coupon assosciated with the order
	 * @return String - the string that represents the coupons discount, and its affect on the receipts
	 */
	private String ApplyCoupon()
	{
		if (coupon.getItemType().equals("Drink"))
		{
			DrinkItem biggestItem= MaxDrink(Drinks);
			subTotal = subTotal - (biggestItem.getCost()*coupon.getDiscount());
			String discountString = "(" + df.format(coupon.getDiscount()*100) + "% off the " + biggestItem.toString()
				+ " : $" + df.format((biggestItem.getCost()*coupon.getDiscount())) + ")";
			return discountString; 
		}
		else
		{
			DessertItem biggestItem = MaxDessert(Desserts);
			double reduction = 0;
			String discountString = "";
			if (biggestItem instanceof Macaroon)
			{
				
				if (((Macaroon) biggestItem).hasTrio())
				{
					reduction = (((Macaroon) biggestItem).getTrioCost()*coupon.getDiscount());
					discountString = "(" + df.format(coupon.getDiscount()*100) + "% off the " + biggestItem.toString()
					+ " : $" + df.format((((Macaroon) biggestItem).getTrioCost()*coupon.getDiscount())) + ")";
				}
				else
				{
					reduction = (((Macaroon) biggestItem).getUnitCost()*coupon.getDiscount());
					discountString = "(" + df.format(coupon.getDiscount()*100) + "% off the " + biggestItem.toString()
					+ " : $" + df.format((((Macaroon)biggestItem).getUnitCost()*coupon.getDiscount())) + ")";
				}
			}
			else if (biggestItem instanceof Cookie)
			{
				if (((Cookie) biggestItem).hasDozen())
				{
					reduction = (((Cookie) biggestItem).getDozenCost()*coupon.getDiscount());
					discountString = "(" + df.format(coupon.getDiscount()*100) + "% off the " + biggestItem.toString()
					+ " : $" + df.format((((Cookie)biggestItem).getDozenCost()*coupon.getDiscount())) + ")";
				}
				else
				{
					reduction = (((Cookie) biggestItem).getUnitCost()*coupon.getDiscount());
					discountString = "(" + df.format(coupon.getDiscount()*100) + "% off the " + biggestItem.toString()
					+ " : $" + df.format((((Cookie)biggestItem).getUnitCost()*coupon.getDiscount())) + ")";
				}
			}
			else
			{
				reduction = biggestItem.getCost()*coupon.getDiscount();
				discountString = "(" + df.format(coupon.getDiscount()*100) + "% off the " + biggestItem.toString()
				+ " : $" + df.format((biggestItem.getCost()*coupon.getDiscount())) + ")";
			}
			subTotal = subTotal - (reduction);
//			String discount = "(" + coupon.getDiscount() + "% off the " + biggestItem.toString()
//				+ " : $" + (biggestItem.getCost()*coupon.getDiscount()) + ")";
			return discountString; 
		}
	}

	/**
	 * Updates the coupon attached to the receipt
	 * @param coup - the coupon to be attached to the receipt
	 */
	public void setCoupon(Coupon coup)
	{
		coupon = coup;
	}
	
	/**
	 * Creates an arraylist of each element on the receipt
	 * @return ArrayList - arraylist of strings, for each item on the receipt
	 */
	private ArrayList<String> GenerateReceipt() 
	{
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
						DessertItem dessertToAdd = Desserts.get(i);
						receipt.add(GenerateLine(dessertToAdd));
						addedItems.add(dessertToAdd.toString());
					}
			}
		return receipt;
	}
	
	/**
	 * Returns the subtotal value
	 * @return subtotal - the subtotal for the receipt
	 */
	public double getSubtotal()
	{
		return subTotal;
	}
	
	/**
	 * returns a string form of the subtotal, formatted to a money format
	 * @return String - the formatted subtotal
	 */
	public String getSubtotalFormatted()
	{
		return df.format(subTotal);
	}
	
	/**
	 * Returns the grand total of the receipt
	 * @return double - the grand total
	 */
	public double getGrandTotal()
	{
		return grandTotal;
	}
	
	/**
	 * Returns the grand total formatted as a string in a money format
	 * @return String - the formatted grand total
	 */
	public String getGrandTotalFormatted()
	{
		return df.format(grandTotal);
	}
	
	/**
	 * Resets the receipt to be empty
	 */
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
		else if (item instanceof Cookie)
			{
				Cookie cookItem = ((Cookie)item);
				if (cookItem.hasDozen())
					{
						double dozenCost = cookItem.getDozenCount()* cookItem.getDozenCost();
						double unitCost = cookItem.getUnitCount() * cookItem.getUnitCost();
						if (cookItem.getUnitCount() > 0)
							{
								formattedDessert = cookItem.getDozenCount() + " - " + item.getName() +  " @ " +
										df.format(cookItem.getDozenCost()) + " for 12 : $" + 
										df.format(dozenCost) + "\n" + cookItem.getUnitCount() + " - " + item.getName() + " @ " 
										+ df.format(((Cookie) item).getUnitCost()) + " each : $" + df.format(unitCost) + "\n" +
										 "\t Total for " + cookItem.getTotalCount() + " " + item.getName() + "s : $" + 
										df.format((unitCost + dozenCost));
							}
						else
							{
								formattedDessert = cookItem.getDozenCount() + " - " + item.getName() +  " @ " +
										df.format(((Cookie) item).getDozenCost()) + " for 12 : $" + 
										df.format(dozenCost);
							}
					}
				else
					{
						double totalCost = cookItem.getUnitCount() * cookItem.getUnitCost();
						formattedDessert = cookItem.getUnitCount() + " - " + item.getName() + " @ " 
								+ df.format(cookItem.getUnitCost()) + " each : $" + df.format(totalCost);
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
		if (addition instanceof Cookie)
			{
				numberOfItems += ((Cookie) addition).getTotalCount();
			}
		else
			{
				numberOfItems++;
			}
	}
	
	/**
	 * Returns the size of the drink array, which is the number of drinks
	 * @return int - number of drinks on the order
	 */
	public int getNumberOfDrinks()
	{
		return Drinks.size();
	}
	
	/**
	 * Returns the number of desserts, by subtracting the number of drinks
	 * from the total number of Items. This accounts for the fact that the 
	 * desserts array does not get the count of items with a quantity > 1
	 * @return int - the number of desserts on the order
	 */
	public int getNumberOfDesserts()
	{
		return (numberOfItems - Drinks.size());
	}
	
	/**
	 * Returns the total number of items on the receipt
	 * @return int - the count of the items on the receipt
	 */
	public int getNumberOfItems() {
		return numberOfItems;
	}
	
	/**
	 * Returns the amount that was paid for the receipt
	 * @return double - the amount paid
	 */
	public double getAmountPaid() {
		return amountPaid;
	}
	
	/**
	 * Returns the amount that was paid as a formated string
	 * @return String - the formatted amount paid
	 */
	public String getAmountPaidFormatted() {
		return df.format(amountPaid);
	}
	
	/**
	 * Sets the amount of the amountPaid variable 
	 * @param amountPaid - the amount that was paid
	 */
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	
	
	/**
	 * Returns the string form of the changeDue 
	 * @return String - changeDue variable 
	 */
	public String getChangeDue() {
		return df.format(changeDue);
	}

	/**
	 * Sets the changeDue variable
	 * @param changeDue - the changeDuevariable
	 */
	public void setChangeDue(double changeDue) {
		this.changeDue = changeDue;
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
