package managmentSystem;

import java.sql.*;

public class Conn {
	
	/*
	 * we can use this Variable in any class to access directly with the Database.......
	 * 
	 */
	Connection con;
	Statement stmt;
	
	Conn(){
		try {
			
			/*
			 * Establishing the connection and Creating the Platforms 
			 * such that we can easily make the JDBC Connections and perform the operations on Data Base
			 */
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql:///hotelmanagmentsystem","root","1234");
			stmt=con.createStatement();
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	

}
