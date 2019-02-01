package edu.csulb.cecs277;

public class GameRunner {
	
	Board gB = new Board();
	Interface ui = new Interface();
	
	/**
	 * Runs the necessary methods to run a full game. 
	 */
	public void execute()
	{
		while (!CheckGameOver())
			{
				GameStatus();
				Wait(1);
				PlayRound();
				gB.ResetBoard();
				System.out.println();
			}
		if (gB.getPlayerDeck().isEmpty())
			{
				System.out.println("You have lost! Better luck next time!");
			}
		else
			{
				System.out.println("You are the winner! Way to Go!");
			}
	
	}
	
	/**
	 * shorthand for thread.sleep 
	 * @param seconds - the number seconds desired to wait
	 */
	private void Wait(double seconds)
		{
			try
				{
					Thread.sleep((long) (seconds * 1000));
				} catch (InterruptedException e)
				{
					
					e.printStackTrace();
				}
		}
	
	/**
	 * checks if one of the players have won
	 * @return boolean - returns true if one deck is empty and the game is over.
	 */
	private boolean CheckGameOver()
	{
		if (gB.getOpponentDeck().isEmpty() || gB.getPlayerDeck().isEmpty())
			{
				return true;
			}
		else 
			{
				return false;
			}
	}
	
	/**
	 * Short method to print the current game status, stating who is winning and how
	 * many cards each player has
	 */
	private void GameStatus()
	{
		String currentWinner;
		
		if (gB.getOpponentDeck().getDeckSize() == gB.getPlayerDeck().getDeckSize())
			{
				currentWinner = "nobody";
			}
		else if (gB.getOpponentDeck().getDeckSize() < gB.getPlayerDeck().getDeckSize())
			{
				currentWinner = "you";
			}
		else
			{
				currentWinner = "the computer";
			}
			
		if (!currentWinner.equals("nobody"))
			{
				System.out.print("The current winner is " + currentWinner + " with ");
				switch(currentWinner)
				{
					case "you": System.out.println(gB.getPlayerDeck().getDeckSize() + " cards. "
							+ "\nYour opponent has " + gB.getOpponentDeck().getDeckSize() + " cards."); break;
					case "the computer": System.out.println(gB.getOpponentDeck().getDeckSize() + " cards. "
							+ "\nYou have " + gB.getPlayerDeck().getDeckSize() + " cards."); break;
					
				}
				System.out.println();
			}
		else
			{
				System.out.println("The game is currently tied, with both players having half the deck");
				System.out.println();
			}
			
		
		
	}
	
	/**
	 * Runs a full round of war
	 */
	private void PlayRound()
		{
			System.out.println("The new round begins!");
			Wait(0.5);
			System.out.println();
			boolean playerWin = gB.BeginRound();
			Wait(1);
			System.out.println();
			if (playerWin)
				{
					if(!gB.getOpponentDeck().isEmpty())
						{
							gB.CollectCards(!ComputerFollowUpDecision());
						}
					else
						{
							System.out.println("The computer has no cards to follow-up.");
						}
					
				}
			else
				{
					if(!gB.getPlayerDeck().isEmpty())
						{				
							System.out.println("You have lost the contest. "
											+ "\nYour Opponent played " + gB.getOpponentContest().showCard() + ". "
											+ "\nYou played " + gB.getPlayerContest().showCard()+ ". "
											+ "\nWould you like to Follow-Up with your next card at a chance to win?"
											+ "\nPlease input (Y) or (N) : ");
							String[] a = new String[] {"Y", "N"};
							String playerResponse = ui.stringInUpper(a);
							switch (playerResponse)
							{
								case "Y": 
									boolean winner = gB.FollowupRound(true); 
									if (winner)
										{
											System.out.println("Congratulations! You won the round with " + gB.getPlayerFollowup().showCard() + ".");
											gB.CollectCards(winner);
										}
									else
										{
											System.out.println("Oh, no! Sorry, you lost the round with " + gB.getPlayerFollowup().showCard() + ".");
											gB.CollectCards(winner);
										}
									break;
								case "N": System.out.println("You have chosen not to follow-up. You lose the round."); gB.CollectCards(false); break;
							}
						}
					else
						{
							System.out.println("You have lost the contest. "
									+ "\nYour Opponent played " + gB.getOpponentContest().showCard() + ". "
									+ "\nYou played " + gB.getPlayerContest().showCard()+ ". ");
							System.out.println("You have no cards to follow up.");
						}
					
				}
		}
	
	/**
	 * A simple program to aid the computer on deciding whether or not it wishes to followup
	 * @return boolean - whether or not the computer wants to followup
	 */
	private boolean ComputerFollowUpDecision()
	{
		System.out.println("The computer is deciding how to act.");
		Wait(2);
		System.out.println();
		if ((gB.getPlayerContest().getRankValue() - gB.getOpponentContest().getRankValue()) > 6 )
			{
				System.out.println("The computer has decided to follow-up.");
				boolean comWon = gB.FollowupRound(false);
				if (comWon)
					{
						System.out.println("The computer won the round with " + gB.getOpponentFollowup().showCard() + ".");
					}
				else
					{
						System.out.println("The computer lost the round with " + gB.getOpponentFollowup().showCard() + ".");
						
					}
					
				return comWon;
			}
		System.out.println("The computer has decided not to follow-up."
				+ "\nYou win the round.");
		System.out.println();
		return false;
		
		
	}
}
