
package edu.csulb.cecs277;

import java.util.LinkedList;
import java.util.Collections;

public class Deck 
{
	LinkedList <Card> deck = new LinkedList <Card>();
	private int deckSize;
	
	/**
	 * Constructs a deck either of 0 cards or all 52
	 * @param isEmpty - if set to true creates an empty deck object. 
	 */
	public Deck(boolean isEmpty)
		{
			if (!isEmpty)
			{
				AddAllCards();
				Shuffle();	
			}
			else
			{
				
			}
		
		}
	
	
	/**
	 * Creates all 52 different cards in a deck
	 */
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
	
	/**
	 * Shuffles the deck
	 */
	private void Shuffle()
		{
			Collections.shuffle(deck);
		}
	
	/**
	 * deals the top card of the deck
	 * @return Card - returns the top card of a deck.
	 */
	public Card Deal()
	{
		return deck.removeFirst();
	}
	
	/**
	 * adds a card to the bottom of the deck
	 * @param addition - the card to be added
	 */
	public void Add(Card addition)
	{
		deck.add(addition);
	}
	
	/**
	 * completely empties the deck into another deck
	 * @param targetDeck - the deck to be emptied into.
	 */
	public void EmptyToDeck(Deck targetDeck)
		{
			int cardCount = getDeckSize();
			for (int i = 0; i < cardCount; i ++)
				{
					Card x = Deal();
					targetDeck.Add(x);
				}
		}
	
	/**
	 * Checks the deck size and compares it against the number required
	 * @param cardsRequired - the minimum number of cards needed for an action
	 * @return boolean - whether or not the deck contains enough cards
	 */
	public boolean hasEnoughCards(int cardsRequired)
	{
		if (cardsRequired > getDeckSize())
			{
				return false;
			}
		else
			{
				return true;
			}
	}
	
	/**
	 *checks if the deck is empty 
	 * @return boolean - whether or not the deck is empty
	 */
	public boolean isEmpty()
	{
		CountDeckSize();
		return (deckSize == 0);
	}
	
	/**
	 * Updates deckSize to the current deck size
	 */
	private void CountDeckSize()
		{
			deckSize = deck.size();
		}
	
	/**
	 * returns the deckSize 
	 * @return deckSize - size of the deck
	 */
	public int getDeckSize()
		{
			CountDeckSize();
			return deckSize;
		}
}

