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
	
	/**
	 * Sets the board up for a new board state
	 */
	public void ResetBoard()
	{
		opponentContest = null;
		playerContest = null;
		opponentFollowup = null;
		playerFollowup = null;
		
	}
	
	/*public void StackDeck(int cardsToKeep)//TODO Delete method
	{
		opponentDeck.EmptyToDeck(playerDeck);
		for (int i = 0; i < cardsToKeep; i++)
			{
				Card x =  playerDeck.Deal();
				opponentDeck.Add(x);
			}
	}*/
	
	/**
	 * Allows external classes to begin a round on the board.
	 * @return boolean - returns whether or not the player won the round.
	 */
	public boolean BeginRound()
		{
			return ContestRound();			
		}
	
	/**
	 * Collects all cards that were played in the round and adds them to the winner's deck
	 * @param isPlayerCards - boolean set to true if the player is the winner and gets the cards
	 */
	public void CollectCards(boolean isPlayerCards)
	{
		if (isPlayerCards)
			{
				playerPlayed.EmptyToDeck(playerDeck);
				opponentPlayed.EmptyToDeck(playerDeck);
			}
		else
			{
				playerPlayed.EmptyToDeck(opponentDeck);
				opponentPlayed.EmptyToDeck(opponentDeck);
			}
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
					//System.out.println("Player Card Played!");
				}
			else
				{
					playedCard = opponentDeck.Deal();
					opponentPlayed.Add(playedCard);
					//System.out.println("Opponent Card Played!");
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
			System.out.println("Now for the contest...");
			System.out.println();
			playerContest = ContestCard(true);
			System.out.println("You played " + playerContest.showCard() + ".");
			opponentContest = ContestCard(false);
			System.out.println("You opponent played " + opponentContest.showCard() + ".");
			if (checkWar())
				{
					if (!playerDeck.isEmpty()&& !opponentDeck.isEmpty())
						{
							return WarRound();
						}
				}
			return checkPlayerWin();
		}
	
	
	/**
	 * This method performs the functionality of the follow up round for both players if desired
	 * @param isPlayerCard - boolean that is true of the player is the one requesting followup. False causes the computer to perform the round
	 * @return boolean - returns if the followup round was won
	 */
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
					System.out.println("Both players have fielded three cards!");
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
				System.out.println("The player has fielded 3 cards.");
				cardsRemaining = opponentDeck.getDeckSize();
				for (int i = 0; i < cardsRemaining-1; i++)
					{
						FieldCard(false);
					}
				System.out.println("The opponent has fielded their last " + (cardsRemaining-1) + " spare cards." );
				
				return ContestRound();
			}
		else
			{
				System.out.println("War!");
				for (int i = 0; i < 3; i++)
					{
						FieldCard(false);
					}
				System.out.println("The opponent has fielded 3 cards.");
				cardsRemaining = playerDeck.getDeckSize();
				for (int i = 0; i < cardsRemaining-1; i++)
					{
						FieldCard(true);
					}
				System.out.println("The player has fielded their last " + (cardsRemaining-1) + " spare cards." );
				
				return ContestRound();
			}
			
	}
	
	/**
	 * checks if both decks contain enough cards for a round of war.
	 * @return boolean - true if both decks have at least 4 cards
	 */
	private boolean BothDecksSufficient()
		{
			return (playerDeck.hasEnoughCards(4) && opponentDeck.hasEnoughCards(4));
		}

	/**
	 * returns the opponent Followup Card
	 * @return Card - The opponent's followup card
	 */
	public Card getOpponentFollowup()
		{
			return opponentFollowup;
		}
	
	/**
	 * returns the player's Followup Card
	 * @return Card - The player's followup card
	 */
	public Card getPlayerFollowup()
		{
			return playerFollowup;
		}
		
	/**
	 * returns how many cards have been played. 
	 * @return int - the number of cards played onto the field
	 */
	public int getCardsInPlay()
	{
		return playerPlayed.getDeckSize() + opponentPlayed.getDeckSize();
	}
	
	/**
	 * returns the player's deck
	 * @return deck - the player's deck
	 */
	public Deck getPlayerDeck()
		{
			return playerDeck;
		}

	/**
	 * returns the opponent's Deck
	 * @return deck - the opponent's deck
	 */
	public Deck getOpponentDeck()
		{
			return opponentDeck;
		}

	/**
	 * Returns the deck that represents the player's played cards
	 * @return deck - the cards the player has played
	 */
	public Deck getPlayerPlayed()
		{
			return playerPlayed;
		}
	
	/**
	 * returns the opponent's contest card
	 * @return card - the opponent's card used to contest
	 */
	public Card getOpponentContest() {
		return opponentContest;
	}
	
	/**
	 * returns the player's contest card
	 * @return card - the opponent's card used to contest
	 */
	public Card getPlayerContest() {
		return playerContest;
	}

	/**
	 * returns the deck that represents the opponent's played cards
	 * @return deck - the cards that the opponent has played
	 */
	public Deck getOpponentPlayed()
		{
			return opponentPlayed;
		}

}

