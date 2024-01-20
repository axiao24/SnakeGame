package main;

import java.util.Random;
import java.util.TimerTask;
public class Apple extends TimerTask
{
	
	private int x;
	private int y;
	private Snake snake;
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public Apple(Snake snake)
	{
		this.snake = snake;
	}
	
	public Apple()
	{
		this.x = 25 * new Random().nextInt(20);
		this.y = 25 * new Random().nextInt(20);
	}

	@Override
	public void run() {
		if(this.snake.getApple() == null);
		{
			this.snake.setApple(new Apple());
		}
		
	}
	

}
