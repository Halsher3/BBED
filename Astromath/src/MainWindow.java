import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JPanel
{

	private Student goku = new Student("goku7", "menameisgoku@gmail.com", "dragonballs", 1234, 1, 1);
	
	private JLabel label_logo = new JLabel("ASTROMATH");
	private JLabel label_name = new JLabel("Goku");
	private JLabel image_ringPlanet = new JLabel("");
	private JLabel image_earth = new JLabel("");
	private JLabel image_redPlanet = new JLabel("");
	private JLabel label_grade = new JLabel("1st Grade");
	private JLabel image_bluePlanet = new JLabel("");
	private JLabel image_sun = new JLabel("");
	private JLabel image_home = new JLabel("");
	private JLabel label_grades = new JLabel("Grades");
	private JLabel label_tests = new JLabel("Tests");
	private JLabel label_practice = new JLabel("Practice");
	private JLabel label_profile = new JLabel("Profile");
	private JLabel image_logout = new JLabel("");
	private JLabel image_settings = new JLabel("");
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int height = screenSize.height;
	private int width = screenSize.width;
	
	private JPanel panel_home = new JPanel();
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public MainWindow(JLayeredPane lp) 
	{
		
				panel_home.setBounds(0, 0, 1262, 681);
				panel_home.setBackground(new Color(77,58,129));
				panel_home.setLayout(null);
				
				
				label_logo.setHorizontalAlignment(SwingConstants.CENTER);
				label_logo.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
				label_logo.setForeground(new Color(255, 255, 255));
				label_logo.setBounds(97, 21, 318, 85);
				panel_home.add(label_logo);
				
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
				

				label_name.setHorizontalAlignment(SwingConstants.RIGHT);
				label_name.setForeground(Color.WHITE);
				label_name.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
				label_name.setBounds(765, 21, 417, 44);
				panel_home.add(label_name);
				
				// Some of the icons for the planets
				
				
				image_ringPlanet.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) 
					{
						image_ringPlanet.setIcon(new ImageIcon(".\\assets\\images\\ringed planet v2.png"));
					}
					@Override
					public void mouseExited(MouseEvent e) 
					{
						image_ringPlanet.setIcon(new ImageIcon(".\\assets\\images\\ringed planet.png"));
					}
					@Override
					public void mouseClicked(MouseEvent e) {
						TestSelection panel_ts = new TestSelection(lp);
						switch_screen(panel_ts.getPanel(), lp);
					}
				});
				image_ringPlanet.setIcon(new ImageIcon(".\\assets\\images\\ringed planet.png"));
				image_ringPlanet.setBounds(64, 389, 318, 224);
				panel_home.add(image_ringPlanet);
				
				image_earth = new JLabel("");
				image_earth.addMouseListener(new MouseAdapter() 
				{
					@Override
					public void mouseEntered(MouseEvent e) 
					{
						image_earth.setIcon(new ImageIcon(".\\assets\\images\\earth v2.png"));
					}
					public void mouseExited(MouseEvent e) 
					{
						image_earth.setIcon(new ImageIcon(".\\assets\\images\\earth.png"));
					}
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						PracticeSelectWindow panel_ps = new PracticeSelectWindow(lp);
						switch_screen(panel_ps.getPanel(), lp);

					}
				});
				image_earth.setIcon(new ImageIcon(".\\assets\\images\\earth.png"));
				image_earth.setBounds(924, 117, 254, 224);
				panel_home.add(image_earth);
				
				image_redPlanet = new JLabel("");
				image_redPlanet.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) 
					{
						image_redPlanet.setIcon(new ImageIcon(".\\assets\\images\\red planet v2.png"));
					}
					@Override
					public void mouseExited(MouseEvent e) 
					{
						image_redPlanet.setIcon(new ImageIcon(".\\assets\\images\\red planet.png"));
					}
				});
				image_redPlanet.setIcon(new ImageIcon(".\\assets\\images\\red planet.png"));
				image_redPlanet.setBounds(900, 389, 224, 224);
				panel_home.add(image_redPlanet);
				
				// The student's grade level displayed under the welcome back message
				
				
				label_grade.setHorizontalAlignment(SwingConstants.RIGHT);
				label_grade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
				label_grade.setForeground(new Color(0, 195, 255));
				label_grade.setBounds(874, 59, 308, 44);
				panel_home.add(label_grade);
				
				//More planet images, and images in general
				
				image_bluePlanet = new JLabel("");
				image_bluePlanet.setIcon(new ImageIcon(".\\assets\\images\\blue planet.png"));
				image_bluePlanet.setBounds(54, 135, 224, 224);
				panel_home.add(image_bluePlanet);
				
				
				image_bluePlanet.addMouseListener(new MouseAdapter() 
				{
					@Override
					public void mouseEntered(MouseEvent e) 
					{
						image_bluePlanet.setIcon(new ImageIcon(".\\assets\\images\\blue planet v2.png"));
					}
					@Override
					public void mouseExited(MouseEvent e) 
					{
						image_bluePlanet.setIcon(new ImageIcon(".\\assets\\images\\blue planet.png"));
					}
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						GradePage panel_grade = new GradePage(lp);
						switch_screen(panel_grade.getPanel(), lp);

					}
				});
				
				image_sun = new JLabel("");
				image_sun.addMouseListener(new MouseAdapter() 
				{
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						
					}
				});
				image_sun.setIcon(new ImageIcon(".\\assets\\images\\sun.png"));
				image_sun.setBounds(402, 99, 512, 512);
				panel_home.add(image_sun);
				
				image_home = new JLabel("");
				image_home.setIcon(new ImageIcon(".\\assets\\images\\home.png"));
				image_home.setBounds(40, 21, 64, 74);
				panel_home.add(image_home);
				
				// Labels for the planets
				
				
				label_grades.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
				label_grades.setForeground(Color.WHITE);
				label_grades.setHorizontalAlignment(SwingConstants.CENTER);
				label_grades.setBounds(40, 352, 254, 44);
				panel_home.add(label_grades);
				
				
				label_tests.setHorizontalAlignment(SwingConstants.CENTER);
				label_tests.setForeground(Color.WHITE);
				label_tests.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
				label_tests.setBounds(84, 622, 254, 44);
				panel_home.add(label_tests);
				
				
				label_practice.setHorizontalAlignment(SwingConstants.CENTER);
				label_practice.setForeground(Color.WHITE);
				label_practice.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
				label_practice.setBounds(913, 334, 254, 44);
				panel_home.add(label_practice);
				
				
				label_profile.setHorizontalAlignment(SwingConstants.CENTER);
				label_profile.setForeground(Color.WHITE);
				label_profile.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
				label_profile.setBounds(883, 622, 254, 44);
				panel_home.add(label_profile);
				
				// Logout button
				
				image_logout = new JLabel("");
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
				panel_home.add(image_logout);
				
				image_settings = new JLabel("");
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
				panel_home.add(image_settings);
				
				lp.add(panel_home);
				
		
	}
	
	public JPanel getPanel()
	{
		return panel_home;
		
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
