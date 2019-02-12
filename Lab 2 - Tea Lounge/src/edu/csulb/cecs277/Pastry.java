package edu.csulb.cecs277;

public class Pastry extends DessertItem
{
	//quantity, unit price, and heating option
	//Cost determined by unit price and quantity
	int quantity;
	double unitPrice;
	boolean heated;
	public double getCost()
	{
		return 5.00;
	}
}
