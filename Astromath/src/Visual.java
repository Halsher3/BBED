import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class Visual {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

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
		
		textField = new JTextField();
		textField.setFont(new Font("A-Space Demo", Font.PLAIN, 42));
		textField.setForeground(Color.WHITE);
		textField.setBackground(new Color(26, 38, 83));
		textField.setBounds(373, 357, 447, 81);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("A-Space Demo", Font.PLAIN, 42));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(26, 38, 83));
		textField_1.setBounds(373, 496, 447, 81);
		frame.getContentPane().add(textField_1);

		
	}
}