import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;

public class TestSelection {

	private JFrame frame;
	private JFrame frame_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestSelection window = new TestSelection();
					window.frame_1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestSelection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Creates the JFrame, and sets the background color and bounds to 1280 x 720 resolution
				frame_1 = new JFrame();
				frame_1.getContentPane().addMouseListener(new MouseAdapter() 
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
				frame_1.getContentPane().setBackground(new Color(77,58,129));
				frame_1.setBounds(100, 100, 1280, 720);
				frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame_1.getContentPane().setLayout(null);
				
				JLabel image_home = new JLabel("");
				image_home.setIcon(new ImageIcon(".\\assets\\images\\home.png"));
				image_home.setBounds(40, 21, 64, 74);
				frame_1.getContentPane().add(image_home);
				// Placeholder variables to use for Student name and Student grade
				
				String studentName = "Jack";
				String grade = "Grade 1";
				
				// Code for the logo in the upper left corner and Astromath text
				
				JLabel label_logo = new JLabel("ASTROMATH");
				
				label_logo.setIcon(null);
				label_logo.setHorizontalAlignment(SwingConstants.CENTER);
				label_logo.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
				label_logo.setForeground(new Color(255, 255, 255));
				label_logo.setBounds(97, 21, 318, 85);
				frame_1.getContentPane().add(label_logo);
				
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
				frame_1.getContentPane().add(label_name);
				
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
				frame_1.getContentPane().add(image_logout);
				
				JLabel image_settings = new JLabel("");
				image_settings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
				image_settings.setBounds(1188, 99, 64, 64);
				frame_1.getContentPane().add(image_settings);
				
				//Test Selection options
				
				JLabel label_name_1 = new JLabel("Grade 1 Tests");
				label_name_1.setHorizontalAlignment(SwingConstants.CENTER);
				label_name_1.setForeground(Color.WHITE);
				label_name_1.setFont(new Font("A-Space Demo", Font.PLAIN, 40));
				label_name_1.setBounds(475, 99, 417, 44);
				frame_1.getContentPane().add(label_name_1);
				
				JLabel label_name_1_1 = new JLabel("Addition Test (Numbers within 20)");
				label_name_1_1.setBackground(new Color(0, 0, 153));
				label_name_1_1.setHorizontalAlignment(SwingConstants.CENTER);
				label_name_1_1.setForeground(Color.WHITE);
				label_name_1_1.setFont(new Font("A-Space Demo", Font.PLAIN, 40));
				label_name_1_1.setBounds(189, 171, 925, 44);
				frame_1.getContentPane().add(label_name_1_1);
				
				label_name_1_1.addMouseListener(new MouseAdapter() 
				{
					@Override
					public void mouseEntered(MouseEvent e) 
					{
						label_name_1_1.setForeground(new Color(0, 195, 255));
					}
					@Override
					public void mouseExited(MouseEvent e) 
					{
						label_name_1_1.setForeground(Color.WHITE);
					}
				});
				
				JEditorPane editorPane = new JEditorPane();
				editorPane.setBackground(new Color(23, 38, 83));
				editorPane.setBounds(175, 153, 953, 74);
				frame_1.getContentPane().add(editorPane);
				
				JLabel lblSubtractionTestnumbers = new JLabel("Subtraction Test (Numbers within 20)");
				lblSubtractionTestnumbers.setHorizontalAlignment(SwingConstants.CENTER);
				lblSubtractionTestnumbers.setForeground(Color.WHITE);
				lblSubtractionTestnumbers.setFont(new Font("A-Space Demo", Font.PLAIN, 38));
				lblSubtractionTestnumbers.setBackground(new Color(0, 0, 153));
				lblSubtractionTestnumbers.setBounds(189, 263, 925, 44);
				frame_1.getContentPane().add(lblSubtractionTestnumbers);
				
				lblSubtractionTestnumbers.addMouseListener(new MouseAdapter() 
				{
					@Override
					public void mouseEntered(MouseEvent e) 
					{
						lblSubtractionTestnumbers.setForeground(new Color(0, 195, 255));
					}
					@Override
					public void mouseExited(MouseEvent e) 
					{
						lblSubtractionTestnumbers.setForeground(Color.WHITE);
					}
				});
				
				JEditorPane editorPane_1 = new JEditorPane();
				editorPane_1.setBackground(new Color(23, 38, 83));
				editorPane_1.setBounds(175, 246, 953, 74);
				frame_1.getContentPane().add(editorPane_1);
				
				JLabel label_name_1_1_1_1 = new JLabel("Measuremnt & Data Test");
				label_name_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
				label_name_1_1_1_1.setForeground(Color.WHITE);
				label_name_1_1_1_1.setFont(new Font("A-Space Demo", Font.PLAIN, 40));
				label_name_1_1_1_1.setBackground(new Color(0, 0, 153));
				label_name_1_1_1_1.setBounds(189, 354, 925, 44);
				frame_1.getContentPane().add(label_name_1_1_1_1);
				
				label_name_1_1_1_1.addMouseListener(new MouseAdapter() 
				{
					@Override
					public void mouseEntered(MouseEvent e) 
					{
						label_name_1_1_1_1.setForeground(new Color(0, 195, 255));
					}
					@Override
					public void mouseExited(MouseEvent e) 
					{
						label_name_1_1_1_1.setForeground(Color.WHITE);
					}
				});
				
				JEditorPane editorPane_2 = new JEditorPane();
				editorPane_2.setBackground(new Color(23, 38, 83));
				editorPane_2.setBounds(175, 343, 953, 74);
				frame_1.getContentPane().add(editorPane_2);
				
				JLabel label_name_1_1_1_2 = new JLabel("Place Value Test");
				label_name_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
				label_name_1_1_1_2.setForeground(Color.WHITE);
				label_name_1_1_1_2.setFont(new Font("A-Space Demo", Font.PLAIN, 38));
				label_name_1_1_1_2.setBackground(new Color(0, 0, 153));
				label_name_1_1_1_2.setBounds(189, 456, 925, 44);
				frame_1.getContentPane().add(label_name_1_1_1_2);
				
				label_name_1_1_1_2.addMouseListener(new MouseAdapter() 
				{
					@Override
					public void mouseEntered(MouseEvent e) 
					{
						label_name_1_1_1_2.setForeground(new Color(0, 195, 255));
					}
					@Override
					public void mouseExited(MouseEvent e) 
					{
						label_name_1_1_1_2.setForeground(Color.WHITE);
					}
				});
				
				JEditorPane editorPane_2_1 = new JEditorPane();
				editorPane_2_1.setBackground(new Color(23, 38, 83));
				editorPane_2_1.setBounds(175, 439, 953, 74);
				frame_1.getContentPane().add(editorPane_2_1);
				

				
	}
}
