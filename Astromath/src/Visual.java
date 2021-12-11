import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.LineBorder;

import chrriis.dj.nativeswing.NativeSwing;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;

public class Visual extends JFrame
{

	private JFrame frame;
	private JTextField textUsername;
	private JPasswordField textPassword;
	private Student goku = new Student("goku7", "menameisgoku@gmail.com", "dragonballs", 1234, 1, 1);
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int height = screenSize.height;
	private int width = screenSize.width;
	public Test test = new Test(0, 0);

	
	private final JLayeredPane layeredPane = new JLayeredPane();
	
	JPanel panel_login = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		NativeSwing.initialize();
		NativeInterface.open();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Visual window = new Visual();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		NativeInterface.runEventPump();
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
	        @Override
	        public void run() {
	            NativeInterface.close();
	        }
	    }));
	}

	/**
	 * Create the application.
	 */
	public Visual() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(new Color(77,58,129));
		frame.setBounds(100, 100, 1278, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	
		
		int x = ((width / 2) - (width / 3));
		int y = ((height / 2) - (height / 3));
		
		frame.setLocation(x, y);
		
		layeredPane.setBounds(0, 0, 1262, 681);
		frame.getContentPane().add(layeredPane);
		
		Login l = new Login(layeredPane, test);
		
		
		
		layeredPane.add(l);
		
		
		
		frame.setVisible(true);
		
		
		
	}
	
	public void switch_screen(JPanel p, JLayeredPane lp, Test test)
	{
		
		lp.removeAll();
		p.setLayout(null);
		lp.add(p);
		lp.repaint();
		lp.revalidate();
		

	}

	
}
