import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Visual extends JFrame
{

	private JFrame frame;
	private JTextField textUsername;
	private JPasswordField textPassword;
	private Student goku = new Student("goku7", "menameisgoku@gmail.com", "dragonballs", 1234, 1, 1);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		JLabel labelUsername = new JLabel("Username");
		labelUsername.setForeground(Color.WHITE);
		labelUsername.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		labelUsername.setBounds(373, 292, 337, 81);
		frame.getContentPane().add(labelUsername);
		
		JLabel labelPassword = new JLabel("Password");
		labelPassword.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		labelPassword.setForeground(Color.WHITE);
		labelPassword.setBounds(373, 430, 220, 68);
		frame.getContentPane().add(labelPassword);
		
		JLabel astromath = new JLabel("ASTROMATH");
		astromath.setForeground(Color.WHITE);
		astromath.setFont(new Font("a Atmospheric", Font.PLAIN, 84));
		astromath.setBounds(310, 147, 745, 156);
		frame.getContentPane().add(astromath);
		
		textUsername = new JTextField();
		textUsername.setFont(new Font("A-Space Demo", Font.PLAIN, 42));
		textUsername.setForeground(Color.WHITE);
		textUsername.setBackground(new Color(26, 38, 83));
		textUsername.setBounds(373, 357, 447, 81);
		textUsername.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
		frame.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JPasswordField();
		textPassword.setForeground(Color.WHITE);
		textPassword.setFont(new Font("A-Space Demo", Font.PLAIN, 42));
		textPassword.setColumns(10);
		textPassword.setBackground(new Color(26, 38, 83));
		textPassword.setBounds(373, 496, 447, 81);
		textPassword.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
		frame.getContentPane().add(textPassword);
		
		JLabel labelIncorrect = new JLabel("Incorrect username or password!");
		labelIncorrect.setVisible(false);
		labelIncorrect.setForeground(new Color(255, 66, 66));
		labelIncorrect.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		labelIncorrect.setBounds(373, 276, 487, 26);
		frame.getContentPane().add(labelIncorrect);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(goku.getLogin(textUsername.getText(), String.valueOf(textPassword.getPassword())))
				{
					MainWindow home = new MainWindow();
					frame.dispose();
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
		frame.getContentPane().add(btnLogin);
		
		frame.setVisible(true);
		
		
		
	}
}
