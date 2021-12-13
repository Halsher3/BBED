import javax.swing.JFrame;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.*;
import javax.swing.JTextField;

public class PasswordChange extends JPanel {

	private JFrame frame;
	private JPanel panel_PasswordChange = new JPanel();
	private JLabel image_logout = new JLabel("");
	private JLabel image_settings = new JLabel("");
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int height = screenSize.height;
	private int width = screenSize.width;
	private JTextField username;
	private JTextField password;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public PasswordChange(JLayeredPane lp, Test test, Student student, Connection con) {
		
		panel_PasswordChange.setBounds(0, 0, 1262, 681);
		panel_PasswordChange.setBackground(new Color(77,58,129));
		panel_PasswordChange.setLayout(null);
		
		JLabel imageHome = new JLabel("");
		imageHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainWindow panel_home = new MainWindow(lp, test, student, con);
				switch_screen(panel_home.getPanel(), lp, test, student, con);
			}
		});
		imageHome.setIcon(new ImageIcon(".\\assets\\images\\home.png"));
		imageHome.setBounds(40, 21, 64, 74);
		panel_PasswordChange.add(imageHome);
		// Placeholder variables to use for Student name and Student grade
		
		JLabel labelLogo = new JLabel("ASTROMATH");
		
		labelLogo.setIcon(null);
		labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
		labelLogo.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
		labelLogo.setForeground(new Color(255, 255, 255));
		labelLogo.setBounds(97, 21, 318, 85);
		panel_PasswordChange.add(labelLogo);
		
		// Does a hover effect on the AstroMath text with the home button
		
		labelLogo.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				labelLogo.setForeground(new Color(0, 195, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				labelLogo.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				MainWindow panel_home = new MainWindow(lp, test, student, con);
				switch_screen(panel_home.getPanel(), lp, test, student, con);
			}
		});
		
		JLabel image_logout = new JLabel("");
		image_logout.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				image_logout.setIcon(new ImageIcon(".\\assets\\images\\logout v2.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				image_logout.setIcon(new ImageIcon(".\\assets\\images\\logout.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Login panel_login = new Login(lp, test, student, con);
				switch_screen(panel_login.getPanel(), lp, test, student, con);
			}
		});
		image_logout.setIcon(new ImageIcon(".\\assets\\images\\logout.png"));
		image_logout.setBounds(1192, 15, 72, 91);
		panel_PasswordChange.add(image_logout);
		
		JLabel imageSettings = new JLabel("");
		imageSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccountSettings panel_acc = new AccountSettings(lp, test, student, con);
				switch_screen(panel_acc.getPanel(), lp, test, student, con);
			}
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				image_settings.setIcon(new ImageIcon(".\\assets\\images\\gear v2.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				image_settings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
			}
		});

		imageSettings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
		imageSettings.setBounds(1188, 99, 64, 64);
		panel_PasswordChange.add(imageSettings);
		
		JLabel accountSettings = new JLabel("Account Settings");
		accountSettings.setForeground(new Color(0, 195, 255));
		accountSettings.setFont(new Font("a Atmospheric", Font.PLAIN, 30));
		accountSettings.setBounds(68, 77, 782, 96);
		panel_PasswordChange.add(accountSettings);
		
		
		JLabel passwordLabel = new JLabel("Enter a new Password");
		passwordLabel.setBounds(68, 273, 616, 96);
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("A-Space Demo", Font.PLAIN, 40));
		panel_PasswordChange.add(passwordLabel);
		
		JLabel astronaut = new JLabel("");
		astronaut.setIcon(new ImageIcon(".\\Assets\\images\\astronaut.png"));
		astronaut.setBounds(614, -93, 1009, 960);
		panel_PasswordChange.add(astronaut);
		
		password = new JTextField();
		password.setBounds(68, 379, 627, 79);
		password.setFont(new Font("A-Space Demo", Font.PLAIN, 26));
		password.setForeground(Color.WHITE);
		password.setBackground(new Color(26, 38, 83));
		password.setBorder(new LineBorder(new Color(0, 195, 255), 3, true));
		panel_PasswordChange.add(password);
		password.setColumns(10);
		
		//student name
		JLabel label_name = new JLabel(student.getName());
		label_name.setHorizontalAlignment(SwingConstants.RIGHT);
		label_name.setForeground(Color.WHITE);
		label_name.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
		label_name.setBounds(765, 21, 417, 44);
		panel_PasswordChange.add(label_name);
		
		//student grade
		JLabel label_grade;
		if(student.getGradeLevel() == 0) {
			label_grade = new JLabel("K");
			label_grade.setHorizontalAlignment(SwingConstants.RIGHT);
			label_grade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
			label_grade.setForeground(new Color(0, 195, 255));
			label_grade.setBounds(874, 59, 308, 44);
			panel_PasswordChange.add(label_grade);
			
		} else {
		label_grade = new JLabel(String.format("Grade: %d", student.getGradeLevel()));
		label_grade.setHorizontalAlignment(SwingConstants.RIGHT);
		label_grade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
		label_grade.setForeground(new Color(0, 195, 255));
		label_grade.setBounds(874, 59, 308, 44);
		panel_PasswordChange.add(label_grade);
		}
		
		JLabel casePasswordReq = new JLabel("Your password must have at least 1 Uppercase character\r\n");
		casePasswordReq.setForeground(Color.WHITE);
		casePasswordReq.setFont(new Font("A-Space Demo", Font.PLAIN, 15));
		casePasswordReq.setBounds(52, 175, 604, 52);
		panel_PasswordChange.add(casePasswordReq);
		
		JLabel characterReq = new JLabel("At least 6 characters long\r\n");
		characterReq.setForeground(Color.WHITE);
		characterReq.setFont(new Font("A-Space Demo", Font.PLAIN, 15));
		characterReq.setBounds(52, 205, 604, 39);
		panel_PasswordChange.add(characterReq);
		
		JLabel specialCharReq = new JLabel("At least one special character (!, ?, /, *, &, ^, etc.)\r\n");
		specialCharReq.setForeground(Color.WHITE);
		specialCharReq.setFont(new Font("A-Space Demo", Font.PLAIN, 15));
		specialCharReq.setBounds(52, 235, 604, 39);
		panel_PasswordChange.add(specialCharReq);
		
		//UPDATE STUFF
		JButton updateButton = new JButton("Update");
        updateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
            	//password requirements
            	String temp = password.getText();
				if(checkString(temp) && temp.length() >= 6) {
					
				
				var newPassword = password.getText();
                try {
                	Connection connection = DriverManager.getConnection("jdbc:mysql://sql5.freesqldatabase.com/sql5458377","sql5458377","FKhgpmjDr9");
                	
                	String query = "UPDATE userinfo SET password = '" + newPassword + "' WHERE userID = '" + student.getAccNum() + "'";
                	Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                	
                	st.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Password change is successful!"); 	
					
					AccountSettings panel_acc = new AccountSettings(lp, test, student, con);
					switch_screen(panel_acc.getPanel(), lp, test, student, con);
                	
                	
                } catch (Exception exception) {
                	exception.printStackTrace();
                }
                
				} else {
					specialCharReq.setForeground(new Color(255, 66, 66));
					characterReq.setForeground(new Color(255, 66, 66));
					casePasswordReq.setForeground(new Color(255, 66, 66));
				}
            }//needs password requirements
            
        });
        updateButton.setBackground(new Color(26, 38, 83));
        updateButton.setHorizontalAlignment(SwingConstants.CENTER);
        updateButton.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
        updateButton.setForeground(new Color(127, 255, 212));
        updateButton.setBounds(176, 479, 384, 85);
        panel_PasswordChange.add(updateButton);

		
		
	} //end of PasswordChange
	
	public JPanel getPanel()
	{
		return panel_PasswordChange;
		
	}
	public void switch_screen(JPanel p, JLayeredPane lp, Test test, Student student, Connection con)
	{
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
	    for(int i=0;i < str.length();i++) {
	        ch = str.charAt(i);
	        if( Character.isDigit(ch)) {
	            numberFlag = true;
	        }
	        else if (Character.isUpperCase(ch)) {
	            capitalFlag = true;
	        } else if (Character.isLowerCase(ch)) {
	            lowerCaseFlag = true;
	        }
	        if(numberFlag && capitalFlag && lowerCaseFlag)
	            return true;
	    }
	    return false;
	}
}
