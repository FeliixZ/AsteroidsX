package net.feliixz.asteroidsx;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * AnimationHandler Class
 */
public class ActionHandler implements ActionListener
{
	public ActionHandler() 
	{
		
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(Var.startGame)
		{
			if(Var.shot)
			{
				Meth.addShot();
			}
			Meth.createPlayerMovement();
			Meth.addAsteroidsLoop();
			Meth.addHealthLoop();
			Meth.addFuelLoop();
			Meth.addScore();
			Meth.addFuel();
			Meth.removeFuelOverTime();
			Meth.shoot();
			Meth.addPlayerCollision();
			Meth.shotCollision();
			Meth.removeAsteroids();
			Meth.removeHealth();
			Meth.removeFuel();
		}
	}
}
