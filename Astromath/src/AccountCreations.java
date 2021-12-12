import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

import java.util.Random;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;


//sql stuff
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTextArea;


public class AccountCreations {

	private JFrame frame;
	private JTextField gradeLevel;
	private JTextField GovName;

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
		userLabel.setBounds(52, 101, 447, 81);
		frame.getContentPane().add(userLabel);
		
		JLabel emailLabel = new JLabel("Add an Email Address");
		emailLabel.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setBounds(52, 206, 447, 68);
		frame.getContentPane().add(emailLabel);
		
		
		JLabel passwordLabel = new JLabel("Enter a Password");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		passwordLabel.setBounds(52, 304, 447, 68);
		frame.getContentPane().add(passwordLabel);
		
		JLabel gradeLabel = new JLabel("Enter your grade level");
		gradeLabel.setForeground(Color.WHITE);
		gradeLabel.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		gradeLabel.setBounds(58, 625, 346, 39);
		frame.getContentPane().add(gradeLabel);

		JLabel astromath = new JLabel("ASTROMATH");
		astromath.setForeground(Color.WHITE);
		astromath.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
		astromath.setBounds(98, 39, 745, 52);
		frame.getContentPane().add(astromath);
		
		JTextField userName = new JTextField();
		userName.setFont(new Font("A-Space Demo", Font.PLAIN, 26));
		userName.setForeground(Color.WHITE);
		userName.setBackground(new Color(26, 38, 83));
		userName.setBounds(52, 163, 592, 56);
		userName.setBorder(new LineBorder(new Color(0, 195, 255), 3, true));
		frame.getContentPane().add(userName);
		userName.setColumns(10);
		
		JTextField userEmail = new JTextField();
		userEmail.setForeground(Color.WHITE);
		userEmail.setFont(new Font("A-Space Demo", Font.PLAIN, 26));
		userEmail.setColumns(10);
		userEmail.setBackground(new Color(26, 38, 83));
		userEmail.setBounds(52, 259, 592, 56);
		userEmail.setBorder(new LineBorder(new Color(0, 195, 255), 3, true));
		frame.getContentPane().add(userEmail);
		
		JTextField userPassword = new JTextField();
		userPassword.setForeground(Color.WHITE);
		userPassword.setFont(new Font("A-Space Demo", Font.PLAIN, 26));
		userPassword.setColumns(10);
		userPassword.setBackground(new Color(26, 38, 83));
		userPassword.setBounds(52, 352, 592, 56);
		userPassword.setBorder(new LineBorder(new Color(0, 195, 255), 3, true));
		frame.getContentPane().add(userPassword);
		
		gradeLevel = new JTextField();
		gradeLevel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (gradeLevel.getText().length() >= 1 ) // limit textfield to 1 characters
		            e.consume();
			}
		});
		gradeLevel.setForeground(Color.WHITE);
		gradeLevel.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		gradeLevel.setBackground(new Color(26, 38, 83));
		gradeLevel.setBounds(392, 618, 78, 52);
		gradeLevel.setColumns(10);
		gradeLevel.setBorder(new LineBorder(new Color(0, 195, 255), 3, true));
		frame.getContentPane().add(gradeLevel);
		
		GovName = new JTextField();
		GovName.setForeground(Color.WHITE);
		GovName.setFont(new Font("A-Space Demo", Font.PLAIN, 26));
		GovName.setBackground(new Color(26, 38, 83));
		GovName.setBounds(52, 533, 592, 56);
		frame.getContentPane().add(GovName);
		GovName.setBorder(new LineBorder(new Color(0, 195, 255), 3, true));
		GovName.setColumns(10);
		
		JLabel casePasswordReq = new JLabel("Your password must have at least 1 Uppercase character\r\n");
		casePasswordReq.setForeground(Color.WHITE);
		casePasswordReq.setFont(new Font("A-Space Demo", Font.PLAIN, 15));
		casePasswordReq.setBounds(52, 399, 604, 52);
		frame.getContentPane().add(casePasswordReq);
		
		JLabel characterReq = new JLabel("At least 6 characters long\r\n");
		characterReq.setForeground(Color.WHITE);
		characterReq.setFont(new Font("A-Space Demo", Font.PLAIN, 15));
		characterReq.setBounds(52, 432, 604, 39);
		frame.getContentPane().add(characterReq);
		
		JLabel specialCharReq = new JLabel("At least one special character (!, ?, /, *, &, ^, etc.)\r\n");
		specialCharReq.setForeground(Color.WHITE);
		specialCharReq.setFont(new Font("A-Space Demo", Font.PLAIN, 15));
		specialCharReq.setBounds(52, 461, 604, 39);
		frame.getContentPane().add(specialCharReq);
		
		JLabel home = new JLabel("");
		home.setIcon(new ImageIcon("C:\\Users\\halsh\\Downloads\\home.png"));
		home.setBounds(30, 23, 78, 81);
		frame.getContentPane().add(home);
		

		
		
		
		//my sql database register stuff
		JButton registerButton = new JButton("Register");
		registerButton.setForeground(new Color(127, 255, 212));
		registerButton.setBackground(new Color(26, 38, 83));
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String gradeString= gradeLevel.getText();
				if(!(gradeString.equals("0")) && !(gradeString.equals("1")) && !(gradeString.equals("2")) && !(gradeString.equals("3")) && !(gradeString.equals("4"))){
					gradeString = "0";
				}
				
				
				var username = userName.getText();
				var email = userEmail.getText();
				var password = userEmail.getText();
				var grade = gradeString;
				var name = GovName.getText();
				
				//userID
				int userID;
				Random rand = new Random();
				userID = rand.nextInt(1000000 - 100000) + 100000;
				
				try {
//DATABASE CONNECTION LINE IS IN DISCORD                    
                    String query  = "SELECT * from userinfo WHERE userID = '" + userID + "'";
                    Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    ResultSet rs = st.executeQuery(query); // execute the query, and get a java resultset

                    // if this ID already exists, we quit
                    if(rs.absolute(1)) {
                    	connection.close();
                         return;
                    }

                    String query1 = "INSERT INTO userinfo(`username`, `email`, `password`, `grade`, `name`, userID) "
                    		+ "VALUES ('" + username + "','" + password + "','" + email + "','" + grade +"','" + name + "','" + userID + "')";
                                                    
                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query1);
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
		registerButton.setBounds(1009, 596, 218, 68);
		frame.getContentPane().add(registerButton);
		
		JLabel LabelName = new JLabel("Enter a display name");
		LabelName.setForeground(new Color(255, 255, 255));
		LabelName.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		LabelName.setBounds(52, 495, 766, 32);
		frame.getContentPane().add(LabelName);
		
		JTextArea txtrIfInKindergarden = new JTextArea();
		txtrIfInKindergarden.setForeground(Color.WHITE);
		txtrIfInKindergarden.setFont(new Font("A-Space Demo", Font.PLAIN, 16));
		txtrIfInKindergarden.setEditable(false);
		txtrIfInKindergarden.setBackground(new Color(77, 58, 129));
		txtrIfInKindergarden.setLineWrap(true);
		txtrIfInKindergarden.setText("If in Kindergarden put K in the box");
		txtrIfInKindergarden.setBounds(480, 625, 206, 70);
		frame.getContentPane().add(txtrIfInKindergarden);
		
		JLabel astronaut = new JLabel("");
		astronaut.setIcon(new ImageIcon("C:\\Users\\halsh\\Downloads\\BBED-main (3)\\BBED-main\\Astromath\\Assets\\images\\astronaut.png"));
		astronaut.setBounds(614, -93, 1009, 960);
		frame.getContentPane().add(astronaut);
		

		

		

		
		//end of button function to create a user
		
		
		
	

		
	}
}
