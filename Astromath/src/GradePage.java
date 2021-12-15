import java.awt.Color;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class GradePage extends JPanel {

	private JFrame frame;
	private JLabel label_name = new JLabel("");
	private JLabel label_grade = new JLabel("");
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int height = screenSize.height;
	private int width = screenSize.width;

	private JPanel panel_grades = new JPanel();
	
	/*
	 * Creates the GradePage page, allows the student to check their grades, which are pulled from the database.
	 * By default it is zero, if a test isnt taken.
	 */
	public GradePage(JLayeredPane lp, Test test, Student student, Connection con) {

		panel_grades.setBounds(0, 0, 1262, 681);
		panel_grades.setBackground(new Color(77, 58, 129));
		panel_grades.setLayout(null);

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
		panel_grades.add(imageHome);

		if (student.getGradeLevel() == 0) {
			label_grade = new JLabel("K");
			label_grade.setHorizontalAlignment(SwingConstants.RIGHT);
			label_grade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
			label_grade.setForeground(new Color(0, 195, 255));
			label_grade.setBounds(874, 59, 308, 44);
			panel_grades.add(label_grade);

		} else {
			label_grade = new JLabel(String.format("Grade: %d", student.getGradeLevel()));
			label_grade.setHorizontalAlignment(SwingConstants.RIGHT);
			label_grade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
			label_grade.setForeground(new Color(0, 195, 255));
			label_grade.setBounds(874, 59, 308, 44);
			panel_grades.add(label_grade);
		}

		label_name = new JLabel(student.getName());
		label_name.setHorizontalAlignment(SwingConstants.RIGHT);
		label_name.setForeground(Color.WHITE);
		label_name.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
		label_name.setBounds(765, 21, 417, 44);
		panel_grades.add(label_name);

		// Code for the logo in the upper left corner and Astromath text

		JLabel labelLogo = new JLabel("ASTROMATH");
		labelLogo.setBounds(97, 21, 318, 85);

		labelLogo.setIcon(null);
		labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
		labelLogo.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
		labelLogo.setForeground(new Color(255, 255, 255));
		panel_grades.add(labelLogo);

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

			public void mouseClicked(MouseEvent e) {
				MainWindow panel_home = new MainWindow(lp, test, student, con);
				switch_screen(panel_home.getPanel(), lp, test, student, con);

			}
		});

		// Logout button

		JLabel imageLogout = new JLabel("");
		imageLogout.setBounds(1192, 15, 72, 91);
		imageLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				imageLogout.setIcon(new ImageIcon(".\\assets\\images\\logout v2.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				imageLogout.setIcon(new ImageIcon(".\\assets\\images\\logout.png"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Login panel_login = new Login(lp, test, student, con);
				switch_screen(panel_login.getPanel(), lp, test, student, con);

			}
		});
		imageLogout.setIcon(new ImageIcon(".\\assets\\images\\logout.png"));
		panel_grades.add(imageLogout);

		JLabel image_settings = new JLabel("");
		image_settings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccountSettings panel_acc = new AccountSettings(lp, test, student, con);
				switch_screen(panel_acc.getPanel(), lp, test, student, con);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				image_settings.setIcon(new ImageIcon(".\\assets\\images\\gear v2.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				image_settings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
			}
		});
		image_settings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
		image_settings.setBounds(1188, 99, 64, 64);
		panel_grades.add(image_settings);

		JLabel lblNewLabel = new JLabel("Grades");
		lblNewLabel.setBounds(82, 89, 782, 96);
		lblNewLabel.setForeground(new Color(0, 195, 255));
		lblNewLabel.setFont(new Font("a Atmospheric", Font.PLAIN, 30));
		panel_grades.add(lblNewLabel);

		// background for the grades

		JPanel panel = new JPanel();
		panel.setBounds(42, 220, 1140, 430);
		panel.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
		panel.setBackground(new Color(26, 38, 83));
		panel_grades.add(panel);
		panel.setLayout(null);

		if (student.getGradeLevel() < 3) {
			JLabel lblNewLabel_1 = new JLabel("Addition Test");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
			lblNewLabel_1.setBounds(37, 25, 458, 93);
			panel.add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel("Subtraction Test");
			lblNewLabel_2.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setBounds(37, 125, 580, 93);
			panel.add(lblNewLabel_2);
		} else {
			JLabel lblNewLabel_1 = new JLabel("Multiplication Test");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
			lblNewLabel_1.setBounds(37, 25, 458, 93);
			panel.add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel("Division Test");
			lblNewLabel_2.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setBounds(37, 125, 580, 93);
			panel.add(lblNewLabel_2);
		}

		JLabel lblNewLabel_3 = new JLabel("True Or False Test");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
		lblNewLabel_3.setBounds(37, 225, 487, 93);
		panel.add(lblNewLabel_3);

		JLabel lblfitb = new JLabel("Fill In The Blank Test");
		lblfitb.setForeground(Color.WHITE);
		lblfitb.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
		lblfitb.setBounds(37, 325, 487, 93);
		panel.add(lblfitb);

		int grade1 = 0;
		int grade2 = 0;
		int grade3 = 0;
		int grade4 = 0;

		try {
			String query = "Select testScore1,testScore2,testScore3,testScore4 from testinfo where userID = '"
					+ student.getAccNum() + "'";
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(query);
			rs.first();
			grade1 = rs.getInt(1);
			grade2 = rs.getInt(2);
			grade3 = rs.getInt(3);
			grade4 = rs.getInt(4);
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		JLabel lblNewLabel_4 = new JLabel("Grade: " + grade1);
		lblNewLabel_4.setForeground(new Color(0, 255, 153));
		lblNewLabel_4.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
		lblNewLabel_4.setBounds(740, 25, 355, 87);
		lblNewLabel_4.setBackground(new Color(0, 255, 153));
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Grade: " + grade2);
		lblNewLabel_5.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
		lblNewLabel_5.setForeground(new Color(0, 255, 153));
		lblNewLabel_5.setBounds(740, 125, 355, 87);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Grade: " + grade3);
		lblNewLabel_6.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
		lblNewLabel_6.setForeground(new Color(0, 255, 153));
		lblNewLabel_6.setBounds(740, 225, 183, 70);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Grade: " + grade4);
		lblNewLabel_7.setFont(new Font("A-Space Demo", Font.PLAIN, 28));
		lblNewLabel_7.setForeground(new Color(0, 255, 153));
		lblNewLabel_7.setBounds(740, 325, 183, 70);
		panel.add(lblNewLabel_7);

		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(".\\Assets\\images\\asteroid1.png"));
		lblNewLabel_9.setBounds(-67, 51, 400, 400);
		panel_grades.add(lblNewLabel_9);

		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(606, -67, 400, 400);
		lblNewLabel_8.setIcon(new ImageIcon(".\\Assets\\images\\satellite1.png"));
		panel_grades.add(lblNewLabel_8);
		// dont touch these or else the code will die fr fr -eddy

	}

	public JPanel getPanel() {
		return panel_grades;

	}

	public void switch_screen(JPanel p, JLayeredPane lp, Test test, Student student, Connection con) {
		lp.removeAll();
		p.setLayout(null);
		lp.add(p);
		lp.repaint();
		lp.revalidate();

	}

}
