package edu.csulb.cecs277;

public class Card {

	private String rank, suit;
	private int value, rankValue;
	private boolean visible;
	
	public Card(String ran, String sui, int val, boolean vis, int ranVal)
		{
			rank = ran;
			suit = sui;
			value = val;
			rankValue = ranVal;
			visible = vis;
		}
	
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
	
	public String showCard()
	{
		makeVisible();
		String cardID = getCardID();
		makeInvisible();
		return cardID;
		
	}
	
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
	
	public String getRank()
		{
			return rank;
		}

	public void setRank(String rank)
		{
			this.rank = rank;
		}

	public String getSuit()
		{
			return suit;
		}

	public void setSuit(String suit)
		{
			this.suit = suit;
		}

	public int getValue()
		{
			return value;
		}

	public void setValue(int value)
		{
			this.value = value;
		}

	public int getRankValue()
		{
			return rankValue;
		}

	public void setRankValue(int rankValue)
		{
			this.rankValue = rankValue;
		}

	public boolean isVisible()
		{
			return visible;
		}

	public void makeVisible()
		{
			visible = true;
		}
	
	public void makeInvisible()
		{
			visible = false;
		}
	
	
}
