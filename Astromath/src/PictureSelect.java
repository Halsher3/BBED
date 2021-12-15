import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class PictureSelect extends JPanel {

	private JFrame frame;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int height = screenSize.height;
	private int width = screenSize.width;
	private JLabel label_name = new JLabel("Goku");
	private JLabel label_grade = new JLabel("1st Grade");
	boolean isSelected = false;
	private JLabel image_pfp1 = new JLabel("");
	private JLabel image_pfp2 = new JLabel("");
	private JLabel image_pfp3 = new JLabel("");
	private JLabel image_pfp4 = new JLabel("");
	private JLabel image_pfp5 = new JLabel("");
	private JLabel image_pfp6 = new JLabel("");
	private JLabel image_pfp7 = new JLabel("");
	private JLabel image_pfp8 = new JLabel("");
	private JLabel image_pfp9 = new JLabel("");
	private JLabel image_pfp10 = new JLabel("");
	private JLabel image_pfp11 = new JLabel("");
	private JLabel image_pfp12 = new JLabel("");
	private JLabel image_pfp13 = new JLabel("");
	private JLabel image_pfp14 = new JLabel("");
	private JLabel image_pfp15 = new JLabel("");

	private String pfpURL = "";

	private JPanel panel_pictureSelect = new JPanel();

	/**
	 * Creates the PictureSelect page, the student can select a profile picture from
	 * one of the 10 default ones or if they are a high enough level, they can
	 * select one of the 5 unlockables. If they are locked, they are unable to be
	 * selected, and only one picture will be able to be selected at a time, using
	 * the killborder function.
	 */
	public PictureSelect(JLayeredPane lp, Test test, Student student, Connection con) {

		panel_pictureSelect.setBounds(0, 0, 1262, 681);
		panel_pictureSelect.setBackground(new Color(77, 58, 129));
		panel_pictureSelect.setLayout(null);

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
		panel_pictureSelect.add(imageHome);

		if (student.getGradeLevel() == 0) {
			label_grade = new JLabel("K");
			label_grade.setHorizontalAlignment(SwingConstants.RIGHT);
			label_grade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
			label_grade.setForeground(new Color(0, 195, 255));
			label_grade.setBounds(874, 59, 308, 44);
			panel_pictureSelect.add(label_grade);

		} else {
			label_grade = new JLabel(String.format("Grade: %d", student.getGradeLevel()));
			label_grade.setHorizontalAlignment(SwingConstants.RIGHT);
			label_grade.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
			label_grade.setForeground(new Color(0, 195, 255));
			label_grade.setBounds(874, 59, 308, 44);
			panel_pictureSelect.add(label_grade);
		}

		label_name = new JLabel(student.getName());
		label_name.setHorizontalAlignment(SwingConstants.RIGHT);
		label_name.setForeground(Color.WHITE);
		label_name.setFont(new Font("A-Space Demo", Font.PLAIN, 21));
		label_name.setBounds(765, 21, 417, 44);
		panel_pictureSelect.add(label_name);

		// Code for the logo in the upper left corner and Astromath text

		JLabel labelLogo = new JLabel("ASTROMATH");

		labelLogo.setIcon(null);
		labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
		labelLogo.setFont(new Font("a Atmospheric", Font.PLAIN, 36));
		labelLogo.setForeground(new Color(255, 255, 255));
		labelLogo.setBounds(97, 21, 318, 85);
		panel_pictureSelect.add(labelLogo);

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

		// Logout button

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
		panel_pictureSelect.add(image_logout);

		JLabel imageSettings = new JLabel("");
		imageSettings.setIcon(new ImageIcon(".\\assets\\images\\gear.png"));
		imageSettings.setBounds(1188, 99, 64, 64);
		panel_pictureSelect.add(imageSettings);

		JLabel label_pfpSelect = new JLabel("Profile Picture Select");
		label_pfpSelect.setForeground(new Color(0, 195, 255));
		label_pfpSelect.setFont(new Font("a Atmospheric", Font.PLAIN, 30));
		label_pfpSelect.setBounds(68, 77, 782, 96);
		panel_pictureSelect.add(label_pfpSelect);

		image_pfp1.setBackground(Color.CYAN);
		image_pfp1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				killBorder(1);
				if (!isSelected) {
					image_pfp1.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
					isSelected = true;
					pfpURL = "pfp1.png";
				}
			}
		});
		image_pfp1.setIcon(new ImageIcon(".\\Assets\\images\\pfp1.png"));
		image_pfp1.setBounds(78, 184, 88, 83);
		panel_pictureSelect.add(image_pfp1);

		image_pfp2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				killBorder(2);
				if (!isSelected) {
					image_pfp2.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
					isSelected = true;
					pfpURL = "pfp2.png";
				}
			}
		});
		image_pfp2.setIcon(new ImageIcon(".\\Assets\\images\\pfp2.png"));
		image_pfp2.setBounds(211, 184, 88, 83);
		panel_pictureSelect.add(image_pfp2);

		image_pfp3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				killBorder(3);
				if (!isSelected) {
					image_pfp3.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
					isSelected = true;
					pfpURL = "pfp3.png";
				}
			}
		});
		image_pfp3.setIcon(new ImageIcon(".\\Assets\\images\\pfp3.png"));
		image_pfp3.setBounds(359, 184, 88, 83);
		panel_pictureSelect.add(image_pfp3);

		image_pfp4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				killBorder(4);
				if (!isSelected) {
					image_pfp4.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
					isSelected = true;
					pfpURL = "pfp4.png";
				}
			}
		});
		image_pfp4.setIcon(new ImageIcon(".\\Assets\\images\\pfp4.png"));
		image_pfp4.setBounds(500, 184, 88, 83);
		panel_pictureSelect.add(image_pfp4);

		image_pfp5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				killBorder(5);
				if (!isSelected) {
					image_pfp5.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
					isSelected = true;
					pfpURL = "pfp5.png";
				}
			}
		});
		image_pfp5.setIcon(new ImageIcon(".\\Assets\\images\\pfp5.png"));
		image_pfp5.setBounds(641, 184, 88, 83);
		panel_pictureSelect.add(image_pfp5);

		image_pfp6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				killBorder(6);
				if (!isSelected) {

					image_pfp6.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
					isSelected = true;
					pfpURL = "pfp6.png";
				}
			}
		});
		image_pfp6.setIcon(new ImageIcon(".\\\\Assets\\\\images\\\\pfp6.png"));
		image_pfp6.setBounds(78, 303, 88, 83);
		panel_pictureSelect.add(image_pfp6);

		image_pfp7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				killBorder(7);
				if (!isSelected) {

					image_pfp7.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
					isSelected = true;
					pfpURL = "pfp7.png";
				}
			}
		});
		image_pfp7.setIcon(new ImageIcon(".\\Assets\\images\\pfp7.png"));
		image_pfp7.setBounds(211, 303, 88, 83);
		panel_pictureSelect.add(image_pfp7);

		image_pfp8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				killBorder(8);
				if (!isSelected) {

					image_pfp8.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
					isSelected = true;
					pfpURL = "pfp8.png";
				}
			}
		});
		image_pfp8.setIcon(new ImageIcon(".\\Assets\\images\\pfp8.png"));
		image_pfp8.setBounds(359, 303, 88, 83);
		panel_pictureSelect.add(image_pfp8);

		image_pfp9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				killBorder(9);
				if (!isSelected) {
					image_pfp9.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
					isSelected = true;
					pfpURL = "pfp9.png";
				}
			}
		});
		image_pfp9.setIcon(new ImageIcon(".\\Assets\\images\\pfp9.png"));
		image_pfp9.setBounds(500, 303, 88, 83);
		panel_pictureSelect.add(image_pfp9);

		image_pfp10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				killBorder(10);
				if (!isSelected) {

					image_pfp10.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
					isSelected = true;
					pfpURL = "pfp10.png";
				}

			}
		});

		image_pfp10.setIcon(new ImageIcon(".\\Assets\\images\\pfp10.png"));
		image_pfp10.setBounds(641, 303, 88, 83);
		panel_pictureSelect.add(image_pfp10);

		image_pfp11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (student.getLevel() >= 20) {
					killBorder(11);
					if (!isSelected) {
						image_pfp11.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
						isSelected = true;
						pfpURL = "pfp11.png";
					}

				}

			}
		});

		if (student.getLevel() >= 20) {
			image_pfp11.setIcon(new ImageIcon(".\\Assets\\images\\pfp11.png"));
		} else {
			image_pfp11.setIcon(new ImageIcon(".\\Assets\\images\\pfp_locked.png"));
		}

		image_pfp11.setBounds(78, 416, 88, 83);
		panel_pictureSelect.add(image_pfp11);

		image_pfp12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (student.getLevel() >= 40) {
					killBorder(12);
					if (!isSelected) {
						image_pfp12.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
						isSelected = true;
						pfpURL = "pfp12.png";
					}
				}
			}
		});

		if (student.getLevel() >= 40) {
			image_pfp12.setIcon(new ImageIcon(".\\Assets\\images\\pfp12.png"));
		} else {
			image_pfp12.setIcon(new ImageIcon(".\\Assets\\images\\pfp_locked.png"));
		}
		image_pfp12.setBounds(211, 416, 88, 83);
		panel_pictureSelect.add(image_pfp12);

		image_pfp13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (student.getLevel() >= 60) {
					killBorder(13);
					if (!isSelected) {
						image_pfp13.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
						isSelected = true;
						pfpURL = "pfp13.png";
					}
				}

			}
		});

		if (student.getLevel() >= 60) {
			image_pfp13.setIcon(new ImageIcon(".\\Assets\\images\\pfp13.png"));
		} else {
			image_pfp13.setIcon(new ImageIcon(".\\Assets\\images\\pfp_locked.png"));
		}
		image_pfp13.setBounds(359, 416, 88, 83);
		panel_pictureSelect.add(image_pfp13);

		image_pfp14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (student.getLevel() >= 75) {
					killBorder(14);
					if (!isSelected) {
						image_pfp14.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
						isSelected = true;
						pfpURL = "pfp14.png";
					}
				}
			}
		});

		if (student.getLevel() >= 75) {
			image_pfp14.setIcon(new ImageIcon(".\\Assets\\images\\pfp14.png"));
		} else {
			image_pfp14.setIcon(new ImageIcon(".\\Assets\\images\\pfp_locked.png"));
		}
		image_pfp14.setBounds(500, 416, 88, 83);
		panel_pictureSelect.add(image_pfp14);

		image_pfp15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (student.getLevel() >= 100 || student.getName().equals("goku")) {
					killBorder(15);
					if (!isSelected) {
						image_pfp15.setBorder(new LineBorder(new Color(0, 195, 255), 5, true));
						isSelected = true;
						pfpURL = "pfp15.png";
					}
				}
			}
		});
		if (student.getLevel() >= 100 || student.getName().equals("goku")) {
			image_pfp15.setIcon(new ImageIcon(".\\Assets\\images\\pfp15.png"));
		} else {
			image_pfp15.setIcon(new ImageIcon(".\\Assets\\images\\pfp_locked.png"));
		}

		image_pfp15.setBounds(641, 416, 88, 83);
		panel_pictureSelect.add(image_pfp15);

		JButton button_submit = new JButton("Select");
		button_submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					String query = "Update profileinfo set userProfilePic = '" + pfpURL + "' where userID = '"
							+ student.getAccNum() + "'";
					Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					st.executeUpdate(query);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				ProfileSettings panel_profileSettings = new ProfileSettings(lp, test, student, con);
				switch_screen(panel_profileSettings.getPanel(), lp, test, student, con);
			}
		});
		button_submit.setBackground(new Color(26, 38, 83));
		button_submit.setHorizontalAlignment(SwingConstants.CENTER);
		button_submit.setFont(new Font("A-Space Demo", Font.PLAIN, 22));
		button_submit.setForeground(new Color(127, 255, 212));
		button_submit.setBounds(238, 569, 288, 68);
		panel_pictureSelect.add(button_submit);

		JLabel image_astro = new JLabel("");
		image_astro.setIcon(new ImageIcon(".\\Assets\\images\\astro.png"));
		image_astro.setBounds(789, 122, 393, 548);
		panel_pictureSelect.add(image_astro);

	}

	public void killBorder(int panelNum) {
		for (int n = 1; n < 16; n++) {
			if (n != panelNum) {
				switch (n) {
				case 1:
					image_pfp1.setBorder(null);
					isSelected = false;
					break;
				case 2:
					image_pfp2.setBorder(null);
					isSelected = false;
					break;
				case 3:
					image_pfp3.setBorder(null);
					isSelected = false;
					break;
				case 4:
					image_pfp4.setBorder(null);
					isSelected = false;
					break;
				case 5:
					image_pfp5.setBorder(null);
					isSelected = false;
					break;
				case 6:
					image_pfp6.setBorder(null);
					isSelected = false;
					break;
				case 7:
					image_pfp7.setBorder(null);
					isSelected = false;
					break;
				case 8:
					image_pfp8.setBorder(null);
					isSelected = false;
					break;
				case 9:
					image_pfp9.setBorder(null);
					isSelected = false;
					break;
				case 10:
					image_pfp10.setBorder(null);
					isSelected = false;
					break;
				case 11:
					image_pfp11.setBorder(null);
					isSelected = false;
					break;
				case 12:
					image_pfp12.setBorder(null);
					isSelected = false;
					break;
				case 13:
					image_pfp13.setBorder(null);
					isSelected = false;
					break;
				case 14:
					image_pfp14.setBorder(null);
					isSelected = false;
					break;
				case 15:
					image_pfp15.setBorder(null);
					isSelected = false;
					break;
				}
			}
		}
	}

	public JPanel getPanel() {
		return panel_pictureSelect;

	}

	public void switch_screen(JPanel p, JLayeredPane lp, Test test, Student student, Connection con) {
		lp.removeAll();
		p.setLayout(null);
		lp.add(p);
		lp.repaint();
		lp.revalidate();

	}
}
