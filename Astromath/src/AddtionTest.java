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

public class AddtionTest {

	private JFrame frame;
	private JFrame frame_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddtionTest window = new AddtionTest();
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
	public AddtionTest() {
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
				String studentName = "Jack";
				String grade = "Grade 1";
				
				JLabel label_name = new JLabel(studentName);
				label_name.setHorizontalAlignment(SwingConstants.RIGHT);
				label_name.setForeground(Color.WHITE);
				label_name.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
				label_name.setBounds(765, 21, 417, 44);
				frame_1.getContentPane().add(label_name);
				
				JLabel label_grade = new JLabel(grade);
				label_grade.setHorizontalAlignment(SwingConstants.RIGHT);
				label_grade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
				label_grade.setForeground(new Color(0, 195, 255));
				label_grade.setBounds(874, 59, 308, 44);
				frame.getContentPane().add(label_grade);
				
				
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
				
				//TEST COMPONENTS
				
				JLabel label_name_1 = new JLabel("Addition Test");
				label_name_1.setHorizontalAlignment(SwingConstants.CENTER);
				label_name_1.setForeground(Color.WHITE);
				label_name_1.setFont(new Font("A-Space Demo", Font.PLAIN, 40));
				label_name_1.setBounds(475, 99, 417, 44);
				frame_1.getContentPane().add(label_name_1);
				

				
				//RANDOM EQUATION MAKER This accesses MultipleChoice.java
				
				MultipleChoice mp = new MultipleChoice(1, 4);
				
				int[] equation = new int[4];
				
				
				equation = mp.generateAddSub(1, 20);
				
				
				
				
				int[] answerKey = new int[4];
				answerKey = mp.generateQuestions(equation[3], 4);
				//ANSWER KEY NUMBERS
				String answerKey0 = String.format("%d", answerKey[0]); 
				String answerKey1 = String.format("%d", answerKey[1]); 
				String answerKey2 = String.format("%d", answerKey[2]); 
				String answerKey3 = String.format("%d", answerKey[3]); 
				
				JLabel lblNewLabel_4 = new JLabel(answerKey0);
				lblNewLabel_4.setForeground(Color.WHITE);
				lblNewLabel_4.setFont(new Font("A-Space Demo", Font.PLAIN, 87));
				lblNewLabel_4.setBounds(55, 483, 186, 161);
				frame_1.getContentPane().add(lblNewLabel_4);
				
				JLabel lblNewLabel_5 = new JLabel(answerKey1);
				lblNewLabel_5.setFont(new Font("A-Space Demo", Font.PLAIN, 87));
				lblNewLabel_5.setForeground(Color.WHITE);
				lblNewLabel_5.setBounds(301, 483, 191, 161);
				frame_1.getContentPane().add(lblNewLabel_5);
				
				JLabel lblNewLabel_6 = new JLabel(answerKey2);
				lblNewLabel_6.setForeground(Color.WHITE);
				lblNewLabel_6.setFont(new Font("A-Space Demo", Font.PLAIN, 78));
				lblNewLabel_6.setBounds(633, 479, 197, 168);
				frame_1.getContentPane().add(lblNewLabel_6);
				
				JLabel lblNewLabel_7 = new JLabel(answerKey3);
				lblNewLabel_7.setForeground(Color.WHITE);
				lblNewLabel_7.setFont(new Font("A-Space Demo", Font.PLAIN, 87));
				lblNewLabel_7.setBounds(981, 483, 186, 176);
				frame_1.getContentPane().add(lblNewLabel_7);

				
				//EQUATION NUMBERS
				String equation0 = String.format("%d", equation[0]);

				String equation2 = String.format("%d", equation[2]);
				String equation3 = String.format("%d", equation[3]);
			
				JLabel lblNewLabel = new JLabel(equation0);
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setForeground(new Color(255, 255, 255));
				lblNewLabel.setFont(new Font("A-Space Demo", Font.PLAIN, 87));
				

				
				JLabel lblNewLabel_2 = new JLabel(equation2);
				lblNewLabel_2.setForeground(new Color(255, 255, 255));
				lblNewLabel_2.setFont(new Font("A-Space Demo", Font.PLAIN, 87));
				lblNewLabel_2.setBounds(536, 264, 197, 91);
				frame_1.getContentPane().add(lblNewLabel_2);
		
				JLabel lblNewLabel_8 = new JLabel("New label");
				lblNewLabel_8.setBounds(1137, 62, -225, 37);
				frame_1.getContentPane().add(lblNewLabel_8);
						
				JLabel lblNewLabel_3 = new JLabel(" = " + equation3);
				lblNewLabel_3.setForeground(new Color(255, 255, 255));
				lblNewLabel_3.setFont(new Font("A-Space Demo", Font.PLAIN, 87));
				lblNewLabel_3.setBounds(765, 256, 259, 113);
				frame_1.getContentPane().add(lblNewLabel_3);
				
				
			
				//OPERAND PART
				String equation1;
				if (equation[1] == 0){
				
				equation1 = "+";
				}
				
				else {
					equation1 = "-";
				}
				JLabel lblNewLabel_1 = new JLabel(equation1);
				lblNewLabel_1.setForeground(new Color(255, 255, 255));
				lblNewLabel_1.setFont(new Font("A-Space Demo", Font.PLAIN, 87));
				lblNewLabel_1.setBounds(345, 264, 164, 85);
				frame_1.getContentPane().add(lblNewLabel_1);
				lblNewLabel.setBounds(164, 249, 153, 104);
				frame_1.getContentPane().add(lblNewLabel);
	}

}
