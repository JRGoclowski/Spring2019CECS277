package edu.csulb.cecs277;

import java.util.LinkedList;
import java.util.Random;


public class Deck 
{
	LinkedList <Card> deck = new LinkedList <Card>();
	private int deckSize;
	private Random rng;
	
	public Deck()
		{
			AddAllCards();
			Shuffle(7);
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
	
	private void Shuffle(int timesShuffled)
		{
			//Create two lists to split the deck into
			LinkedList <Card> stackOne = new LinkedList <Card>();
			LinkedList <Card> stackTwo = new LinkedList <Card>();
			//Shuffles the decks by taking from one of the two stacks randomly, done a number of times
			//according to param timesShuffled
			for (int l = 0; l < timesShuffled; l++); //TODO make sure this shuffles the right times according to param
				{
					int i,j;
					CountDeckSize();
					//Splits the deck in half
					for (i = 0; i< deckSize/2; i++)
						{
							stackOne.add(deck.removeFirst());
						}
					while (!deck.isEmpty())
						{
							stackTwo.add(deck.removeFirst());
						}
					//Randomly chooses until one stack is empty
					while (!stackOne.isEmpty() && !stackTwo.isEmpty())
						{
							int toss = rng.nextInt(1);
							if (toss == 0)
								{
									deck.add(stackOne.removeFirst());
								}
							else
								{
									deck.add(stackTwo.removeFirst());
								}
						}
					if (stackOne.isEmpty())
						{
							while (!stackTwo.isEmpty())
								{
									deck.add(stackTwo.removeFirst());
								}
						}
					else
						{
							while (!stackOne.isEmpty())
								{
									deck.add(stackOne.removeFirst());
								}
						}
				}
		}
	
	public Card Deal()
	{
		return deck.removeFirst();
	}

	private void CountDeckSize()
		{
			deckSize = deck.size();
		}
	
	public int getDeckSize()
		{
			CountDeckSize();
			return deckSize;
		}
}
