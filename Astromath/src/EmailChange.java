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

public class EmailChange extends JPanel {

	private JFrame frame;
	private JPanel panel_EmailChange = new JPanel();
	private JLabel image_logout = new JLabel("");
	private JLabel image_settings = new JLabel("");
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int height = screenSize.height;
	private int width = screenSize.width;
	private JTextField email;

	/**
	 * Allows the user to change their email, in the created EmailChange page.
	 */
	public EmailChange(JLayeredPane lp, Test test, Student student, Connection con) {

		panel_EmailChange.setBounds(0, 0, 1262, 681);
		panel_EmailChange.setBackground(new Color(77, 58, 129));
		panel_EmailChange.setLayout(null);

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
		panel_EmailChange.add(imageHome);

		JLabel labelLogo = new JLabel("ASTROMATH");

		labelLogo.setIcon(null);
		labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
		labelLogo.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
		labelLogo.setForeground(new Color(255, 255, 255));
		labelLogo.setBounds(97, 21, 318, 85);
		panel_EmailChange.add(labelLogo);

		// Does a hover effect on the AstroMath text with the home button

		labelLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labelLogo.setForeground(new Color(0, 195, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				labelLogo.setForeground(Color.WHITE);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				MainWindow panel_home = new MainWindow(lp, test, student, con);
				switch_screen(panel_home.getPanel(), lp, test, student, con);
			}
		});

		JLabel image_logout = new JLabel("");
		image_logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				image_logout.setIcon(new ImageIcon(".\\assets\\images\\logout v2.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				image_logout.setIcon(new ImageIcon(".\\assets\\images\\logout.png"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Login panel_login = new Login(lp, test, student, con);
				switch_screen(panel_login.getPanel(), lp, test, student, con);
			}
		});
		image_logout.setIcon(new ImageIcon(".\\assets\\images\\logout.png"));
		image_logout.setBounds(1192, 15, 72, 91);
		panel_EmailChange.add(image_logout);

		JLabel imageSettings = new JLabel("");
		imageSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccountSettings panel_acc = new AccountSettings(lp, test, student, con);
				switch_screen(panel_acc.getPanel(), lp, test, student, con);
			}

			public void mouseEntered(MouseEvent e) {
				image_settings.setIcon(new ImageIcon(".\\assets\\images\\gear v2.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				image_settings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
			}
		});

		imageSettings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
		imageSettings.setBounds(1188, 99, 64, 64);
		panel_EmailChange.add(imageSettings);

		JLabel accountSettings = new JLabel("Account Settings");
		accountSettings.setForeground(new Color(0, 195, 255));
		accountSettings.setFont(new Font("a Atmospheric", Font.PLAIN, 30));
		accountSettings.setBounds(68, 77, 782, 96);
		panel_EmailChange.add(accountSettings);

		JLabel emailLabel = new JLabel("Enter a new Email");
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		emailLabel.setBounds(68, 273, 616, 96);
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(new Font("A-Space Demo", Font.PLAIN, 40));
		panel_EmailChange.add(emailLabel);

		JLabel astronaut = new JLabel("");
		astronaut.setIcon(new ImageIcon(".\\Assets\\images\\astronaut.png"));
		astronaut.setBounds(614, -93, 1009, 960);
		panel_EmailChange.add(astronaut);

		email = new JTextField();
		email.setBounds(68, 379, 627, 79);
		email.setFont(new Font("A-Space Demo", Font.PLAIN, 26));
		email.setForeground(Color.WHITE);
		email.setBackground(new Color(26, 38, 83));
		email.setBorder(new LineBorder(new Color(0, 195, 255), 3, true));
		panel_EmailChange.add(email);
		email.setColumns(10);

		// student name
		JLabel label_name = new JLabel(student.getName());
		label_name.setHorizontalAlignment(SwingConstants.RIGHT);
		label_name.setForeground(Color.WHITE);
		label_name.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
		label_name.setBounds(765, 21, 417, 44);
		panel_EmailChange.add(label_name);

		// student grade
		JLabel label_grade;
		if (student.getGradeLevel() == 0) {
			label_grade = new JLabel("K");
			label_grade.setHorizontalAlignment(SwingConstants.RIGHT);
			label_grade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
			label_grade.setForeground(new Color(0, 195, 255));
			label_grade.setBounds(874, 59, 308, 44);
			panel_EmailChange.add(label_grade);

		} else {
			label_grade = new JLabel(String.format("Grade: %d", student.getGradeLevel()));
			label_grade.setHorizontalAlignment(SwingConstants.RIGHT);
			label_grade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
			label_grade.setForeground(new Color(0, 195, 255));
			label_grade.setBounds(874, 59, 308, 44);
			panel_EmailChange.add(label_grade);
		}

		// UPDATE STUFF
		JButton updateButton = new JButton("Update");
		updateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				var newEmail = email.getText();
				try {
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://sql5.freesqldatabase.com/sql5458377", "sql5458377", "FKhgpmjDr9");

					String query = "UPDATE userinfo SET email = '" + newEmail + "' WHERE userID = '"
							+ student.getAccNum() + "'";
					Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);

					st.executeUpdate(query);

					JOptionPane.showMessageDialog(null, "Email change is successful!");

					AccountSettings panel_acc = new AccountSettings(lp, test, student, con);
					switch_screen(panel_acc.getPanel(), lp, test, student, con);

				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		updateButton.setBackground(new Color(26, 38, 83));
		updateButton.setHorizontalAlignment(SwingConstants.CENTER);
		updateButton.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		updateButton.setForeground(new Color(127, 255, 212));
		updateButton.setBounds(176, 479, 384, 85);
		panel_EmailChange.add(updateButton);

	} // end of EmailChange

	public JPanel getPanel() {
		return panel_EmailChange;

	}

	public void switch_screen(JPanel p, JLayeredPane lp, Test test, Student student, Connection con) {
		lp.removeAll();
		p.setLayout(null);
		lp.add(p);
		lp.repaint();
		lp.revalidate();

	}

}
