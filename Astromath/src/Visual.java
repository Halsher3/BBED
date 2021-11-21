import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Visual extends JFrame
{

	private JFrame frame;
	private JTextField text_username;
	private JPasswordField text_password;
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
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		lblNewLabel.setBounds(373, 292, 337, 81);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(373, 430, 220, 68);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ASTROMATH");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("a Atmospheric", Font.PLAIN, 84));
		lblNewLabel_2.setBounds(310, 147, 745, 156);
		frame.getContentPane().add(lblNewLabel_2);
		
		text_username = new JTextField();
		text_username.setFont(new Font("A-Space Demo", Font.PLAIN, 42));
		text_username.setForeground(Color.WHITE);
		text_username.setBackground(new Color(26, 38, 83));
		text_username.setBounds(373, 357, 447, 81);
		frame.getContentPane().add(text_username);
		text_username.setColumns(10);
		
		text_password = new JPasswordField();
		text_password.setForeground(Color.WHITE);
		text_password.setFont(new Font("A-Space Demo", Font.PLAIN, 42));
		text_password.setColumns(10);
		text_password.setBackground(new Color(26, 38, 83));
		text_password.setBounds(373, 496, 447, 81);
		frame.getContentPane().add(text_password);
		
		JLabel label_incorrect = new JLabel("Incorrect username or password!");
		label_incorrect.setVisible(false);
		label_incorrect.setForeground(new Color(255, 66, 66));
		label_incorrect.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		label_incorrect.setBounds(373, 276, 487, 26);
		frame.getContentPane().add(label_incorrect);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(goku.getLogin(text_username.getText(), String.valueOf(text_password.getPassword())))
				{
					MainWindow home = new MainWindow();
					frame.dispose();
				}
				else
				{
					
					label_incorrect.setVisible(true);
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
