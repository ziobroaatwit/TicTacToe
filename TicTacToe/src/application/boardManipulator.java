package application;

import java.util.ArrayList;
import java.util.Random;
/**
 * boardManipulator is a class dedicated to any sort of board manipulation required. In this case it is suited for TicTacToe only
 * but can be modified to encompass more tileBased games. 
 *
 * @author ziobroa
 *
 */
public class boardManipulator
{
	GameTile[] board;
	int move;
	public boardManipulator(GameTile[] s) //board object for manipulating gameTiles as the game proceeds.
	{
		this.board=s;
		this.move=0;
	}
	/**
	 * This method simply checks for whether the game should be over in any way. 
	 * @return
	 */
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
	public void decideMove()  //Currently just randomly generates moves. 
	{
		ArrayList<Integer> avInd = avInd(this.board);
		Random rand = new Random();
		if(avInd.size()>1)
		{
		int index=rand.nextInt(avInd.size());
		this.move=avInd.get(index);
		}
		else
		{
			this.move=-2;
		}
	}
	public void debugBoardPrint() //Prints out all GameTiles in the board.
	{
		for(int i=0;i<board.length;i++)
		{
			System.out.println(board[i].toString());
		}
	}
	public int getMove()
	{
		return this.move;
	}
}
