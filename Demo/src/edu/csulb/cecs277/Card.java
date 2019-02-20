
package edu.csulb.cecs277;

public class Card {

	private String rank, suit;
	private int value, rankValue;
	private boolean visible;
	
	/**
	 * Constructor for a card
	 * @param ran - The string form of the rank
	 * @param sui - The string form of the suit 
	 * @param val - The int value of the card used for blackjack and the like
	 * @param vis - Whether or not the card's values should be visible
	 * @param ranVal - the int value of the rank
	 */
	public Card(String ran, String sui, int val, boolean vis, int ranVal)
		{
			rank = ran;
			suit = sui;
			value = val;
			rankValue = ranVal;
			visible = vis;
		}
	
	/**
	 * Constructor for a card
	 * @param ran - The string form of the rank
	 * @param sui - The string form of the suit
	 * @param vis - whether or not the card's values should be visible
	 */
	public Card(String ran, String sui, boolean vis)
		{
			rank = ran;
			suit = sui;
			try
				{
					int valueInt = Integer.parseInt(ran);
					value = valueInt;
				}
			catch (NumberFormatException q)
				{
					if (ran.toUpperCase().equals("A"))
						{
							value = 1;
						}
					else if (ran.toUpperCase().equals("J")
							|| ran.toUpperCase().equals("Q")
							|| ran.toUpperCase().equals("K"))
						{
							value = 10;
							if (ran.toUpperCase().equals("J"))
								{
									rankValue = 11;	
								}
							else if (ran.toUpperCase().equals("Q"))
								{
									rankValue = 12;
								}
							else if (ran.toUpperCase().equals("K"))
								{
									rankValue = 13;
								}
						}
					
				}
			visible = vis;
		}
	
	/**
	 * Constructor for a card
	 * @param ran - int form of the rank, from 0 for ace to 12 for king
	 * @param sui - int form of suit by alphabetical order
	 * @param vis - whether or not the card's values should be visible
	 */
	public Card(int ran, int sui, boolean vis)
		{
			switch (ran)
			{
				case 0: rank = "Ace"; rankValue = 1; break;
				case 1: rank = "2"; rankValue = 2; break;
				case 2: rank = "3"; rankValue = 3; break;
				case 3: rank = "4"; rankValue = 4; break;
				case 4: rank = "5"; rankValue = 5; break;
				case 5: rank = "6"; rankValue = 6; break;
				case 6: rank = "7"; rankValue = 7; break;
				case 7: rank = "8"; rankValue = 8; break;
				case 8: rank = "9"; rankValue = 9; break;
				case 9: rank = "10"; rankValue = 10; break;
				case 10: rank = "Jack"; rankValue = 11; break;
				case 11: rank = "Queen"; rankValue = 12; break;
				case 12: rank = "King"; rankValue = 13; break;
			}
			
			switch (sui)
			{
				case 0: suit = "Clubs"; break;
				case 1: suit = "Diamonds"; break;
				case 2: suit = "Hearts"; break;
				case 3: suit = "Spades"; break;
			}
			
			if (ran < 10)
				{
					value = ran + 1;
				}
			else
				{
					value = 10;
				}
			
			visible = vis;
		}
	
	/**
	 * Sets a card as visible, gets the ID string, then returns it to invisible
	 * @return cardID - The string form of the card "[rank] of [suit]"
	 */
	public String showCard()
	{
		makeVisible();
		String cardID = getCardID();
		makeInvisible();
		return cardID;
		
	}
	
	/**
	 * Returns a string that is either hidden or shown depending on the vard's visible value
	 * @return String - A string either showing the cards values or keeping them as ???
	 */
	private String getCardID()
	{
		String cardID;
		if (isVisible())
			{
				cardID = new String (getRank() + " of " + getSuit());
				return cardID;
			}
		else
			{
				cardID = "??? of ???";
				return cardID;
			}
	}
	
	/**
	 * Returns the rank value of the card
	 * @return String - String of the ranks
	 */
	public String getRank()
		{
			return rank;
		}

	/**
	 * sets the rank of a card
	 * @param rank - the desired rank in string form
	 */
	public void setRank(String rank)
		{
			this.rank = rank;
		}
	
	/**
	 * returns the suit in string form
	 * @return String - String form of the suit
	 */
	public String getSuit()
		{
			return suit;
		}
	
	/**
	 * sets the suit of a card
	 * @param suit - String form of the desired suit
	 */
	public void setSuit(String suit)
		{
			this.suit = suit;
		}
	
	/**
	 * returns the integer value of the card
	 * @return int - the value of the card
	 */
	public int getValue()
		{
			return value;
		}
	
	/**
	 * sets the value of a card
	 * @param value - integer of the desired value
	 */
	public void setValue(int value)
		{
			this.value = value;
		}
	
	/**
	 * Gets the rank value of the card
	 * @return int - the rank value of the card
	 */
	public int getRankValue()
		{
			return rankValue;
		}
	
	/**
	 * sets the Rank Value of the card
	 * @param rankValue - int the desired rank value
	 */
	public void setRankValue(int rankValue)
		{
			this.rankValue = rankValue;
		}
	
	/**
	 * Checks if the card is visible or not
	 * @return boolean - true if the card is visible
	 */
	public boolean isVisible()
		{
			return visible;
		}
	
	/**
	 * sets a card's visible value as true
	 */
	public void makeVisible()
		{
			visible = true;
		}
	
	/**
	 * sets a card's visible value as false
	 */
	public void makeInvisible()
		{
			visible = false;
		}
	
	
}