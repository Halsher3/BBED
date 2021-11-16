package bs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField name_field;
	private JTextField user_field;
	private JTextField password_field;
	private JTextField organization_field;
	private JTextField dob_field;
	private JTextField phone_field;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public MainWindow() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	Connection connection=null;
	
	public void createTableNew()
	{
		try
		{
			DatabaseMetaData dmd = connection.getMetaData();
			ResultSet set = dmd.getTables(null, null, "USERTABLE", null);
			
			if(set.next())
			{
				
			}
			else
			{
				String create_table="create table USERTABLE ("
					+ "name varchar2(20), "
					+ "username varchar2(15), "
					+ "password varchar2(15), "
					+ "organization varchar2(20), "
					+ "dateofbirth varchar2(12), mobile "
					+ "varchar2(11))";
				
				PreparedStatement statement = connection.prepareStatement(create_table);
				statement.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Table Create Sucessfully");
			}
		}
		catch (Exception e)
		{
			
		}
	}
	
	private void initialize() throws SQLException {
		// create database connection, am using h2 embded database
		// first add jdbc jar to your project
		
		try
		{
			Class.forName("org.h2.Driver");
			connection=DriverManager.getConnection("jdbc:h2:~/test","sa","");
			
			JOptionPane.showInternalMessageDialog(null, "Connection Success!!!!");
		}
		catch (ClassNotFoundException e1)
		{
			e1.printStackTrace();
		}
		
		
		frame = new JFrame();
		frame.setBounds(200, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Simple Billing System");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		lblNewLabel.setBounds(291, 11, 391, 85);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(92, 175, 262, 71);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(545, 191, 364, 44);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(545, 263, 364, 44);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(416, 188, 119, 44);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(416, 260, 119, 44);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Returning User");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_2.setBounds(628, 142, 211, 38);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				try 
				{
					String validate="select * from usertable where username=? and password=?";
					PreparedStatement statement=connection.prepareStatement(validate);
					statement.setString(1, user_field.getText());
					statement.setString(2, password_field.getText());
					ResultSet set=statement.executeQuery();
					
					if(set.next())
					{
						JOptionPane.showInternalMessageDialog(null, "Login Sucessful");
						new Tasks().setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid Username or Password");
					}
					
					
				} catch (SQLException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(687, 318, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		panel = new JPanel();
		
		panel.setVisible(false);
		// make variable global
		panel.setBounds(10, 296, 452, 239);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(10, 33, 77, 27);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Username");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3_1.setBounds(10, 77, 92, 27);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Password");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3_2.setBounds(10, 115, 92, 37);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Organization");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3_3.setBounds(10, 163, 107, 27);
		panel.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Birthday");
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3_4.setBounds(10, 201, 92, 27);
		panel.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("Phone");
		lblNewLabel_3_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3_5.setBounds(250, 33, 77, 27);
		panel.add(lblNewLabel_3_5);
		
		JButton btnNewButton_2 = new JButton("Create Account");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				try
				{
					String insert_data="insert into USERTABLE values(?,?,?,?,?)";
					PreparedStatement statement=connection.prepareStatement(insert_data);
					statement.setString(1, name_field.getText());
					statement.setString(2, user_field.getText());
					statement.setString(3, password_field.getText());
					statement.setString(4, organization_field.getText());
					statement.setString(5, dob_field.getText());
					statement.setString(6, phone_field.getText());
					
					int data_entered=statement.executeUpdate();
					
					if(data_entered>0)
					{
						JOptionPane.showMessageDialog(null, "Data inserted succesfully");
						frame.setVisible(false);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Unable to insert data.");
					}
					
					
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_2.setBounds(275, 82, 123, 27);
		panel.add(btnNewButton_2);
		
		name_field = new JTextField();
		name_field.setBounds(117, 36, 123, 27);
		panel.add(name_field);
		name_field.setColumns(10);
		
		user_field = new JTextField();
		user_field.setColumns(10);
		user_field.setBounds(117, 83, 123, 27);
		panel.add(user_field);
		
		password_field = new JTextField();
		password_field.setColumns(10);
		password_field.setBounds(112, 126, 123, 27);
		panel.add(password_field);
		
		organization_field = new JTextField();
		organization_field.setColumns(10);
		organization_field.setBounds(117, 169, 123, 27);
		panel.add(organization_field);
		
		dob_field = new JTextField();
		dob_field.setColumns(10);
		dob_field.setBounds(117, 207, 123, 27);
		panel.add(dob_field);
		
		phone_field = new JTextField();
		phone_field.setColumns(10);
		phone_field.setBounds(319, 33, 123, 27);
		panel.add(phone_field);
		
		JLabel lblNewLabel_2_1 = new JLabel("New User");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_2_1.setBounds(113, 121, 211, 38);
		frame.getContentPane().add(lblNewLabel_2_1);
	}
}
