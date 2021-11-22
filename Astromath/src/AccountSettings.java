import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AccountSettings {

	private JFrame frame;
	private JFrame frame_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountSettings window = new AccountSettings();
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
	public AccountSettings() {
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
		
		JLabel imageHome = new JLabel("");
		imageHome.setIcon(new ImageIcon(".\\assets\\images\\home.png"));
		imageHome.setBounds(40, 21, 64, 74);
		frame_1.getContentPane().add(imageHome);
		// Placeholder variables to use for Student name and Student grade
		
		String studentName = "Jack";
		String grade = "Grade 1";
		
		JLabel labelGrade = new JLabel(grade);
		labelGrade.setHorizontalAlignment(SwingConstants.RIGHT);
		labelGrade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
		labelGrade.setForeground(new Color(0, 195, 255));
		labelGrade.setBounds(874, 59, 308, 44);
		frame_1.getContentPane().add(labelGrade);
		
		
		JLabel labelName = new JLabel(studentName);
		labelName.setHorizontalAlignment(SwingConstants.RIGHT);
		labelName.setForeground(Color.WHITE);
		labelName.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
		labelName.setBounds(765, 21, 417, 44);
		frame_1.getContentPane().add(labelName);
		
		
		// Code for the logo in the upper left corner and Astromath text
		
		JLabel labelLogo = new JLabel("ASTROMATH");
		
		labelLogo.setIcon(null);
		labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
		labelLogo.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
		labelLogo.setForeground(new Color(255, 255, 255));
		labelLogo.setBounds(97, 21, 318, 85);
		frame_1.getContentPane().add(labelLogo);
		
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
		frame_1.getContentPane().add(imageLogout);
		
		JLabel imageSettings = new JLabel("");
		imageSettings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
		imageSettings.setBounds(1188, 99, 64, 64);
		frame_1.getContentPane().add(imageSettings);
		
		JLabel accountSettings = new JLabel("Account Settings");
		accountSettings.setForeground(Color.WHITE);
		accountSettings.setFont(new Font("A-Space Demo", Font.PLAIN, 40));
		accountSettings.setBounds(97, 89, 782, 96);
		frame_1.getContentPane().add(accountSettings);
		
		JLabel changePassword = new JLabel("Change Password");
		changePassword.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
		changePassword.setForeground(Color.WHITE);
		changePassword.setBounds(97, 285, 533, 119);
		frame_1.getContentPane().add(changePassword);
		
		changePassword.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e) 
            {
            	changePassword.setForeground(new Color(0, 195, 255));
            }
            @Override
            public void mouseExited(MouseEvent e) 
            {
            	changePassword.setForeground(Color.WHITE);
            }
        });
		
		JLabel changeEmail = new JLabel("Change Email Address");
		changeEmail.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
		changeEmail.setForeground(Color.WHITE);
		changeEmail.setBounds(97, 396, 533, 110);
		frame_1.getContentPane().add(changeEmail);
		
		changeEmail.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e) 
            {
            	changeEmail.setForeground(new Color(0, 195, 255));
            }
            @Override
            public void mouseExited(MouseEvent e) 
            {
            	changeEmail.setForeground(Color.WHITE);
            }
        });
		
		JLabel changeUsername = new JLabel("Change Username");
		changeUsername.setForeground(Color.WHITE);
		changeUsername.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
		changeUsername.setBounds(97, 519, 376, 96);
		frame_1.getContentPane().add(changeUsername);
		
		changeUsername.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e) 
            {
            	changeUsername.setForeground(new Color(0, 195, 255));
            }
            @Override
            public void mouseExited(MouseEvent e) 
            {
            	changeUsername.setForeground(Color.WHITE);
            }
        });
		
		JLabel verifyEmail = new JLabel("Verify Email Address");
		verifyEmail.setForeground(Color.WHITE);
		verifyEmail.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
		verifyEmail.setBounds(98, 206, 444, 64);
		frame_1.getContentPane().add(verifyEmail);
		
		verifyEmail.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e) 
            {
            	verifyEmail.setForeground(new Color(0, 195, 255));
            }
            @Override
            public void mouseExited(MouseEvent e) 
            {
            	verifyEmail.setForeground(Color.WHITE);
            }
        });
		
		JLabel label = new JLabel("New label");
		label.setBounds(1193, 670, -432, -417);
		frame_1.getContentPane().add(label);
		
		JLabel astronaut = new JLabel("");
		astronaut.setIcon(new ImageIcon("C:\\Users\\halsh\\Downloads\\BBED-main\\BBED-main\\Astromath\\Assets\\images\\astronaut.png"));
		astronaut.setBounds(552, 99, 609, 679);
		frame_1.getContentPane().add(astronaut);
	}

}
