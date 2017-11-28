package sqlstatements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import global.Global;
import trello.ConnectionManager;
import sqlstatements.CommonSqlQueries;

public class RegisterStatements {
	private Connection con;
	private Statement s = null;
	private CommonSqlQueries sqlObj = new CommonSqlQueries();
	public int registerUser(String username,String password,String email,String userType,String orgName,String comment)
	{
		try{
		con = ConnectionManager.getConnection();
		boolean usernameCheck=sqlObj.userNameExisitsCheck(username);
		boolean emailCheck=sqlObj.emailExisitsCheck(email);
		if(!usernameCheck && !emailCheck ){
			String values = "INSERT INTO login (user_name,password,email_id,user_type,org_name) " + "VALUES "
					+ "('" +username+ "', '" +password+"','" +email+"','" +userType+"','" +orgName+"')";
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
	
	
	public boolean loginCheck(String username,String password) {
		try {
			con = ConnectionManager.getConnection();
			String values = "Select user_name,password,user_type from login Where user_name ='" 
					+ username + "' and password = '" + password + "';";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(values);
			if (rs.next()) {
				Global.userType = rs.getString("user_type");
				con.close();
				return true;
			} else {
				con.close();
				return false;
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return false;
	}
	public void forgotPassword(String username, String password) {
		try {		
			con = ConnectionManager.getConnection();
					String values = "UPDATE login (user_name,password) " + "VALUES ('"
						+ username + "', '" + password + "')";
				s = con.createStatement();
				s.executeUpdate(values);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}
}

