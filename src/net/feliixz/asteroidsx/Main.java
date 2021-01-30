package net.feliixz.asteroidsx;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Main Class
 */
public class Main extends JFrame 
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @param args Main Method
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Main frame = new Main();
					frame.setVisible(true);
					new ImageLoader();
					new Meth();
					new Var();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() 
	{
		setTitle("AsteroidsX");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Var.displayWidth, Var.displayHeight);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
		setUndecorated(true);
		setExtendedState(MAXIMIZED_BOTH);
		setIconImage(ImageLoader.loadImage("rsc/AsteroidsX_Icon.png"));
		
		GamePanel gamePanel = new GamePanel();
		contentPane.add(gamePanel, BorderLayout.CENTER);
	}

}
