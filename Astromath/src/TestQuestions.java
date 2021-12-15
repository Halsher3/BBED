	import java.awt.EventQueue;

	import java.awt.*;
	import java.util.Random;
	
	import java.awt.Color;
	
	import java.awt.Font;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
	import javax.swing.JTextField;
	import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
	import javax.swing.JTextPane;
	
	import javax.swing.JFrame;
	import javax.swing.JProgressBar;
import javax.swing.JTextArea;
	
	public class TestQuestions {
	
		private JFrame frame;
		public int questionsRight = 0;
		private JTextField textAnswer;
		private int[] answerKey = new int[4];
		private int[] equation = new int[4];
		private String[] phrase1 = new String[2];
		private int numOfQuestions;
		private String[] tofPhrase = new String[numOfQuestions];
		private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		private int height = screenSize.height;
		private int width = screenSize.width;
		private JLabel label_name = new JLabel("");
		private JLabel label_grade = new JLabel("");
		

		

		private JPanel panel_TestQuestions = new JPanel();
	
		
		/**
		 * Create the application.
		 */
		public TestQuestions(JLayeredPane lp, Test test, int questionSelect, int operand, Student student, Connection con) {
			int grade = student.getGradeLevel();
			panel_TestQuestions.setBounds(0, 0, 1262, 681);
			panel_TestQuestions.setBackground(new Color(77,58,129));
			panel_TestQuestions.setLayout(null);
			
			JLabel home = new JLabel("");
			home.setIcon(new ImageIcon(".\\assets\\images\\home.png"));
			home.setBounds(40, 21, 64, 74);
			panel_TestQuestions.add(home);
			// Placeholder variables to use for Student name and Student grade
			

			
			// Code for the logo in the upper left corner and Astromath text
			
			JLabel astromath = new JLabel("ASTROMATH");
			
			astromath.setIcon(null);
			astromath.setHorizontalAlignment(SwingConstants.CENTER);
			astromath.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
			astromath.setForeground(new Color(255, 255, 255));
			astromath.setBounds(97, 21, 318, 85);
			panel_TestQuestions.add(astromath);
			
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
					switch_screen(panel_home.getPanel(), lp, test, student, con);

				}
			});
			
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

			

			label_name = new JLabel(student.getName());
			label_name.setHorizontalAlignment(SwingConstants.RIGHT);
			label_name.setForeground(Color.WHITE);
			label_name.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
			label_name.setBounds(765, 21, 417, 44);
			panel_TestQuestions.add(label_name);
			
			if(student.getGradeLevel() == 0) {
				label_grade = new JLabel("K");
				label_grade.setHorizontalAlignment(SwingConstants.RIGHT);
				label_grade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
				label_grade.setForeground(new Color(0, 195, 255));
				label_grade.setBounds(874, 59, 308, 44);
				panel_TestQuestions.add(label_grade);
				
			} else {
			label_grade = new JLabel(String.format("Grade: %d", student.getGradeLevel()));
			label_grade.setHorizontalAlignment(SwingConstants.RIGHT);
			label_grade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
			label_grade.setForeground(new Color(0, 195, 255));
			label_grade.setBounds(874, 59, 308, 44);
			panel_TestQuestions.add(label_grade);
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
				@Override
				public void mouseClicked(MouseEvent e) 
				{
					Login panel_login = new Login(lp, test, student, con);
					switch_screen(panel_login.getPanel(), lp, test, student, con);

				}
			});
			imageLogout.setIcon(new ImageIcon(".\\assets\\images\\logout.png"));
			imageLogout.setBounds(1192, 15, 72, 91);
			panel_TestQuestions.add(imageLogout);
			
			JLabel image_settings = new JLabel("");
			image_settings.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					AccountSettings panel_acc = new AccountSettings(lp, test, student, con);
					switch_screen(panel_acc.getPanel(), lp, test, student, con);

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
			panel_TestQuestions.add(image_settings);
			
	
			JButton button_submit = new JButton("Finish");
			button_submit.setVisible(false);
			button_submit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) 
				{
					int grades = test.calculateGrade(test.getScoreSheet());
					
					try {
					String tempTest = test.getCurrentTest();
					
						if(tempTest.equals("Addition Test") || tempTest.equals("Multiplication Test")) {
						String query = "Update testinfo set testScore1 = '" + grades + "' where userID = '" + student.getAccNum() + "'";
						Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
						st.executeUpdate(query);
						}
						else if(tempTest.equals("Subtraction Test") || tempTest.equals("Division Test")) {
							String query = "Update testinfo set testScore2 = '" + grades + "' where userID = '" + student.getAccNum() + "'";
							Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							st.executeUpdate(query);
							
							}
						else if(tempTest.equals("True Or False Test")) {
								String query = "Update testinfo set testScore3 = '" + grades + "' where userID = '" + student.getAccNum() + "'";
								Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
								st.executeUpdate(query);
								}
						else if(tempTest.equals("Fill In The Blank Test")) {
							String query = "Update testinfo set testScore4 = '" + grades + "' where userID = '" + student.getAccNum() + "'";
							Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							st.executeUpdate(query);
							}

						

					} catch (SQLException e1) {

						e1.printStackTrace();
					}
					
					
					
				    JOptionPane.showMessageDialog(null,"Congrats, you've leveled up!");
					
					test.resetNumQuestions();
					TestResult panel_tr = new TestResult(lp, test, student, con);
					switch_screen(panel_tr.getPanel(), lp, test, student, con);
				}
			});
			button_submit.setBackground(new Color(26, 38, 83));
			button_submit.setHorizontalAlignment(SwingConstants.CENTER);
			button_submit.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
			button_submit.setForeground(new Color(127, 255, 212));
			button_submit.setBounds(890, 602, 288, 68);
			panel_TestQuestions.add(button_submit);
			
			JLabel label_testOver = new JLabel("The test is now over,");
			label_testOver.setVisible(false);
			label_testOver.setFont(new Font("A-Space Demo", Font.PLAIN, 45));
			label_testOver.setForeground(Color.WHITE);
			label_testOver.setBounds(309, 218, 610, 53);
			panel_TestQuestions.add(label_testOver);
			
			JLabel label_clickButton = new JLabel("click the button to see your results.");
			label_clickButton.setVisible(false);
			label_clickButton.setForeground(Color.WHITE);
			label_clickButton.setFont(new Font("A-Space Demo", Font.PLAIN, 45));
			label_clickButton.setBounds(116, 282, 1061, 53);
			panel_TestQuestions.add(label_clickButton);
			
			JLabel image_student = new JLabel("");
			image_student.setVisible(false);
			image_student.setIcon(new ImageIcon(".\\Assets\\images\\homework.png"));
			image_student.setBounds(351, 282, 480, 480);
			panel_TestQuestions.add(image_student);
			
			if(test.getNumQuestions() == 10) 
			{
			button_submit.setVisible(true);
			label_testOver.setVisible(true);
			label_clickButton.setVisible(true);
			image_student.setVisible(true);
			
			
			} else {
			//TEST COMPONENTS
			
			JLabel practiceProblems = new JLabel(test.getCurrentTest());
			practiceProblems.setHorizontalAlignment(SwingConstants.CENTER);
			practiceProblems.setForeground(new Color(0, 195, 255));
			practiceProblems.setFont(new Font("a Atmospheric", Font.PLAIN, 30));
			practiceProblems.setBounds(22, 94, 530, 44);
			panel_TestQuestions.add(practiceProblems);
			
			int diff = test.getNumQuestions();
			JProgressBar progressBar = new JProgressBar();
			progressBar.setBackground(new Color(255, 0, 153));
			progressBar.setForeground(new Color(0, 255, 153));
			progressBar.setMaximum(10);
			progressBar.setBounds((0), 681-20, 1262, 20);
			progressBar.setValue(diff);
			panel_TestQuestions.add(progressBar);
			
			lp.revalidate();
			
			JLabel lblNewLabel = new JLabel(String.format("%d",  diff));
			lblNewLabel.setBounds(634, 61, 46, 14);
			lblNewLabel.setVisible(false);
			panel_TestQuestions.add(lblNewLabel);
			

			

			

			
			//RANDOM EQUATION MAKER This accesses MultipleChoice.java


			
			int font = 87;
			switch(questionSelect) {
			case 0: 
				MultipleChoice mp = new MultipleChoice(grade, 4);
				

				
				
				equation = mp.generateEquation(grade, operand, 1);
				

				answerKey = MultipleChoice.generateQuestions(grade, equation[3], 4);
				//ANSWER KEY NUMBERS
				String answerKey0 = String.format("%d", answerKey[0]); 
				String answerKey1 = String.format("%d", answerKey[1]); 
				String answerKey2 = String.format("%d", answerKey[2]); 
				String answerKey3 = String.format("%d", answerKey[3]); 
				
				if(equation[3] > 100) {
					font = 50;
				 if(equation[3] > 1000) {
					font = 40;
				}
				 if(equation[3] > 10000) {
					 font = 30;
				 }
				
				}
				
				JButton mpAnswer1 = new JButton(answerKey0);
				mpAnswer1.setForeground(Color.WHITE);
				mpAnswer1.setFont(new Font("A-Space Demo", Font.PLAIN, font));
				mpAnswer1.setBounds(50, 460, 200, 200);
				mpAnswer1.setBackground(new Color(0, 255, 153));
				panel_TestQuestions.add(mpAnswer1);
				
				mpAnswer1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						if(answerKey[0] == equation[3])
						{
							test.setScoreSheet(1);
							test.setNumQuestions(test.getNumQuestions());
							TestQuestions panel_question = new TestQuestions(lp, test, questionSelect, operand, student, con);
							switch_screen(panel_question.getPanel(), lp, test, student, con);
							

						}
						else
						{
							test.setScoreSheet(0);
							test.setNumQuestions(test.getNumQuestions());
							mpAnswer1.setBackground(new Color(255, 0, 153));
							
							TestQuestions panel_question = new TestQuestions(lp, test, questionSelect, operand, student, con);
							switch_screen(panel_question.getPanel(), lp, test, student, con);
							
						}
					}
				});
				
				JButton mpAnswer2 = new JButton(answerKey1);
				mpAnswer2.setFont(new Font("A-Space Demo", Font.PLAIN, font));
				mpAnswer2.setForeground(Color.WHITE);
				mpAnswer2.setBounds(350, 460, 200, 200);
				mpAnswer2.setBackground(new Color(0, 255, 153));
				panel_TestQuestions.add(mpAnswer2);
				mpAnswer2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						if(answerKey[1] == equation[3])
						{
							test.setScoreSheet(1);
							test.setNumQuestions(test.getNumQuestions());
							TestQuestions panel_question = new TestQuestions(lp, test, questionSelect, operand, student, con);
							switch_screen(panel_question.getPanel(), lp, test, student, con);
							
						}
						else
						{
							test.setScoreSheet(0);
							test.setNumQuestions(test.getNumQuestions());
							
							mpAnswer2.setBackground(new Color(255, 0, 153));
							TestQuestions panel_question = new TestQuestions(lp, test, questionSelect, operand, student, con);
							switch_screen(panel_question.getPanel(), lp, test, student, con);
							
						}
					}
				});
				
				JButton mpAnswer3 = new JButton(answerKey2);
				mpAnswer3.setForeground(Color.WHITE);
				mpAnswer3.setFont(new Font("A-Space Demo", Font.PLAIN, font));
				mpAnswer3.setBounds(650, 460, 200, 200);
				mpAnswer3.setBackground(new Color(0, 255, 153));
				panel_TestQuestions.add(mpAnswer3);
				mpAnswer3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						if(answerKey[2] == equation[3])
						{
							test.setScoreSheet(1);
							test.setNumQuestions(test.getNumQuestions());
							TestQuestions panel_question = new TestQuestions(lp, test, questionSelect, operand, student, con);
							switch_screen(panel_question.getPanel(), lp, test, student, con);
							
						}
						else
						{
							test.setScoreSheet(0);
							test.setNumQuestions(test.getNumQuestions());
							mpAnswer3.setBackground(new Color(255, 0, 153));
							TestQuestions panel_question = new TestQuestions(lp, test, questionSelect, operand, student, con);
							switch_screen(panel_question.getPanel(), lp, test, student, con);
							
						}
					}
				});
				
				JButton mpAnswer4 = new JButton(answerKey3);
				mpAnswer4.setForeground(Color.WHITE);
				mpAnswer4.setFont(new Font("A-Space Demo", Font.PLAIN, font));
				mpAnswer4.setBounds(950, 460, 200, 200);
				mpAnswer4.setBackground(new Color(0, 255, 153));
				panel_TestQuestions.add(mpAnswer4);
				mpAnswer4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						if(answerKey[3] == equation[3])
						{
							test.setScoreSheet(1);
							test.setNumQuestions(test.getNumQuestions());
							TestQuestions panel_question = new TestQuestions(lp, test, questionSelect, operand, student, con);
							switch_screen(panel_question.getPanel(), lp, test, student, con);
							
						}
						else
						{
							test.setScoreSheet(0);
							test.setNumQuestions(test.getNumQuestions());
							mpAnswer4.setBackground(new Color(255, 0, 153));
							TestQuestions panel_question = new TestQuestions(lp, test, questionSelect, operand, student, con);
							switch_screen(panel_question.getPanel(), lp, test, student, con);
							
						}
					}
				});
				
				//EQUATION NUMBERS
				String equation0 = String.format("%d", equation[0]);

				String equation2 = String.format("%d", equation[2]);
				String equation3 = String.format("%d", equation[3]);
			
				int mpAdjustX = 350;
				int mpAdjustWidth = 200;
				if(equation[0] > 1000) {
					mpAdjustX = 300;
				}
				if(equation[0] > 10000) {
					mpAdjustX = 200;
				}
				if(equation[0] > 1000) {
					mpAdjustWidth = 300;
				}
				if(equation[0] > 10000) {
					mpAdjustWidth = 400;
				}
				JLabel mpEquation1 = new JLabel(equation0);
				mpEquation1.setHorizontalAlignment(SwingConstants.CENTER);
				mpEquation1.setBounds(mpAdjustX, 260, mpAdjustWidth, 91);
				mpEquation1.setForeground(new Color(255, 255, 255));
				mpEquation1.setFont(new Font("A-Space Demo", Font.PLAIN, 60));
				panel_TestQuestions.add(mpEquation1);
				

				
				JLabel mpEquation2 = new JLabel(equation2);
				mpEquation2.setForeground(new Color(255, 255, 255));
				mpEquation2.setHorizontalAlignment(SwingConstants.CENTER);
				mpEquation2.setFont(new Font("A-Space Demo", Font.PLAIN, 60));
				mpEquation2.setBounds(750, 260, mpAdjustWidth, 91);
				panel_TestQuestions.add(mpEquation2);
		
					
				JLabel mpEquation4 = new JLabel("");
				mpEquation4.setForeground(new Color(255, 255, 255));
				mpEquation4.setFont(new Font("A-Space Demo", Font.PLAIN, 60));
				mpEquation4.setBounds(950, 260, 197, 91);
				panel_TestQuestions.add(mpEquation4);
				
				
				
				
			
				//OPERAND PART
				String equation1 = "";
				if (equation[1] == 0){
				
				equation1 = "+";
				}
				
				else if(equation[1] == 1){
					equation1 = "-";
				}
				else if(equation[1] == 2){
					equation1 = "x";
				}
				else if(equation[1] == 3){
					equation1 = "/";
				}
				JLabel mpEquation3 = new JLabel(equation1);
				mpEquation3.setForeground(new Color(255, 255, 255));
				mpEquation3.setFont(new Font("A-Space Demo", Font.PLAIN, 60));
				mpEquation3.setBounds(590, 260, 197, 91);
				panel_TestQuestions.add(mpEquation3);
				break;
				
			
			case 1:
				font = 30;
				TrueOrFalse tof = new TrueOrFalse(grade, 2);
				int numOfQuestions = 2;
				 

				int tofAdjustX = 50;
				
				tofPhrase = tof.generateToF(grade);
				
				
				//EQUATION NUMBERS
				if(tofPhrase[0].length() < 20) {
					
					font = 50;
					tofAdjustX = 0;
					panel_TestQuestions.revalidate();
					panel_TestQuestions.repaint();
				}
				else if(tofPhrase[0].length() > 50) 
				{
					font = 16;
				
				}
				
				
				JLabel tofPhrase1 = new JLabel(tofPhrase[0]);
				tofPhrase1.setForeground(new Color(255, 255, 255));
				tofPhrase1.setFont(new Font("A-Space Demo", Font.PLAIN, font));
				tofPhrase1.setHorizontalAlignment(SwingConstants.CENTER);
				tofPhrase1.setBounds(0, 266,1263,200);
				panel_TestQuestions.add(tofPhrase1);
				
				String trueButton = "True";
				
				
				
				JButton tofPhrase2 = new JButton(trueButton);
				tofPhrase2.setHorizontalAlignment(SwingConstants.CENTER);
				tofPhrase2.setForeground(new Color(255, 255, 255));
				tofPhrase2.setFont(new Font("A-Space Demo", Font.PLAIN, 45));
				tofPhrase2.setBounds(350, 460, 200, 200);
				tofPhrase2.setBackground(new Color(0, 255, 153));
				panel_TestQuestions.add(tofPhrase2);
				tofPhrase2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						if(tofPhrase[1].equals(trueButton))
						{
							test.setScoreSheet(1);
							test.setNumQuestions(test.getNumQuestions());
							TestQuestions panel_question = new TestQuestions(lp, test, questionSelect, operand, student, con);
							switch_screen(panel_question.getPanel(), lp, test, student, con);
						}
						else
						{
							test.setScoreSheet(0);
							test.setNumQuestions(test.getNumQuestions());
							tofPhrase2.setBackground(new Color(255, 0, 153));
							TestQuestions panel_question = new TestQuestions(lp, test, questionSelect, operand, student, con);
							switch_screen(panel_question.getPanel(), lp, test, student, con);
							
						}
					}
				});
				
				String falseButton = "False";
				
				JButton tofPhrase3 = new JButton(falseButton);
				tofPhrase3.setHorizontalAlignment(SwingConstants.CENTER);
				tofPhrase3.setForeground(new Color(255, 255, 255));
				tofPhrase3.setFont(new Font("A-Space Demo", Font.PLAIN, 45));
				tofPhrase3.setBounds(650, 460, 200, 200);
				tofPhrase3.setBackground(new Color(0, 255, 153));
				panel_TestQuestions.add(tofPhrase3);
				tofPhrase3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						if(tofPhrase[1].equals(falseButton))
						{
							test.setScoreSheet(1);
							test.setNumQuestions(test.getNumQuestions());
							TestQuestions panel_question = new TestQuestions(lp, test, questionSelect, operand, student, con);
							switch_screen(panel_question.getPanel(), lp, test, student, con);
						}
						else
						{
							test.setScoreSheet(0);
							test.setNumQuestions(test.getNumQuestions());
							tofPhrase3.setBackground(new Color(255, 0, 153));
							TestQuestions panel_question = new TestQuestions(lp, test, questionSelect, operand, student, con);
							switch_screen(panel_question.getPanel(), lp, test, student, con);
							
						}
					}
				});
				
				break;
				

case 2:
	
	FillInTheBlank fitb = new FillInTheBlank(grade, 4);
	
	
	
	phrase1 = fitb.generateFITB(grade);
	
	
font = 50;
	
	//phase[0] is the statement, phrase[1] is the answer

	if(phrase1[0].length() > 20) {
		font = 30;
		panel_TestQuestions.revalidate();
		panel_TestQuestions.repaint();
	}
	if(phrase1[0].length() > 40) {
		font = 20;
	}

	JLabel fitbPhrase1 = new JLabel(phrase1[0]);
	fitbPhrase1.setBackground(new Color(77,58,129));
	fitbPhrase1.setForeground(new Color(255,255,255));
	fitbPhrase1.setHorizontalAlignment(SwingConstants.CENTER);
	fitbPhrase1.setFont(new Font("A-Space Demo", Font.PLAIN, font));
	fitbPhrase1.setBounds(0, 266,1263,200);
	panel_TestQuestions.add(fitbPhrase1);
	
	textAnswer = new JTextField();
	textAnswer.setFont(new Font("A-Space Demo", Font.PLAIN, 42));
	textAnswer.setForeground(Color.WHITE);
	textAnswer.setBackground(new Color(26, 38, 83));
	textAnswer.setBounds(372, 450, 589, 106);
	textAnswer.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
	panel_TestQuestions.add(textAnswer);
	textAnswer.setColumns(10);
	
	JButton lblNewLabel_1 = new JButton("Submit");
	lblNewLabel_1.setBackground(new Color(26, 38, 83));
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
	lblNewLabel_1.setForeground(new Color(127, 255, 212));
	lblNewLabel_1.setBounds(964, 580, 288, 68);
	panel_TestQuestions.add(lblNewLabel_1);
	
	lblNewLabel_1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			if(textAnswer.getText().equals(phrase1[1]))
			{
				test.setScoreSheet(1);
				test.setNumQuestions(test.getNumQuestions());
				TestQuestions panel_question = new TestQuestions(lp, test, questionSelect, operand, student, con);
				switch_screen(panel_question.getPanel(), lp, test, student, con);
			}
			else
			{
				
				test.setScoreSheet(0);
				test.setNumQuestions(test.getNumQuestions());
				TestQuestions panel_question = new TestQuestions(lp, test, questionSelect, operand, student, con);
				switch_screen(panel_question.getPanel(), lp, test, student, con);
				
			}
		}
	});
	
	break;
	
	


}

						
		}
		}
		public JPanel getPanel()
		{
			return panel_TestQuestions;
			
		}
		

	public void switch_screen(JPanel p, JLayeredPane lp, Test test, Student student, Connection con)
	{
		lp.removeAll();
		p.setLayout(null);
		lp.add(p);
		lp.repaint();
		lp.revalidate();
		

	}
	}
	
					
		
	
