package edu.csulb.cecs277;

import java.util.ArrayList;

public class Main
{
	public static void main(String args[])
	{
		Receipt total = new Receipt();
		CoffeeDrink coffee1 = new CoffeeDrink('S', "Whole", 2);
		CoffeeDrink coffee2 = new CoffeeDrink('M', "Whole", 2);
		CoffeeDrink coffee3 = new CoffeeDrink('L', "Water", 1);
		int[] toppings = {1,2};
		BobaDrink boba1 = new BobaDrink('S', "Green", 2, "Almond", toppings);
		Pastry pastry1 = new Pastry(1,true);
		Pastry pastry2 = new Pastry(1,true);
		Pastry pastry3 = new Pastry(2, false);
		Macaroon mac1 = new Macaroon(2);
		Macaroon mac2 = new Macaroon(1);
		Macaroon mac3 = new Macaroon(2);
		total.AddDessert(pastry1);
		total.AddDessert(pastry3);
		total.AddDessert(mac1);
		total.AddDessert(pastry2);
		total.AddDessert(mac2);
		total.AddDrink(coffee2);
		total.AddDrink(boba1);
		total.AddDrink(coffee1);
		total.AddDrink(coffee3);
		total.AddDessert(mac3);
		total.print();
		System.out.println();
		total.Sort();
		total.print();
		System.out.println(total.GetNumberOf(mac1));
		System.out.println(total.GetNumberOf(pastry1));
	}
}
