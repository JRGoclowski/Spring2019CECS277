package edu.csulb.cecs277;

import java.util.ArrayList;

public class CashRegister
{
	
	//Provide methods to enter drink and desert items to the register
	//Provide a clear Method
	//Provide methods to geth the number of items and subtotals before tax
	//Calculate the grand total including tax
	static IOshortcut io = new IOshortcut();
	ArrayList <Receipt> orders = new ArrayList<Receipt>();
	
	public void showOptions()
	{
		System.out.println("What would you like to do?\n"
				+ "\n1 - Start a new order"
				+ "\n2 - Show previous receipts"
				+ "\n3 - Clear all previous orders"
				+ "\n4 - Close out register"
				+ "\nEnter choice : ");
		int choice = io.intIn(1,4); 
		switch (choice)
		{
		
		}
		
	}
	
	private Receipt newOrder() 
	{
		Receipt currentOrder = new Receipt();
		System.out.println("What would you like to do?\n"
				+ "\n1 - Print the current order receipt"
				+ "\n2 - Add a drink to the order"
				+ "\n3 - Add a dessert to the order"
				+ "\n4 - Clear the current order"
				+ "\n5 - Add any coupons and finalize the order"
				+ "\nEnter choice : ");
		int choice = io.intIn(1,5); 
		switch (choice)
		{
			case 1: currentOrder.PrintReceipt(); break;
			case 2: currentOrder.AddDrink(CreateDrink()); break;
			case 3: addDesserts(currentOrder); break;
		}
	}
	
	private void addDesserts(Receipt order)
	{
		System.out.print("Would you like to add: \n"
				+ "\n1 - Pastries"
				+ "\n2 - Cookies"
				+ "\n3 - Macaroons"
				+ "\nEnter choice : ");
		int dessertType = io.intIn(1, 3);
		switch (dessertType)
		{
			case 1: AddPastries(order); break;
			case 2: AddCookies(order); break;
			case 3: AddMacaroons(order); break;
			default: AddPastries(order); break;
		}
	}
	
	private void AddPastries(Receipt order)
	{
		System.out.print("Would you like to add: \n"
				+ "\n1 - Cinnamon Roll"
				+ "\n2 - Croissant"
				+ "\n3 - Bagel"
				+ "\n4 - Muffin"
				+ "\nEnter choice : ");
		int dessertType= io.intIn(1, 4)-1;
		System.out.print("Would you like it heated? [Y]es/[N]o : ");
		boolean heatedChoice = io.YesOrNo();
		Pastry desiredDessert = new Pastry(dessertType, heatedChoice);
		int numberDesired = 0;
		boolean correctCount = false;
		while (!correctCount)
		{
			System.out.print("How many would you like to add : ");
			numberDesired = io.intIn();
			System.out.println("You would like to add " + numberDesired + " " + desiredDessert.getName() +"(s)." 
					+ "\nIs this correct? [Y]es/[N]o : ");
			correctCount = io.YesOrNo();
		}
		for (int i = 0; i < numberDesired; i++)
		{
			order.AddDessert(desiredDessert);
		}
		System.out.println("Added " + numberDesired + " " + desiredDessert.getName() +"(s).");
	}
	
	private void AddCookies(Receipt order) //TODO Add Prices
	{
		System.out.print("Would you like to add: \n"
				+ "\n1 - Chocolate Chip Cookies"
				+ "\n2 - Oatmeal Cookies"
				+ "\n3 - Peanut Butter Cookies"
				+ "\nEnter choice : ");
		int dessertType= io.intIn(1, 3)-1;
		System.out.print("Would you like it heated? [Y]es/[N]o : ");
		boolean heatedChoice = io.YesOrNo();
		Pastry desiredDessert = new Pastry(dessertType, heatedChoice);
		int numberDesired = 0;
		boolean correctCount = false;
		while (!correctCount)
		{
			System.out.print("How many would you like to add : ");
			numberDesired = io.intIn();
			System.out.println("You would like to add " + numberDesired + " " + desiredDessert.getName() +"(s)." 
					+ "\nIs this correct? [Y]es/[N]o : ");
			correctCount = io.YesOrNo();
		}
		for (int i = 0; i < numberDesired; i++)
		{
			order.AddDessert(desiredDessert);
		}
		System.out.println("Added " + numberDesired + " " + desiredDessert.getName() +"(s).");
	}
	
	private void AddMacaroons(Receipt order);
	
	private DrinkItem CreateDrink()
	{
		DrinkItem drinkConstructed;
		System.out.print("Would you like to add a : \n"
				+ "\n1 - Coffee Drink "
				+ "\n2 - Boba Drink "
				+ "\nEnter choice : ");
		int drinkType = io.intIn(1, 2);
		switch (drinkType)
		{
			case 1: drinkConstructed = CreateCoffee(); break;
			case 2: drinkConstructed = CreateTea(); break;
			default : drinkConstructed = CreateTea(); break;
		}
		System.out.println("Added " + drinkConstructed.getName());
		return drinkConstructed;
	}
	
	private CoffeeDrink CreateCoffee()
	{
		char size;
		String base;
		int sweetener, choice;
		System.out.print("What size? \n"
				+ "\n1 - Small"
				+ "\n2 - Medium"
				+ "\n3 - Large "
				+ "\nEnter choice : ");
		choice = io.intIn(1,3);
		switch (choice)
		{
			case 1: size = 'S'; break;
			case 2: size = 'M'; break;
			case 3: size = 'L'; break;
			default: size = 'M'; break;
		}
		System.out.print("Which base for making the coffee? \n"
				+ "\n1 - Whole Milk"
				+ "\n2 - Water"
				+ "\n3 - Almond Milk"
				+ "\nEnter choice : ");
		choice = io.intIn(1,3);
		switch (choice)
		{
			case 1: base = "Whole"; break;
			case 2: base = "Water"; break;
			case 3: base = "Almond"; break;
			default: base = "Whole"; break;
		}
		System.out.print("How many teaspoons of sugar?\n"
				+ "\nEnter desired number : ");
		sweetener = io.intIn();
		return new CoffeeDrink(size, base, sweetener);
		
	}
	
	private BobaDrink CreateTea() 
	{
		String[] options = {"Boba", "Popping Boba",	"Grass Jelly", 
				"Lyche Jelly", "Coconut Jelly","Mini Mochi"};
		ArrayList <Integer> toppings = new ArrayList<Integer>();
		char size;
		int sweetness, choice, topping;
		String milk, base;
		System.out.print("What size? \n"
				+ "\n1 - Small"
				+ "\n2 - Medium"
				+ "\n3 - Large "
				+ "\nEnter choice : ");
		choice = io.intIn(1,3);
		switch (choice)
		{
			case 1: size = 'S'; break;
			case 2: size = 'M'; break;
			case 3: size = 'L'; break;
			default: size = 'M'; break;
		}
		
		System.out.print("Which tea base is desired? \n"
				+ "\n1 - Green Tea"
				+ "\n2 - Black Tea"
				+ "\n3 - Jasmine Green Tea"
				+ "\n4 - Rose Tea"
				+ "\n5 - Oolong Tea"
				+ "\nEnter choice : ");
		choice = io.intIn(1,5);
		switch (choice)
		{
			case 1: base = "Green"; break;
			case 2: base = "Black"; break;
			case 3: base = "Jasmine"; break;
			case 4: base = "Rose"; break;
			case 5: base = "Oolong"; break;
			default: base = "Green"; break;
		}
		
		System.out.print("Which milk is desired? \n"
				+ "\n1 - Whole Milk"
				+ "\n2 - Half and Half"
				+ "\n3 - Almond Milk"
				+ "\n4 - Coconut Milk"
				+ "\n5 - No Milk"
				+ "\nEnter choice : ");
		choice = io.intIn(1,5);
		switch (choice)
		{
			case 1: milk = "Whole"; break;
			case 2: milk = "Half and Half"; break;
			case 3: milk = "Almond"; break;
			case 4: milk = "Coconut"; break;
			case 5: milk = "None"; break;
			default: milk = "Whole"; break;
		}
		
		System.out.print("How sweet shall it be?\n"
				+ "\n1 - Unsweetened"
				+ "\n2 - 1/4 sweetened"
				+ "\n3 - 1/2 sweetened"
				+ "\n4 - 3/4 sweetened"
				+ "\n5 - sweetened"
				+ "\nEnter choice : ");
		sweetness = io.intIn(1,5) - 1;
		
		System.out.println("Which toppings are desired?\n"
				+ "\n1 - Boba"
				+ "\n2 - Popping Boba"
				+ "\n3 - Grass Jelly"
				+ "\n4 - Lyche Jelly"
				+ "\n5 - Coconut Jelly"
				+ "\n6 - Mini Mochi"
				+ "You may add as many as desired. Enter 0 when no more toppings are desired"
				+ "\nEnter choice : ");
		choice = io.intIn(0,6);
		while (choice != 0)
		{
			if (toppings.contains(choice))
			{
				System.out.println("You have already added " + options[choice]);
			}
			else
			{
				toppings.add(choice);
				System.out.println("You have added " + options[choice]);
			}
			System.out.println("Which toppings are desired?\n"
					+ "\n1 - Boba"
					+ "\n2 - Popping Boba"
					+ "\n3 - Grass Jelly"
					+ "\n4 - Lyche Jelly"
					+ "\n5 - Coconut Jelly"
					+ "\n6 - Mini Mochi"
					+ "You may add as many as desired. Enter 0 when no more toppings are desired"
					+ "\nEnter choice : ");
			choice = io.intIn(1,6);
		}
		
		return new BobaDrink(size, base, sweetness, milk, toppings);
		
	}
	
}
