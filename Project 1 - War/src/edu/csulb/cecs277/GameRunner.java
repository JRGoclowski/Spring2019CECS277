package edu.csulb.cecs277;

public class GameRunner {
	
	Board gameBoard = new Board();
	
	public void execute()
	{
		while (true)
			{
				PlayRound();
			}
		
	}
	
	public void PlayRound()
		{
			if (gameBoard.BeginRound())
				{
					//ComputerFollowUp
					int x = 5;
				}
			else
				{
					gameBoard.FollowupRound(true);
				}
		}

}
