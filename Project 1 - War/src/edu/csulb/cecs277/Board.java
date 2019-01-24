package edu.csulb.cecs277;

public class Board {

	private Deck playerDeck, opponentDeck, playerPlayed, opponentPlayed;
	private Card opponentContest, playerContest;
	
	private boolean checkWar()
	{
		if (opponentContest.getRankValue() == playerContest.getRankValue())
			{
				return true;
			}
		else
			{
				return false;
			}
	}
	
	private boolean checkPlayerWin()
		{
			if (opponentContest.getRankValue()>playerContest.getRankValue())
				{
					return false;
				}
			else
				{
					return true;
				}
		}
	
	public Deck getPlayerDeck()
		{
			return playerDeck;
		}



	public Deck getOpponentDeck()
		{
			return opponentDeck;
		}



	public Deck getPlayerPlayed()
		{
			return playerPlayed;
		}



	public Deck getOpponentPlayed()
		{
			return opponentPlayed;
		}

}
