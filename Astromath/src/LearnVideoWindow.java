

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;

import chrriis.dj.nativeswing.NativeSwing;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;


public class LearnVideoWindow extends JPanel
{

	private JFrame frame;
	private String videoURL;
	private String topic = "Addition within 20";
	
	private JPanel panel_vidWindow = new JPanel();
	
	
	
	
	

	
	public LearnVideoWindow(JLayeredPane lp, Test test) 
	{
		
				panel_vidWindow.setBounds(0, 0, 1262, 681);
				panel_vidWindow.setBackground(new Color(77,58,129));
				panel_vidWindow.setLayout(null);
				
				
				// Code for the logo in the upper left corner and Astromath text
				
				JLabel label_logo = new JLabel("ASTROMATH");
				
				label_logo.setHorizontalAlignment(SwingConstants.CENTER);
				label_logo.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
				label_logo.setForeground(new Color(255, 255, 255));
				label_logo.setBounds(97, 21, 318, 85);
				panel_vidWindow.add(label_logo);
				
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
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						MainWindow panel_home = new MainWindow(lp);
						switch_screen(panel_home.getPanel(), lp);
					}
				});
				
				JLabel image_home = new JLabel("");
				image_home.setIcon(new ImageIcon(".\\assets\\images\\home.png"));
				image_home.setBounds(40, 21, 64, 74);
				panel_vidWindow.add(image_home);
				
				JLabel label_pageTitle = new JLabel("" + topic);
				label_pageTitle.setForeground(new Color(0, 195, 255));
				label_pageTitle.setFont(new Font("a Atmospheric", Font.PLAIN, 30));
				label_pageTitle.setBounds(97, 106, 953, 74);
				panel_vidWindow.add(label_pageTitle);
				
				
				JLabel label_name = new JLabel("Goku");
				label_name.setHorizontalAlignment(SwingConstants.RIGHT);
				label_name.setForeground(Color.WHITE);
				label_name.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
				label_name.setBounds(765, 21, 417, 44);
				panel_vidWindow.add(label_name);
				
				 JLabel label_grade = new JLabel("First Grade");
				label_grade.setHorizontalAlignment(SwingConstants.RIGHT);
				label_grade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
				label_grade.setForeground(new Color(0, 195, 255));
				label_grade.setBounds(874, 59, 308, 44);
				panel_vidWindow.add(label_grade);
				
				
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
						Login panel_login = new Login(lp);
						switch_screen(panel_login.getPanel(), lp);
					}
				});
				image_logout.setIcon(new ImageIcon(".\\assets\\images\\logout.png"));
				image_logout.setBounds(1192, 15, 72, 91);
				panel_vidWindow.add(image_logout);
				
				JLabel image_settings = new JLabel("");
				image_settings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
				image_settings.setBounds(1188, 99, 64, 64);
				panel_vidWindow.add(image_settings);
				
				
				JWebBrowser webBrowser = new JWebBrowser();
				webBrowser.setBounds(97, 178, 1055, 467);
				webBrowser.setBarsVisible(false);
			    webBrowser.navigate("https://www.youtube.com/embed/R1seVzmeM-8");
				panel_vidWindow.add(webBrowser);
				
	}
	
	public JPanel getPanel()
	{
		return panel_vidWindow;
		
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
