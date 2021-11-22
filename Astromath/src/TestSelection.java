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


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestSelection window = new TestSelection();
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
				
				JLabel image_home = new JLabel("");
				image_home.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) { 
						MainWindow mw = new MainWindow();
						frame.dispose();
					}
				});
				image_home.setIcon(new ImageIcon(".\\assets\\images\\home.png"));
				image_home.setBounds(40, 21, 64, 74);
				frame.getContentPane().add(image_home);
				// Placeholder variables to use for Student name and Student grade
				
				String studentName = "Jack";
				String grade = "Grade 1";
				
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
				
				//Test Selection options
				
				JLabel grade1Tests = new JLabel("Grade 1 Tests");
				grade1Tests.setHorizontalAlignment(SwingConstants.CENTER);
				grade1Tests.setForeground(Color.WHITE);
				grade1Tests.setFont(new Font("A-Space Demo", Font.PLAIN, 40));
				grade1Tests.setBounds(475, 99, 417, 44);
				frame.getContentPane().add(grade1Tests);
				
				JLabel additionTest = new JLabel("Addition Test (Numbers within 20)");
				additionTest.setBackground(new Color(0, 0, 153));
				additionTest.setHorizontalAlignment(SwingConstants.CENTER);
				additionTest.setForeground(Color.WHITE);
				additionTest.setFont(new Font("A-Space Demo", Font.PLAIN, 40));
				additionTest.setBounds(189, 171, 925, 44);
				frame.getContentPane().add(additionTest);
				
				additionTest.addMouseListener(new MouseAdapter() 
				{
					@Override
					public void mouseEntered(MouseEvent e) 
					{
						additionTest.setForeground(new Color(0, 195, 255));
					}
					@Override
					public void mouseExited(MouseEvent e) 
					{
						additionTest.setForeground(Color.WHITE);
					}
				});
				
				JEditorPane editorPane = new JEditorPane();
				editorPane.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						AdditionTest at = new AdditionTest();
						frame.dispose();
					}
				});
				
				editorPane.setBackground(new Color(23, 38, 83));
				editorPane.setBounds(175, 153, 953, 74);
				frame.getContentPane().add(editorPane);
				
				JLabel subtractionTest = new JLabel("Subtraction Test (Numbers within 20)");
				subtractionTest.setHorizontalAlignment(SwingConstants.CENTER);
				subtractionTest.setForeground(Color.WHITE);
				subtractionTest.setFont(new Font("A-Space Demo", Font.PLAIN, 38));
				subtractionTest.setBackground(new Color(0, 0, 153));
				subtractionTest.setBounds(189, 263, 925, 44);
				frame.getContentPane().add(subtractionTest);
				
				subtractionTest.addMouseListener(new MouseAdapter() 
				{
					@Override
					public void mouseEntered(MouseEvent e) 
					{
						subtractionTest.setForeground(new Color(0, 195, 255));
					}
					@Override
					public void mouseExited(MouseEvent e) 
					{
						subtractionTest.setForeground(Color.WHITE);
					}
				});
				
				JEditorPane editorPane_1 = new JEditorPane();
				editorPane_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						SubtractionTest st = new SubtractionTest();
						frame.dispose();
					}
				});
				editorPane_1.setBackground(new Color(23, 38, 83));
				editorPane_1.setBounds(175, 246, 953, 74);
				frame.getContentPane().add(editorPane_1);
				
				JLabel trueOrFalseTest = new JLabel("True Or False Test");
				trueOrFalseTest.setHorizontalAlignment(SwingConstants.CENTER);
				trueOrFalseTest.setForeground(Color.WHITE);
				trueOrFalseTest.setFont(new Font("A-Space Demo", Font.PLAIN, 40));
				trueOrFalseTest.setBackground(new Color(0, 0, 153));
				trueOrFalseTest.setBounds(189, 354, 925, 44);
				frame.getContentPane().add(trueOrFalseTest);
				
				trueOrFalseTest.addMouseListener(new MouseAdapter() 
				{
					@Override
					public void mouseEntered(MouseEvent e) 
					{
						trueOrFalseTest.setForeground(new Color(0, 195, 255));
					}
					@Override
					public void mouseExited(MouseEvent e) 
					{
						trueOrFalseTest.setForeground(Color.WHITE);
					}
				});
				
				JEditorPane editorPane_2 = new JEditorPane();
				editorPane_2.setBackground(new Color(23, 38, 83));
				editorPane_2.setBounds(175, 343, 953, 74);
				frame.getContentPane().add(editorPane_2);
				
				JLabel fillInTheBlankTest = new JLabel("Fill In The Blank Test");
				fillInTheBlankTest.setHorizontalAlignment(SwingConstants.CENTER);
				fillInTheBlankTest.setForeground(Color.WHITE);
				fillInTheBlankTest.setFont(new Font("A-Space Demo", Font.PLAIN, 38));
				fillInTheBlankTest.setBackground(new Color(0, 0, 153));
				fillInTheBlankTest.setBounds(189, 456, 925, 44);
				frame.getContentPane().add(fillInTheBlankTest);
				
				fillInTheBlankTest.addMouseListener(new MouseAdapter() 
				{
					@Override
					public void mouseEntered(MouseEvent e) 
					{
						fillInTheBlankTest.setForeground(new Color(0, 195, 255));
					}
					@Override
					public void mouseExited(MouseEvent e) 
					{
						fillInTheBlankTest.setForeground(Color.WHITE);
					}
				});
				
				JEditorPane editorPane_2_1 = new JEditorPane();
				editorPane_2_1.setBackground(new Color(23, 38, 83));
				editorPane_2_1.setBounds(175, 439, 953, 74);
				frame.getContentPane().add(editorPane_2_1);
				

				frame.setVisible(true);
	}
}
