import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

//sql stuff
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;


/*
 * Creates the AccountCreation page, here the student can make their account with all
 * their paramaters.
 */
public class AccountCreations extends JPanel {

	private JPanel panel_accCreate = new JPanel();
	private JTextField gradeLevel;
	private JTextField GovName;

	public AccountCreations(JLayeredPane lp, Test test, Student student, Connection con) {

		panel_accCreate.setBounds(0, 0, 1262, 681);
		panel_accCreate.setBackground(new Color(77, 58, 129));
		panel_accCreate.setLayout(null);

		JLabel imageHome = new JLabel("");
		imageHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login panel_home = new Login(lp, test, student, con);
				switch_screen(panel_home.getPanel(), lp, test, student, con);
			}
		});
		imageHome.setIcon(new ImageIcon(".\\assets\\images\\home.png"));
		imageHome.setBounds(40, 21, 64, 74);
		panel_accCreate.add(imageHome);

		JLabel userLabel = new JLabel("Create a Username");
		userLabel.setForeground(Color.WHITE);
		userLabel.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		userLabel.setBounds(52, 101, 447, 81);
		panel_accCreate.add(userLabel);

		JLabel emailLabel = new JLabel("Add an Email Address");
		emailLabel.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setBounds(52, 206, 447, 68);
		panel_accCreate.add(emailLabel);

		JLabel passwordLabel = new JLabel("Enter a Password");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		passwordLabel.setBounds(52, 304, 447, 68);
		panel_accCreate.add(passwordLabel);

		JLabel gradeLabel = new JLabel("Enter your grade level");
		gradeLabel.setForeground(Color.WHITE);
		gradeLabel.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		gradeLabel.setBounds(58, 625, 346, 39);
		panel_accCreate.add(gradeLabel);

		JLabel astromath = new JLabel("ASTROMATH");
		astromath.setForeground(Color.WHITE);
		astromath.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
		astromath.setBounds(98, 39, 745, 52);
		panel_accCreate.add(astromath);

		JTextField userName = new JTextField();
		userName.setFont(new Font("A-Space Demo", Font.PLAIN, 26));
		userName.setForeground(Color.WHITE);
		userName.setBackground(new Color(26, 38, 83));
		userName.setBounds(52, 163, 592, 56);
		userName.setBorder(new LineBorder(new Color(0, 195, 255), 3, true));
		panel_accCreate.add(userName);
		userName.setColumns(10);

		JTextField userEmail = new JTextField();
		userEmail.setForeground(Color.WHITE);
		userEmail.setFont(new Font("A-Space Demo", Font.PLAIN, 26));
		userEmail.setColumns(10);
		userEmail.setBackground(new Color(26, 38, 83));
		userEmail.setBounds(52, 259, 592, 56);
		userEmail.setBorder(new LineBorder(new Color(0, 195, 255), 3, true));
		panel_accCreate.add(userEmail);

		JPasswordField userPassword = new JPasswordField();
		userPassword.setForeground(Color.WHITE);
		userPassword.setFont(new Font("A-Space Demo", Font.PLAIN, 26));
		userPassword.setColumns(10);
		userPassword.setBackground(new Color(26, 38, 83));
		userPassword.setBounds(52, 352, 592, 56);
		userPassword.setBorder(new LineBorder(new Color(0, 195, 255), 3, true));
		panel_accCreate.add(userPassword);

		gradeLevel = new JTextField();
		gradeLevel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (gradeLevel.getText().length() >= 1) // limit textfield to 1 characters
					e.consume();
			}
		});
		gradeLevel.setForeground(Color.WHITE);
		gradeLevel.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		gradeLevel.setBackground(new Color(26, 38, 83));
		gradeLevel.setBounds(392, 618, 78, 52);
		gradeLevel.setColumns(10);
		gradeLevel.setBorder(new LineBorder(new Color(0, 195, 255), 3, true));
		panel_accCreate.add(gradeLevel);

		GovName = new JTextField();
		GovName.setForeground(Color.WHITE);
		GovName.setFont(new Font("A-Space Demo", Font.PLAIN, 26));
		GovName.setBackground(new Color(26, 38, 83));
		GovName.setBounds(52, 533, 592, 56);
		panel_accCreate.add(GovName);
		GovName.setBorder(new LineBorder(new Color(0, 195, 255), 3, true));
		GovName.setColumns(10);

		JLabel casePasswordReq = new JLabel("Your password must have at least 1 Uppercase character\r\n");
		casePasswordReq.setForeground(Color.WHITE);
		casePasswordReq.setFont(new Font("A-Space Demo", Font.PLAIN, 15));
		casePasswordReq.setBounds(52, 399, 604, 52);
		panel_accCreate.add(casePasswordReq);

		JLabel characterReq = new JLabel("At least 6 characters long\r\n");
		characterReq.setForeground(Color.WHITE);
		characterReq.setFont(new Font("A-Space Demo", Font.PLAIN, 15));
		characterReq.setBounds(52, 432, 604, 39);
		panel_accCreate.add(characterReq);

		JLabel numberChar = new JLabel("At least one number\r\n");
		numberChar.setForeground(Color.WHITE);
		numberChar.setFont(new Font("A-Space Demo", Font.PLAIN, 15));
		numberChar.setBounds(52, 461, 604, 39);
		panel_accCreate.add(numberChar);

		// my sql database register stuff
		JButton registerButton = new JButton("Register");
		registerButton.setForeground(new Color(127, 255, 212));
		registerButton.setBackground(new Color(26, 38, 83));
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String temp = userPassword.getText();
				if (checkString(temp) && temp.length() >= 6) {

					String gradeString = gradeLevel.getText();
					if (!(gradeString.equals("0")) && !(gradeString.equals("1")) && !(gradeString.equals("2"))
							&& !(gradeString.equals("3")) && !(gradeString.equals("4"))) {
						gradeString = "0";
					}

					var username = userName.getText();
					var email = userEmail.getText();
					var password = userPassword.getText();
					var grade = gradeString;
					var name = GovName.getText();

					// userID
					int userID;
					Random rand = new Random();
					userID = rand.nextInt(1000000 - 100000) + 100000;

					try {
						Connection connection = DriverManager.getConnection(
								"jdbc:mysql://sql5.freesqldatabase.com/sql5458377", "sql5458377", "FKhgpmjDr9");
						String query = "SELECT * from userinfo WHERE userID = '" + userID + "'";
						Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_READ_ONLY);
						ResultSet rs = st.executeQuery(query); // execute the query, and get a java resultset

						// if this ID already exists, we quit
						if (rs.absolute(1)) {

							JLabel labelIncorrect = new JLabel("This account already exist");
							labelIncorrect.setForeground(new Color(255, 66, 66));
							labelIncorrect.setBackground(new Color(26, 38, 83));
							labelIncorrect.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
							labelIncorrect.setBounds(1009, 540, 218, 68);
							panel_accCreate.add(labelIncorrect);

						}

						String query1 = "INSERT INTO userinfo(`username`, `password`, `email`, `grade`, `name`, userID) "
								+ "VALUES ('" + username + "','" + password + "','" + email + "','" + grade + "','"
								+ name + "','" + userID + "')";

						Statement sta = connection.createStatement();
						int x = sta.executeUpdate(query1);
						if (x == 0) {
							JOptionPane.showMessageDialog(registerButton,
									"This account with this email already exists.");
						} else {
							String msg = name;
							JOptionPane.showMessageDialog(registerButton,
									"Welcome, " + msg + ". Your account has been successfully created.");
							Login panel_login = new Login(lp, test, student, con);
							switch_screen(panel_login.getPanel(), lp, test, student, con);

						}

					} catch (Exception exception) {
						exception.printStackTrace();
					}
				} else {

					numberChar.setForeground(new Color(255, 66, 66));
					characterReq.setForeground(new Color(255, 66, 66));
					casePasswordReq.setForeground(new Color(255, 66, 66));

				}
			}
		});

		registerButton.setFont(new Font("A-Space Demo", Font.PLAIN, 27));
		registerButton.setBounds(1009, 596, 218, 68);
		panel_accCreate.add(registerButton);

		JLabel LabelName = new JLabel("Enter a display name");
		LabelName.setForeground(new Color(255, 255, 255));
		LabelName.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		LabelName.setBounds(52, 495, 766, 32);
		panel_accCreate.add(LabelName);

		JTextArea txtrIfInKindergarden = new JTextArea();
		txtrIfInKindergarden.setForeground(Color.WHITE);
		txtrIfInKindergarden.setFont(new Font("A-Space Demo", Font.PLAIN, 16));
		txtrIfInKindergarden.setEditable(false);
		txtrIfInKindergarden.setBackground(new Color(77, 58, 129));
		txtrIfInKindergarden.setLineWrap(true);
		txtrIfInKindergarden.setText("If in Kindergarden put K in the box");
		txtrIfInKindergarden.setBounds(480, 625, 206, 70);
		panel_accCreate.add(txtrIfInKindergarden);

		JLabel astronaut = new JLabel("");
		astronaut.setIcon(new ImageIcon(".\\Assets\\images\\astronaut.png"));
		astronaut.setBounds(614, -93, 1009, 960);
		panel_accCreate.add(astronaut);

		JLabel labelIncorrect = new JLabel("");
		labelIncorrect.setVisible(false);
		labelIncorrect.setForeground(new Color(255, 66, 66));
		labelIncorrect.setBackground(new Color(26, 38, 83));
		labelIncorrect.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		labelIncorrect.setBounds(1009, 540, 218, 68);
		panel_accCreate.add(labelIncorrect);

		// end of button function to create a user

	}

	public JPanel getPanel() {
		return panel_accCreate;

	}

	public void switch_screen(JPanel p, JLayeredPane lp, Test test, Student student, Connection con) {
		lp.removeAll();
		p.setLayout(null);
		lp.add(p);
		lp.repaint();
		lp.revalidate();

	}

	private static boolean checkString(String str) {
		char ch;
		boolean capitalFlag = false;
		boolean lowerCaseFlag = false;
		boolean numberFlag = false;
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (Character.isDigit(ch)) {
				numberFlag = true;
			} else if (Character.isUpperCase(ch)) {
				capitalFlag = true;
			} else if (Character.isLowerCase(ch)) {
				lowerCaseFlag = true;
			}
			if (numberFlag && capitalFlag && lowerCaseFlag)
				return true;
		}
		return false;
	}
}
