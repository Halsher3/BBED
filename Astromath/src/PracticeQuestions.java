	import java.awt.EventQueue;
	import java.awt.*;
	import java.util.Random;
	
	import java.awt.Color;
	
	import java.awt.Font;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	
	import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
	import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
	
	import javax.swing.JFrame;
	
	public class PracticeQuestions {
	
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
		private JLabel labelName = new JLabel("Goku");
		private JLabel labelGrade = new JLabel("1st Grade");
		int difficulty = 0;

		private JPanel panel_practiceQuestions = new JPanel();
	
		
		/**
		 * Create the application.
		 */
		public PracticeQuestions(JLayeredPane lp) {
			panel_practiceQuestions.setBounds(0, 0, 1262, 681);
			panel_practiceQuestions.setBackground(new Color(77,58,129));
			panel_practiceQuestions.setLayout(null);
			
			JLabel home = new JLabel("");
			home.setIcon(new ImageIcon(".\\assets\\images\\home.png"));
			home.setBounds(40, 21, 64, 74);
			panel_practiceQuestions.add(home);
			// Placeholder variables to use for Student name and Student grade
			

			
			// Code for the logo in the upper left corner and Astromath text
			
			JLabel astromath = new JLabel("ASTROMATH");
			
			astromath.setIcon(null);
			astromath.setHorizontalAlignment(SwingConstants.CENTER);
			astromath.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
			astromath.setForeground(new Color(255, 255, 255));
			astromath.setBounds(97, 21, 318, 85);
			panel_practiceQuestions.add(astromath);
			
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
					MainWindow panel_home = new MainWindow(lp);
					switch_screen(panel_home.getPanel(), lp);

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

			

			 labelName.setHorizontalAlignment(SwingConstants.RIGHT);
			 labelName.setForeground(Color.WHITE);
			 labelName.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
			 labelName.setBounds(765, 21, 417, 44);
			panel_practiceQuestions.add(labelName);
			
			labelGrade.setHorizontalAlignment(SwingConstants.RIGHT);
			labelGrade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
			labelGrade.setForeground(new Color(0, 195, 255));
			labelGrade.setBounds(874, 59, 308, 44);
			panel_practiceQuestions.add(labelGrade);
			
			
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
					Login panel_login = new Login(lp);
					switch_screen(panel_login.getPanel(), lp);

				}
			});
			imageLogout.setIcon(new ImageIcon(".\\assets\\images\\logout.png"));
			imageLogout.setBounds(1192, 15, 72, 91);
			panel_practiceQuestions.add(imageLogout);
			
			JLabel image_settings = new JLabel("");
			image_settings.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					AccountSettings panel_acc = new AccountSettings(lp);
					switch_screen(panel_acc.getPanel(), lp);

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
			panel_practiceQuestions.add(image_settings);
			
			//TEST COMPONENTS
			
			JLabel practiceProblems = new JLabel("Practice Problems");
			practiceProblems.setHorizontalAlignment(SwingConstants.CENTER);
			practiceProblems.setForeground(new Color(0, 195, 255));
			practiceProblems.setFont(new Font("a Atmospheric", Font.PLAIN, 30));
			practiceProblems.setBounds(22, 94, 530, 44);
			panel_practiceQuestions.add(practiceProblems);
			

			

			
			//RANDOM EQUATION MAKER This accesses MultipleChoice.java
			Random rand = new Random(); 
			Boolean canRoll = true;
			int questionSelect = rand.nextInt(3);
			if(canRoll) {
				questionSelect = rand.nextInt(3);
			}
			
			
			switch(questionSelect) {
			case 0: 
				MultipleChoice mp = new MultipleChoice(1, 4);
				

				
				
				equation = mp.generateEquation(3, 4, 1);
				
				
				
				answerKey = MultipleChoice.generateQuestions(3, equation[3], 4);
				//ANSWER KEY NUMBERS
				String answerKey0 = String.format("%d", answerKey[0]); 
				String answerKey1 = String.format("%d", answerKey[1]); 
				String answerKey2 = String.format("%d", answerKey[2]); 
				String answerKey3 = String.format("%d", answerKey[3]); 
				
				JButton mpAnswer1 = new JButton(answerKey0);
				mpAnswer1.setForeground(Color.WHITE);
				mpAnswer1.setFont(new Font("A-Space Demo", Font.PLAIN, 87));
				mpAnswer1.setBounds(50, 460, 200, 200);
				mpAnswer1.setBackground(new Color(0, 255, 153));
				panel_practiceQuestions.add(mpAnswer1);
				mpAnswer1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						if(answerKey[0] == equation[3])
						{
							PracticeQuestions panel_question = new PracticeQuestions(lp);
							switch_screen(panel_question.getPanel(), lp);

						}
						else
						{
							mpAnswer1.setVisible(false);
							
						}
					}
				});
				
				JButton mpAnswer2 = new JButton(answerKey1);
				mpAnswer2.setFont(new Font("A-Space Demo", Font.PLAIN, 87));
				mpAnswer2.setForeground(Color.WHITE);
				mpAnswer2.setBounds(350, 460, 200, 200);
				mpAnswer2.setBackground(new Color(0, 255, 153));
				panel_practiceQuestions.add(mpAnswer2);
				mpAnswer2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						if(answerKey[1] == equation[3])
						{
							PracticeQuestions panel_question = new PracticeQuestions(lp);
							switch_screen(panel_question.getPanel(), lp);
						}
						else
						{
							mpAnswer2.setVisible(false);
							
						}
					}
				});
				
				JButton mpAnswer3 = new JButton(answerKey2);
				mpAnswer3.setForeground(Color.WHITE);
				mpAnswer3.setFont(new Font("A-Space Demo", Font.PLAIN, 78));
				mpAnswer3.setBounds(650, 460, 200, 200);
				mpAnswer3.setBackground(new Color(0, 255, 153));
				panel_practiceQuestions.add(mpAnswer3);
				mpAnswer3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						if(answerKey[2] == equation[3])
						{
							PracticeQuestions panel_question = new PracticeQuestions(lp);
							switch_screen(panel_question.getPanel(), lp);
						}
						else
						{
							mpAnswer3.setVisible(false);
							
						}
					}
				});
				
				JButton mpAnswer4 = new JButton(answerKey3);
				mpAnswer4.setForeground(Color.WHITE);
				mpAnswer4.setFont(new Font("A-Space Demo", Font.PLAIN, 87));
				mpAnswer4.setBounds(950, 460, 200, 200);
				mpAnswer4.setBackground(new Color(0, 255, 153));
				panel_practiceQuestions.add(mpAnswer4);
				mpAnswer4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						if(answerKey[3] == equation[3])
						{
							PracticeQuestions panel_question = new PracticeQuestions(lp);
							switch_screen(panel_question.getPanel(), lp);
						}
						else
						{
							mpAnswer4.setVisible(false);
							
						}
					}
				});
				
				//EQUATION NUMBERS
				String equation0 = String.format("%d", equation[0]);

				String equation2 = String.format("%d", equation[2]);
				String equation3 = String.format("%d", equation[3]);
			
				JLabel mpEquation1 = new JLabel(equation0);
				mpEquation1.setHorizontalAlignment(SwingConstants.CENTER);
				mpEquation1.setBounds(350, 260, 197, 91);
				mpEquation1.setForeground(new Color(255, 255, 255));
				mpEquation1.setFont(new Font("A-Space Demo", Font.PLAIN, 60));
				panel_practiceQuestions.add(mpEquation1);
				

				
				JLabel mpEquation2 = new JLabel(equation2);
				mpEquation2.setForeground(new Color(255, 255, 255));
				mpEquation2.setFont(new Font("A-Space Demo", Font.PLAIN, 60));
				mpEquation2.setBounds(750, 260, 197, 91);
				panel_practiceQuestions.add(mpEquation2);
		
					
				JLabel mpEquation4 = new JLabel("");
				mpEquation4.setForeground(new Color(255, 255, 255));
				mpEquation4.setFont(new Font("A-Space Demo", Font.PLAIN, 60));
				mpEquation4.setBounds(950, 260, 197, 91);
				panel_practiceQuestions.add(mpEquation4);
				
				
				
			
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
					equation1 = "÷";
				}
				JLabel mpEquation3 = new JLabel(equation1);
				mpEquation3.setForeground(new Color(255, 255, 255));
				mpEquation3.setFont(new Font("A-Space Demo", Font.PLAIN, 60));
				mpEquation3.setBounds(590, 260, 197, 91);
				panel_practiceQuestions.add(mpEquation3);
				break;
				
			
			case 1:
				TrueOrFalse tof = new TrueOrFalse(1, 2);
				int numOfQuestions = 2;
				

				
				
				tofPhrase = tof.generateToF(3);
				
				
				//EQUATION NUMBERS
				JLabel tofPhrase1 = new JLabel(tofPhrase[0]);
				tofPhrase1.setHorizontalAlignment(SwingConstants.CENTER);
				tofPhrase1.setForeground(new Color(255, 255, 255));
				tofPhrase1.setFont(new Font("A-Space Demo", Font.PLAIN, 10));
				tofPhrase1.setBounds(-50, 266,1400,200);
				panel_practiceQuestions.add(tofPhrase1);
				
				String trueButton = "True";
				
				JButton tofPhrase2 = new JButton(trueButton);
				tofPhrase2.setHorizontalAlignment(SwingConstants.CENTER);
				tofPhrase2.setForeground(new Color(255, 255, 255));
				tofPhrase2.setFont(new Font("A-Space Demo", Font.PLAIN, 45));
				tofPhrase2.setBounds(350, 460, 200, 200);
				tofPhrase2.setBackground(new Color(0, 255, 153));
				panel_practiceQuestions.add(tofPhrase2);
				tofPhrase2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						if(tofPhrase[1].equals(trueButton))
						{
							PracticeQuestions panel_question = new PracticeQuestions(lp);
							switch_screen(panel_question.getPanel(), lp);
						}
						else
						{
							tofPhrase2.setVisible(false);
							
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
				panel_practiceQuestions.add(tofPhrase3);
				tofPhrase3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						if(tofPhrase[1].equals(falseButton))
						{
							PracticeQuestions panel_question = new PracticeQuestions(lp);
							switch_screen(panel_question.getPanel(), lp);
						}
						else
						{
							tofPhrase3.setVisible(false);
							
						}
					}
				});
				
				break;
				

case 2:
	
	FillInTheBlank fitb = new FillInTheBlank(1, 4);
	
	
	
	phrase1 = fitb.generateFITB(3);
	
	
	
	
	//phase[0] is the statement, phrase[1] is the answer


	JLabel fitbPhrase1 = new JLabel(phrase1[0]);
	fitbPhrase1.setHorizontalAlignment(SwingConstants.CENTER);
	fitbPhrase1.setForeground(new Color(255, 255, 255));
	fitbPhrase1.setFont(new Font("A-Space Demo", Font.PLAIN, 30));
	fitbPhrase1.setBounds(-50, 266,1400,200);
	panel_practiceQuestions.add(fitbPhrase1);
	
	textAnswer = new JTextField();
	textAnswer.setFont(new Font("A-Space Demo", Font.PLAIN, 42));
	textAnswer.setForeground(Color.WHITE);
	textAnswer.setBackground(new Color(26, 38, 83));
	textAnswer.setBounds(372, 450, 589, 106);
	textAnswer.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
	panel_practiceQuestions.add(textAnswer);
	textAnswer.setColumns(10);
	
	JButton lblNewLabel_1 = new JButton("Submit");
	lblNewLabel_1.setBackground(new Color(26, 38, 83));
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
	lblNewLabel_1.setForeground(new Color(127, 255, 212));
	lblNewLabel_1.setBounds(964, 602, 288, 68);
	panel_practiceQuestions.add(lblNewLabel_1);
	
	lblNewLabel_1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			if(textAnswer.getText().equals(phrase1[1]))
			{
				PracticeQuestions panel_question = new PracticeQuestions(lp);
				switch_screen(panel_question.getPanel(), lp);
			}
			else
			{
				/*
				labelIncorrect.setVisible(true);
				*/
			}
		}
	});
	
	break;
	
	


}

						
		}
		public JPanel getPanel()
		{
			return panel_practiceQuestions;
			
		}

public void switch_screen(JPanel p, JLayeredPane lp)
	{
		lp.removeAll();
		p.setLayout(null);
		lp.add(p);
		lp.repaint();
		lp.revalidate();
		

	}
	
	
	}
					
		
	