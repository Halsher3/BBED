

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PracticeSelectWindow 
{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PracticeSelectWindow window = new PracticeSelectWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PracticeSelectWindow() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		// Creates the JFrame, and sets the background color and bounds to 1280 x 720 resolution
		frame = new JFrame();
		frame.getContentPane().addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				//Toolkit tools = frame.getToolkit();
				//Image rocket = tools.getImage("C:\\Users\\Ru\\Desktop\\Project\\home.png");
				//Point hotspot = new Point(0,0);
				//frame.setCursor(tools.createCustomCursor(rocket, hotspot, "idk"));
				
			}
		});
		frame.getContentPane().setBackground(new Color(77,58,129));
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		// Code for the logo in the upper left corner and Astromath text
		
		JLabel label_logo = new JLabel("ASTROMATH");
		
		label_logo.setHorizontalAlignment(SwingConstants.CENTER);
		label_logo.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
		label_logo.setForeground(new Color(255, 255, 255));
		label_logo.setBounds(97, 21, 318, 85);
		frame.getContentPane().add(label_logo);
		
		// Does a hover effect on the AstroMath text with the home button
		
		label_logo.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				label_logo.setForeground(new Color(0, 195, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				label_logo.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				MainWindow home = new MainWindow();
				frame.dispose();
			}
		});
		
		JLabel image_home = new JLabel("");
		image_home.setIcon(new ImageIcon(".\\assets\\images\\home.png"));
		image_home.setBounds(40, 21, 64, 74);
		frame.getContentPane().add(image_home);
		
		JLabel label_learn = new JLabel("Learn");
		label_learn.setHorizontalAlignment(SwingConstants.CENTER);
		label_learn.setForeground(Color.WHITE);
		label_learn.setFont(new Font("A-Space Demo", Font.PLAIN, 45));
		label_learn.setBounds(210, 581, 254, 44);
		frame.getContentPane().add(label_learn);
		
		JLabel label_practice = new JLabel("Practice");
		label_practice.setHorizontalAlignment(SwingConstants.CENTER);
		label_practice.setForeground(Color.WHITE);
		label_practice.setFont(new Font("A-Space Demo", Font.PLAIN, 45));
		label_practice.setBounds(786, 572, 247, 53);
		frame.getContentPane().add(label_practice);
		
		JLabel label_pageTitle = new JLabel("practice");
		label_pageTitle.setForeground(new Color(0, 195, 255));
		label_pageTitle.setFont(new Font("a Atmospheric", Font.PLAIN, 30));
		label_pageTitle.setBounds(97, 106, 318, 74);
		frame.getContentPane().add(label_pageTitle);
		
		JLabel image_learn = new JLabel("");
		image_learn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				image_learn.setIcon(new ImageIcon(".\\Assets\\images\\The Guys v2.png"));
				label_learn.setForeground(new Color(0, 195, 255));
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				image_learn.setIcon(new ImageIcon(".\\Assets\\images\\The Guys.png"));
				label_learn.setForeground(Color.WHITE);
			}
		});
		image_learn.setIcon(new ImageIcon(".\\Assets\\images\\The Guys.png"));
		image_learn.setBounds(86, 117, 480, 480);
		frame.getContentPane().add(image_learn);
		
		JLabel image_practice = new JLabel("");
		image_practice.setIcon(new ImageIcon(".\\Assets\\images\\homework.png"));
		image_practice.setBounds(663, 117, 480, 480);
		frame.getContentPane().add(image_practice);
		
		image_practice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				image_practice.setIcon(new ImageIcon(".\\Assets\\images\\homework v2.png"));
				label_practice.setForeground(new Color(0, 195, 255));
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				image_practice.setIcon(new ImageIcon(".\\assets\\images\\homework.png"));
				label_practice.setForeground(Color.WHITE);
			}
		});
		
		
		JLabel label_name = new JLabel("Goku");
		label_name.setHorizontalAlignment(SwingConstants.RIGHT);
		label_name.setForeground(Color.WHITE);
		label_name.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
		label_name.setBounds(765, 21, 417, 44);
		frame.getContentPane().add(label_name);
		
		 JLabel label_grade = new JLabel("First Grade");
		label_grade.setHorizontalAlignment(SwingConstants.RIGHT);
		label_grade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
		label_grade.setForeground(new Color(0, 195, 255));
		label_grade.setBounds(874, 59, 308, 44);
		frame.getContentPane().add(label_grade);
		
		
		JLabel image_logout = new JLabel("");
		image_logout.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				image_logout.setIcon(new ImageIcon(".\\assets\\images\\logout v2.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				image_logout.setIcon(new ImageIcon(".\\assets\\images\\logout.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Visual vis = new Visual();
				frame.dispose();
			}
		});
		image_logout.setIcon(new ImageIcon(".\\assets\\images\\logout.png"));
		image_logout.setBounds(1192, 15, 72, 91);
		frame.getContentPane().add(image_logout);
		
		JLabel image_settings = new JLabel("");
		image_settings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
		image_settings.setBounds(1188, 99, 64, 64);
		frame.getContentPane().add(image_settings);
		
		frame.setVisible(true);
	}
}
