import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import java.text.*;
import java.awt.print.*;


;public class TestResult extends JPanel 
{


	private JFrame frame;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int height = screenSize.height;
	private int width = screenSize.width;
	private JLabel labelName = new JLabel("Goku");
	private JLabel labelGrade = new JLabel("1st Grade");
	
	private JPanel panel_result = new JPanel();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public TestResult(JLayeredPane lp, Test test) 
	{
		
				panel_result.setBounds(0, 0, 1262, 681);
				panel_result.setBackground(new Color(77,58,129));
				panel_result.setLayout(null);
			
				
				JLabel imageHome = new JLabel("");
				imageHome.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						MainWindow panel_home = new MainWindow(lp, test);
						switch_screen(panel_home.getPanel(), lp);
					}
				});
				imageHome.setIcon(new ImageIcon(".\\assets\\images\\home.png"));
				imageHome.setBounds(40, 21, 64, 74);
				panel_result.add(imageHome);
				// Placeholder variables to use for Student name and Student grade
			
				
				labelGrade.setHorizontalAlignment(SwingConstants.RIGHT);
				labelGrade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
				labelGrade.setForeground(new Color(0, 195, 255));
				labelGrade.setBounds(874, 59, 308, 44);
				panel_result.add(labelGrade);
				
				
				labelName.setHorizontalAlignment(SwingConstants.RIGHT);
				labelName.setForeground(Color.WHITE);
				labelName.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
				labelName.setBounds(765, 21, 417, 44);
				panel_result.add(labelName);
				
				
				// Code for the logo in the upper left corner and Astromath text
				
				JLabel labelLogo = new JLabel("ASTROMATH");
				
				labelLogo.setIcon(null);
				labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
				labelLogo.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
				labelLogo.setForeground(new Color(255, 255, 255));
				labelLogo.setBounds(97, 21, 318, 85);
				panel_result.add(labelLogo);
				
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
						MainWindow panel_home = new MainWindow(lp, test);
						switch_screen(panel_home.getPanel(), lp);
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
						Login panel_login = new Login(lp, test);
						switch_screen(panel_login.getPanel(), lp);
					}
				});
				image_logout.setIcon(new ImageIcon(".\\assets\\images\\logout.png"));
				image_logout.setBounds(1192, 15, 72, 91);
				panel_result.add(image_logout);
				
				JLabel imageSettings = new JLabel("");
				imageSettings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
				imageSettings.setBounds(1188, 99, 64, 64);
				panel_result.add(imageSettings);
				
				JLabel image_rocket = new JLabel("");
				image_rocket.setIcon(new ImageIcon("C:\\Users\\Ru\\eclipse-workspace\\Astromath\\Assets\\images\\cursor.png"));
				image_rocket.setBounds(351, 584, 30, 49);
				panel_result.add(image_rocket);
				
				JLabel label_congrats = new JLabel("Congratulations Goku!");
				label_congrats.setForeground(Color.WHITE);
				label_congrats.setFont(new Font("A-Space Demo", Font.PLAIN, 54));
				label_congrats.setBounds(211, 114, 843, 124);
				panel_result.add(label_congrats);
				
				JLabel label_youScored = new JLabel("You scored");
				label_youScored.setHorizontalAlignment(SwingConstants.CENTER);
				label_youScored.setForeground(Color.WHITE);
				label_youScored.setFont(new Font("A-Space Demo", Font.PLAIN, 44));
				label_youScored.setBounds(183, 195, 843, 124);
				panel_result.add(label_youScored);
				
				JLabel label_score = new JLabel("90%");
				label_score.setHorizontalAlignment(SwingConstants.CENTER);
				label_score.setForeground(Color.YELLOW);
				label_score.setFont(new Font("a Atmospheric", Font.PLAIN, 94));
				label_score.setBounds(351, 274, 496, 219);
				panel_result.add(label_score);
				
				JLabel lblOnTheAddition = new JLabel("on the Addition 20 test!");
				lblOnTheAddition.setHorizontalAlignment(SwingConstants.CENTER);
				lblOnTheAddition.setForeground(Color.WHITE);
				lblOnTheAddition.setFont(new Font("A-Space Demo", Font.PLAIN, 44));
				lblOnTheAddition.setBounds(18, 461, 1188, 124);
				panel_result.add(lblOnTheAddition);
				
				JLabel image_star = new JLabel("");
				image_star.setIcon(new ImageIcon("C:\\Users\\Ru\\eclipse-workspace\\Astromath\\Assets\\images\\star.png"));
				image_star.setBounds(112, 231, 229, 220);
				panel_result.add(image_star);
				
				JLabel image_star2 = new JLabel("");
				image_star2.setIcon(new ImageIcon("C:\\Users\\Ru\\eclipse-workspace\\Astromath\\Assets\\images\\star.png"));
				image_star2.setBounds(904, 230, 229, 220);
				panel_result.add(image_star2);
				
				JLabel image_rocket2 = new JLabel("");
				image_rocket2.setIcon(new ImageIcon("C:\\Users\\Ru\\eclipse-workspace\\Astromath\\Assets\\images\\cursor.png"));
				image_rocket2.setBounds(885, 584, 30, 49);
				panel_result.add(image_rocket2);
				
				JLabel lblReturnToTest = new JLabel("Return to test selection");
				lblReturnToTest.setFont(new Font("a Atmospheric", Font.PLAIN, 24));
				lblReturnToTest.setHorizontalAlignment(SwingConstants.CENTER);
				lblReturnToTest.setForeground(Color.WHITE);
				lblReturnToTest.setBounds(345, 569, 570, 74);
				panel_result.add(lblReturnToTest);
				
				lblReturnToTest.addMouseListener(new MouseAdapter() 
				{
					@Override
					public void mouseEntered(MouseEvent e) 
					{
						lblReturnToTest.setForeground(new Color(0, 195, 255));
					}
					@Override
					public void mouseExited(MouseEvent e) 
					{
						lblReturnToTest.setForeground(Color.WHITE);
					}
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						TestSelection panel_select = new TestSelection(lp, test);
						switch_screen(panel_select.getPanel(), lp);
					}
				});
				
				JLabel image_print = new JLabel("");
				image_print.setIcon(new ImageIcon(".\\assets\\images\\print.png"));
				image_print.setBounds(1082, 512, 119, 131);
				panel_result.add(image_print);
				
				image_print.addMouseListener(new MouseAdapter() 
				{
					@Override
					public void mouseEntered(MouseEvent e) 
					{
						image_print.setIcon(new ImageIcon(".\\assets\\images\\print v2.png"));
					}
					@Override
					public void mouseExited(MouseEvent e) 
					{
						image_print.setIcon(new ImageIcon(".\\assets\\images\\print.png"));
					}
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						PrinterJob job = PrinterJob.getPrinterJob();
						job.setJobName("Test Results");
						
						job.setPrintable(new Printable() {

							@Override
							public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
									throws PrinterException 
							{
								if(pageIndex>0)
								{
									return Printable.NO_SUCH_PAGE;
								}
								
								Graphics2D g2 = (Graphics2D)graphics;
								g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
								g2.scale(0.24, 0.24);
								
								lp.paint(g2);
								return Printable.PAGE_EXISTS;

							}
							
						});
						
						boolean ok = job.printDialog();
						if(ok)
						{
							try
							{
								job.print();
							}
							catch (PrinterException ex) {}
						}
						
						
						
					}
				});
				
				

	}

	public JPanel getPanel()
	{
		return panel_result;
		
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
