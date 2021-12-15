import java.sql.*;


/*
 * testing class to see if the database connections
 */
public class database {

	public static void main(String args[]) {
		Connection con = null;
		try {
			// the host server name along with my xampp user and the pass i gave it
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://sql5.freesqldatabase.com/sql5458377", "sql5458377",
					"FKhgpmjDr9");
			if (!con.isClosed())
				System.out.println("Successfully connected to MySQL server...");
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage()); // will tell you whats wrong if connection is
																// unsuccessful
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}
}