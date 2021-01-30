package net.feliixz.asteroidsx;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;

/**
 * DrawPanel Class
 */
public class GamePanel extends JPanel
{
	public GamePanel() 
	{
		setBackground(Color.BLACK);
		this.addMouseListener(new MouseHandler());
		this.addMouseMotionListener(new MouseHandler());
		this.addKeyListener(new KeyHandler());
		this.setFocusable(true);
		
		Var.timer = new Timer(10, new ActionHandler());
		Var.timer.start();
		
		Meth.addRandomAsteroids();
		Meth.addRandomHealth();
		Meth.addRandomFuel();
	}

	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D)g;
		
		if(Var.start)
		{
			Meth.drawMenu(g2D);
			Var.startGame = false;
			repaint();
		}
		
		if(Var.startGame)
		{
			Var.start = false;
			Meth.createAsteroids(g2D);
			Meth.createHealth(g2D);
			Meth.createFuel(g2D);
			Meth.createPlayer(g2D);
			Meth.drawShot(g2D);	
			Meth.drawScore(g2D);
			Meth.drawFuel(g2D);
			Meth.drawHealth(g2D);
			repaint();
		}
		
		if(Var.exit)
		{
			System.exit(0);
		}
		
		if(Var.health == 0)
		{
			Var.gameOver = true;
		}
		
		if(Var.fuel <= 0)
		{
			Var.gameOver = true;
		}
		
		if(Var.gameOver)
		{
			Var.startGame = false;
			Var.start = false;
			Meth.drawGameOver(g2D);
			repaint();
		}
		repaint();
	}
}
