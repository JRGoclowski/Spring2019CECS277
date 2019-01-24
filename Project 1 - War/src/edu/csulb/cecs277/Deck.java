package edu.csulb.cecs277;

import java.util.LinkedList;

public class Deck 
{
	LinkedList <Card> deck = new LinkedList <Card>();
	
	public Deck()
		{
			AddAllCards();
			Shuffle();
		}
	
	private void AddAllCards()
		{
			int i,j;
			for (i = 0; i < 13; i ++)
				{
					for (j = 0; j < 4; j++)
						{
							Card Addition = new Card(i, j, false);
							deck.add(Addition);
						}
				}
			
		}
	
	private void Shuffle()
		{
			
		}
	
}
