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

public class TrueOrFalseTest {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrueOrFalseTest window = new TrueOrFalseTest();
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
	public TrueOrFalseTest() {
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
				
				JLabel imageHome = new JLabel("");
				imageHome.setIcon(new ImageIcon(".\\assets\\images\\home.png"));
				imageHome.setBounds(40, 21, 64, 74);
				frame.getContentPane().add(imageHome);
				// Placeholder variables to use for Student name and Student grade
				

				
				// Code for the logo in the upper left corner and Astromath text
				
				JLabel astromath = new JLabel("ASTROMATH");
				
				astromath.setIcon(null);
				astromath.setHorizontalAlignment(SwingConstants.CENTER);
				astromath.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
				astromath.setForeground(new Color(255, 255, 255));
				astromath.setBounds(97, 21, 318, 85);
				frame.getContentPane().add(astromath);
				
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
				frame.getContentPane().add(name);
				
				JLabel labelGrade = new JLabel(grade);
				labelGrade.setHorizontalAlignment(SwingConstants.RIGHT);
				labelGrade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
				labelGrade.setForeground(new Color(0, 195, 255));
				labelGrade.setBounds(874, 59, 308, 44);
				frame.getContentPane().add(labelGrade);
				
				
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
				frame.getContentPane().add(imageLogout);
				
				JLabel imageSettings = new JLabel("");
				imageSettings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
				imageSettings.setBounds(1188, 99, 64, 64);
				frame.getContentPane().add(imageSettings);
				
				//TEST COMPONENTS
				
				JLabel trueOrFalseTest = new JLabel("True Or False Test");
				trueOrFalseTest.setHorizontalAlignment(SwingConstants.CENTER);
				trueOrFalseTest.setForeground(Color.WHITE);
				trueOrFalseTest.setFont(new Font("A-Space Demo", Font.PLAIN, 40));
				trueOrFalseTest.setBounds(475, 99, 417, 44);
				frame.getContentPane().add(trueOrFalseTest);
				

				
				//RANDOM EQUATION MAKER This accesses MultipleChoice.java
				
				TrueOrFalse tof = new TrueOrFalse(1, 2);
				int numOfQuestions = 2;
				
				String[] phrase = new String[numOfQuestions];
				
				
				phrase = tof.generateToF(1);
				
				
				//EQUATION NUMBERS
				JLabel labelPhrase0 = new JLabel(phrase[0]);
				labelPhrase0.setHorizontalAlignment(SwingConstants.CENTER);
				labelPhrase0.setForeground(new Color(255, 255, 255));
				labelPhrase0.setFont(new Font("A-Space Demo", Font.PLAIN, 45));
				labelPhrase0.setBounds(-50, 266,1400,200);
				frame.getContentPane().add(labelPhrase0);
				

				
				JLabel labelTrue = new JLabel("True");
				labelTrue.setHorizontalAlignment(SwingConstants.CENTER);
				labelTrue.setForeground(new Color(255, 255, 255));
				labelTrue.setFont(new Font("A-Space Demo", Font.PLAIN, 45));
				labelTrue.setBounds(-50, 500,1400,200);
				frame.getContentPane().add(labelTrue);
				
				JLabel labelFalse = new JLabel("False");
				labelFalse.setHorizontalAlignment(SwingConstants.CENTER);
				labelFalse.setForeground(new Color(255, 255, 255));
				labelFalse.setFont(new Font("A-Space Demo", Font.PLAIN, 45));
				labelFalse.setBounds(250, 500,1400,200);
				frame.getContentPane().add(labelFalse);
				
	}

}
