import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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

public class ProfileSettings extends JPanel 
{


	private JFrame frame;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int height = screenSize.height;
	private int width = screenSize.width;
	private JLabel label_name = new JLabel("");
	private JLabel label_grade = new JLabel("");
	
	private JPanel panel_profileSettings = new JPanel();
	private JTextField textbox_state;
	private JTextField textfield_aboutMe;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public ProfileSettings(JLayeredPane lp, Test test, Student student, Connection con) 
	{
		
				panel_profileSettings.setBounds(0, 0, 1262, 681);
				panel_profileSettings.setBackground(new Color(77,58,129));
				panel_profileSettings.setLayout(null);
			
				
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
				panel_profileSettings.add(imageHome);
				// Placeholder variables to use for Student name and Student grade
			
				
				if(student.getGradeLevel() == 0) {
					label_grade = new JLabel("K");
					label_grade.setHorizontalAlignment(SwingConstants.RIGHT);
					label_grade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
					label_grade.setForeground(new Color(0, 195, 255));
					label_grade.setBounds(874, 59, 308, 44);
					panel_profileSettings.add(label_grade);
					
				} else {
				label_grade = new JLabel(String.format("Grade: %d", student.getGradeLevel()));
				label_grade.setHorizontalAlignment(SwingConstants.RIGHT);
				label_grade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
				label_grade.setForeground(new Color(0, 195, 255));
				label_grade.setBounds(874, 59, 308, 44);
				panel_profileSettings.add(label_grade);
				}
				
				
				label_name = new JLabel(student.getName());
				label_name.setHorizontalAlignment(SwingConstants.RIGHT);
				label_name.setForeground(Color.WHITE);
				label_name.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
				label_name.setBounds(765, 21, 417, 44);
				panel_profileSettings.add(label_name);
				
				
				
				// Code for the logo in the upper left corner and Astromath text
				
				JLabel labelLogo = new JLabel("ASTROMATH");
				
				labelLogo.setIcon(null);
				labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
				labelLogo.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
				labelLogo.setForeground(new Color(255, 255, 255));
				labelLogo.setBounds(97, 21, 318, 85);
				panel_profileSettings.add(labelLogo);
				
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
				panel_profileSettings.add(image_logout);
				
				JLabel imageSettings = new JLabel("");
				imageSettings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
				imageSettings.setBounds(1188, 99, 64, 64);
				panel_profileSettings.add(imageSettings);
				
				JLabel label_profileSettings = new JLabel("Profile Settings");
				label_profileSettings.setForeground(new Color(0, 195, 255));
				label_profileSettings.setFont(new Font("a Atmospheric", Font.PLAIN, 30));
				label_profileSettings.setBounds(68, 77, 782, 96);
				panel_profileSettings.add(label_profileSettings);
				
			
				
				JLabel image_pfp = new JLabel("");
				image_pfp.setIcon(new ImageIcon(".\\Assets\\images\\"));
				image_pfp.setBounds(110, 161, 88, 83);
				panel_profileSettings.add(image_pfp);
				
				JLabel label_name = new JLabel("Name:");
				label_name.setFont(new Font("A-Space Demo", Font.PLAIN, 38));
				label_name.setForeground(Color.WHITE);
				label_name.setBounds(100, 255, 336, 45);
				panel_profileSettings.add(label_name);
				
				JTextField textbox_name = new JTextField();
				textbox_name.setFont(new Font("A-Space Demo", Font.PLAIN, 42));
				textbox_name.setForeground(Color.WHITE);
				textbox_name.setBackground(new Color(26, 38, 83));
				textbox_name.setBounds(97, 311, 362, 64);
				textbox_name.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
				panel_profileSettings.add(textbox_name);
				textbox_name.setColumns(10);
				
				JLabel label_level = new JLabel(String.format("%d", student.getLevel()));
				label_level.setForeground(Color.WHITE);
				label_level.setFont(new Font("A-Space Demo", Font.PLAIN, 30));
				label_level.setBounds(208, 160, 262, 36);
				panel_profileSettings.add(label_level);
				
				JLabel label_aboutMe = new JLabel("About Me:");
				label_aboutMe.setForeground(Color.WHITE);
				label_aboutMe.setFont(new Font("A-Space Demo", Font.PLAIN, 38));
				label_aboutMe.setBounds(677, 184, 336, 45);
				panel_profileSettings.add(label_aboutMe);
				
				JLabel label_state = new JLabel("State:");
				label_state.setForeground(Color.WHITE);
				label_state.setFont(new Font("A-Space Demo", Font.PLAIN, 38));
				label_state.setBounds(100, 456, 336, 45);
				panel_profileSettings.add(label_state);
				
				textbox_state = new JTextField();
				textbox_state.setForeground(Color.WHITE);
				textbox_state.setFont(new Font("A-Space Demo", Font.PLAIN, 42));
				textbox_state.setColumns(10);
				textbox_state.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
				textbox_state.setBackground(new Color(26, 38, 83));
				textbox_state.setBounds(97, 531, 362, 64);
				panel_profileSettings.add(textbox_state);
				
				textfield_aboutMe = new JTextField();
				textfield_aboutMe.setForeground(Color.WHITE);
				textfield_aboutMe.setFont(new Font("A-Space Demo", Font.PLAIN, 42));
				textfield_aboutMe.setColumns(10);
				textfield_aboutMe.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
				textfield_aboutMe.setBackground(new Color(26, 38, 83));
				textfield_aboutMe.setBounds(677, 255, 417, 272);
				panel_profileSettings.add(textfield_aboutMe);
				
				JLabel label_chngePfp = new JLabel("Change Profile Picture");
				label_chngePfp.setForeground(new Color(0, 195, 255));
				label_chngePfp.setFont(new Font("A-Space Demo", Font.PLAIN, 24));
				label_chngePfp.setBounds(208, 207, 352, 28);
				panel_profileSettings.add(label_chngePfp);
				
				label_chngePfp.addMouseListener(new MouseAdapter() 
				{
					@Override
					public void mouseEntered(MouseEvent e) 
					{
						label_chngePfp.setForeground(new Color(0, 230, 255));
					}
					@Override
					public void mouseExited(MouseEvent e) 
					{
						label_chngePfp.setForeground(new Color(0, 195, 255));
					}
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						// Profile Pic page
					}
				});
				
				JButton button_submit = new JButton("Save");
				button_submit.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						// DATABASE STUFF HERE AND THEN POPUP
						try {
							
							String aboutMe = textfield_aboutMe.getText();
							String state = textbox_state.getText();
							
							String query = "Update profileinfo set userAboutMe = '" + aboutMe + "', profileState = '" + state +  "' where userID = '" + student.getAccNum() + "'";
							Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							st.executeUpdate(query);
						


						} catch (SQLException e1) {

							e1.printStackTrace();
						}
						
						try {
							
							
							String name = textbox_name.getText();
							String query = "Update userinfo set name = '" + name + "' where userID = '" + student.getAccNum() + "'";
							Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							st.executeUpdate(query);
							
							
							query = "Select name from userinfo where userID = '" + student.getAccNum() + "'";
							st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							ResultSet rs = st.executeQuery(query);
							rs.first();
							student.setName(rs.getString(1));
						


						} catch (SQLException e1) {

							e1.printStackTrace();
						}
						
						
						Profile panel_profile = new Profile(lp, test, student, con);
						switch_screen(panel_profile.getPanel(), lp, test, student, con);
					}
				});
				button_submit.setBackground(new Color(26, 38, 83));
				button_submit.setHorizontalAlignment(SwingConstants.CENTER);
				button_submit.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
				button_submit.setForeground(new Color(127, 255, 212));
				button_submit.setBounds(806, 581, 288, 68);
				panel_profileSettings.add(button_submit);

	}

	public JPanel getPanel()
	{
		return panel_profileSettings;
		
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
