package application;
/**
 * This class contains the Move object constructors, and its methods
 * @author ziobroa
 *
 */
public class Move 
{
	protected int index;
	protected int score;
	/**
	 * This original constructor would have been used in the 
	 * context of a minimax algorithm but I could not get it functioning
	 * in time.
	 * @param i
	 * @param s
	 */
	public Move(int i,int s)
	{
		this.index=i;
		this.score=s;
	}
	/**
	 * This scoreless constructor simply holds the index of the move.
	 * @param i
	 */
	public Move(int i)
	{
		this.index=i;
	}
	/**
	 * If a score exists, it returns it.
	 * @return
	 */
	public int getScore()
	{
		return this.score;
	}
	/**
	 * Returns the index.
	 * @return
	 */
	public int getIndex()
	{
		return this.index;
	}
	public String toString()
	{
		return String.format("SCORE: %d INDEX: %d",this.getScore(),this.getIndex());
	}
	
}
