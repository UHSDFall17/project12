package sqlStatements;

import java.sql.Connection;
import java.sql.Statement;

import trello.ConnectionManager;

public class RegisterStatements {
	private Connection con;
	Statement s = null;
	
	public void registerUser(String username,String password,String email)
	{
		try{
		con = ConnectionManager.getConnection();
		String values = "INSERT INTO login (user_name,password,email_id) " + "VALUES ('" +username+ "', '" +password+"','" +email+"')";
		s = con.createStatement();
		s.executeUpdate(values);  
		con.close();
		}
		catch(Exception e){ System.out.println(e);}
	}
}
