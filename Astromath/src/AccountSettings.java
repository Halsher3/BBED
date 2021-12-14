import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.*;

public class AccountSettings extends JPanel 
{


	private JFrame frame;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int height = screenSize.height;
	private int width = screenSize.width;
	private JLabel label_name = new JLabel("Goku");
	private JLabel label_grade = new JLabel("1st Grade");
	
	private JPanel panel_accSettings = new JPanel();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public AccountSettings(JLayeredPane lp, Test test, Student student, Connection con)
	{
		
				panel_accSettings.setBounds(0, 0, 1262, 681);
				panel_accSettings.setBackground(new Color(77,58,129));
				panel_accSettings.setLayout(null);
			
				
				JLabel imageHome = new JLabel("");
				imageHome.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						MainWindow panel_home = new MainWindow(lp, test, student, con);
						switch_screen(panel_home.getPanel(), lp, test, student, con);
					}
				});
				imageHome.setIcon(new ImageIcon(".\\assets\\images\\home.png"));
				imageHome.setBounds(40, 21, 64, 74);
				panel_accSettings.add(imageHome);
				// Placeholder variables to use for Student name and Student grade
			
				
				if(student.getGradeLevel() == 0) {
					label_grade = new JLabel("K");
					label_grade.setHorizontalAlignment(SwingConstants.RIGHT);
					label_grade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
					label_grade.setForeground(new Color(0, 195, 255));
					label_grade.setBounds(874, 59, 308, 44);
					panel_accSettings.add(label_grade);
					
				} else {
				label_grade = new JLabel(String.format("Grade: %d", student.getGradeLevel()));
				label_grade.setHorizontalAlignment(SwingConstants.RIGHT);
				label_grade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
				label_grade.setForeground(new Color(0, 195, 255));
				label_grade.setBounds(874, 59, 308, 44);
				panel_accSettings.add(label_grade);
				}
				
				label_name = new JLabel(student.getName());
				label_name.setHorizontalAlignment(SwingConstants.RIGHT);
				label_name.setForeground(Color.WHITE);
				label_name.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
				label_name.setBounds(765, 21, 417, 44);
				panel_accSettings.add(label_name);
				
				
				// Code for the logo in the upper left corner and Astromath text
				
				JLabel labelLogo = new JLabel("ASTROMATH");
				
				labelLogo.setIcon(null);
				labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
				labelLogo.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
				labelLogo.setForeground(new Color(255, 255, 255));
				labelLogo.setBounds(97, 21, 318, 85);
				panel_accSettings.add(labelLogo);
				
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
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						MainWindow panel_home = new MainWindow(lp, test, student, con);
						switch_screen(panel_home.getPanel(), lp, test, student, con);
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
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						Login panel_login = new Login(lp, test, student, con);
						switch_screen(panel_login.getPanel(), lp, test, student, con);
					}
				});
				image_logout.setIcon(new ImageIcon(".\\assets\\images\\logout.png"));
				image_logout.setBounds(1192, 15, 72, 91);
				panel_accSettings.add(image_logout);
				
				JLabel imageSettings = new JLabel("");
				imageSettings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
				imageSettings.setBounds(1188, 99, 64, 64);
				panel_accSettings.add(imageSettings);
				
				JLabel accountSettings = new JLabel("Account Settings");
				accountSettings.setForeground(new Color(0, 195, 255));
				accountSettings.setFont(new Font("a Atmospheric", Font.PLAIN, 30));
				accountSettings.setBounds(68, 77, 782, 96);
				panel_accSettings.add(accountSettings);
				
				JLabel changePassword = new JLabel("Change Password");
				changePassword.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
				changePassword.setForeground(Color.WHITE);
				changePassword.setBounds(97, 184, 533, 119);
				panel_accSettings.add(changePassword);
				
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
					@Override
					public void mouseClicked(MouseEvent e) {
						PasswordChange panel_home = new PasswordChange(lp, test, student, con);
						switch_screen(panel_home.getPanel(), lp, test, student, con);
					}
		        });
				
				JLabel changeEmail = new JLabel("Change Email Address");
				changeEmail.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
				changeEmail.setForeground(Color.WHITE);
				changeEmail.setBounds(97, 314, 533, 110);
				panel_accSettings.add(changeEmail);
				
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
					@Override
					public void mouseClicked(MouseEvent e) {
						EmailChange panel_home = new EmailChange(lp, test, student, con);
						switch_screen(panel_home.getPanel(), lp, test, student, con);
					}
		        });
				
				JLabel changeUsername = new JLabel("Change Username");
				changeUsername.setForeground(Color.WHITE);
				changeUsername.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
				changeUsername.setBounds(97, 435, 376, 96);
				panel_accSettings.add(changeUsername);
				
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
					@Override
					public void mouseClicked(MouseEvent e) {
						UsernameChange panel_home = new UsernameChange(lp, test, student, con);
						switch_screen(panel_home.getPanel(), lp, test, student, con);
					}
		        });
				
				
				JLabel label = new JLabel("New label");
				label.setBounds(1193, 670, -432, -417);
				panel_accSettings.add(label);
				
				JLabel astronaut = new JLabel("");
				astronaut.setIcon(new ImageIcon(".\\assets\\images\\astronaut.png"));
				astronaut.setBounds(552, 99, 609, 679);
				panel_accSettings.add(astronaut);

	}

	public JPanel getPanel()
	{
		return panel_accSettings;
		
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
