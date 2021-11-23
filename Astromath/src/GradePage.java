import java.awt.Color;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class GradePage {

	private JFrame frame;
	private JLabel labelName = new JLabel("Goku");
	private JLabel labelGrade = new JLabel("1st Grade");
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int height = screenSize.height;
	private int width = screenSize.width;


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
		frame.getContentPane().setBackground(new Color(77,58,129));
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int x = ((width / 2) - (width / 3));
		int y = ((height / 2) - (height / 3));
		
		frame.setLocation(x, y);
		
		JLabel imageHome = new JLabel("");
		imageHome.setBounds(40, 21, 64, 74);
		imageHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainWindow mw = new MainWindow();
				frame.dispose();
			}
		});
		frame.getContentPane().setLayout(null);
		imageHome.setIcon(new ImageIcon(".\\assets\\images\\home.png"));
		frame.getContentPane().add(imageHome);
		// Placeholder variables to use for Student name and Student grade
		

		
		
		labelGrade.setBounds(874, 59, 308, 44);
		labelGrade.setHorizontalAlignment(SwingConstants.RIGHT);
		labelGrade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
		labelGrade.setForeground(new Color(0, 195, 255));
		frame.getContentPane().add(labelGrade);
		
		
	
		labelName.setBounds(765, 21, 417, 44);
		labelName.setHorizontalAlignment(SwingConstants.RIGHT);
		labelName.setForeground(Color.WHITE);
		labelName.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
		frame.getContentPane().add(labelName);
		
		
		// Code for the logo in the upper left corner and Astromath text
		
		JLabel labelLogo = new JLabel("ASTROMATH");
		labelLogo.setBounds(97, 21, 318, 85);
		
		labelLogo.setIcon(null);
		labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
		labelLogo.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
		labelLogo.setForeground(new Color(255, 255, 255));
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
			public void mouseClicked(MouseEvent e) 
			{
				MainWindow home = new MainWindow();
				frame.dispose();
			}
		});
		
		// The Welcome back message given when a student logs in, add in boolean to get rid of "Welcome back," and just leave in the name later
		

		
		// Logout button
		
		JLabel imageLogout = new JLabel("");
		imageLogout.setBounds(1192, 15, 72, 91);
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
		frame.getContentPane().add(imageLogout);
		
		JLabel imageSettings = new JLabel("");
		imageSettings.setBounds(1188, 99, 64, 64);
		imageSettings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
		frame.getContentPane().add(imageSettings);
		
		JLabel lblNewLabel = new JLabel("Grades - 1st Grade");
		lblNewLabel.setBounds(82, 89, 782, 96);
		lblNewLabel.setForeground(new Color(0, 195, 255));
		lblNewLabel.setFont(new Font("a Atmospheric", Font.PLAIN, 30));
		frame.getContentPane().add(lblNewLabel);
		
		//background for the grades
		
		JPanel panel = new JPanel();
		panel.setBounds(42, 220, 1140, 430);
		panel.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
		panel.setBackground(new Color(26, 38, 83));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Addition Test within 20");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(37, 25, 458, 93);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Subtraction Test within 20");
		lblNewLabel_2.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(37, 157, 580, 93);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Word Problem Test");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
		lblNewLabel_3.setBounds(37, 291, 487, 93);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Grade: ");
		lblNewLabel_4.setForeground(new Color(0, 255, 153));
		lblNewLabel_4.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
		lblNewLabel_4.setBounds(740, 31, 355, 87);
		lblNewLabel_4.setBackground(new Color(0, 255, 153));
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Grade:");
		lblNewLabel_5.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
		lblNewLabel_5.setForeground(new Color(0, 255, 153));
		lblNewLabel_5.setBounds(740, 160, 355, 87);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Grade:");
		lblNewLabel_6.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
		lblNewLabel_6.setForeground(new Color(0, 255, 153));
		lblNewLabel_6.setBounds(740, 302, 183, 70);
		panel.add(lblNewLabel_6);
		
		frame.setVisible(true);
	}
}
