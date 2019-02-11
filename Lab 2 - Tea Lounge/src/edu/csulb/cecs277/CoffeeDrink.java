package edu.csulb.cecs277;
import java.util.*;

public class CoffeeDrink extends DrinkItem
{
	
	String baseChoice;
	
	public CoffeeDrink(char size, String base, int sweetener)
	{
		char sizeChoice = Character.toUpperCase(size);
		switch (sizeChoice) 
		{
			case 'S': super.setSize("Small");break;
			case 'M': super.setSize("Medium");break;
			case 'L': super.setSize("Large");break;
			default: super.setSize("Medium");break;
		}
		
		switch (base)
		{
			case "Whole": baseChoice = base + " milk"; break;
			case "Water": baseChoice = base; break;
			case "Almond": baseChoice = base + " milk"; break;
			default: baseChoice = "Water"; break;
		}
		
		setSweetness(sweetener);
		String drinkName = super.getSize() + " " + baseChoice + " Coffee with " + sweetener + " sugars";
		super.setName(drinkName);
	}
	
	public void setSweetness(int numberOfTsp)
	{
		super.setSweetness(Integer.toString(numberOfTsp) + " sugars");
	}
	
	public void setBase(String milkType)
	{
		baseChoice = milkType;
	}
	
	public double getCost() 
	{
		switch(super.getSize())
		{
			case "Small": return 2.40;
			case "Medium": return 2.90;
			case "Large": return 3.15;
			default: return 2.90;
		}
		
	}
}
