package edu.csulb.cecs277.Lab3;

import java.util.*;
import java.text.DecimalFormat;


public class Receipt {
	

	double subTotal;
	String subString;
	
	double grandTotal;
	String grandString;
	
	static ArrayList <Item> orderedItems = new ArrayList<Item>();
	static ArrayList <String> receipt = new ArrayList<String>();
	DecimalFormat df = new DecimalFormat("#0.00");
	
	/**
	 * Creates a single string that represents the full receipt
	 * @return String - The full receipt
	 */
	public String CreateFull() {
		receipt.clear();
		for (Item currentItem : orderedItems) {
			receipt.add((FormatItem(currentItem) + "\n\n"));
		}
		String fullReceipt = "\t   ~~~~~~~~~~~~~~~~~~~~~~ Current Order ~~~~~~~~~~~~~~~~~~~~~~\n\n";
		for (String item : receipt) {
			fullReceipt += item;
		}
		double sub = (Double.parseDouble(df.format(subTotal)));
		fullReceipt += "\t   Subtotal:\t\t$" + df.format(sub) + "\n";
		double tax = (Double.parseDouble(df.format(subTotal*0.1)));
		fullReceipt += "\t   Tax: \t\t$" + df.format((tax)) + "\n";
		fullReceipt += "\t   Grand Total: \t\t$" + getGrandString();
		return fullReceipt;
	}
	
	/**
	 * Adds an item to the receipt's item array 
	 * @param addition - The item to be added to the receipt
	 */
	public void AddItem(Item addition) {
		orderedItems.add(addition);
		subTotal += addition.getCost();
	}
	
	/**
	 * Creates a formatted String of an item that will fit into the
	 * format of the receipt
	 * @param itemArg - The item to be formatted
	 * @return String - The item's receipt representation
	 */
	
	private String FormatItem(Item itemArg) {
		Item currentItem = itemArg;
		String formattedItem= "";
		if (currentItem instanceof DrinkItem) {
			formattedItem = FormatDrink(((DrinkItem)currentItem));
		}
		else {
			formattedItem = FormatPastry((PastryItem)currentItem);
		}
		return formattedItem;
	}
	
	/**
	 * helper method that specializes in formatting a drink item
	 * @param drink - The drink to be formatted
	 * @return String - The drink formatted to the receipt format
	 */
	private String FormatDrink(DrinkItem drink) {
		String formattedDrink = "";
		formattedDrink = "\t   --" + drink.toString() + "\t\t\t";
		//if (drink instanceof TeaItem && !(drink.getFlavor().equals("Jasmine Green") || (drink.getFlavor().equals("Oolong")))) {
			//formattedDrink += "\t";
		//}
			formattedDrink += "$" + df.format(drink.getCost())
			+ "\n\t\tSweetness: " + drink.getSweetness();
		if (drink instanceof CoffeeItem) { formattedDrink += " Teaspoon(s)";}
		formattedDrink += "\n\t\tMilk: " + drink.getMilk();
		if (drink instanceof TeaItem ) {
			formattedDrink += "\n\t\tToppings: ";
			ArrayList <String> toppings = ((TeaItem) drink).getToppings();
			if (toppings.isEmpty()) {
				formattedDrink += "none";
			}
			else {
				for (int i = 0; i < toppings.size(); i++) {
					String item = toppings.get(i);
					formattedDrink += item + " | ";
					if (i % 2 == 0) {
						formattedDrink += "\n\t\t";
					}
				}
			}
			
		}
		else {
			formattedDrink += "\n\t\tTemperature: " + ((CoffeeItem)drink).getTemperature()
					+ "\n\t\tSpecial Instructions: " + ((CoffeeItem)drink).getSpecialInstructions();
		}
		return formattedDrink;
	}
	 
	/**
	 * helper method that specializes in formatting a pastry item
	 * @param Pastry - The pastry to be formatted
	 * @return String - The pastry formatted to the receipt format
	 */
	private String FormatPastry(PastryItem Pastry) {
		String formattedPastry = "\t   --" + Pastry.getName() + " (";
		if (!Pastry.isHeated()) {
			formattedPastry += "un";
		}
		formattedPastry += "heated)" + "\t\t\t$" + df.format(Pastry.getCost());
		formattedPastry += "\n\t\t" + Pastry.getFlavor();
		return formattedPastry;
	}
	 
	/**
	 * Returns if the order is empty, having no items
	 * @return boolean - If the order is empty or not
	 */
	public boolean isEmpty() { return orderedItems.isEmpty(); }
	
	/**
	 * Returns the array of ordered Items
	 * @return ArrayList<Item> - The array containing ordered items
	 */
	public static ArrayList<Item> getOrderedItems() {
		return orderedItems;
	}
	
	/**
	 * Returns the double of the subTotal cost of the order
	 * @return double - The subtotal cost of the order so far
	 */
	public double getSubTotal() { return subTotal; } 
	 
	/**
	 * Returns the string form of the subTotal cost of the order
	 * @return string - The subtotal cost of the order so far
	 */
	public String getSubString() { return df.format(subTotal); }
	
	/**
	 * Updates the grand total of the order based on the current items
	 */
	public void setGrandTotal() { 
		double sub = Double.parseDouble(getSubString());
		double tax = Double.parseDouble(df.format(subTotal*0.1));
		grandTotal = sub + tax;
	}
	
	/**
	 * Returns the string form of the Grand Total cost of the order
	 * @return string - The subtotal cost of the order so far
	 */
	public String getGrandString() {
		setGrandTotal();
		return df.format(grandTotal);
	}
	
	/**
	 * Returns the double of the Grand Total cost of the order
	 * @return double - The Grand Total cost of the order so far
	 */
	public double getGrandTotal() { 
		setGrandTotal();
		return grandTotal; 
	}
	
	
}
