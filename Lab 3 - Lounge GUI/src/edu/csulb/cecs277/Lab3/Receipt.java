package edu.csulb.cecs277.Lab3;

import java.util.*;
import java.text.DecimalFormat;


public class Receipt {
	
	public static ArrayList<Item> getOrderedItems() {
		return orderedItems;
	}

	double subTotal;
	String subString;
	
	double grandTotal;
	String grandString;
	
	static ArrayList <Item> orderedItems = new ArrayList<Item>();
	static ArrayList <String> receipt = new ArrayList<String>();
	DecimalFormat df = new DecimalFormat("#0.00");
	
	public String CreateFull() {
		receipt.clear();
		for (Item currentItem : orderedItems) {
			receipt.add((FormatItem(currentItem) + "\n\n"));
		}
		String fullReceipt = "~~~~~~~~~~~~~~~~~~~~~ Current Order ~~~~~~~~~~~~~~~~~~~~~\n\n";
		for (String item : receipt) {
			fullReceipt += item;
		}
		double sub = (Double.parseDouble(df.format(subTotal)));
		fullReceipt += "Subtotal:\t\t$" + df.format(sub) + "\n";
		double tax = (Double.parseDouble(df.format(subTotal*0.1)));
		fullReceipt += "Tax: \t\t$" + df.format((tax)) + "\n";
		fullReceipt += "Grand Total: \t\t$" + getGrandString();
		return fullReceipt;
	}

	public void AddItem(Item addition) {
		orderedItems.add(addition);
		subTotal += addition.getCost();
	}
	
	public String FormatItem(Item itemArg) {
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
	
	public String FormatDrink(DrinkItem drink) {
		String formattedDrink = "";
		formattedDrink = "--" + drink.toString() + "\t\t\t$" + df.format(drink.getCost())
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
	
	public String FormatPastry(PastryItem Pastry) {
		String formattedPastry = "--" + Pastry.getName() + " (";
		if (!Pastry.isHeated()) {
			formattedPastry += "un";
		}
		formattedPastry += "heated)" + "\t\t\t$" + df.format(Pastry.getCost());
		formattedPastry += "\n\t\t" + Pastry.getFlavor();
		return formattedPastry;
	}
	
	public boolean isEmpty() { return orderedItems.isEmpty(); }
	
	public double getSubTotal() { return subTotal; } 
	
	public String getSubString() { return df.format(subTotal); }
	
	public void setGrandTotal() { 
		double sub = Double.parseDouble(getSubString());
		double tax = Double.parseDouble(df.format(subTotal*0.1));
		grandTotal = sub + tax;
	}
	
	public String getGrandString() {
		setGrandTotal();
		return df.format(grandTotal);
	}
	
	public double getGrandTotal() { 
		setGrandTotal();
		return grandTotal; 
	}
	
	
}
