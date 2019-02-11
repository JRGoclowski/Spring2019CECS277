package edu.csulb.cecs277;
import java.util.*;

public class BobaDrink extends DrinkItem
{
	//base tea can be green, black, jasmine green, rose, or oolong tea
	//sweetness can be 3/4, 1/2, 1/4 or unsweetened
	//toppings boba, popping boba, grass jelly, lyche jelly, coconut jelly, and mini mochi
	//milk can be whole, half and half, almond milk, coconut milk, or none
	//cost determined by size and number of toppings
	ArrayList<String> toppings = new ArrayList<String>();
	String baseTea, baseMilk;
	
	public BobaDrink(char size, String base, int sweetness, String milk)
	{
		char sizeChoice = Character.toUpperCase(size);
		switch(base)
		{
			case "Green": baseTea = base + " Tea"; break;
			case "Black": baseTea = base + " Tea"; break;
			case "Jasmine": baseTea = base + " Green Tea"; break;
			case "Rose": baseTea = base + " Tea"; break;
			case "Oolong": baseTea = base + " Tea"; break;
			default: baseTea = "Green Tea"; break;
		}
		
		switch (sizeChoice) 
		{
			case 'S': super.setSize("Small");break;
			case 'M': super.setSize("Medium");break;
			case 'L': super.setSize("Large");break;
			default: super.setSize("Medium");break;
		}
		
		switch (milk)
		{
			case "Whole": baseMilk = milk + " milk"; break;
			case "Half and Half": baseMilk = milk; break;
			case "Almond": baseMilk = milk + " milk"; break;
			case "Coconut": baseMilk = milk + " milk"; break;
			case "None": baseMilk = milk; break; 
			default: baseMilk = "Water"; break;
		}
		
		switch (sweetness)
		{
			case 0: super.setSweetness("Unsweetened");
			case 1: super.setSweetness("1/4 sweetened");
			case 2: super.setSweetness("1/2 sweetened");
			case 3: super.setSweetness("3/4 sweetened");
			case 4: super.setSweetness("Sweetened");
			default: super.setSweetness("Unsweetened");
		}
		
		String name = super.getSweetness() + baseTea + " with " 
	}
	public double getCost()
	{
		return 5.00;
	}
}
