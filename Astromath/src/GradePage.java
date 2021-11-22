import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GradePage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GradePage window = new GradePage();
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
	public GradePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setBackground(new Color(77,58,129));
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel imageHome = new JLabel("");
		imageHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainWindow mw = new MainWindow();
				frame.dispose();
			}
		});
		imageHome.setIcon(new ImageIcon(".\\assets\\images\\home.png"));
		imageHome.setBounds(40, 21, 64, 74);
		frame.getContentPane().add(imageHome);
		// Placeholder variables to use for Student name and Student grade
		
		String studentName = "Jack";
		String grade = "Grade 1";
		
		JLabel labelGrade = new JLabel(grade);
		labelGrade.setHorizontalAlignment(SwingConstants.RIGHT);
		labelGrade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
		labelGrade.setForeground(new Color(0, 195, 255));
		labelGrade.setBounds(874, 59, 308, 44);
		frame.getContentPane().add(labelGrade);
		
		
		JLabel labelName = new JLabel(studentName);
		labelName.setHorizontalAlignment(SwingConstants.RIGHT);
		labelName.setForeground(Color.WHITE);
		labelName.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
		labelName.setBounds(765, 21, 417, 44);
		frame.getContentPane().add(labelName);
		
		
		// Code for the logo in the upper left corner and Astromath text
		
		JLabel labelLogo = new JLabel("ASTROMATH");
		
		labelLogo.setIcon(null);
		labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
		labelLogo.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
		labelLogo.setForeground(new Color(255, 255, 255));
		labelLogo.setBounds(97, 21, 318, 85);
		frame.getContentPane().add(labelLogo);
		
		// Does a hover effect on the AstroMath text with the home button
		
		labelLogo.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				labelLogo.setForeground(new Color(0, 195, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				labelLogo.setForeground(Color.WHITE);
			}
		});
		
		// The Welcome back message given when a student logs in, add in boolean to get rid of "Welcome back," and just leave in the name later
		

		
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
		
		frame.setVisible(true);
	}

}
