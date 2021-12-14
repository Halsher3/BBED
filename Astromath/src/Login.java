import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;

import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JPanel 
{

	private JPanel panel_login = new JPanel();
	private JTextField textUsername;
	private JPasswordField textPassword;
	private Student goku = new Student("goku7", "menameisgoku@gmail.com", "dragonballs", 1234, 1, 1, "");
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
	public Login(JLayeredPane lp, Test test, Student student, Connection con) 
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
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try  {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con= DriverManager.getConnection("jdbc:mysql://sql5.freesqldatabase.com/sql5458377","sql5458377","FKhgpmjDr9"); 
					Statement stmt=con.createStatement();
					var sql="Select * from userinfo where username='"+textUsername.getText()+"' and password='"+textPassword.getText()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
					{
						
						
						student.setUsername(labelUsername.getText());
						student.setPassword(labelPassword.getText());
						
						String query = "Select userID, userLevel, grade, email, name from userinfo where username = '" +textUsername.getText() +  "'";
						

						try {
							Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							 rs = st.executeQuery(query);
							 rs.first();
							 student.setAccNum(rs.getInt(1));
							 student.setLevel(rs.getInt(2));
							 student.setGradeLevel(rs.getInt(3));
							 student.setEmail(rs.getString(4));
							 student.setName(rs.getString(5));
						} catch (SQLException e1) {

							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null,"Login Success!"); 	
						MainWindow panel_home = new MainWindow(lp, test, student, con);
						switch_screen(panel_home.getPanel(), lp, test, student, con);
					}
						
					else
						labelIncorrect.setVisible(true);;
					
					/*
					 The login will connect and work but it needs to lead into the homepage with all its data
					 */
						
				}catch(Exception w) {System.out.print(w);}
			}
		});
		
		/* OLD LOGIN STUFF
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
					
					labelIncorrect.setVisible(true);;
				}
			}
		});
		*/
		
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setFont(new Font("A-Space Demo", Font.PLAIN, 24));
		btnLogin.setBounds(412, 588, 370, 68);
		panel_login.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\\\assets\\\\images\\\\astro.png"));
		lblNewLabel.setBounds(-19, 325, 370, 424);
		panel_login.add(lblNewLabel);
		
		JButton lblNewLabel_1 = new JButton("New Student?");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				AccountCreations panel_home = new AccountCreations(lp, test, student, con);
				switch_screen(panel_home.getPanel(), lp, test, student, con);
			}
		});
		lblNewLabel_1.setBackground(new Color(26, 38, 83));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		lblNewLabel_1.setForeground(new Color(127, 255, 212));
		lblNewLabel_1.setBounds(964, 602, 288, 68);
		panel_login.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(".\\Assets\\images\\satellite1.png"));
		lblNewLabel_2.setBounds(859, 38, 393, 460);
		panel_login.add(lblNewLabel_2);
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
	public void switch_screen(JPanel p, JLayeredPane lp, Test test, Student student, Connection con)
	{
		lp.removeAll();
		p.setLayout(null);
		lp.add(p);
		lp.repaint();
		lp.revalidate();
		

	}
	
}
