package net.feliixz.asteroidsx;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.Timer;

/**
 * Variable Class
 */
public class Var 
{

	public Var() 
	{
		spaceShip1 = ImageLoader.loadImage("rsc/SpaceShip_1.png");
		//spaceShip2 = ImageLoader.loadImage("");
		//spaceShip3 = ImageLoader.loadImage("");
		
		asteroid1 = ImageLoader.loadImage("rsc/Asteroid_1.png");
		//asteroid2 = ImageLoader.loadImage("");
		//asteroid3 = ImageLoader.loadImage("");
		
		health1 = ImageLoader.loadImage("rsc/Health_1.png");
		
		fuel1 = ImageLoader.loadImage("rsc/Fuel_1.png");
		
		shot1 = ImageLoader.loadImage("rsc/Shot_1.png");
	}
	
	public static BufferedImage spaceShip1;
	public static BufferedImage spaceShip2;
	public static BufferedImage spaceShip3;
	public static BufferedImage asteroid1;
	public static BufferedImage asteroid2;
	public static BufferedImage asteroid3;
	public static BufferedImage health1;
	public static BufferedImage fuel1;
	public static BufferedImage shot1;
	
	public static Timer timer;
	public static Random random = new Random();
	public static Font gameFont = new Font("",Font.BOLD,50);
	public static Font menuFont = new Font("Courier",Font.PLAIN,100);
	public static Font titleFont = new Font("Courier",Font.PLAIN,150);
	public static Stroke stroke = new BasicStroke(3);
	public static final int displayWidth = 1920;
	public static final int displayHeight = 1080;
	public static int mouseX;
	public static int mouseY;
	public static int spaceShipWidth = 100;
	public static int spaceShipHeight = 100;
	public static int spaceShipPosX = 0;
	public static int spaceShipPosY = Var.displayHeight/2-Var.spaceShipHeight/2;
	public static int spaceShipSpeed = 5;
	public static int asteroidsSpeed = 1;
	public static int healthSpeed = 1;
	public static int fuelSpeed = 1;
	public static boolean spaceShipUp = false;
	public static boolean spaceShipDown = false;
	public static boolean spaceShipLeft = false;
	public static boolean spaceShipRight = false;
	public static int arrayIndexAsteroids = 25;
	public static int arrayIndexHealth = 5;
	public static int arrayIndexFuel = 10;
	public static int arrayIndexShot = 2;
	public static int[] asteroidsPosX = new int[arrayIndexAsteroids];
	public static int[] asteroidsPosY = new int[arrayIndexAsteroids];
	public static int[] healthPosX = new int[arrayIndexHealth];
	public static int[] healthPosY = new int[arrayIndexHealth];
	public static int[] fuelPosX = new int[arrayIndexFuel];
	public static int[] fuelPosY = new int[arrayIndexFuel];
	public static boolean[] shotBool = new boolean[arrayIndexShot];
	public static int asteroidsWidth = 125;
	public static int asteroidsHeight = 125;
	public static int healthWidth = 75;
	public static int healthHeight = 75;
	public static int fuelWidth = 75;
	public static int fuelHeight = 75;
	public static int shotWidth = 40;
	public static int shotHeight = 5;
	public static int[] shotX = new int[arrayIndexShot];
	public static int[] shotY = new int[arrayIndexShot];
	public static boolean[] asteroidsDisappear = new boolean[arrayIndexAsteroids];
	public static boolean[] healthDisappear = new boolean[arrayIndexHealth];
	public static boolean[] fuelDisappear = new boolean[arrayIndexFuel];
	public static boolean shot = false;
	public static long score = 0;
	public static int scoreSpeed = 5;
	public static int shotSpeed = 10;
	public static boolean shotCollision = false;
	public static boolean start = true;			//If you run the application (game)
	public static boolean startGame = false;	//If you press the START button
	public static boolean exit = false;			//If you press the EXIT button
	public static boolean gameOver = false;
	public static final int BUTTON_NONE = 0;
	public static final int BUTTON_OVER = 1;
	public static final int BUTTON_PRESSED = 2;
	public static int buttonStartStatus = BUTTON_NONE;
	public static int buttonExitStatus = BUTTON_NONE;
	public static Color[] buttonColor = {Color.WHITE, Color.RED, Color.ORANGE};
	public static int buttonWidth = 325;
	public static int buttonHeight = 150;
	public static int buttonStartPosX = Var.displayWidth/2-Var.buttonWidth/2;
	public static int buttonStartPosY = Var.displayHeight/2-125-Var.buttonHeight/2;
	public static int buttonExitPosX = Var.displayWidth/2-Var.buttonWidth/2;
	public static int buttonExitPosY = Var.displayHeight/2+175-Var.buttonHeight/2;
	public static int health = 100;
	public static int healthLength = 500;
	public static double fuel = 1000;
	public static int fuelLength = 500;
	public static boolean fuelStatus = true;
	public static boolean spaceShipCollision = false;

}
