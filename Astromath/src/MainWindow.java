import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow 
{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() 
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
		
		// Placeholder variables to use for Student name and Student grade
		
		String studentName = "Jack";
		String grade = "Kindergarten";
		
		// Code for the logo in the upper left corner and Astromath text
		
		JLabel label_logo = new JLabel("ASTROMATH");
		
		label_logo.setIcon(null);
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
		});
		
		// The Welcome back message given when a student logs in, add in boolean to get rid of "Welcome back," and just leave in the name later
		
		JLabel label_name = new JLabel("Welcome back, " + studentName);
		label_name.setHorizontalAlignment(SwingConstants.RIGHT);
		label_name.setForeground(Color.WHITE);
		label_name.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
		label_name.setBounds(765, 21, 417, 44);
		frame.getContentPane().add(label_name);
		
		// Some of the icons for the planets
		
		JLabel image_ringPlanet = new JLabel("");
		image_ringPlanet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				image_ringPlanet.setIcon(new ImageIcon(".\\assets\\images\\ringed planet v2.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				image_ringPlanet.setIcon(new ImageIcon(".\\assets\\images\\ringed planet.png"));
			}
		});
		image_ringPlanet.setIcon(new ImageIcon(".\\assets\\images\\ringed planet.png"));
		image_ringPlanet.setBounds(64, 389, 318, 224);
		frame.getContentPane().add(image_ringPlanet);
		
		JLabel image_earth = new JLabel("");
		image_earth.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				image_earth.setIcon(new ImageIcon(".\\assets\\images\\earth v2.png"));
			}
			public void mouseExited(MouseEvent e) 
			{
				image_earth.setIcon(new ImageIcon(".\\assets\\images\\earth.png"));
			}
		});
		image_earth.setIcon(new ImageIcon(".\\assets\\images\\earth.png"));
		image_earth.setBounds(924, 117, 254, 224);
		frame.getContentPane().add(image_earth);
		
		JLabel image_redPlanet = new JLabel("");
		image_redPlanet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				image_redPlanet.setIcon(new ImageIcon(".\\assets\\images\\red planet v2.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				image_redPlanet.setIcon(new ImageIcon(".\\assets\\images\\red planet.png"));
			}
		});
		image_redPlanet.setIcon(new ImageIcon(".\\assets\\images\\red planet.png"));
		image_redPlanet.setBounds(900, 389, 224, 224);
		frame.getContentPane().add(image_redPlanet);
		
		// The student's grade level displayed under the welcome back message
		
		JLabel label_grade = new JLabel(grade);
		label_grade.setHorizontalAlignment(SwingConstants.RIGHT);
		label_grade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
		label_grade.setForeground(new Color(0, 195, 255));
		label_grade.setBounds(874, 59, 308, 44);
		frame.getContentPane().add(label_grade);
		
		//More planet images, and images in general
		
		JLabel image_bluePlanet = new JLabel("");
		image_bluePlanet.setIcon(new ImageIcon(".\\assets\\images\\blue planet.png"));
		image_bluePlanet.setBounds(54, 135, 224, 224);
		frame.getContentPane().add(image_bluePlanet);
		
		
		image_bluePlanet.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				image_bluePlanet.setIcon(new ImageIcon(".\\assets\\images\\blue planet v2.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				image_bluePlanet.setIcon(new ImageIcon(".\\assets\\images\\blue planet.png"));
			}
		});
		
		JLabel image_sun = new JLabel("");
		image_sun.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
			}
		});
		image_sun.setIcon(new ImageIcon(".\\assets\\images\\sun.png"));
		image_sun.setBounds(402, 99, 512, 512);
		frame.getContentPane().add(image_sun);
		
		JLabel image_home = new JLabel("");
		image_home.setIcon(new ImageIcon(".\\assets\\images\\home.png"));
		image_home.setBounds(40, 21, 64, 74);
		frame.getContentPane().add(image_home);
		
		// Labels for the planets
		
		JLabel label_grades = new JLabel("Grades");
		label_grades.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
		label_grades.setForeground(Color.WHITE);
		label_grades.setHorizontalAlignment(SwingConstants.CENTER);
		label_grades.setBounds(40, 352, 254, 44);
		frame.getContentPane().add(label_grades);
		
		JLabel label_tests = new JLabel("Tests");
		label_tests.setHorizontalAlignment(SwingConstants.CENTER);
		label_tests.setForeground(Color.WHITE);
		label_tests.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
		label_tests.setBounds(84, 622, 254, 44);
		frame.getContentPane().add(label_tests);
		
		JLabel label_practice = new JLabel("Practice");
		label_practice.setHorizontalAlignment(SwingConstants.CENTER);
		label_practice.setForeground(Color.WHITE);
		label_practice.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
		label_practice.setBounds(913, 334, 254, 44);
		frame.getContentPane().add(label_practice);
		
		JLabel label_profile = new JLabel("Profile");
		label_profile.setHorizontalAlignment(SwingConstants.CENTER);
		label_profile.setForeground(Color.WHITE);
		label_profile.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
		label_profile.setBounds(883, 622, 254, 44);
		frame.getContentPane().add(label_profile);
		
		// Logout button
		
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
		});
		image_logout.setIcon(new ImageIcon(".\\assets\\images\\logout.png"));
		image_logout.setBounds(1192, 15, 72, 91);
		frame.getContentPane().add(image_logout);
		
		JLabel image_settings = new JLabel("");
		image_settings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
		image_settings.setBounds(1188, 99, 64, 64);
		frame.getContentPane().add(image_settings);
	}
}
