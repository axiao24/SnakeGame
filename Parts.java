package main;
public class Parts {

	private int x;
	private int y;
	
	
	public static final int height = 25;
	public static final int width = 25;
	
	public Parts( int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public boolean crash(Parts other)
	{
		return this.x == other.getPosX() && this.y == other.getPosY(); 
	}
	
	public int getPosX()
	{
		return x;
	}
	
	public int getPosY()
	{
		return y;
	}
	
	public void setPosx(int move)
	{
		this.x = this.x + move;
	}
	
	
	public void setPosY(int move)
	{
		this.y = this.y + move;
	}
	
	
}
