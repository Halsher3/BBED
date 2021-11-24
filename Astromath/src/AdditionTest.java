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
import javax.swing.JButton;

public class AdditionTest {

	private JFrame frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdditionTest window = new AdditionTest();
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
	public AdditionTest() {
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
				imageSettings.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						AccountSettings as = new AccountSettings();
						frame.dispose();
					}
				});
				imageSettings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
				imageSettings.setBounds(1188, 99, 64, 64);
				frame.getContentPane().add(imageSettings);
				
				//TEST COMPONENTS
				
				JLabel additionTest = new JLabel("Addition Test");
				additionTest.setHorizontalAlignment(SwingConstants.CENTER);
				additionTest.setForeground(Color.WHITE);
				additionTest.setFont(new Font("A-Space Demo", Font.PLAIN, 40));
				additionTest.setBounds(475, 99, 417, 44);
				frame.getContentPane().add(additionTest);
				

				
				//RANDOM EQUATION MAKER This accesses MultipleChoice.java
				
				MultipleChoice mp = new MultipleChoice(1, 4);
				
				int[] equation = new int[4];
				
				
				equation = mp.generateAddSub(20, 1, 5);
				
				
				
				int difficulty = 1;
				int[] answerKey = new int[4];
				answerKey = MultipleChoice.generateQuestions(equation[3], 4);
				//ANSWER KEY NUMBERS
				String answerKey0 = String.format("%d", answerKey[0]); 
				String answerKey1 = String.format("%d", answerKey[1]); 
				String answerKey2 = String.format("%d", answerKey[2]); 
				String answerKey3 = String.format("%d", answerKey[3]); 
				
				JButton btnNewButton = new JButton(answerKey0);
				btnNewButton.setForeground(Color.WHITE);
				btnNewButton.setFont(new Font("A-Space Demo", Font.PLAIN, 70));
				btnNewButton.setBounds(123, 439, 169, 157);
				btnNewButton.setBackground(new Color(0, 255, 153));
				frame.getContentPane().add(btnNewButton);
				
				JButton btnNewButton_1 = new JButton(answerKey1);
				btnNewButton_1.setForeground(Color.WHITE);
				btnNewButton_1.setFont(new Font("A-Space Demo", Font.PLAIN, 70));
				btnNewButton_1.setBounds(382, 439, 169, 157);
				btnNewButton_1.setBackground(new Color(0, 255, 153));
				frame.getContentPane().add(btnNewButton_1);
				
				JButton btnNewButton_1_1 = new JButton(answerKey2);
				btnNewButton_1_1.setForeground(Color.WHITE);
				btnNewButton_1_1.setFont(new Font("A-Space Demo", Font.PLAIN, 70));
				btnNewButton_1_1.setBounds(652, 439, 169, 157);
				btnNewButton_1_1.setBackground(new Color(0, 255, 153));
				frame.getContentPane().add(btnNewButton_1_1);
				
				JButton btnNewButton_1_1_1 = new JButton(answerKey3);
				btnNewButton_1_1_1.setForeground(Color.WHITE);
				btnNewButton_1_1_1.setFont(new Font("A-Space Demo", Font.PLAIN, 70));
				btnNewButton_1_1_1.setBounds(916, 439, 169, 157);
				btnNewButton_1_1_1.setBackground(new Color(0, 255, 153));
				frame.getContentPane().add(btnNewButton_1_1_1);
				
				
				//EQUATION NUMBERS
				String equation0 = String.format("%d", equation[0]);

				String equation2 = String.format("%d", equation[2]);
				String equation3 = String.format("%d", equation[3]);
			
				JLabel labelEquation0 = new JLabel(equation0);
				labelEquation0.setHorizontalAlignment(SwingConstants.CENTER);
				labelEquation0.setForeground(new Color(255, 255, 255));
				labelEquation0.setFont(new Font("A-Space Demo", Font.PLAIN, 87));
				labelEquation0.setBounds(164, 249, 153, 104);
				frame.getContentPane().add(labelEquation0);

				
				JLabel labelEquation2 = new JLabel(equation2);
				labelEquation2.setForeground(new Color(255, 255, 255));
				labelEquation2.setFont(new Font("A-Space Demo", Font.PLAIN, 87));
				labelEquation2.setBounds(536, 264, 197, 91);
				frame.getContentPane().add(labelEquation2);
		
				JLabel newLabel = new JLabel("New label");
				newLabel.setBounds(1137, 62, -225, 37);
				frame.getContentPane().add(newLabel);
						
				JLabel labelEquation3 = new JLabel(" = " + equation3);
				labelEquation3.setForeground(new Color(255, 255, 255));
				labelEquation3.setFont(new Font("A-Space Demo", Font.PLAIN, 87));
				labelEquation3.setBounds(765, 256, 259, 113);
				frame.getContentPane().add(labelEquation3);
				
				
			
				//OPERAND PART
				String equation1;
				if (equation[1] == 0){
				
				equation1 = "+";
				}
				
				else {
					equation1 = "-";
				}
				JLabel labelEquation1 = new JLabel(equation1);
				labelEquation1.setForeground(new Color(255, 255, 255));
				labelEquation1.setFont(new Font("A-Space Demo", Font.PLAIN, 87));
				labelEquation1.setBounds(345, 264, 164, 85);
				frame.getContentPane().add(labelEquation1);

				frame.setVisible(true);
	}
}
