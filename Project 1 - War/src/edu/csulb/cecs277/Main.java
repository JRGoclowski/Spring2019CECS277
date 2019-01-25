package edu.csulb.cecs277;

public class Main {
	
	public static void main (String args[])
	{
		Deck test = new Deck();
		int size = test.getDeckSize();
		for (int i = 0; i < size; i ++)
			{
				Card x =test.Deal();
				x.makeVisible();
				System.out.println(x.showCard());
			}
	}
}
