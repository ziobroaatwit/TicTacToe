package application;

public class Move 
{
	protected int index;
	protected int score;
	public Move(int i,int s)
	{
		this.index=i;
		this.score=s;
	}
	public int getScore()
	{
		return this.score;
	}
	public int getIndex()
	{
		return this.index;
	}
	public String toString()
	{
		return String.format("SCORE: %d INDEX: %d",this.getScore(),this.getIndex());
	}
	
}
