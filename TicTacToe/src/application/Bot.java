package application;

import java.util.ArrayList;
/**
 * The bot class exists to contain bot data and related methods.
 * @author ziobroa
 *
 */
public class Bot implements Player 
{
	protected int id;
	protected String name;
	public Bot(String n)
	{
		this.id=1;
		this.name=n;
	}
	/**
	 * The moveCheck method grabs an optimal next move from boardManipulator creates a move out of it
	 * (this move originally existed when doing a Minimax algorithm was in the cards)
	 * The move is then interrogated for its id value and this ID value is returned.
	 * @param currentBoard
	 * @return optimal move ID
	 */
	public int moveCheck(GameTile[] currentBoard) //This grabs a valid move using boardManipulator then sends it back to mainController so that the AI can manipulate the board.
	{
		GameTile[] placeBoard = new GameTile[9];
		placeBoard=currentBoard;
		boardManipulator decision = new boardManipulator(placeBoard);
		int SID=0;
		decision.decideMove();
		Move oMove= new Move(decision.getMove());
		SID=oMove.getIndex();	
		return SID;
	}
	/**
	 * Returns the owner ID of the current object.
	 */
	@Override
	public int getOID() {
		return this.id;
	}
	/**
	 * Returns this objects name.
	 */
	@Override
	public String getName() {
		return this.name;
	}
}
