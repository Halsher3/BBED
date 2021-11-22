import java.awt.EventQueue;
import java.util.Random;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class FillInTheBlankTest {

	private JFrame frame;
	private JFrame frame_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FillInTheBlankTest window = new FillInTheBlankTest();
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
	public FillInTheBlankTest() {
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
				
				JLabel imageHome = new JLabel("");
				imageHome.setIcon(new ImageIcon(".\\assets\\images\\home.png"));
				imageHome.setBounds(40, 21, 64, 74);
				frame_1.getContentPane().add(imageHome);
				// Placeholder variables to use for Student name and Student grade
				

				
				// Code for the logo in the upper left corner and Astromath text
				
				JLabel astromath = new JLabel("ASTROMATH");
				
				astromath.setIcon(null);
				astromath.setHorizontalAlignment(SwingConstants.CENTER);
				astromath.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
				astromath.setForeground(new Color(255, 255, 255));
				astromath.setBounds(97, 21, 318, 85);
				frame_1.getContentPane().add(astromath);
				
				// Does a hover effect on the AstroMath text with the home button
				
				astromath.addMouseListener(new MouseAdapter() 
				{
					@Override
					public void mouseEntered(MouseEvent e) 
					{
						astromath.setForeground(new Color(0, 195, 255));
					}
					@Override
					public void mouseExited(MouseEvent e) 
					{
						astromath.setForeground(Color.WHITE);
					}
				});
				
				// The Welcome back message given when a student logs in, add in boolean to get rid of "Welcome back," and just leave in the name later
				String studentName = "Jack";
				String grade = "Grade 1";
				
				JLabel name = new JLabel(studentName);
				name.setHorizontalAlignment(SwingConstants.RIGHT);
				name.setForeground(Color.WHITE);
				name.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
				name.setBounds(765, 21, 417, 44);
				frame_1.getContentPane().add(name);
				
				JLabel labelGrade = new JLabel(grade);
				labelGrade.setHorizontalAlignment(SwingConstants.RIGHT);
				labelGrade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
				labelGrade.setForeground(new Color(0, 195, 255));
				labelGrade.setBounds(874, 59, 308, 44);
				frame_1.getContentPane().add(labelGrade);
				
				
				// Logout button
				
				JLabel imageLogout = new JLabel("");
				imageLogout.addMouseListener(new MouseAdapter() 
				{
					@Override
					public void mouseEntered(MouseEvent e) 
					{
						imageLogout.setIcon(new ImageIcon(".\\assets\\images\\logout v2.png"));
					}
					@Override
					public void mouseExited(MouseEvent e) 
					{
						imageLogout.setIcon(new ImageIcon(".\\assets\\images\\logout.png"));
					}
				});
				imageLogout.setIcon(new ImageIcon(".\\assets\\images\\logout.png"));
				imageLogout.setBounds(1192, 15, 72, 91);
				frame_1.getContentPane().add(imageLogout);
				
				JLabel imageSettings = new JLabel("");
				imageSettings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
				imageSettings.setBounds(1188, 99, 64, 64);
				frame_1.getContentPane().add(imageSettings);
				
				//TEST COMPONENTS
				
				JLabel FITBTest = new JLabel("Fill In The Blank Test");
				FITBTest.setHorizontalAlignment(SwingConstants.CENTER);
				FITBTest.setForeground(Color.WHITE);
				FITBTest.setFont(new Font("A-Space Demo", Font.PLAIN, 40));
				FITBTest.setBounds(333, 99, 559, 44);
				frame_1.getContentPane().add(FITBTest);
				

				
				//RANDOM EQUATION MAKER This accesses MultipleChoice.java
				
				FillInTheBlank fitb = new FillInTheBlank(1, 4);
				
				String[] phrase = new String[2];
				
				
				phrase = fitb.generateFITB(1);
				
				
				
				
				//phase[0] is the statement, phrase[1] is the answer

			
				JLabel labelPhrase0 = new JLabel(phrase[0]);
				labelPhrase0.setHorizontalAlignment(SwingConstants.CENTER);
				labelPhrase0.setForeground(new Color(255, 255, 255));
				labelPhrase0.setFont(new Font("A-Space Demo", Font.PLAIN, 30));
				labelPhrase0.setBounds(-50, 215,1400,200);
				frame_1.getContentPane().add(labelPhrase0);
				
				//answer field for fill in the blank
				textField = new JTextField();
				textField.setForeground(Color.WHITE);
				textField.setFont(new Font("A-Space Demo", Font.PLAIN, 70));
				textField.setBounds(438, 425, 442, 177);
				frame_1.getContentPane().add(textField);
				textField.setBackground(new Color(0, 255, 153));

				textField.setColumns(10);
				

				/* testing commented out
				 * JLabel lblNewLabel1 = new JLabel(phrase[1]);
				lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel1.setForeground(new Color(255, 255, 255));
				lblNewLabel1.setFont(new Font("A-Space Demo", Font.PLAIN, 45));
				lblNewLabel1.setBounds(-50, 500,1400,200);
				frame.getContentPane().add(lblNewLabel1);
				*/
			
				
				
	}
}

