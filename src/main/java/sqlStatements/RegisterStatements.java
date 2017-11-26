package sqlStatements;

import java.sql.Connection;
import java.sql.Statement;
import trello.ConnectionManager;
import sqlStatements.CommonSqlQueries;

public class RegisterStatements {
	private Connection con;
	Statement s = null;
	CommonSqlQueries sqlObj = new CommonSqlQueries();
	public int registerUser(String username,String password,String email,String userType)
	{
		try{
		con = ConnectionManager.getConnection();
		boolean usernameCheck=sqlObj.UserNameExisitsCheck(username);
		boolean emailCheck=sqlObj.EmailExisitsCheck(email);
		if(!usernameCheck && !emailCheck ){
			String values = "INSERT INTO login (user_name,password,email_id,user_type) " + "VALUES ('" +username+ "', '" +password+"','" +email+"','" +userType+"')";
			s = con.createStatement();
			s.executeUpdate(values);  
			con.close();
			return 0;
		}
		else if(usernameCheck)
		{
			return 1;			
		}
		else if(emailCheck)
		{
			return 2;			
		}		
		
		}
		catch(Exception e){ System.out.println(e);}
		return 3;
	}
}
