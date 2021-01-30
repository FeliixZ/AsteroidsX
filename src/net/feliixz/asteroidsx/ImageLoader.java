package net.feliixz.asteroidsx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * ImageLoader Class
 */
public class ImageLoader 
{

	public ImageLoader() 
	{

	}
	
	public static BufferedImage loadImage(String path)
	{
		BufferedImage picture = null;
		try
		{
		    File file = new File(path);
			picture = ImageIO.read(file);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("Could not load pictures!");
		}
		return picture;
	}
	
}
