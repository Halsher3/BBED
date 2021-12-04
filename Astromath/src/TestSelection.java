import java.awt.Color;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JLabel labelName = new JLabel("Goku");
	private JLabel labelGrade = new JLabel("1st Grade");

	private JPanel panel_testSelect = new JPanel();


	
	public TestSelection(JLayeredPane lp) 
	{

		panel_testSelect.setBounds(0, 0, 1262, 681);
		panel_testSelect.setBackground(new Color(77,58,129));
		panel_testSelect.setLayout(null);
		
		
		JLabel image_home = new JLabel("");
		image_home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 
				MainWindow panel_home = new MainWindow(lp);
				switch_screen(panel_home.getPanel(), lp);
			}
		});
		image_home.setIcon(new ImageIcon(".\\assets\\images\\home.png"));
		image_home.setBounds(40, 21, 64, 74);
		frame.getContentPane().add(image_home);
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
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				MainWindow panel_home = new MainWindow(lp);
				switch_screen(panel_home.getPanel(), lp);
			}
		});
		
		// The Welcome back message given when a student logs in, add in boolean to get rid of "Welcome back," and just leave in the name later
		
		labelName.setHorizontalAlignment(SwingConstants.RIGHT);
		labelName.setForeground(Color.WHITE);
		labelName.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
		labelName.setBounds(765, 21, 417, 44);
		frame.getContentPane().add(labelName);
		
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
				Login panel_login = new Login(lp);
				switch_screen(panel_login.getPanel(), lp);
			}
		});
		image_logout.setIcon(new ImageIcon(".\\assets\\images\\logout.png"));
		image_logout.setBounds(1192, 15, 72, 91);
		frame.getContentPane().add(image_logout);
		
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
		frame.getContentPane().add(image_settings);
		
		//Test Selection options
		
		JLabel grade1Tests = new JLabel("Grade 1 Tests");
		grade1Tests.setHorizontalAlignment(SwingConstants.CENTER);
		grade1Tests.setForeground(new Color(0, 195, 255));
		grade1Tests.setFont(new Font("a Atmospheric", Font.PLAIN, 30));
		grade1Tests.setBounds(10, 99, 417, 44);
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
	}

	public JPanel getPanel()
	{
		return panel_testSelect;
		
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
