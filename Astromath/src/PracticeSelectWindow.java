

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PracticeSelectWindow 
{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PracticeSelectWindow window = new PracticeSelectWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PracticeSelectWindow() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		// Creates the JFrame, and sets the background color and bounds to 1280 x 720 resolution
		frame = new JFrame();
		frame.getContentPane().addMouseListener(new MouseAdapter() 
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
		frame.getContentPane().setBackground(new Color(77,58,129));
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		// Code for the logo in the upper left corner and Astromath text
		
		JLabel astromath = new JLabel("ASTROMATH");
		
		astromath.setHorizontalAlignment(SwingConstants.CENTER);
		astromath.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
		astromath.setForeground(new Color(255, 255, 255));
		astromath.setBounds(97, 21, 318, 85);
		frame.getContentPane().add(astromath);
		
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
				MainWindow home = new MainWindow();
				frame.dispose();
			}
		});
		
		JLabel imageHome = new JLabel("");
		imageHome.setIcon(new ImageIcon(".\\assets\\images\\home.png"));
		imageHome.setBounds(40, 21, 64, 74);
		frame.getContentPane().add(imageHome);
		
		JLabel labelLearn = new JLabel("Learn");
		labelLearn.setHorizontalAlignment(SwingConstants.CENTER);
		labelLearn.setForeground(Color.WHITE);
		labelLearn.setFont(new Font("A-Space Demo", Font.PLAIN, 45));
		labelLearn.setBounds(210, 581, 254, 44);
		frame.getContentPane().add(labelLearn);
		
		JLabel labelPractice = new JLabel("Practice");
		labelPractice.setHorizontalAlignment(SwingConstants.CENTER);
		labelPractice.setForeground(Color.WHITE);
		labelPractice.setFont(new Font("A-Space Demo", Font.PLAIN, 45));
		labelPractice.setBounds(786, 572, 247, 53);
		frame.getContentPane().add(labelPractice);
		
		JLabel label_pageTitle = new JLabel("practice");
		label_pageTitle.setForeground(new Color(0, 195, 255));
		label_pageTitle.setFont(new Font("a Atmospheric", Font.PLAIN, 30));
		label_pageTitle.setBounds(97, 106, 318, 74);
		frame.getContentPane().add(label_pageTitle);
		
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
		});
		imageLearn.setIcon(new ImageIcon(".\\Assets\\images\\The Guys.png"));
		imageLearn.setBounds(86, 117, 480, 480);
		frame.getContentPane().add(imageLearn);
		
		JLabel imagePractice = new JLabel("");
		imagePractice.setIcon(new ImageIcon(".\\Assets\\images\\homework.png"));
		imagePractice.setBounds(663, 117, 480, 480);
		frame.getContentPane().add(imagePractice);
		
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
		});
		
		
		JLabel name = new JLabel("Goku");
		name.setHorizontalAlignment(SwingConstants.RIGHT);
		name.setForeground(Color.WHITE);
		name.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
		name.setBounds(765, 21, 417, 44);
		frame.getContentPane().add(name);
		
		 JLabel labelGrade = new JLabel("First Grade");
		labelGrade.setHorizontalAlignment(SwingConstants.RIGHT);
		labelGrade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
		labelGrade.setForeground(new Color(0, 195, 255));
		labelGrade.setBounds(874, 59, 308, 44);
		frame.getContentPane().add(labelGrade);
		
		
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
				Visual vis = new Visual();
				frame.dispose();
			}
		});
		imageLogout.setIcon(new ImageIcon(".\\assets\\images\\logout.png"));
		imageLogout.setBounds(1192, 15, 72, 91);
		frame.getContentPane().add(imageLogout);
		
		JLabel imageSettings = new JLabel("");
		imageSettings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
		imageSettings.setBounds(1188, 99, 64, 64);
		frame.getContentPane().add(imageSettings);
		
		frame.setVisible(true);
	}
}
