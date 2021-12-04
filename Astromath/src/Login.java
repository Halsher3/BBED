import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;

public class Login extends JPanel 
{

	private JPanel panel_login = new JPanel();
	private JTextField textUsername;
	private JPasswordField textPassword;
	private Student goku = new Student("goku7", "menameisgoku@gmail.com", "dragonballs", 1234, 1, 1);
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int height = screenSize.height;
	private int width = screenSize.width;
	

	

	/**
	 *
	 * public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visual window = new Visual();
					window.panel_login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 *
	 *
	 */
	

	/**
	 * Create the application.
	 */
	public Login(JLayeredPane lp) 
	{
		
		panel_login.setBackground(new Color(77,58,129));
		panel_login.setBounds(0, 0, 1262, 681);
		lp.add(panel_login);
		panel_login.setLayout(null);
		
		JLabel labelUsername = new JLabel("Username");
		labelUsername.setForeground(Color.WHITE);
		labelUsername.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		labelUsername.setBounds(373, 292, 337, 81);
		panel_login.add(labelUsername);
		
		JLabel labelPassword = new JLabel("Password");
		labelPassword.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		labelPassword.setForeground(Color.WHITE);
		labelPassword.setBounds(373, 430, 220, 68);
		panel_login.add(labelPassword);
		
		JLabel astromath = new JLabel("ASTROMATH");
		astromath.setForeground(Color.WHITE);
		astromath.setFont(new Font("a Atmospheric", Font.PLAIN, 84));
		astromath.setBounds(261, 146, 745, 156);
		panel_login.add(astromath);
		
		textUsername = new JTextField();
		textUsername.setFont(new Font("A-Space Demo", Font.PLAIN, 42));
		textUsername.setForeground(Color.WHITE);
		textUsername.setBackground(new Color(26, 38, 83));
		textUsername.setBounds(373, 357, 447, 81);
		textUsername.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
		panel_login.add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JPasswordField();
		textPassword.setForeground(Color.WHITE);
		textPassword.setFont(new Font("A-Space Demo", Font.PLAIN, 42));
		textPassword.setColumns(10);
		textPassword.setBackground(new Color(26, 38, 83));
		textPassword.setBounds(373, 496, 447, 81);
		textPassword.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
		panel_login.add(textPassword);
		
		JLabel labelIncorrect = new JLabel("Incorrect username or password!");
		labelIncorrect.setVisible(false);
		labelIncorrect.setForeground(new Color(255, 66, 66));
		labelIncorrect.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		labelIncorrect.setBounds(373, 276, 487, 26);
		panel_login.add(labelIncorrect);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(goku.getLogin(textUsername.getText(), String.valueOf(textPassword.getPassword())))
				{
					MainWindow panel_home = new MainWindow(lp);
					switch_screen(panel_home.getPanel(), lp);
				}
				else
				{
					
					labelIncorrect.setVisible(true);
				}
			}
		});
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setFont(new Font("A-Space Demo", Font.PLAIN, 24));
		btnLogin.setBounds(412, 588, 370, 68);
		panel_login.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\\\assets\\\\images\\\\astro.png"));
		lblNewLabel.setBounds(-19, 325, 370, 424);
		panel_login.add(lblNewLabel);
		
		JButton lblNewLabel_1 = new JButton("New Student?");
		lblNewLabel_1.setBackground(new Color(26, 38, 83));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		lblNewLabel_1.setForeground(new Color(127, 255, 212));
		lblNewLabel_1.setBounds(964, 602, 288, 68);
		panel_login.add(lblNewLabel_1);
	}

	/**
	 * Initialize the contents of the panel_login.
	 */
	//private void initialize() {

		
		
	
		
		
		
	//}
	
	public JPanel getPanel()
	{
		return panel_login;
		
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
