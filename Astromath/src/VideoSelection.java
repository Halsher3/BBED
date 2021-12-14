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

public class VideoSelection extends JPanel {

	private JFrame frame;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int height = screenSize.height;
	private int width = screenSize.width;
	private JLabel label_name = new JLabel("");
	private JLabel label_grade = new JLabel("");

	private JPanel panel_vidSelect = new JPanel();



	
	public VideoSelection(JLayeredPane lp, Test test, Student student, Connection con) 
	{

		panel_vidSelect.setBounds(0, 0, 1262, 681);
		panel_vidSelect.setBackground(new Color(77,58,129));
		panel_vidSelect.setLayout(null);
		
		
		JLabel image_home = new JLabel("");
		image_home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 
				MainWindow panel_home = new MainWindow(lp, test, student, con);
				switch_screen(panel_home.getPanel(), lp, test, student, con);
			}
		});
		image_home.setIcon(new ImageIcon(".\\assets\\images\\home.png"));
		image_home.setBounds(40, 21, 64, 74);
		panel_vidSelect.add(image_home);
		// Placeholder variables to use for Student name and Student grade
		
		// Code for the logo in the upper left corner and Astromath text
		
		JLabel astromath = new JLabel("ASTROMATH");
		
		astromath.setIcon(null);
		astromath.setHorizontalAlignment(SwingConstants.CENTER);
		astromath.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
		astromath.setForeground(new Color(255, 255, 255));
		astromath.setBounds(97, 21, 318, 85);
		panel_vidSelect.add(astromath);
		
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
				switch_screen(panel_home.getPanel(), lp, test, student, con);
			}
		});
		
		// The Welcome back message given when a student logs in, add in boolean to get rid of "Welcome back," and just leave in the name later
		
		label_name = new JLabel(student.getName());
		label_name.setHorizontalAlignment(SwingConstants.RIGHT);
		label_name.setForeground(Color.WHITE);
		label_name.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
		label_name.setBounds(765, 21, 417, 44);
		panel_vidSelect.add(label_name);
		
		if(student.getGradeLevel() == 0) {
			label_grade = new JLabel("K");
			label_grade.setHorizontalAlignment(SwingConstants.RIGHT);
			label_grade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
			label_grade.setForeground(new Color(0, 195, 255));
			label_grade.setBounds(874, 59, 308, 44);
			panel_vidSelect.add(label_grade);
			
		} else {
		label_grade = new JLabel(String.format("Grade: %d", student.getGradeLevel()));
		label_grade.setHorizontalAlignment(SwingConstants.RIGHT);
		label_grade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
		label_grade.setForeground(new Color(0, 195, 255));
		label_grade.setBounds(874, 59, 308, 44);
		panel_vidSelect.add(label_grade);
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
				switch_screen(panel_login.getPanel(), lp, test, student, con);
			}
		});
		image_logout.setIcon(new ImageIcon(".\\assets\\images\\logout.png"));
		image_logout.setBounds(1192, 15, 72, 91);
		panel_vidSelect.add(image_logout);
		
		JLabel image_settings = new JLabel("");
		image_settings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccountSettings panel_acc= new AccountSettings(lp, test, student, con);
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
		panel_vidSelect.add(image_settings);
		
		//Video Selection options
		
		if(student.getGradeLevel() == 0) {
		JLabel grade1Tests = new JLabel("Kindergarten Videos");
		grade1Tests.setHorizontalAlignment(SwingConstants.CENTER);
		grade1Tests.setForeground(new Color(0, 195, 255));
		grade1Tests.setFont(new Font("a Atmospheric", Font.PLAIN, 30));
		grade1Tests.setBounds(10, 99, 717, 44);
		panel_vidSelect.add(grade1Tests);
		} else { 
			JLabel grade1Tests = new JLabel(String.format("Grade %d Videos",student.getGradeLevel()));
			grade1Tests.setHorizontalAlignment(SwingConstants.CENTER);
			grade1Tests.setForeground(new Color(0, 195, 255));
			grade1Tests.setFont(new Font("a Atmospheric", Font.PLAIN, 30));
			grade1Tests.setBounds(10, 99, 417, 44);
			panel_vidSelect.add(grade1Tests);
		}
		
		if(student.getGradeLevel() >= 3) {
			JLabel additionVideo = new JLabel("Multiplication Video");
			additionVideo.setBackground(new Color(0, 0, 153));
			additionVideo.setHorizontalAlignment(SwingConstants.CENTER);
			additionVideo.setForeground(Color.WHITE);
			additionVideo.setFont(new Font("A-Space Demo", Font.PLAIN, 40));
			additionVideo.setBounds(189, 171, 925, 44);
			panel_vidSelect.add(additionVideo);
			
			additionVideo.addMouseListener(new MouseAdapter() 
			{
				@Override
				public void mouseClicked(MouseEvent e) {
					test.setCurrentTest(additionVideo.getText());
					LearnVideoWindow panel_learnVid = new LearnVideoWindow(lp, test, student, con);
					switch_screen(panel_learnVid.getPanel(), lp, test, student, con);
				}
				@Override
				public void mouseEntered(MouseEvent e) 
				{
					additionVideo.setForeground(new Color(0, 195, 255));
				}
				@Override
				public void mouseExited(MouseEvent e) 
				{
					additionVideo.setForeground(Color.WHITE);
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
			panel_vidSelect.add(editorPane);
			
			JLabel subtractionVideo = new JLabel("Division Video");
			subtractionVideo.setHorizontalAlignment(SwingConstants.CENTER);
			subtractionVideo.setForeground(Color.WHITE);
			subtractionVideo.setFont(new Font("A-Space Demo", Font.PLAIN, 38));
			subtractionVideo.setBackground(new Color(0, 0, 153));
			subtractionVideo.setBounds(189, 263, 925, 44);
			panel_vidSelect.add(subtractionVideo);
			
			subtractionVideo.addMouseListener(new MouseAdapter() 
			{
				@Override
				public void mouseClicked(MouseEvent e) {
					test.setCurrentTest(subtractionVideo.getText());
					LearnVideoWindow panel_learnVid = new LearnVideoWindow(lp, test, student, con);
					switch_screen(panel_learnVid.getPanel(), lp, test, student, con);
				}
				@Override
				public void mouseEntered(MouseEvent e) 
				{
					subtractionVideo.setForeground(new Color(0, 195, 255));
				}
				@Override
				public void mouseExited(MouseEvent e) 
				{
					subtractionVideo.setForeground(Color.WHITE);
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
			panel_vidSelect.add(editorPane_1);
			
		}
		JLabel additionVideo = new JLabel("Addition Video");
		additionVideo.setBackground(new Color(0, 0, 153));
		additionVideo.setHorizontalAlignment(SwingConstants.CENTER);
		additionVideo.setForeground(Color.WHITE);
		additionVideo.setFont(new Font("A-Space Demo", Font.PLAIN, 40));
		additionVideo.setBounds(189, 171, 925, 44);
		panel_vidSelect.add(additionVideo);
		
		additionVideo.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				test.setCurrentTest(additionVideo.getText());
				LearnVideoWindow panel_learnVid = new LearnVideoWindow(lp, test, student, con);
				switch_screen(panel_learnVid.getPanel(), lp, test, student, con);
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				additionVideo.setForeground(new Color(0, 195, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				additionVideo.setForeground(Color.WHITE);
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
		panel_vidSelect.add(editorPane);
		
		JLabel subtractionVideo = new JLabel("Subtraction Video");
		subtractionVideo.setHorizontalAlignment(SwingConstants.CENTER);
		subtractionVideo.setForeground(Color.WHITE);
		subtractionVideo.setFont(new Font("A-Space Demo", Font.PLAIN, 38));
		subtractionVideo.setBackground(new Color(0, 0, 153));
		subtractionVideo.setBounds(189, 263, 925, 44);
		panel_vidSelect.add(subtractionVideo);
		
		subtractionVideo.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				test.setCurrentTest(subtractionVideo.getText());
				LearnVideoWindow panel_learnVid = new LearnVideoWindow(lp, test, student, con);
				switch_screen(panel_learnVid.getPanel(), lp, test, student, con);
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				subtractionVideo.setForeground(new Color(0, 195, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				subtractionVideo.setForeground(Color.WHITE);
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
		
		
		JLabel option3 = new JLabel("Counting to 10");
		option3.setHorizontalAlignment(SwingConstants.CENTER);
		option3.setForeground(Color.WHITE);
		option3.setFont(new Font("A-Space Demo", Font.PLAIN, 40));
		option3.setBackground(new Color(0, 0, 153));
		option3.setBounds(189, 354, 925, 44);
		
		
		option3.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				test.setCurrentTest(option3.getText());
				LearnVideoWindow panel_learnVid = new LearnVideoWindow(lp, test, student, con);
				switch_screen(panel_learnVid.getPanel(), lp, test, student, con);
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				option3.setForeground(new Color(0, 195, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				option3.setForeground(Color.WHITE);
			}
		});
		
		JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setBackground(new Color(23, 38, 83));
		editorPane_2.setBounds(175, 343, 953, 74);
		
		
		JLabel option4 = new JLabel("");
		option4.setHorizontalAlignment(SwingConstants.CENTER);
		option4.setForeground(Color.WHITE);
		option4.setFont(new Font("A-Space Demo", Font.PLAIN, 38));
		option4.setBackground(new Color(0, 0, 153));
		option4.setBounds(189, 456, 925, 44);
		option4.setVisible(false);
		
		
		option4.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				test.setCurrentTest(option4.getText());
				LearnVideoWindow panel_learnVid = new LearnVideoWindow(lp, test, student, con);
				switch_screen(panel_learnVid.getPanel(), lp, test, student, con);
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				option4.setForeground(new Color(0, 195, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				option4.setForeground(Color.WHITE);
			}
			});
		
		
		
		
		
		switch(student.getGradeLevel())
		{
			case 0:
				
				break;	
				
				case 1:
				
				option3.setText("Word Problem Comparison to 20");	
				
				option4.setVisible(false);
					
				break;
				
				case 2:
					
				option3.setText("Money Word Problems");	
				option4.setVisible(false);
				
				break;
				
				case 3:
				
				option3.setText("Unknowns in Multiplication");	
				option4.setVisible(false);	
					
				break;
				
				case 4:
					
				option3.setText("Decimals to Fractions");	
				option4.setVisible(false);
				break;
		}
		
		panel_vidSelect.add(editorPane_1);
		panel_vidSelect.add(option3);
		panel_vidSelect.add(editorPane_2);
		panel_vidSelect.add(option4);	
		
	
	

	}

	public JPanel getPanel()
	{
		return panel_vidSelect;
		
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
