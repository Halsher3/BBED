import javax.swing.JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.*;
import javax.swing.JTextField;

public class UsernameChange extends JPanel {

	private JFrame frame;
	private JPanel panel_UsernameChange = new JPanel();
	private JLabel image_logout = new JLabel("");
	private JLabel image_settings = new JLabel("");
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int height = screenSize.height;
	private int width = screenSize.width;
	private JTextField username;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public UsernameChange(JLayeredPane lp, Test test, Student student, Connection con) {
		
		panel_UsernameChange.setBounds(0, 0, 1262, 681);
		panel_UsernameChange.setBackground(new Color(77,58,129));
		panel_UsernameChange.setLayout(null);
		
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
		panel_UsernameChange.add(imageHome);
		// Placeholder variables to use for Student name and Student grade
		
		JLabel labelLogo = new JLabel("ASTROMATH");
		
		labelLogo.setIcon(null);
		labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
		labelLogo.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
		labelLogo.setForeground(new Color(255, 255, 255));
		labelLogo.setBounds(97, 21, 318, 85);
		panel_UsernameChange.add(labelLogo);
		
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
		panel_UsernameChange.add(image_logout);
		
		JLabel imageSettings = new JLabel("");
		image_settings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccountSettings panel_acc = new AccountSettings(lp, test, student, con);
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
		imageSettings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
		imageSettings.setBounds(1188, 99, 64, 64);
		panel_UsernameChange.add(imageSettings);
		
		JLabel accountSettings = new JLabel("Account Settings");
		accountSettings.setForeground(new Color(0, 195, 255));
		accountSettings.setFont(new Font("a Atmospheric", Font.PLAIN, 30));
		accountSettings.setBounds(68, 77, 782, 96);
		panel_UsernameChange.add(accountSettings);
		
		username = new JTextField();
		username.setBounds(68, 379, 627, 79);
		username.setFont(new Font("A-Space Demo", Font.PLAIN, 26));
		username.setForeground(Color.WHITE);
		username.setBackground(new Color(26, 38, 83));
		username.setBorder(new LineBorder(new Color(0, 195, 255), 3, true));
		panel_UsernameChange.add(username);
		username.setColumns(10);
		
		JLabel usernameLabel = new JLabel("Enter a new Username");
		usernameLabel.setBounds(68, 273, 616, 96);
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setFont(new Font("A-Space Demo", Font.PLAIN, 40));
		panel_UsernameChange.add(usernameLabel);
		
		JLabel astronaut = new JLabel("");
		astronaut.setIcon(new ImageIcon(".\\Assets\\images\\astronaut.png"));
		astronaut.setBounds(614, -93, 1009, 960);
		panel_UsernameChange.add(astronaut);
		
		
	}//end of UsernameChange

	public JPanel getPanel()
	{
		return panel_UsernameChange;
		
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
