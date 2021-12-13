import java.awt.Color;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;

public class TestSelection extends JPanel {

	private JFrame frame;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int height = screenSize.height;
	private int width = screenSize.width;
	private JLabel label_name = new JLabel("");
	private JLabel label_grade = new JLabel("");

	private JPanel panel_testSelect = new JPanel();
	private int questionSelect;
	private int operand;


	
	public TestSelection(JLayeredPane lp, Test test, Student student, Connection con) 
	{

		panel_testSelect.setBounds(0, 0, 1262, 681);
		panel_testSelect.setBackground(new Color(77,58,129));
		panel_testSelect.setLayout(null);
		
		
		JLabel image_home = new JLabel("");
		image_home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 
				MainWindow panel_home = new MainWindow(lp, test, student, con);
				switch_screen(panel_home.getPanel(), lp, test, questionSelect, operand, student, con);
			}
		});
		image_home.setIcon(new ImageIcon(".\\assets\\images\\home.png"));
		image_home.setBounds(40, 21, 64, 74);
		panel_testSelect.add(image_home);
		// Placeholder variables to use for Student name and Student grade
		
		// Code for the logo in the upper left corner and Astromath text
		
		JLabel astromath = new JLabel("ASTROMATH");
		
		astromath.setIcon(null);
		astromath.setHorizontalAlignment(SwingConstants.CENTER);
		astromath.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
		astromath.setForeground(new Color(255, 255, 255));
		astromath.setBounds(97, 21, 318, 85);
		panel_testSelect.add(astromath);
		
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
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				MainWindow panel_home = new MainWindow(lp, test, student, con);
				switch_screen(panel_home.getPanel(), lp, test, questionSelect, operand, student, con);
			}
		});
		
		// The Welcome back message given when a student logs in, add in boolean to get rid of "Welcome back," and just leave in the name later
		
		label_name = new JLabel(student.getName());
		label_name.setHorizontalAlignment(SwingConstants.RIGHT);
		label_name.setForeground(Color.WHITE);
		label_name.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
		label_name.setBounds(765, 21, 417, 44);
		panel_testSelect.add(label_name);
		
		if(student.getGradeLevel() == 0) {
			label_grade = new JLabel("K");
			label_grade.setHorizontalAlignment(SwingConstants.RIGHT);
			label_grade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
			label_grade.setForeground(new Color(0, 195, 255));
			label_grade.setBounds(874, 59, 308, 44);
			panel_testSelect.add(label_grade);
			
		} else {
		label_grade = new JLabel(String.format("Grade: %d", student.getGradeLevel()));
		label_grade.setHorizontalAlignment(SwingConstants.RIGHT);
		label_grade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
		label_grade.setForeground(new Color(0, 195, 255));
		label_grade.setBounds(874, 59, 308, 44);
		panel_testSelect.add(label_grade);
		}
		
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
				Login panel_login = new Login(lp, test, student, con);
				switch_screen(panel_login.getPanel(), lp, test, questionSelect, operand, student, con);
			}
		});
		image_logout.setIcon(new ImageIcon(".\\assets\\images\\logout.png"));
		image_logout.setBounds(1192, 15, 72, 91);
		panel_testSelect.add(image_logout);
		
		JLabel image_settings = new JLabel("");
		image_settings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccountSettings panel_acc= new AccountSettings(lp, test, student, con);
				switch_screen(panel_acc.getPanel(), lp, test, questionSelect, operand, student, con);
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				image_settings.setIcon(new ImageIcon(".\\assets\\images\\gear v2.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				image_settings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
			}
		});
		image_settings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
		image_settings.setBounds(1188, 99, 64, 64);
		panel_testSelect.add(image_settings);
		
		//Test Selection options
		
		if(student.getGradeLevel() == 0) {
		JLabel grade1Tests = new JLabel("Kindergarten Test");
		grade1Tests.setHorizontalAlignment(SwingConstants.CENTER);
		grade1Tests.setForeground(new Color(0, 195, 255));
		grade1Tests.setFont(new Font("a Atmospheric", Font.PLAIN, 30));
		grade1Tests.setBounds(10, 99, 717, 44);
		panel_testSelect.add(grade1Tests);
		} else { 
			JLabel grade1Tests = new JLabel(String.format("Grade %d Test",student.getGradeLevel()));
			grade1Tests.setHorizontalAlignment(SwingConstants.CENTER);
			grade1Tests.setForeground(new Color(0, 195, 255));
			grade1Tests.setFont(new Font("a Atmospheric", Font.PLAIN, 30));
			grade1Tests.setBounds(10, 99, 417, 44);
			panel_testSelect.add(grade1Tests);
		}
		
		if(student.getGradeLevel() >= 3) {
			JLabel additionTest = new JLabel("Multiplication Test");
			additionTest.setBackground(new Color(0, 0, 153));
			additionTest.setHorizontalAlignment(SwingConstants.CENTER);
			additionTest.setForeground(Color.WHITE);
			additionTest.setFont(new Font("A-Space Demo", Font.PLAIN, 40));
			additionTest.setBounds(189, 171, 925, 44);
			panel_testSelect.add(additionTest);
			
			additionTest.addMouseListener(new MouseAdapter() 
			{
				@Override
				public void mouseClicked(MouseEvent e) {
					questionSelect = 0;
					operand = 2;
					test.setCurrentTest(additionTest.getText());
					TestQuestions panel_testQ = new TestQuestions(lp, test, questionSelect, operand, student, con);
					switch_screen(panel_testQ.getPanel(), lp, test, questionSelect, operand, student, con);
				}
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
					
				}
			});
			
			editorPane.setBackground(new Color(23, 38, 83));
			editorPane.setBounds(175, 153, 953, 74);
			panel_testSelect.add(editorPane);
			
			JLabel subtractionTest = new JLabel("Division Test");
			subtractionTest.setHorizontalAlignment(SwingConstants.CENTER);
			subtractionTest.setForeground(Color.WHITE);
			subtractionTest.setFont(new Font("A-Space Demo", Font.PLAIN, 38));
			subtractionTest.setBackground(new Color(0, 0, 153));
			subtractionTest.setBounds(189, 263, 925, 44);
			panel_testSelect.add(subtractionTest);
			
			subtractionTest.addMouseListener(new MouseAdapter() 
			{
				@Override
				public void mouseClicked(MouseEvent e) {
					questionSelect = 0;
					operand = 3;
					test.setCurrentTest(subtractionTest.getText());
					TestQuestions panel_testQ = new TestQuestions(lp, test, questionSelect, operand, student, con);
					switch_screen(panel_testQ.getPanel(), lp, test, questionSelect, operand, student, con);
				}
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
					
				}
			});
			editorPane_1.setBackground(new Color(23, 38, 83));
			editorPane_1.setBounds(175, 246, 953, 74);
			panel_testSelect.add(editorPane_1);
			
		}
		JLabel additionTest = new JLabel("Addition Test");
		additionTest.setBackground(new Color(0, 0, 153));
		additionTest.setHorizontalAlignment(SwingConstants.CENTER);
		additionTest.setForeground(Color.WHITE);
		additionTest.setFont(new Font("A-Space Demo", Font.PLAIN, 40));
		additionTest.setBounds(189, 171, 925, 44);
		panel_testSelect.add(additionTest);
		
		additionTest.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				questionSelect = 0;
				operand = 0;
				test.setCurrentTest(additionTest.getText());
				TestQuestions panel_testQ = new TestQuestions(lp, test, questionSelect, operand, student, con);
				switch_screen(panel_testQ.getPanel(), lp, test, questionSelect, operand, student, con);
			}
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
				
			}
		});
		
		editorPane.setBackground(new Color(23, 38, 83));
		editorPane.setBounds(175, 153, 953, 74);
		panel_testSelect.add(editorPane);
		
		JLabel subtractionTest = new JLabel("Subtraction Test");
		subtractionTest.setHorizontalAlignment(SwingConstants.CENTER);
		subtractionTest.setForeground(Color.WHITE);
		subtractionTest.setFont(new Font("A-Space Demo", Font.PLAIN, 38));
		subtractionTest.setBackground(new Color(0, 0, 153));
		subtractionTest.setBounds(189, 263, 925, 44);
		panel_testSelect.add(subtractionTest);
		
		subtractionTest.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				questionSelect = 0;
				operand = 1;
				test.setCurrentTest(subtractionTest.getText());
				TestQuestions panel_testQ = new TestQuestions(lp, test, questionSelect, operand, student, con);
				switch_screen(panel_testQ.getPanel(), lp, test, questionSelect, operand, student, con);
			}
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
				
			}
		});
		editorPane_1.setBackground(new Color(23, 38, 83));
		editorPane_1.setBounds(175, 246, 953, 74);
		panel_testSelect.add(editorPane_1);
		
		JLabel trueOrFalseTest = new JLabel("True Or False Test");
		trueOrFalseTest.setHorizontalAlignment(SwingConstants.CENTER);
		trueOrFalseTest.setForeground(Color.WHITE);
		trueOrFalseTest.setFont(new Font("A-Space Demo", Font.PLAIN, 40));
		trueOrFalseTest.setBackground(new Color(0, 0, 153));
		trueOrFalseTest.setBounds(189, 354, 925, 44);
		panel_testSelect.add(trueOrFalseTest);
		
		trueOrFalseTest.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				questionSelect = 1;
				operand = 0;
				test.setCurrentTest(trueOrFalseTest.getText());
				TestQuestions panel_testQ = new TestQuestions(lp, test, questionSelect, operand, student, con);
				switch_screen(panel_testQ.getPanel(), lp, test, questionSelect, operand, student, con);
			}
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
		panel_testSelect.add(editorPane_2);
		
		JLabel fillInTheBlankTest = new JLabel("Fill In The Blank Test");
		fillInTheBlankTest.setHorizontalAlignment(SwingConstants.CENTER);
		fillInTheBlankTest.setForeground(Color.WHITE);
		fillInTheBlankTest.setFont(new Font("A-Space Demo", Font.PLAIN, 38));
		fillInTheBlankTest.setBackground(new Color(0, 0, 153));
		fillInTheBlankTest.setBounds(189, 456, 925, 44);
		panel_testSelect.add(fillInTheBlankTest);
		
		fillInTheBlankTest.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				questionSelect = 2;
				operand = 0;
				test.setCurrentTest(fillInTheBlankTest.getText());
				TestQuestions panel_testQ = new TestQuestions(lp, test, questionSelect, operand, student, con);
				switch_screen(panel_testQ.getPanel(), lp, test, questionSelect, operand, student, con);
			}
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
		panel_testSelect.add(editorPane_2_1);
		
		
		
		try {
			
			String quer = "Select userID from testinfo where userID = '" + student.getAccNum() +"'";                    
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(quer);
			if(rs.next()){
				
			} else {

	             quer = "INSERT INTO testinfo(`userID`, `testName1`, `testName2`, `testName3`, `testName4`, `testScore1`, `testScore2`, `testScore3`, `testScore4`) "
	               		
	                    + "VALUES ('" + student.getAccNum() + "','" + additionTest.getText() + "','" + subtractionTest.getText() + "','" +  trueOrFalseTest.getText() +"','" + fillInTheBlankTest.getText() + "','" + 0 + "','"+ 0 + "','" + 0 + "','" + 0 + "')";
	                    
	                     Statement sta = con.createStatement();
	                     sta.executeUpdate(quer);
			}
			
			
			
			

			 
			 

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		
	}

	public JPanel getPanel()
	{
		return panel_testSelect;
		
	}
	public void switch_screen(JPanel p, JLayeredPane lp, Test test, int questionSelect, int operand, Student student, Connection con)
	{
		lp.removeAll();
		p.setLayout(null);
		lp.add(p);
		lp.repaint();
		lp.revalidate();
		

	}
}
