package net.feliixz.asteroidsx;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * KeyHandler Class
 */
public class KeyHandler implements KeyListener 
{

	public KeyHandler() 
	{
		
	}

	public void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode();
		
		if(Var.startGame)
		{
			if(key == KeyEvent.VK_W)
			{
				Var.spaceShipUp = true;
			}
			else if(key == KeyEvent.VK_A)
			{
				Var.spaceShipLeft = true;
			}
			else if(key == KeyEvent.VK_S)
			{
				Var.spaceShipDown = true;
			}
			else if(key == KeyEvent.VK_D)
			{
				Var.spaceShipRight = true;
			}
			else if(key == KeyEvent.VK_ESCAPE)
			{
				Var.startGame = false;
				Var.start = true;
			}
			else if(key == KeyEvent.VK_SPACE)
			{
				Var.shot = true;
			}
		}
	}

	public void keyReleased(KeyEvent e) 
	{
		int key = e.getKeyCode();
		
		if(Var.startGame)
		{
			if(key == KeyEvent.VK_W)
			{
				Var.spaceShipUp = false;
			}
			else if(key == KeyEvent.VK_A)
			{
				Var.spaceShipLeft = false;
			}
			else if(key == KeyEvent.VK_S)
			{
				Var.spaceShipDown = false;
			}
			else if(key == KeyEvent.VK_D)
			{
				Var.spaceShipRight = false;
			}
			else if(key == KeyEvent.VK_SPACE)
			{
				Var.shot = false;
			}
		}
	}

	public void keyTyped(KeyEvent e) 
	{
	}

}
