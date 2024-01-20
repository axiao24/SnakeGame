package main;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.*;

import static main.Parts.height;
import static main.Parts.width;



public class Snake extends JPanel{

		
		public static final Color color = new Color(255,255,255);
		public static final int start = 250;
		public static final int speed = 25;
	
		private ArrayList<Parts> body;
		private String direction;
		private Apple apple;
		
		private Main window;
		
		public Snake(main.Main window)
		{
			this.window = window;
			this.body = new ArrayList<>();
			body.add(new Parts(start, start));
			Parts tail = this.body.get(0);
			body.add(new Parts(tail.getPosX() - width, tail.getPosY()));
			Parts tail2 = this.body.get(1);
			body.add(new Parts(tail2.getPosX() - width, tail2.getPosY()));
			this.direction = "right";
			
		}
		
		public void setDirection(String direction)
		{
			this.direction = direction;
		}
		
		public String getDirection()
		{
			return direction;
		}
		
		public void addPart()
		{
			Parts tail = this.body.get(this.body.size() - 1);
			switch(this.direction)
			{
			case("left"):
				this.body.add(new Parts(tail.getPosX() + width, tail.getPosY()));
				break;
			case("right"):
				this.body.add(new Parts(tail.getPosX() - width, tail.getPosY()));
				break;
			case("up"):
				this.body.add(new Parts(tail.getPosX(), tail.getPosY() + width));
				break;
			case("down"):
				this.body.add(new Parts(tail.getPosX(), tail.getPosY() - width));
				break;
				
			}
			
		}
		public void checkCrash()
		{
			Parts p1 = this.body.get(0);
			for (int i = 1; i < this.body.size(); i++)
			{
				Parts p2 = this.body.get(i);
				
				
				if(p1.crash(p2))
				{
					System.out.println("GAME OVER!!");
					this.window.setVisible(false);
					JFrame frame = new JFrame("GAME OVER!");
					JOptionPane.showMessageDialog(frame,"Your Score: " + this.body.size());
					
					
					this.window.dispatchEvent(new WindowEvent(this.window, WindowEvent.WINDOW_CLOSING));
					System.exit(0);
				}
			}
			
			if(this.apple != null)
			{
				if(p1.crash(new Parts(this.apple.getX(), this.apple.getY())))
						{
				this.apple = null;
				this.addPart();
						}
			}
			
			
		}
		
		public void move()
		{
			ArrayList<Parts> newPart = new ArrayList<>();
			
			Parts first = this.body.get(0);
			Parts head = new Parts(first.getPosX(),first.getPosY());
			
					
		
		
		switch(this.direction)
		{
		case("right"):
			head.setPosx(speed);
			break;
		case("left"):
			head.setPosx(-speed);
			break;
		case("up"):
			head.setPosY(-speed);
			break;
		case("down"):
			head.setPosY(speed);
			break;
		}
		newPart.add(head);
		
		for(int i = 1; i < this.body.size(); i++)
		{
			Parts previous = this.body.get(i-1);
			Parts nextPart = new Parts(previous.getPosX(), previous.getPosY());
			newPart.add(nextPart);
			
		}
		
		this.body = newPart;
		checkCrash();
		}
		
		private void printSnake(Graphics g)
		{
			move();
			
			
			Graphics2D draw = (Graphics2D) g;
			if(this.apple != null)
			{
				draw.setPaint(Color.red);
				draw.drawRect(this.apple.getX(), this.apple.getY(), width, height);
				draw.fillRect(this.apple.getX(), this.apple.getY(), width, height);
			}
			
			
			draw.setPaint(Color.green);
			for(Parts a : this.body)
			{
				draw.drawRect(a.getPosX(), a.getPosY(), width,height);
				draw.fillRect(a.getPosX(), a.getPosY(), width,height);
			}
		}
		
		
		public void setApple(Apple apple)
		{
			this.apple = apple;
		}
		
		public Apple getApple() {
			return this.apple;
		}
		

		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			setBackground(color);
			printSnake(g);
		}

		
}
