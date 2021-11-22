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
		
		JLabel image_home = new JLabel("");
		image_home.setIcon(new ImageIcon(".\\assets\\images\\home.png"));
		image_home.setBounds(40, 21, 64, 74);
		frame_1.getContentPane().add(image_home);
		// Placeholder variables to use for Student name and Student grade
		
		String studentName = "Jack";
		String grade = "Grade 1";
		
		JLabel label_grade = new JLabel(grade);
		label_grade.setHorizontalAlignment(SwingConstants.RIGHT);
		label_grade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
		label_grade.setForeground(new Color(0, 195, 255));
		label_grade.setBounds(874, 59, 308, 44);
		frame_1.getContentPane().add(label_grade);
		
		
		JLabel label_name = new JLabel(studentName);
		label_name.setHorizontalAlignment(SwingConstants.RIGHT);
		label_name.setForeground(Color.WHITE);
		label_name.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
		label_name.setBounds(765, 21, 417, 44);
		frame_1.getContentPane().add(label_name);
		
		
		// Code for the logo in the upper left corner and Astromath text
		
		JLabel label_logo = new JLabel("ASTROMATH");
		
		label_logo.setIcon(null);
		label_logo.setHorizontalAlignment(SwingConstants.CENTER);
		label_logo.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
		label_logo.setForeground(new Color(255, 255, 255));
		label_logo.setBounds(97, 21, 318, 85);
		frame_1.getContentPane().add(label_logo);
		
		// Does a hover effect on the AstroMath text with the home button
		
		label_logo.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				label_logo.setForeground(new Color(0, 195, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				label_logo.setForeground(Color.WHITE);
			}
		});
		
		// The Welcome back message given when a student logs in, add in boolean to get rid of "Welcome back," and just leave in the name later
		

		
		// Logout button
		
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
		});
		image_logout.setIcon(new ImageIcon(".\\assets\\images\\logout.png"));
		image_logout.setBounds(1192, 15, 72, 91);
		frame_1.getContentPane().add(image_logout);
		
		JLabel image_settings = new JLabel("");
		image_settings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
		image_settings.setBounds(1188, 99, 64, 64);
		frame_1.getContentPane().add(image_settings);
		
		JLabel lblNewLabel = new JLabel("Account Settings");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("A-Space Demo", Font.PLAIN, 40));
		lblNewLabel.setBounds(97, 89, 782, 96);
		frame_1.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Change Password");
		lblNewLabel_1.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(97, 285, 533, 119);
		frame_1.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_1.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e) 
            {
            	lblNewLabel_1.setForeground(new Color(0, 195, 255));
            }
            @Override
            public void mouseExited(MouseEvent e) 
            {
            	lblNewLabel_1.setForeground(Color.WHITE);
            }
        });
		
		JLabel lblNewLabel_2 = new JLabel("Change Email Address");
		lblNewLabel_2.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(97, 396, 533, 110);
		frame_1.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_2.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e) 
            {
            	lblNewLabel_2.setForeground(new Color(0, 195, 255));
            }
            @Override
            public void mouseExited(MouseEvent e) 
            {
            	lblNewLabel_2.setForeground(Color.WHITE);
            }
        });
		
		JLabel lblNewLabel_3 = new JLabel("Change Username");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
		lblNewLabel_3.setBounds(97, 519, 376, 96);
		frame_1.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_3.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e) 
            {
            	lblNewLabel_3.setForeground(new Color(0, 195, 255));
            }
            @Override
            public void mouseExited(MouseEvent e) 
            {
            	lblNewLabel_3.setForeground(Color.WHITE);
            }
        });
		
		JLabel lblNewLabel_4 = new JLabel("Verify Email Address");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
		lblNewLabel_4.setBounds(98, 206, 444, 64);
		frame_1.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_4.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseEntered(MouseEvent e) 
            {
            	lblNewLabel_4.setForeground(new Color(0, 195, 255));
            }
            @Override
            public void mouseExited(MouseEvent e) 
            {
            	lblNewLabel_4.setForeground(Color.WHITE);
            }
        });
		
		JLabel label = new JLabel("New label");
		label.setBounds(1193, 670, -432, -417);
		frame_1.getContentPane().add(label);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\halsh\\Downloads\\BBED-main\\BBED-main\\Astromath\\Assets\\images\\astronaut.png"));
		lblNewLabel_5.setBounds(552, 99, 609, 679);
		frame_1.getContentPane().add(lblNewLabel_5);
	}

}
