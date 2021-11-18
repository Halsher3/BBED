import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AccountCreations {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountCreations window = new AccountCreations();
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
	public AccountCreations() {
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
		
		JLabel lblNewLabel = new JLabel("Create a Username");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		lblNewLabel.setBounds(98, 114, 447, 81);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Add an Email Address");
		lblNewLabel_1.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(98, 266, 447, 68);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter a Password");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(98, 413, 447, 68);
		frame.getContentPane().add(lblNewLabel_1_1);

		
		JLabel lblNewLabel_2 = new JLabel("ASTROMATH");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
		lblNewLabel_2.setBounds(98, 39, 745, 52);
		frame.getContentPane().add(lblNewLabel_2);
		
		JTextField textField = new JTextField();
		textField.setFont(new Font("A-Space Demo", Font.PLAIN, 42));
		textField.setForeground(Color.WHITE);
		textField.setBackground(new Color(26, 38, 83));
		textField.setBounds(98, 175, 592, 81);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextField textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("A-Space Demo", Font.PLAIN, 42));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(26, 38, 83));
		textField_1.setBounds(98, 322, 592, 81);
		frame.getContentPane().add(textField_1);
		
		JTextField textField_2 = new JTextField();
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("A-Space Demo", Font.PLAIN, 42));
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(26, 38, 83));
		textField_2.setBounds(98, 468, 592, 81);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\halsh\\Downloads\\astronaut.png"));
		lblNewLabel_3.setBounds(614, -93, 1009, 960);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Your password must have at least 1 Uppercase character\r\n");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("A-Space Demo", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(98, 538, 604, 52);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("At least 6 characters long\r\n");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("A-Space Demo", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(98, 576, 604, 39);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("At least one special character (!, ?, /, *, &, ^, etc.)\r\n");
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setFont(new Font("A-Space Demo", Font.PLAIN, 15));
		lblNewLabel_4_1_1.setBounds(98, 608, 604, 39);
		frame.getContentPane().add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\halsh\\Downloads\\home.png"));
		lblNewLabel_5.setBounds(30, 23, 78, 81);
		frame.getContentPane().add(lblNewLabel_5);

		
	}

}
