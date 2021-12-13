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
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Profile extends JPanel 
{


	private JFrame frame;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int height = screenSize.height;
	private int width = screenSize.width;
	private JLabel labelName = new JLabel("Goku");
	private JLabel labelGrade = new JLabel("1st Grade");
	
	private JPanel panel_profile = new JPanel();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Profile(JLayeredPane lp, Test test, Student student, Connection con) 
	{
		
				panel_profile.setBounds(0, 0, 1262, 681);
				panel_profile.setBackground(new Color(77,58,129));
				panel_profile.setLayout(null);
			
				
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
				panel_profile.add(imageHome);
				// Placeholder variables to use for Student name and Student grade
			
				
				labelGrade.setHorizontalAlignment(SwingConstants.RIGHT);
				labelGrade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
				labelGrade.setForeground(new Color(0, 195, 255));
				labelGrade.setBounds(874, 59, 308, 44);
				panel_profile.add(labelGrade);
				
				
				labelName.setHorizontalAlignment(SwingConstants.RIGHT);
				labelName.setForeground(Color.WHITE);
				labelName.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
				labelName.setBounds(765, 21, 417, 44);
				panel_profile.add(labelName);
				
				
				// Code for the logo in the upper left corner and Astromath text
				
				JLabel labelLogo = new JLabel("ASTROMATH");
				
				labelLogo.setIcon(null);
				labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
				labelLogo.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
				labelLogo.setForeground(new Color(255, 255, 255));
				labelLogo.setBounds(97, 21, 318, 85);
				panel_profile.add(labelLogo);
				
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
				panel_profile.add(image_logout);
				
				JLabel imageSettings = new JLabel("");
				imageSettings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
				imageSettings.setBounds(1188, 99, 64, 64);
				panel_profile.add(imageSettings);
				
				JLabel accountSettings = new JLabel("Profile");
				accountSettings.setForeground(new Color(0, 195, 255));
				accountSettings.setFont(new Font("a Atmospheric", Font.PLAIN, 30));
				accountSettings.setBounds(68, 77, 782, 96);
				panel_profile.add(accountSettings);
				
			
				
				JLabel image_pfp = new JLabel("");
				image_pfp.setIcon(new ImageIcon("C:\\Users\\Ru\\eclipse-workspace\\Astromath\\Assets\\images\\pfp3.png"));
				image_pfp.setBounds(110, 161, 88, 83);
				panel_profile.add(image_pfp);
				
				JLabel label_nameGrade = new JLabel("Goku, Grade 1");
				label_nameGrade.setFont(new Font("A-Space Demo", Font.PLAIN, 38));
				label_nameGrade.setForeground(Color.WHITE);
				label_nameGrade.setBounds(227, 152, 336, 45);
				panel_profile.add(label_nameGrade);
				
				JLabel label_level = new JLabel("Level 4");
				label_level.setForeground(Color.WHITE);
				label_level.setFont(new Font("A-Space Demo", Font.PLAIN, 30));
				label_level.setBounds(227, 208, 262, 36);
				panel_profile.add(label_level);
				
				JLabel label_aboutMe = new JLabel("About Me:");
				label_aboutMe.setForeground(Color.WHITE);
				label_aboutMe.setFont(new Font("A-Space Demo", Font.PLAIN, 38));
				label_aboutMe.setBounds(97, 282, 336, 45);
				panel_profile.add(label_aboutMe);
				
				JTextArea aboutContent = new JTextArea();
				aboutContent.setEditable(false);
				aboutContent.setLineWrap(true);
				aboutContent.setText("hi my name goku im 7 i like dragon ball and bakugan");
				aboutContent.setForeground(Color.WHITE);
				aboutContent.setFont(new Font("A-Space Demo", Font.PLAIN, 20));
				aboutContent.setBackground(new Color(26, 38, 83));
				aboutContent.setBounds(97, 338, 592, 265);
				aboutContent.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
				panel_profile.add(aboutContent);
				
				JLabel image_astro = new JLabel("");
				image_astro.setIcon(new ImageIcon("C:\\Users\\Ru\\eclipse-workspace\\Astromath\\Assets\\images\\astro.png"));
				image_astro.setBounds(744, 118, 400, 475);
				panel_profile.add(image_astro);
				
				JLabel image_pencil = new JLabel("");
				image_pencil.setIcon(new ImageIcon("C:\\Users\\Ru\\eclipse-workspace\\Astromath\\Assets\\images\\profile pencil.png"));
				image_pencil.setBounds(889, 604, 64, 64);
				panel_profile.add(image_pencil);
				
				JLabel label_edit = new JLabel("Edit Profile?");
				label_edit.setForeground(Color.WHITE);
				label_edit.setFont(new Font("A-Space Demo", Font.PLAIN, 34));
				label_edit.setBounds(963, 613, 275, 45);
				panel_profile.add(label_edit);
				
				label_edit.addMouseListener(new MouseAdapter() 
				{
					@Override
					public void mouseEntered(MouseEvent e) 
					{
						label_edit.setForeground(new Color(0, 195, 255));
					}
					@Override
					public void mouseExited(MouseEvent e) 
					{
						label_edit.setForeground(Color.WHITE);
					}
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						//ProfileSettings panel_profileSet = new ProfileSettings(lp, test);
						//switch_screen(panel_profileSet.getPanel(), lp);
					}
				});

	}

	public JPanel getPanel()
	{
		return panel_profile;
		
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
