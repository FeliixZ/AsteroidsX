package net.feliixz.asteroidsx;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Method Class
 */
public class Meth 
{	
	public Meth() 
	{
		
	}
	
	/**
	 * Draws the space ship.
	 * @param g2D Graphics2D
	 */
	public static void createPlayer(Graphics2D g2D)
	{
		g2D.drawImage(Var.spaceShip1, Var.spaceShipPosX, Var.spaceShipPosY, Var.spaceShipWidth, Var.spaceShipHeight, null);
	}
	
	/**
	 * Draws the asteroids.
	 * @param g2D Graphics2D
	 */
	public static void createAsteroids(Graphics2D g2D)
	{
		for(int i = 0; i < Var.asteroidsPosX.length; i++)
		{
			g2D.drawImage(Var.asteroid1, Var.asteroidsPosX[i], Var.asteroidsPosY[i], Var.asteroidsWidth, Var.asteroidsHeight, null);
		}
	}
	/**
	 * Draws the hearts.
	 * @param g2D Graphics2D
	 */
	public static void createHealth(Graphics2D g2D)
	{
		for(int h = 0; h < Var.healthPosX.length; h++)
		{
			g2D.drawImage(Var.health1, Var.healthPosX[h], Var.healthPosY[h], Var.healthWidth, Var.healthHeight, null);
		}
	}
	/**
	 * Draws the fuel.
	 * @param g2D Graphics2D
	 */
	public static void createFuel(Graphics2D g2D)
	{
		for(int f = 0; f < Var.fuelPosX.length; f++)
		{
			g2D.drawImage(Var.fuel1, Var.fuelPosX[f], Var.fuelPosY[f], Var.fuelWidth, Var.fuelHeight, null);
		}
	}
	
	/**
	 * Moves the space ship.
	 */
	public static void createPlayerMovement()
	{
		if(Var.spaceShipUp)
		{
			Var.spaceShipPosY -= Var.spaceShipSpeed;
		}
		if(Var.spaceShipDown)
		{
			Var.spaceShipPosY += Var.spaceShipSpeed;
		}
		if(Var.spaceShipLeft)
		{
			Var.spaceShipPosX -= Var.spaceShipSpeed;
		}
		if(Var.spaceShipRight)
		{
			Var.spaceShipPosX += Var.spaceShipSpeed;
		}
	}
	
	/**
	 * Spawns random asteroids on the screen.
	 */
	public static void addRandomAsteroids()
	{
		for(int i = 0; i < Var.asteroidsPosX.length; i++)
		{
			Var.asteroidsPosX[i] = Var.random.nextInt(Var.displayWidth-Var.asteroidsWidth/2+1)-Var.asteroidsWidth/2;
			Var.asteroidsPosY[i] = Var.random.nextInt(Var.displayHeight-Var.asteroidsHeight/2+1)-Var.asteroidsHeight/2;
			Var.asteroidsPosX[i] += Var.displayWidth;
		}
	}
	
	/**
	 * Deletes the asteroids by contact.
	 */
	public static void removeAsteroids()
	{
		for(int i = 0; i < Var.asteroidsPosX.length; i++)
		{
			if(Meth.collision(Var.spaceShipPosX, Var.spaceShipPosY, Var.asteroidsPosX[i], Var.asteroidsPosY[i], Var.asteroidsWidth, Var.asteroidsHeight) ||
			   Meth.collision(Var.spaceShipPosX+Var.spaceShipWidth, Var.spaceShipPosY+Var.spaceShipHeight, Var.asteroidsPosX[i], Var.asteroidsPosY[i], Var.asteroidsWidth, Var.asteroidsHeight) ||
			   Meth.collision(Var.spaceShipPosX+Var.spaceShipWidth/2, Var.spaceShipPosY+Var.spaceShipHeight/2, Var.asteroidsPosX[i], Var.asteroidsPosY[i], Var.asteroidsWidth, Var.asteroidsHeight) ||
			   Meth.collision(Var.spaceShipPosX+Var.spaceShipWidth, Var.spaceShipPosY, Var.asteroidsPosX[i], Var.asteroidsPosY[i], Var.asteroidsWidth, Var.asteroidsHeight) ||
			   Meth.collision(Var.spaceShipPosX, Var.spaceShipPosY+Var.spaceShipHeight, Var.asteroidsPosX[i], Var.asteroidsPosY[i], Var.asteroidsWidth, Var.asteroidsHeight))
			{
				Var.asteroidsPosX[i] = Var.random.nextInt(Var.displayWidth-Var.asteroidsWidth/2+1)-Var.asteroidsWidth/2;
				Var.asteroidsPosY[i] = Var.random.nextInt(Var.displayHeight-Var.asteroidsHeight/2+1)-Var.asteroidsHeight/2;
				Var.asteroidsPosX[i] += Var.displayWidth;
				Var.health-=20;
			}
		}
	}
	/**
	 * Moves the asteroids for a infinity duration time.
	 */
	public static void addAsteroidsLoop()
	{
		for(int i = 0; i < Var.asteroidsPosX.length; i++)
		{
			Var.asteroidsPosX[i] -= Var.asteroidsSpeed;
			
			if(Var.asteroidsPosX[i] == 0 - Var.asteroidsWidth)
			{
				Var.asteroidsDisappear[i] = true;
			}
			
			if(Var.asteroidsDisappear[i])
			{
				Var.asteroidsPosX[i] = Var.displayWidth;
			}
			
			Var.asteroidsDisappear[i] = false;
		}
	}
	/**
	 * Spawns random hearts on the screen.
	 */
	public static void addRandomHealth()
	{
		for(int i = 0; i < Var.healthPosX.length; i++)
		{
			Var.healthPosX[i] = Var.random.nextInt(Var.displayWidth-Var.healthWidth/2+1)-Var.healthWidth/2;
			Var.healthPosY[i] = Var.random.nextInt(Var.displayHeight-Var.healthHeight/2+1)-Var.healthHeight/2;
			Var.healthPosX[i] += Var.displayWidth;
		}
	}
	
	/**
	 * Deletes the hearts by contact.
	 */
	public static void removeHealth()
	{
		for(int i = 0; i < Var.healthPosX.length; i++)
		{
			if(Meth.collision(Var.spaceShipPosX, Var.spaceShipPosY, Var.healthPosX[i], Var.healthPosY[i], Var.healthWidth, Var.healthHeight) ||
			   Meth.collision(Var.spaceShipPosX+Var.spaceShipWidth, Var.spaceShipPosY+Var.spaceShipHeight, Var.healthPosX[i], Var.healthPosY[i], Var.healthWidth, Var.healthHeight) ||
			   Meth.collision(Var.spaceShipPosX+Var.spaceShipWidth/2, Var.spaceShipPosY+Var.spaceShipHeight/2, Var.healthPosX[i], Var.healthPosY[i], Var.healthWidth, Var.healthHeight) ||
			   Meth.collision(Var.spaceShipPosX+Var.spaceShipWidth, Var.spaceShipPosY, Var.healthPosX[i], Var.healthPosY[i], Var.healthWidth, Var.healthHeight) ||
			   Meth.collision(Var.spaceShipPosX, Var.spaceShipPosY+Var.spaceShipHeight, Var.healthPosX[i], Var.healthPosY[i], Var.healthWidth, Var.healthHeight))
			{
				Var.healthPosX[i] = Var.random.nextInt(Var.displayWidth-Var.healthWidth/2+1)-Var.healthWidth/2;
				Var.healthPosY[i] = Var.random.nextInt(Var.displayHeight-Var.healthHeight/2+1)-Var.healthHeight/2;
				Var.healthPosX[i] += Var.displayWidth;
				if(Var.health < 100)
				{
					Var.health += 20;
				}
			}
		}
	}
	/**
	 * Moves the hearts for a infinity duration time.
	 */
	public static void addHealthLoop()
	{
		for(int i = 0; i < Var.healthPosX.length; i++)
		{
			Var.healthPosX[i] -= Var.healthSpeed;
			
			if(Var.healthPosX[i] == 0 - Var.healthWidth)
			{
				Var.healthDisappear[i] = true;
			}
			
			if(Var.healthDisappear[i])
			{
				Var.healthPosX[i] = Var.displayWidth;
			}
			
			Var.healthDisappear[i] = false;
		}
	}
	/**
	 * Spawns random fuel on the screen.
	 */
	public static void addRandomFuel()
	{
		for(int i = 0; i < Var.fuelPosX.length; i++)
		{
			Var.fuelPosX[i] = Var.random.nextInt(Var.displayWidth-Var.fuelWidth/2+1)-Var.fuelWidth/2;
			Var.fuelPosY[i] = Var.random.nextInt(Var.displayHeight-Var.fuelHeight/2+1)-Var.fuelHeight/2;
			Var.fuelPosX[i] += Var.displayWidth;
		}
	}
	
	/**
	 * Deletes the fuel by contact.
	 */
	public static void removeFuel()
	{
		for(int i = 0; i < Var.fuelPosX.length; i++)
		{
			if(Meth.collision(Var.spaceShipPosX, Var.spaceShipPosY, Var.fuelPosX[i], Var.fuelPosY[i], Var.fuelWidth, Var.fuelHeight) ||
			   Meth.collision(Var.spaceShipPosX+Var.spaceShipWidth, Var.spaceShipPosY+Var.spaceShipHeight, Var.fuelPosX[i], Var.fuelPosY[i], Var.fuelWidth, Var.fuelHeight) ||
			   Meth.collision(Var.spaceShipPosX+Var.spaceShipWidth/2, Var.spaceShipPosY+Var.spaceShipHeight/2, Var.fuelPosX[i], Var.fuelPosY[i], Var.fuelWidth, Var.fuelHeight) ||
			   Meth.collision(Var.spaceShipPosX+Var.spaceShipWidth, Var.spaceShipPosY, Var.fuelPosX[i], Var.fuelPosY[i], Var.fuelWidth, Var.fuelHeight) ||
			   Meth.collision(Var.spaceShipPosX, Var.spaceShipPosY+Var.spaceShipHeight, Var.fuelPosX[i], Var.fuelPosY[i], Var.fuelWidth, Var.fuelHeight))
			{
				Var.fuelPosX[i] = Var.random.nextInt(Var.displayWidth-Var.fuelWidth/2+1)-Var.fuelWidth/2;
				Var.fuelPosY[i] = Var.random.nextInt(Var.displayHeight-Var.fuelHeight/2+1)-Var.fuelHeight/2;
				Var.fuelPosX[i] += Var.displayWidth;
				if(Var.fuel < 1000)
				{
					Var.fuel += 50;
				}
			}
		}
	}
	/**
	 * Removes fuel in a certain time.
	 */
	public static void removeFuelOverTime()
	{
		int count = 0;
		int maxCount = 100;
		
		for(int i = 0; i < maxCount; i++)
		{
			count++;
			
			if(count == maxCount)
			{
				Var.fuel -= 0.125;
				count = 0;
			}
		}
	}
	/**
	 * Moves the fuel for a infinity duration time.
	 */
	public static void addFuelLoop()
	{
		for(int i = 0; i < Var.fuelPosX.length; i++)
		{
			Var.fuelPosX[i] -= Var.fuelSpeed;
			
			if(Var.fuelPosX[i] == 0 - Var.fuelWidth)
			{
				Var.fuelDisappear[i] = true;
			}
			
			if(Var.fuelDisappear[i])
			{
				Var.fuelPosX[i] = Var.displayWidth;
			}
			
			Var.fuelDisappear[i] = false;
		}
	}
	/**
	 * Detects a collision (only for rectangle shaped figures).
	 * @param curPosX Current horizontal position of the object
	 * @param curPosY Current vertical position of the object
	 * @param objPosX Fixed horizontal position of the object
	 * @param objPosY Fixed vertical position of the object
	 * @param objWidth Width of the object
	 * @param objHeight Height of the object
	 * @return if the collision is true or false
	 */
	public static boolean collision(int curPosX, int curPosY, int objPosX, int objPosY, int objWidth, int objHeight)
	{
		return curPosX >= objPosX && curPosX <= (objPosX + objWidth) && curPosY >= objPosY && curPosY <= (objPosY + objHeight);
	}
	
	/**
	 * Checks the collision with the player.
	 * @param collision collision boolean
	 * @return the collision
	 */
	public static void addPlayerCollision()
	{
		if(Var.spaceShipPosX <= 0)
		{
			Var.spaceShipPosX = 0;
		}
		if(Var.spaceShipPosY <= 0)
		{
			Var.spaceShipPosY = 0;
		}
		if(Var.spaceShipPosX >= Var.displayWidth-Var.spaceShipWidth)
		{
			Var.spaceShipPosX = Var.displayWidth-Var.spaceShipWidth;
		}
		if(Var.spaceShipPosY >= Var.displayHeight-Var.spaceShipHeight)
		{
			Var.spaceShipPosY = Var.displayHeight-Var.spaceShipHeight;
		}
		
	}
	
	/**
	 * Adds the score with different speed.
	 */
	public static void addScore()
	{
		Var.score += Var.scoreSpeed;
	}
	
	/**
	 * Draws the score of the game.
	 * @param g2D Graphics2D
	 */
	public static void drawScore(Graphics2D g2D)
	{
		g2D.setColor(Color.WHITE);
		g2D.setFont(Var.gameFont);
		g2D.drawString("Score: "+Var.score, 0, 40);
	}
	
	/**
	 * Adds the fuel to the game.
	 */
	public static void addFuel()
	{
		if(Var.fuel > 0)
		{
			if(Var.spaceShipUp)
			{
				Var.fuel-=0.25;
			}
		}
		else
		{
			Var.fuelStatus = false;
		}
		if(Var.fuel > 0)
		{
			if(Var.spaceShipDown)
			{
				Var.fuel-=0.25;
			}
		}
		else
		{
			Var.fuelStatus = false;
		}
		if(Var.fuel > 0)
		{
			if(Var.spaceShipLeft)
			{
				Var.fuel-=0.25;
			}
		}
		else
		{
			Var.fuelStatus = false;
		}
		if(Var.fuel > 0)
		{
			if(Var.spaceShipRight)
			{
				Var.fuel-=0.25;
			}
		}
		else
		{
			Var.fuelStatus = false;
		}
		if(Var.fuel <= 0)
		{
			Var.spaceShipSpeed = 0;
		}
		if(Var.fuel > 0)
		{
			Var.spaceShipSpeed = 5;
		}
	}
	/**
	 * Draws the fuel.
	 * @param g2D Graphics2D
	 */
	public static void drawFuel(Graphics2D g2D)
	{
		g2D.setColor(Color.WHITE);
		g2D.setFont(Var.gameFont);
		g2D.drawString("Fuel: "+(int)Var.fuel, 350, 40);
		
		g2D.setColor(Color.YELLOW);
		g2D.fillRect(650, 10, (int)Var.fuel/2, 30);
		g2D.drawRect(650, 10, Var.fuelLength, 30);
	}
	/**
	 * Draws the health.
	 * @param g2D Graphics2D
	 */
	public static void drawHealth(Graphics2D g2D)
	{
		g2D.setColor(Color.WHITE);
		g2D.setFont(Var.gameFont);
		g2D.drawString("Health: "+Var.health, 350, 80);
		
		g2D.setColor(Color.RED);
		g2D.fillRect(650, 50, Var.health*5, 30);
		g2D.drawRect(650, 50, Var.healthLength, 30);
	}
	/**
	 * Draws the game menu.
	 * @param g2D Graphics2D
	 */
	public static void drawMenu(Graphics2D g2D)
	{
		g2D.setColor(Color.BLACK);
		g2D.fillRect(0, 0, Var.displayWidth, Var.displayHeight);
		g2D.setColor(Color.WHITE);
		g2D.setStroke(Var.stroke);
		//ASTEROIDSX
		g2D.setFont(Var.titleFont);
		g2D.drawString("ASTEROIDSX", Var.displayWidth/2-425, Var.displayHeight/5);
		//START-BUTTON
		g2D.setColor(Var.buttonColor[Var.buttonStartStatus]);
		g2D.drawRect(Var.buttonStartPosX, Var.buttonStartPosY, Var.buttonWidth, Var.buttonHeight);
		g2D.setFont(Var.menuFont);
		g2D.drawString("START", Var.displayWidth/2-150, Var.displayHeight/2-100);
		//EXIT-BUTTON
		g2D.setColor(Var.buttonColor[Var.buttonExitStatus]);
		g2D.drawRect(Var.buttonExitPosX, Var.buttonExitPosY, Var.buttonWidth, Var.buttonHeight);
		g2D.drawString("EXIT", Var.displayWidth/2-120, Var.displayHeight/2+200);
	}
	
	/**
	 * Creates the button status for mouseMoved method.
	 */
	public static void buttonStatusMoved()
	{
		if(Meth.collision(Var.mouseX, Var.mouseY, Var.buttonStartPosX, Var.buttonStartPosY, Var.buttonWidth, Var.buttonHeight))
		{
			Var.buttonStartStatus = Var.BUTTON_OVER;
		}
		else
		{
			Var.buttonStartStatus = Var.BUTTON_NONE;
		}
		if(Meth.collision(Var.mouseX, Var.mouseY, Var.buttonExitPosX, Var.buttonExitPosY, Var.buttonWidth, Var.buttonHeight))
		{
			Var.buttonExitStatus = Var.BUTTON_OVER;
		}
		else
		{
			Var.buttonExitStatus = Var.BUTTON_NONE;
		}
	}
	
	/**
	 * Creates the button status for mousePressed method.
	 */
	public static void buttonStatusPressed()
	{
		if(Meth.collision(Var.mouseX, Var.mouseY, Var.buttonStartPosX, Var.buttonStartPosY, Var.buttonWidth, Var.buttonHeight))
		{
			Var.buttonStartStatus = Var.BUTTON_PRESSED;
			Var.startGame = true;
			Var.start = false;
		}
		
		if(Meth.collision(Var.mouseX, Var.mouseY, Var.buttonExitPosX, Var.buttonExitPosY, Var.buttonWidth, Var.buttonHeight))
		{
			Var.buttonExitStatus = Var.BUTTON_PRESSED;
			Var.exit = true;
		}
	}
	
	/**
	 * Creates the button status for mouseReleased method.
	 */
	public static void buttonStatusReleased()
	{
		if(Meth.collision(Var.mouseX, Var.mouseY, Var.buttonStartPosX, Var.buttonStartPosY, Var.buttonWidth, Var.buttonHeight))
		{
			Var.buttonStartStatus = Var.BUTTON_OVER;
		}
		
		if(Meth.collision(Var.mouseX, Var.mouseY, Var.buttonExitPosX, Var.buttonExitPosY, Var.buttonWidth, Var.buttonHeight))
		{
			Var.buttonExitStatus = Var.BUTTON_OVER;
		}
	}
	
	/**
	 * Draws the Game Over Menu.
	 * @param g2D Graphics2D
	 */
	public static void drawGameOver(Graphics2D g2D) 
	{
		g2D.setColor(Color.BLACK);
		g2D.fillRect(0, 0, Var.displayWidth, Var.displayHeight);
		g2D.setColor(Color.WHITE);
		g2D.setFont(Var.menuFont);
		g2D.drawString("GAME OVER", Var.displayWidth/2-275, Var.displayHeight/2-100);
		g2D.drawString("SCORE: "+Var.score, Var.displayWidth/2-275, Var.displayHeight/2);
	}
	
	/**
	 * Draws the shot.
	 * @param g2D Graphics2D
	 */
	public static void drawShot(Graphics2D g2D)
	{
		g2D.setColor(Color.RED);
	    for (int i = 0; i < Var.shotBool.length; i++) 
	    {
	        if (Var.shotBool[i]) 
	        {
	           g2D.drawImage(Var.shot1, Var.shotX[i]-Var.shotWidth/2, Var.shotY[i]-Var.shotHeight/2, Var.shotWidth, Var.shotHeight, null);
	        }
	    }
	}
	
	/**
	 * Adds a shot.
	 */
	public static void addShot()
	{
		for (int i = 0; i < Var.shotBool.length; i++) 
		{
			if (!Var.shotBool[i])
			{
				Var.shotX[i] = Var.spaceShipPosX+Var.spaceShipWidth;
				Var.shotY[i] = Var.spaceShipPosY+Var.spaceShipHeight/2;
				Var.shotBool[i] = true;
				break;
			}
	    }
	}
	
	/**
	 * Moves the shot.
	 */
	public static void shoot()
	{
	    for (int i = 0; i < Var.shotBool.length; i++) 
	    {
	    	if (Var.shotBool[i])
	    	{
	    		Var.shotX[i] += Var.shotSpeed;
	    		
	            if (Var.shotX[i] > Var.displayWidth) 
	            {
	                removeShot(i);
	            }
	    	}
	    }
	}
	
	/**
	 * Deletes the shot.
	 * @param arrayIndex boolean index
	 */
	public static void removeShot(int arrayIndex)
	{
		Var.shotBool[arrayIndex] = false;
	}
	
	/**
	 * Detects the shot collision.
	 */
	public static void shotCollision()
	{
		for(int i = 0; i < Var.asteroidsPosX.length; i++)
		{
			for(int j = 0; j < Var.shotX.length; j++)
			{
				if(Meth.collision(Var.shotX[j]+Var.shotWidth, Var.shotY[j]+Var.shotHeight/2, Var.asteroidsPosX[i], Var.asteroidsPosY[i], Var.asteroidsWidth, Var.asteroidsHeight))
				{
					removeShot(j);
					Var.asteroidsPosX[i] = Var.random.nextInt(Var.displayWidth-Var.asteroidsWidth/2+1)-Var.asteroidsWidth/2;
					Var.asteroidsPosY[i] = Var.random.nextInt(Var.displayHeight-Var.asteroidsHeight/2+1)-Var.asteroidsHeight/2;
					Var.asteroidsPosX[i] += Var.displayWidth;
				}
			}
		}
	}

}
