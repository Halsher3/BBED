

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
import java.sql.Connection;

public class PracticeSelectWindow extends JPanel
{

	private JFrame frame;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int height = screenSize.height;
	private int width = screenSize.width;
	
	private JPanel panel_practiceSelect = new JPanel();



	/**
	 * Create the application.
	 */
	public PracticeSelectWindow(JLayeredPane lp, Test test, Student student, Connection con) 
	{
		
		panel_practiceSelect.setBounds(0, 0, 1262, 681);
		panel_practiceSelect.setBackground(new Color(77,58,129));
		panel_practiceSelect.setLayout(null);
		
		// Code for the logo in the upper left corner and Astromath text
		
				JLabel astromath = new JLabel("ASTROMATH");
				
				astromath.setHorizontalAlignment(SwingConstants.CENTER);
				astromath.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
				astromath.setForeground(new Color(255, 255, 255));
				astromath.setBounds(97, 21, 318, 85);
				panel_practiceSelect.add(astromath);
				
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
						MainWindow panel_home = new MainWindow(lp, test, student, con);
						switch_screen(panel_home.getPanel(), lp, test, student, con);

					}
				});
				
				JLabel imageHome = new JLabel("");
				imageHome.setIcon(new ImageIcon(".\\assets\\images\\home.png"));
				imageHome.setBounds(40, 21, 64, 74);
				panel_practiceSelect.add(imageHome);
				
				JLabel labelLearn = new JLabel("Learn");
				labelLearn.setHorizontalAlignment(SwingConstants.CENTER);
				labelLearn.setForeground(Color.WHITE);
				labelLearn.setFont(new Font("A-Space Demo", Font.PLAIN, 45));
				labelLearn.setBounds(210, 581, 254, 44);
				panel_practiceSelect.add(labelLearn);
				
				JLabel labelPractice = new JLabel("Practice");
				labelPractice.setHorizontalAlignment(SwingConstants.CENTER);
				labelPractice.setForeground(Color.WHITE);
				labelPractice.setFont(new Font("A-Space Demo", Font.PLAIN, 45));
				labelPractice.setBounds(786, 572, 247, 53);
				panel_practiceSelect.add(labelPractice);
				
				JLabel label_pageTitle = new JLabel("practice");
				label_pageTitle.setForeground(new Color(0, 195, 255));
				label_pageTitle.setFont(new Font("a Atmospheric", Font.PLAIN, 30));
				label_pageTitle.setBounds(97, 106, 318, 74);
				panel_practiceSelect.add(label_pageTitle);
				
				JLabel imageLearn = new JLabel("");
				imageLearn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) 
					{
						imageLearn.setIcon(new ImageIcon(".\\Assets\\images\\The Guys v2.png"));
						labelLearn.setForeground(new Color(0, 195, 255));
						
						
					}
					@Override
					public void mouseExited(MouseEvent e) 
					{
						imageLearn.setIcon(new ImageIcon(".\\Assets\\images\\The Guys.png"));
						labelLearn.setForeground(Color.WHITE);
					}
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						LearnVideoWindow panel_vidWindow = new LearnVideoWindow(lp, test, student, con);
						switch_screen(panel_vidWindow.getPanel(), lp, test, student, con);
					}
				});
				imageLearn.setIcon(new ImageIcon(".\\Assets\\images\\The Guys.png"));
				imageLearn.setBounds(86, 117, 480, 480);
				panel_practiceSelect.add(imageLearn);
				
				JLabel imagePractice = new JLabel("");
				imagePractice.setIcon(new ImageIcon(".\\Assets\\images\\homework.png"));
				imagePractice.setBounds(663, 117, 480, 480);
				panel_practiceSelect.add(imagePractice);
				
				imagePractice.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) 
					{
						imagePractice.setIcon(new ImageIcon(".\\Assets\\images\\homework v2.png"));
						labelPractice.setForeground(new Color(0, 195, 255));
						
						
					}
					@Override
					public void mouseExited(MouseEvent e) 
					{
						imagePractice.setIcon(new ImageIcon(".\\assets\\images\\homework.png"));
						labelPractice.setForeground(Color.WHITE);
					}
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						PracticeQuestions panel_question = new PracticeQuestions(lp, test, student, con);
						switch_screen(panel_question.getPanel(), lp, test, student, con);
					}
				});
				
				
				JLabel name = new JLabel("Goku");
				name.setHorizontalAlignment(SwingConstants.RIGHT);
				name.setForeground(Color.WHITE);
				name.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
				name.setBounds(765, 21, 417, 44);
				panel_practiceSelect.add(name);
				
				 JLabel labelGrade = new JLabel("1st Grade");
				labelGrade.setHorizontalAlignment(SwingConstants.RIGHT);
				labelGrade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
				labelGrade.setForeground(new Color(0, 195, 255));
				labelGrade.setBounds(874, 59, 308, 44);
				panel_practiceSelect.add(labelGrade);
				
				
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
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						Login panel_login = new Login(lp, test, student, con);
						switch_screen(panel_login.getPanel(), lp, test, student, con);

					}
				});
				imageLogout.setIcon(new ImageIcon(".\\assets\\images\\logout.png"));
				imageLogout.setBounds(1192, 15, 72, 91);
				panel_practiceSelect.add(imageLogout);
				
				JLabel image_settings = new JLabel("");
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
				image_settings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
				image_settings.setBounds(1188, 99, 64, 64);
				panel_practiceSelect.add(image_settings);
				
	}

	
	public JPanel getPanel()
	{
		return panel_practiceSelect;
		
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
