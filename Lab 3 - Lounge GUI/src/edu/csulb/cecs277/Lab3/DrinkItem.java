package edu.csulb.cecs277.Lab3;

public abstract class DrinkItem extends Item
{
	String size, flavor, sweetness, milk;
	
	protected DrinkItem() {
		super.setName("N/A");
		setSize("N/A");
		setFlavor("N/A");
		setSweetness("N/A");
		setMilk("N/A");
	}
	
	protected DrinkItem(String name, String size, String flavor, String sweetness, String milk) {
		super.setName(name);
		setSize(size);
		setFlavor(flavor);
		setSweetness(sweetness);
		setMilk(milk);
	}
	
	public void setFlavor(String flavorString) {
		flavor = flavorString;
	}
	
	public void setMilk (String milkString) {
		milk = milkString;
	}
	
	public void setSize(String sizeString) {
		size = sizeString;
	}
	
	public void setSweetness(String sweetString) {
		sweetness = sweetString;
	}

	public String getSize()
	{
		return size;
	}

	public String getFlavor()
	{
		return flavor;
	}

	public String getSweetness()
	{
		return sweetness;
	}

	public String getMilk()
	{
		return milk;
	}
	
	public abstract String toString();
	
	
}
