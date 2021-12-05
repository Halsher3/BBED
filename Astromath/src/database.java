import java.sql.*;

public class database {
	
	public static void main(String args[]) {
		Connection con=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con= DriverManager.getConnection("jdbc:mysql://localhost:3307/userregistration","root","ubuntu123");
			if(!con.isClosed())
				System.out.println("Successfully connected to MySQL server...");
			}catch(Exception e) {
				System.err.println("Exception: "+e.getMessage());
				}finally{
					try{
						if(con!=null)
							con.close();
						}catch(SQLException e) {}
					}
		}
	}
