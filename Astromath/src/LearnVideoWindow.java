

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;






public class LearnVideoWindow 
{

	private JFrame frame;
	private String videoURL;
	private String topic = "Addition within 20";
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LearnVideoWindow window = new LearnVideoWindow();
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
	public LearnVideoWindow() 
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
		
		JLabel label_pageTitle = new JLabel("" + topic);
		label_pageTitle.setForeground(new Color(0, 195, 255));
		label_pageTitle.setFont(new Font("a Atmospheric", Font.PLAIN, 30));
		label_pageTitle.setBounds(97, 106, 953, 74);
		frame.getContentPane().add(label_pageTitle);
		
		
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(292, 245, 687, 358);
		frame.getContentPane().add(lblNewLabel);
		
		frame.setVisible(true);
	}
}
