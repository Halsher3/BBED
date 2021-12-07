import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

//sql stuff
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
	
		JLabel userLabel = new JLabel("Create a Username");
		userLabel.setForeground(Color.WHITE);
		userLabel.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		userLabel.setBounds(98, 114, 447, 81);
		frame.getContentPane().add(userLabel);
		
		JLabel emailLabel = new JLabel("Add an Email Address");
		emailLabel.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setBounds(98, 266, 447, 68);
		frame.getContentPane().add(emailLabel);
		
		
		JLabel passwordLabel = new JLabel("Enter a Password");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		passwordLabel.setBounds(98, 413, 447, 68);
		frame.getContentPane().add(passwordLabel);

		
		JLabel astromath = new JLabel("ASTROMATH");
		astromath.setForeground(Color.WHITE);
		astromath.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
		astromath.setBounds(98, 39, 745, 52);
		frame.getContentPane().add(astromath);
		
		JTextField userName = new JTextField();
		userName.setFont(new Font("A-Space Demo", Font.PLAIN, 42));
		userName.setForeground(Color.WHITE);
		userName.setBackground(new Color(26, 38, 83));
		userName.setBounds(98, 175, 592, 81);
		frame.getContentPane().add(userName);
		userName.setColumns(10);
		
		JTextField userEmail = new JTextField();
		userEmail.setForeground(Color.WHITE);
		userEmail.setFont(new Font("A-Space Demo", Font.PLAIN, 42));
		userEmail.setColumns(10);
		userEmail.setBackground(new Color(26, 38, 83));
		userEmail.setBounds(98, 322, 592, 81);
		frame.getContentPane().add(userEmail);
		
		JTextField userPassword = new JTextField();
		userPassword.setForeground(Color.WHITE);
		userPassword.setFont(new Font("A-Space Demo", Font.PLAIN, 42));
		userPassword.setColumns(10);
		userPassword.setBackground(new Color(26, 38, 83));
		userPassword.setBounds(98, 468, 592, 81);
		frame.getContentPane().add(userPassword);
		
		JLabel astronaut = new JLabel("");
		astronaut.setIcon(new ImageIcon("C:\\Users\\halsh\\Downloads\\astronaut.png"));
		astronaut.setBounds(614, -93, 1009, 960);
		frame.getContentPane().add(astronaut);
		
		JLabel casePasswordReq = new JLabel("Your password must have at least 1 Uppercase character\r\n");
		casePasswordReq.setForeground(Color.WHITE);
		casePasswordReq.setFont(new Font("A-Space Demo", Font.PLAIN, 15));
		casePasswordReq.setBounds(98, 538, 604, 52);
		frame.getContentPane().add(casePasswordReq);
		
		JLabel characterReq = new JLabel("At least 6 characters long\r\n");
		characterReq.setForeground(Color.WHITE);
		characterReq.setFont(new Font("A-Space Demo", Font.PLAIN, 15));
		characterReq.setBounds(98, 576, 604, 39);
		frame.getContentPane().add(characterReq);
		
		JLabel specialCharReq = new JLabel("At least one special character (!, ?, /, *, &, ^, etc.)\r\n");
		specialCharReq.setForeground(Color.WHITE);
		specialCharReq.setFont(new Font("A-Space Demo", Font.PLAIN, 15));
		specialCharReq.setBounds(98, 608, 604, 39);
		frame.getContentPane().add(specialCharReq);
		
		JLabel home = new JLabel("");
		home.setIcon(new ImageIcon("C:\\Users\\halsh\\Downloads\\home.png"));
		home.setBounds(30, 23, 78, 81);
		frame.getContentPane().add(home);
		
		//my sql database register stuff
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = userName.getText();
				String email = userEmail.getText();
				String password = userEmail.getText();
				//String grade = userEmail.getText(); this will hopefull be grade when i get this working
              
				try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/userregistration","root","ubuntu123");

                    String query = "INSERT INTO account values('" + username + "','" + password + "','" + email + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(registerButton, "This is alredy exist");
                    } else {
                        String msg = null;
						JOptionPane.showMessageDialog(registerButton,
                            "Welcome, " + msg + "Your account is sucessfully created");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });	
		registerButton.setFont(new Font("A-Space Demo", Font.PLAIN, 27));
		registerButton.setBounds(674, 594, 218, 68);
		frame.getContentPane().add(registerButton);
		
		//end of button function to create a user
		
		
		
	

		
	}
}
