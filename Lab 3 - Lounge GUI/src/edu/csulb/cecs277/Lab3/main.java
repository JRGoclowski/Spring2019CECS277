package edu.csulb.cecs277.Lab3;

public class main {
	
	static Receipt test = new Receipt();
	
	public static void main(String[] args) {
		addItems();
		System.out.println(test.CreateFull());

		
	}
	
	
	public static void addItems() {
		PastryItem pastry1 = new PastryItem ("Muffin", "Blueberry", false);
		PastryItem pastry2 = new PastryItem ("Cheesecake", "Blueberry", false);
		PastryItem pastry3 = new PastryItem ("Muffin", "Coffee Cake", true);
		CoffeeItem coffee1 = new CoffeeItem ("S", "Regular", "4", "No Milk", "Hot", "None");
		CoffeeItem coffee2 = new CoffeeItem ("M", "Mocha", "1", "No Milk", "Hot", "Warm");
		TeaItem tea1 = new TeaItem("L", "Green", "1/2 Sweetened", "Whole Milk");
		test.AddItem(pastry1);
		test.AddItem(pastry2);
		test.AddItem(pastry3);
		test.AddItem(coffee1);
		test.AddItem(coffee2);
		test.AddItem(tea1);
	}
	
}
