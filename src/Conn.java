import java.sql.*;

public class Conn {
	
	Connection c ;
	Statement s;
	
	public Conn() {
		try {
			// step 1: Register the drive class
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		
//			step 2: Creating connection string
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem", "root", "root");

//			step 3: creating statement
			s = c.createStatement();
			
			
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
