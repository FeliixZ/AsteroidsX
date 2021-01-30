package net.feliixz.asteroidsx;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * MouseHandler Class
 */
public class MouseHandler implements MouseListener, MouseMotionListener
{

	public MouseHandler() 
	{
		
	}

	public void mouseDragged(MouseEvent e) 
	{

	}

	public void mouseMoved(MouseEvent e) 
	{
		if(Var.start)
		{
			Var.mouseX = e.getX();
			Var.mouseY = e.getY();
			
			Meth.buttonStatusMoved();
		}
	}

	public void mouseClicked(MouseEvent e) 
	{

	}

	public void mouseEntered(MouseEvent e) 
	{

	}

	public void mouseExited(MouseEvent e) 
	{

	}

	public void mousePressed(MouseEvent e) 
	{
		if(Var.start)
		{
			Var.mouseX = e.getX();
			Var.mouseY = e.getY();
			
			Meth.buttonStatusPressed();
		}
	}

	public void mouseReleased(MouseEvent e) 
	{
		if(Var.start)
		{
			Var.mouseX = e.getX();
			Var.mouseY = e.getY();
			
			Meth.buttonStatusReleased();
		}
	}

}
