import java.sql.*;

public class database {
	
	public static void main(String args[]) {
		Connection con=null;
		try{
			//the host server name along with my xampp user and the pass i gave it
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			//DATABASE CONNECTION LINE IS IN DISCORD  
			if(!con.isClosed())
				System.out.println("Successfully connected to MySQL server...");
			}catch(Exception e) {
				System.err.println("Exception: "+e.getMessage()); //will tell you whats wrong if connection is unsuccessful
				}finally{
					try{
						if(con!=null)
							con.close();
						}catch(SQLException e) {}
					}
		}
	}
