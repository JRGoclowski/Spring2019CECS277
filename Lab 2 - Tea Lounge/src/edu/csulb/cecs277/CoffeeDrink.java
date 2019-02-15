package edu.csulb.cecs277;
import java.util.*;

public class CoffeeDrink extends DrinkItem
{
	
	String baseChoice;
	
	/**
	 * Constructor for the coffee
	 * @param size - Single character representing one of the three sizes
	 * @param base - The string form of the base for the coffee
	 * @param sweetener - the number of teaspoons to be added to the drink
	 */
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
	
	/**
	 * Sets the sweetness of the drink using the superclass method
	 * @param numberOfTsp - the number of teaspoons added to the drink to sweeten it
	 */
	public void setSweetness(int numberOfTsp)
	{
		super.setSweetness(Integer.toString(numberOfTsp) + " sugars");
	}
	
	/**
	 * Sets the base milk type
	 * @param milkType - String format of the base milk or water
	 */
	public void setBase(String milkType)
	{
		baseChoice = milkType;
	}
	
	/**
	 * Returns the calculated cost of the drink
	 */
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
