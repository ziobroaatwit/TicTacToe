package application;

import java.util.ArrayList;

public class boardManipulator
{
	GameTile[] board;
	int move;
	public boardManipulator(GameTile[] s) //board object for manipulating gameTiles as the game proceeds.
	{
		this.board=s;
		this.move=0;
	}
	public boolean gameOver() //Returns the game over state given any player either real or computer has won or the board is out of moves to play.
	{
		return(playerWon(0)||playerWon(1)|| avInd(board).isEmpty());
	}
	public boolean playerWon(int playerID) //Checks if any win condition has been met, at all, given a player ID.
	{
		//Check in this order, top row, mid row, bottom row, left col, mid col, right col, left diag, right diag
		if(
				(board[0].getOID()==playerID&&board[1].getOID()==playerID&&board[2].getOID()==playerID) 
				||
				(board[3].getOID()==playerID&&board[4].getOID()==playerID&&board[5].getOID()==playerID)
				||
				(board[6].getOID()==playerID&&board[7].getOID()==playerID&&board[8].getOID()==playerID)
				||
				(board[0].getOID()==playerID&&board[3].getOID()==playerID&&board[6].getOID()==playerID)
				||
				(board[1].getOID()==playerID&&board[4].getOID()==playerID&&board[7].getOID()==playerID)
				||
				(board[2].getOID()==playerID&&board[5].getOID()==playerID&&board[8].getOID()==playerID)
				||
				(board[0].getOID()==playerID&&board[4].getOID()==playerID&&board[8].getOID()==playerID)
				||
				(board[2].getOID()==playerID&&board[4].getOID()==playerID&&board[6].getOID()==playerID)
			)
			return true;
		else
			return false;
	}
	public static ArrayList<Integer> avInd(GameTile[] s) //Retrieves all indices in the board that are not filled.
	{
		ArrayList<Integer> avInd = new ArrayList<>();
		for(int i=0;i<s.length;i++)
		{
			if(s[i].getOID()==-1)
			{
				avInd.add(i);
			}
		}
		return avInd;	
		
	}
	public boolean placeMove(int i,int playerID) //checks if the location in the board is empty, if it is not, returns false, then places the index in the ID of the player passed.
	{
		if(board[i].getOID()!=-1)
		{
			return false;
		}
		board[i].changeOID(playerID);
			return true;

	}
	public void debugBoardPrint() //Prints out all GameTiles in the board.
	{
		for(int i=0;i<board.length;i++)
		{
			System.out.println(board[i].toString());
		}
	}
	public int minimax(int depth,int turn) //MinMax Algorithm for Deciding the Next Move for the AI.
	{
		int min=Integer.MIN_VALUE;
		int max=Integer.MAX_VALUE;
		ArrayList<Integer> avInd = avInd(board);
		if(playerWon(1))
		{
			return 1;
		}
		if(playerWon(0))
		{
			return -1;
		}
		if(avInd.isEmpty())
		{
			return 0;
		}
		for(int i=0;i<avInd.size();i++)
		{
			System.out.println(avInd);
			int index = avInd.get(i);
			System.out.println("INDEX: "+index);
			if(turn==1)
			{
				placeMove(index,1);
				int currentScore = minimax(depth+1,0);
				max=Math.max(currentScore, max);
				if(depth==0)
				{
					System.out.println("Computer Score for Position "+index+" = "+currentScore);
				}
				if(currentScore>=0)
				{
					if(depth==0)
					{
						this.move=index;
					}
				}
				if(currentScore==1)
				{
					board[index].changeOID(-1);
					break;
				}
				if(i==avInd.size()-1 && max<0)
				{
					if(depth==0)
					{
						this.move=index;
					}
				}
				
			}
			else if(turn==0)
			{
				placeMove(index,0);
				int currentScore = minimax(depth+1,1);
				min = Math.min(currentScore, min);
				if(min == -1)
				{
					board[i].changeOID(-1);
					break;
				}
				
			}
			board[i].changeOID(-1);
		}
		if(turn == 1)
		{
			System.out.println("MAX: "+max);
			return max;
		}
		else
		{
			System.out.println("MIN: "+min);
			return min;
		}
		
	}
	public int getMove()
	{
		return this.move;
	}
}
