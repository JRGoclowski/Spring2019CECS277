package edu.csulb.cecs277;

import java.util.ArrayList;

public class CashRegister
{
	
	//Provide methods to enter drink and desert items to the register
	//Provide a clear Method
	//Provide methods to geth the number of items and subtotals before tax
	//Calculate the grand total including tax
	static IOshortcut io = new IOshortcut();
	static ArrayList <Receipt> orders = new ArrayList<Receipt>();
	
	public void showOptions()
	{
		boolean continueRunning = true;
		while (continueRunning)
		{
			System.out.print("What would you like to do?\n"
					+ "\n1 - Start a new order"
					+ "\n2 - Show a previous receipt"
					+ "\n3 - Clear all previous orders"
					+ "\n4 - Close out register"
					+ "\nEnter choice : ");
			int choice = io.intIn(1,4); 
			System.out.println();
			switch (choice)
			{
				case 1: System.out.println("Begining new order"); System.out.println(); orders.add(newOrder()); break;
				case 2: PrintPreviousOrder(); break;
				case 3: orders.clear(); System.out.println("All previous orders cleared!");break;
				case 4: continueRunning = false; break;
			}
		}
		
		
	}
	
	private void PrintPreviousOrder()
	{
		if (orders.isEmpty())
		{
			System.out.println("There have been no orders yet.");
			System.out.println();
			return;
		}
		for (int i = 0; i < orders.size(); i++)//TOO this is not working, due to some mistake in the incrementation
		{
			Receipt givenOrder = orders.get(i);
			System.out.println((i+1) + "- " + givenOrder.getNumberOfItems() + " Items"
					+ "\n" + givenOrder.getNumberOfDrinks() + " Drinks"
					+ "\n" + givenOrder.getNumberOfDesserts() + " Desserts"
					+ "\nTotal Due : " + givenOrder.getGrandTotal());
			System.out.println();
		}
		System.out.print("Enter the number of the desired order to see a detailed view"
				+ "\nEnter 0 to return to main menu"
				+ "\nDesired order : ");
		int desiredOrder = io.intIn(0, orders.size())-1;
		if (desiredOrder != -1)
		{
			orders.get(desiredOrder).PrintReceipt();
		}
		
	}
	
	private Receipt newOrder() 
	{
		Receipt currentOrder = new Receipt();
		boolean orderComplete = false;
		while (!orderComplete)
		{
			System.out.print("What would you like to do?\n"
					+ "\n1 - Print the current order receipt"
					+ "\n2 - Add a drink to the order"
					+ "\n3 - Add a dessert to the order"
					+ "\n4 - Clear the current order"
					+ "\n5 - Add any coupons and finalize the order"
					+ "\nEnter choice : ");
			int choice = io.intIn(1,5); 
			System.out.println();
			switch (choice)
			{
				case 1: currentOrder.PrintReceipt(); break;
				case 2: currentOrder.AddDrink(CreateDrink()); break;
				case 3: addDesserts(currentOrder); break;
				case 4: currentOrder.Clear(); 
					System.out.println("Order Cleared! New order begun"); break;
				case 5: 
					currentOrder.FinalizeOrder(io);; orderComplete = true; break;
				
			}
		}
		
		return currentOrder;
		
	}
	
	
	/**
	 * Creates a menu for the user to decide what kind of dessert they want to add to the order
	 * @param order - the receipt that the desserts are to be added to. 
	 */
	private void addDesserts(Receipt order)
	{
		System.out.print("Would you like to add: \n"
				+ "\n1 - Pastries"
				+ "\n2 - Cookies"
				+ "\n3 - Macaroons"
				+ "\nEnter choice : ");
		int dessertType = io.intIn(1, 3);
		System.out.println();
		switch (dessertType)
		{
			case 1: AddPastries(order); break;
			case 2: AddCookies(order); break;
			case 3: AddMacaroons(order); break;
			default: AddPastries(order); break;
		}
	}
	
	/**
	 * Creates a menu for the user to decide what kind of Pastries to add to the order, and how many.
	 * @param order - The receipt that the Pastries will be added to.
	 */
	private void AddPastries(Receipt order)
	{
		System.out.print("Would you like to add: \n"
				+ "\n1 - Cinnamon Roll - $ 3.00"
				+ "\n2 - Croissant - $2.70"
				+ "\n3 - Bagel - $2.90"
				+ "\n4 - Muffin - $3.10"
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
		System.out.println();
		System.out.println("Added " + numberDesired + " " + desiredDessert.getName() +"(s).");
		System.out.println();
	}
	
	/**
	 * Creates a menu for the user to decide what kind of Cookies to add to the order, and how many.
	 * @param order - The receipt that the Cookies will be added to.
	 */
	private void AddCookies(Receipt order) //TODO Add Prices
	{
		System.out.print("Would you like to add: \n"
				+ "\n1 - Chocolate Chip Cookies - $0.50 each\n\t\t- $5.00 per dozen"
				+ "\n2 - Oatmeal Cookies - $0.75 each\n\t\t- $7.50 per dozen"
				+ "\n3 - Peanut Butter Cookies - $0.80 each\n\t\t- $8.00 per dozen"
				+ "\nEnter choice : ");
		int dessertType= io.intIn(1, 3)-1;
		Cookie desiredDessert = new Cookie(dessertType);
		int numberDesired = 0;
		boolean correctCount = false;
		while (!correctCount)
		{
			System.out.print("How many would you like to add : ");
			numberDesired = io.intIn();
			System.out.print("You would like to add " + numberDesired + " " + desiredDessert.getName() +"(s)." 
					+ "\nIs this correct? [Y]es/[N]o : ");
			correctCount = io.YesOrNo();
		}
		for (int i = 0; i < numberDesired; i++)
		{
			order.AddDessert(desiredDessert);
		}
		System.out.println();
		System.out.println("Added " + numberDesired + " " + desiredDessert.getName() +"(s).");
		System.out.println();
	}
	
	/**
	 * Creates a menu for the user to decide what kind of Macaroons to add to the order, and how many.
	 * @param order - The receipt that the Macaroons will be added to.
	 */
	private void AddMacaroons(Receipt order)
	{
		System.out.print("Would you like to add: \n"
				+ "\n1 - Green Tea Macaroon - $1.00 each\n\t\t- $2.50 for 3"
				+ "\n2 - Chocolate Macaroon - $1.25 each\n\t\t- $3.00 for 3"
				+ "\n3 - Mango Macaroon - $1.50 each\n\t\t- $4.00 for 3"
				+ "\n4 - Strawberry Macaroon - $1.50 each\n\t\t- $4.00 for 3"
				+ "\nEnter choice : ");
		int dessertType= io.intIn(1, 4)-1;
		System.out.println();
		Macaroon desiredDessert = new Macaroon(dessertType);
		int numberDesired = 0;
		boolean correctCount = false;
		while (!correctCount)
		{
			System.out.print("How many would you like to add : ");
			numberDesired = io.intIn();
			System.out.print("You would like to add " + numberDesired + " " + desiredDessert.getName() +"(s)." 
					+ "\nIs this correct? [Y]es/[N]o : ");
			correctCount = io.YesOrNo();
		}
		for (int i = 0; i < numberDesired; i++)
		{
			order.AddDessert(desiredDessert);
		}
		System.out.println();
		System.out.println("Added " + numberDesired + " " + desiredDessert.getName() +"(s).");
		System.out.println();
	}
	
	/**
	 * Creates a menu for the user to decide what kind of drink to make, and calls the appropriate method
	 * @return DrinkItem - returns the drink the user decides to make.
	 */
	private DrinkItem CreateDrink()
	{
		DrinkItem drinkConstructed;
		System.out.print("Would you like to add a : \n"
				+ "\n1 - Coffee Drink "
				+ "\n2 - Boba Drink "
				+ "\nEnter choice : ");
		int drinkType = io.intIn(1, 2);
		System.out.println();
		switch (drinkType)
		{
			case 1: drinkConstructed = CreateCoffee(); break;
			case 2: drinkConstructed = CreateTea(); break;
			default : drinkConstructed = CreateTea(); break;
		}
		System.out.println();
		System.out.println("Added " + drinkConstructed.getName());
		System.out.println();
		return drinkConstructed;
	}
	
	/**
	 * Walks the user through creating a coffee drink
	 * @return CoffeeDrink - the constructed Coffee Drink
	 */
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
		System.out.println();
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
		System.out.println();
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
		System.out.println();
		return new CoffeeDrink(size, base, sweetener);
		
	}
	
	/**
	 * Walks the user through creating a tea drink
	 * @return BobaDrink - the constructed Tea Drink
	 */
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
		System.out.println();
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
		System.out.println();
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
		System.out.println();
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
		System.out.println();
		System.out.print("Which toppings are desired?\n"
				+ "\n1 - Boba"
				+ "\n2 - Popping Boba"
				+ "\n3 - Grass Jelly"
				+ "\n4 - Lyche Jelly"
				+ "\n5 - Coconut Jelly"
				+ "\n6 - Mini Mochi"
				+ "\n \nYou may add as many as desired. "
				+ "\nEnter 0 when no more toppings are desired"
				+ "\nEnter choice : ");
		choice = io.intIn(0,6)-1;
		System.out.println();
		while (choice != -1)
		{
			if (toppings.contains(choice))
			{
				System.out.println("You have already added " + options[choice]);
				System.out.println();
			}
			else
			{
				toppings.add(choice);
				System.out.println("You have added " + options[choice]);
				System.out.println();
			}
			System.out.print("Which toppings are desired?\n"
					+ "\n1 - Boba"
					+ "\n2 - Popping Boba"
					+ "\n3 - Grass Jelly"
					+ "\n4 - Lyche Jelly"
					+ "\n5 - Coconut Jelly"
					+ "\n6 - Mini Mochi"
					+ "\n\nYou may add as many as desired. \nEnter 0 when no more toppings are desired"
					+ "\nEnter choice : ");
			choice = io.intIn(0,6)-1;
			System.out.println();
		}
		return new BobaDrink(size, base, sweetness, milk, toppings);
		
	}
	
}
