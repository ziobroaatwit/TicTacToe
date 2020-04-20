package application;

import java.util.ArrayList;

public class Bot implements Player 
{
	protected int id;
	protected String name;
	public Bot(String n)
	{
		this.id=1;
		this.name=n;
	}
	public int moveCheck(GameTile[] currentBoard)
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
	@Override
	public int getOID() {
		return this.id;
	}
	@Override
	public String getName() {
		return this.name;
	}
}
