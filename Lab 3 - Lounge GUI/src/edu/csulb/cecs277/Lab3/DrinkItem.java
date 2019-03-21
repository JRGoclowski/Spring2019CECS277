package edu.csulb.cecs277.Lab3;

public abstract class DrinkItem extends Item
{
	String size, flavor, sweetness, milk;
	
	/**
	 * Default drink constuctor that sets all values to "N/A"
	 */
	protected DrinkItem() {
		super.setName("N/A");
		setSize("N/A");
		setFlavor("N/A");
		setSweetness("N/A");
		setMilk("N/A");
	}
	
	/**
	 * Drink constructor with all the desired variable values
	 * @param name - The name of the drink type, (i.e. Tea and Coffee)
	 * @param size - Single letter representation of size (S,M or L)
	 *  @param flavor - Single word to describe the flavor of the drink
	 * @param sweetness - A string that respresents the amount of sweetness
	 * @param milk  - The kind of milk that the drink has
	 */
	protected DrinkItem(String name, String size, String flavor, String sweetness, String milk) {
		super.setName(name);
		setSize(size);
		setFlavor(flavor);
		setSweetness(sweetness);
		setMilk(milk);
	}
	
	/**
	 * Sets the flavor variable of the drink
	 * @param flavorString - the flavor of the drink
	 */
	public void setFlavor(String flavorString) {
		flavor = flavorString;
	}
	
	/**
	 * Sets the milk variable of the drink
	 * @param milkString - the milk of the drink
	 */
	public void setMilk (String milkString) {
		milk = milkString;
	}
	
	/**
	 * Sets the size variable of the drink
	 * @param sizeString - the size of the drink
	 */
	public void setSize(String sizeString) {
		size = sizeString;
	}
	
	/**
	 * Sets the sweetness variable of the drink
	 * @param sweetString - the sweetness of the drink
	 */
	public void setSweetness(String sweetString) {
		sweetness = sweetString;
	}
	
	/**
	 * Returns the size variable of the drink
	 * @return String - the size variable of the drink
	 */
	public String getSize()
	{
		return size;
	}
	
	/**
	 * Returns the flavor variable of the drink
	 * @return String - the flavor variable of the drink
	 */
	public String getFlavor()
	{
		return flavor;
	}
	
	/**
	 * Returns the sweetness variable of the drink
	 * @return String - the sweetness variable of the drink
	 */
	public String getSweetness()
	{
		return sweetness;
	}

	/**
	 * Returns the milk variable of the drink
	 * @return String - the milk variable of the drink
	 */
	public String getMilk()
	{
		return milk;
	}
	
	/**
	 * Abstract method to turn the drink Item into a string
	 */
	public abstract String toString();
	
	
}
