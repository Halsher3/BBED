	import java.awt.EventQueue;
	import java.util.Random;
	
	import java.awt.Color;
	
	import java.awt.Font;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	
	import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.SwingConstants;
	import javax.swing.JTextPane;
	
	import javax.swing.JFrame;
	
	public class PracticeQuestions {
	
		private JFrame frame;
		public int questionsRight = 0;
		private int[] answerKey = new int[4];
		private int[] equation = new int[4];
		private int numOfQuestions;
		private String[] tofPhrase = new String[numOfQuestions];
	
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						PracticeQuestions window = new PracticeQuestions();
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
		public PracticeQuestions() {
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
					
					JLabel home = new JLabel("");
					home.setIcon(new ImageIcon(".\\assets\\images\\home.png"));
					home.setBounds(40, 21, 64, 74);
					frame.getContentPane().add(home);
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
						@Override
						public void mouseClicked(MouseEvent e) 
						{
							Visual vis = new Visual();
							frame.dispose();
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
					
					JLabel practiceProblems = new JLabel("Practice Problems");
					practiceProblems.setHorizontalAlignment(SwingConstants.CENTER);
					practiceProblems.setForeground(Color.WHITE);
					practiceProblems.setFont(new Font("A-Space Demo", Font.PLAIN, 40));
					practiceProblems.setBounds(475, 99, 530, 44);
					frame.getContentPane().add(practiceProblems);
					
	
					
	
					
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
						

						
						
						equation = mp.generateAddSub(1, 20, 0);
						
						
						
						int difficulty = 1;

						answerKey = MultipleChoice.generateQuestions(equation[3], 4, difficulty);
						//ANSWER KEY NUMBERS
						String answerKey0 = String.format("%d", answerKey[0]); 
						String answerKey1 = String.format("%d", answerKey[1]); 
						String answerKey2 = String.format("%d", answerKey[2]); 
						String answerKey3 = String.format("%d", answerKey[3]); 
						
						JButton mpAnswer1 = new JButton(answerKey0);
						mpAnswer1.setForeground(Color.WHITE);
						mpAnswer1.setFont(new Font("A-Space Demo", Font.PLAIN, 87));
						mpAnswer1.setBounds(55, 483, 186, 161);
						mpAnswer1.setBackground(new Color(0, 255, 153));
						frame.getContentPane().add(mpAnswer1);
						mpAnswer1.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) 
							{
								if(answerKey[0] == equation[3])
								{
									PracticeQuestions pq = new PracticeQuestions();
									frame.dispose();
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
						mpAnswer2.setBounds(301, 483, 191, 161);
						mpAnswer2.setBackground(new Color(0, 255, 153));
						frame.getContentPane().add(mpAnswer2);
						mpAnswer2.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) 
							{
								if(answerKey[1] == equation[3])
								{
									PracticeQuestions pq = new PracticeQuestions();
									frame.dispose();
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
						mpAnswer3.setBounds(633, 479, 197, 168);
						mpAnswer3.setBackground(new Color(0, 255, 153));
						frame.getContentPane().add(mpAnswer3);
						mpAnswer3.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) 
							{
								if(answerKey[2] == equation[3])
								{
									PracticeQuestions pq = new PracticeQuestions();
									frame.dispose();
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
						mpAnswer4.setBounds(981, 483, 186, 176);
						mpAnswer4.setBackground(new Color(0, 255, 153));
						frame.getContentPane().add(mpAnswer4);
						mpAnswer4.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) 
							{
								if(answerKey[3] == equation[3])
								{
									PracticeQuestions pq = new PracticeQuestions();
									frame.dispose();
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
						mpEquation1.setBounds(50, 264, 197, 91);
						mpEquation1.setForeground(new Color(255, 255, 255));
						mpEquation1.setFont(new Font("A-Space Demo", Font.PLAIN, 60));
						frame.getContentPane().add(mpEquation1);
						
	
						
						JLabel mpEquation2 = new JLabel(equation2);
						mpEquation2.setForeground(new Color(255, 255, 255));
						mpEquation2.setFont(new Font("A-Space Demo", Font.PLAIN, 60));
						mpEquation2.setBounds(536, 264, 197, 91);
						frame.getContentPane().add(mpEquation2);
				
								
						JLabel mpEquation4 = new JLabel(" = " + equation3);
						mpEquation4.setForeground(new Color(255, 255, 255));
						mpEquation4.setFont(new Font("A-Space Demo", Font.PLAIN, 60));
						mpEquation4.setBounds(765, 256, 259, 113);
						frame.getContentPane().add(mpEquation4);
						
						
					
						//OPERAND PART
						String equation1;
						if (equation[1] == 0){
						
						equation1 = "+";
						}
						
						else {
							equation1 = "-";
						}
						JLabel mpEquation3 = new JLabel(equation1);
						mpEquation3.setForeground(new Color(255, 255, 255));
						mpEquation3.setFont(new Font("A-Space Demo", Font.PLAIN, 60));
						mpEquation3.setBounds(345, 264, 164, 85);
						frame.getContentPane().add(mpEquation3);
						break;
						
					
					case 1:
						TrueOrFalse tof = new TrueOrFalse(1, 2);
						int numOfQuestions = 2;
						

						
						
						tofPhrase = tof.generateToF(1);
						
						
						//EQUATION NUMBERS
						JLabel tofPhrase1 = new JLabel(tofPhrase[0]);
						tofPhrase1.setHorizontalAlignment(SwingConstants.CENTER);
						tofPhrase1.setForeground(new Color(255, 255, 255));
						tofPhrase1.setFont(new Font("A-Space Demo", Font.PLAIN, 30));
						tofPhrase1.setBounds(-50, 266,1400,200);
						frame.getContentPane().add(tofPhrase1);
						
						String trueButton = "True";
						
						JButton tofPhrase2 = new JButton(trueButton);
						tofPhrase2.setHorizontalAlignment(SwingConstants.CENTER);
						tofPhrase2.setForeground(new Color(255, 255, 255));
						tofPhrase2.setFont(new Font("A-Space Demo", Font.PLAIN, 45));
						tofPhrase2.setBounds(50, 500,200,200);
						tofPhrase2.setBackground(new Color(0, 255, 153));
						frame.getContentPane().add(tofPhrase2);
						tofPhrase2.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) 
							{
								if(tofPhrase[1].equals(trueButton))
								{
									PracticeQuestions pq = new PracticeQuestions();
									frame.dispose();
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
						tofPhrase3.setBounds(400, 500,200,200);
						tofPhrase3.setBackground(new Color(0, 255, 153));
						frame.getContentPane().add(tofPhrase3);
						tofPhrase3.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) 
							{
								if(tofPhrase[1].equals(falseButton))
								{
									PracticeQuestions pq = new PracticeQuestions();
									frame.dispose();
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
			
			String[] phrase1 = new String[2];
			
			
			phrase1 = fitb.generateFITB(1);
			
			
			
			
			//phase[0] is the statement, phrase[1] is the answer
	
		
			JLabel fitbPhrase1 = new JLabel(phrase1[0]);
			fitbPhrase1.setHorizontalAlignment(SwingConstants.CENTER);
			fitbPhrase1.setForeground(new Color(255, 255, 255));
			fitbPhrase1.setFont(new Font("A-Space Demo", Font.PLAIN, 30));
			fitbPhrase1.setBounds(-50, 266,1400,200);
			frame.getContentPane().add(fitbPhrase1);
			break;
		
			
						
		}
					
			frame.setVisible(true);
		}
	}
					
		
	
	
