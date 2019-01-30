package edu.csulb.cecs277;


public class Board {

	private Deck playerDeck, opponentDeck, playerPlayed, opponentPlayed;
	private Card opponentContest, playerContest, opponentFollowup, playerFollowup;
	
	/**Board Constructor
	 * Creates a basic deck, gives the first half to the player, the gives the
	 * remaining cards to the opponent
	 * 
	 */
	public Board()
	{
		Deck startDeck = new Deck(false);
		playerDeck = new Deck(true);
		opponentDeck = new Deck (true);
		while (!startDeck.isEmpty())
			{
				playerDeck.Add(startDeck.Deal());
				opponentDeck.Add(startDeck.Deal());
			}
		playerPlayed = new Deck (true);
		opponentPlayed = new Deck(true);
	}
	
	public boolean BeginRound()
		{
			return ContestRound();			
		}
	
	
	/**
	 * checks current cards in play, and determines whether the current board state is a war
	 * 
	 * @return boolean - returns true if cards played initiate war
	 */
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
	
	/**
	 * checks current cards in play, and determines if the player has the winning card
	 * @return boolean - returns true if the players' card is superior
	 */
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
	
	/**
	 * Takes a card from a deck, and puts it onto the board in the appropriate field deck.
	 * 
	 * @param isPlayerCard -A boolean used to regulate which deck is to be acted on by the board
	 * 						A true statement will cause the board to act on the player's deck
	 * @return Card - returns the card that is added to the field.
	 */
	private Card FieldCard(Boolean isPlayerCard)
		{
			Card playedCard;
			if (isPlayerCard)
				{
					playedCard = playerDeck.Deal();
					playerPlayed.Add(playedCard);
					System.out.println("Player Card Played!");
				}
			else
				{
					playedCard = opponentDeck.Deal();
					opponentPlayed.Add(playedCard);
					System.out.println("Opponent Card Played!");
				}
			return playedCard;
		}
	
	/**
	 * Method to show the card that will be used to contest between the player and the opponent.
	 * Fields a card, and sets it to visible, so it can be displayed by the game.
	 * @param isPlayerCard -A boolean used to regulate which deck is to be acted on by the board
	 * 						A true statement will cause the board to act on the player's deck 
	 * @return Card - The card being played as the contest card
	 */
	private Card ContestCard(Boolean isPlayerCard)
		{
			Card x;
			x = FieldCard(isPlayerCard);
			x.makeVisible();
			return x;
			
			
		}
	
	/**
	 * Both players field a card, and it is made visible. The conditions are then checked for war
	 * and a loop begins until a contest Round where war is not met, and the game continues
	 * @return boolean	-	returns true if the player won
	 */
	private boolean ContestRound()
		{
			playerContest = ContestCard(true);
			opponentContest = ContestCard(false);
			if (checkWar())
				{
					if (!playerDeck.isEmpty()&& !opponentDeck.isEmpty())
						{
							return WarRound();
						}
				}
			return checkPlayerWin();
		}
	
	public boolean FollowupRound (boolean isPlayerCard)
	{
		Card Followup = FieldCard(isPlayerCard);
		
		if (isPlayerCard)
			{
				playerFollowup = Followup;
				if ((playerContest.getRankValue() + Followup.getRankValue())< opponentContest.getRankValue()) //TODO find out how face cards are used in this calculation
					{
						return true;
					}
				else
					{
						return false;
					}
			}
		else
			{
				opponentFollowup = Followup;
				if ((opponentContest.getRankValue() + Followup.getRankValue())< playerContest.getRankValue()) //TODO find out how face cards are used in this calculation
					{
						return true;
					}
				else
					{
						return false;
					}
			}
	}
	
	/**
	 * Runs a War Round, dealing out the cards and contesting. If the contest yields another war,
	 * calls another War Round. Checks that both decks have enough cards before continuing. If 
	 * there are insufficient cards, calls instead the Insufficient cards round instead.
	 * 
	 * 
	 */
	private boolean WarRound() 
		{
			if (BothDecksSufficient())
				{
					System.out.println("War!");
					for (int i = 0; i < 3; i++)
						{
							FieldCard(true);
							FieldCard(false);
						}
					return ContestRound();
				}
			else
				{
					return InsufficientCardsWarRound();
				}
			
		}
	
	/**
	 * Runs a round of war in which one of the decks does not have enough cards for a full round, 
	 * and handles the cards accordingly.
	 */
	private boolean InsufficientCardsWarRound()
	{
		int cardsRemaining;
		if (playerDeck.hasEnoughCards(4))
			{
				System.out.println("War!");
				for (int i = 0; i < 3; i++)
					{
						FieldCard(true);
					}
				cardsRemaining = opponentDeck.getDeckSize();
				for (int i = 0; i < cardsRemaining-1; i++)
					{
						FieldCard(false);
					}
				return ContestRound();
			}
		else
			{
				System.out.println("War!");
				for (int i = 0; i < 3; i++)
					{
						FieldCard(false);
					}
				cardsRemaining = playerDeck.getDeckSize();
				for (int i = 0; i < cardsRemaining-1; i++)
					{
						FieldCard(true);
					}
				return ContestRound();
			}
			
	}
	
	public Card getOpponentFollowup()
		{
			return opponentFollowup;
		}

	public Card getPlayerFollowup()
		{
			return playerFollowup;
		}

	private boolean BothDecksSufficient()
		{
			return (playerDeck.hasEnoughCards(4) && opponentDeck.hasEnoughCards(4));
		}
	
	public int getCardsInPlay()
	{
		return playerPlayed.getDeckSize() + opponentPlayed.getDeckSize();
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

