package sqlstatements;

import global.Global;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import trello.ConnectionManager;

public class CommonSqlQueries {
	private Connection con;
	private Statement s = null;
	
	public boolean userNameExisitsCheck(String username)
	{
		try{
			con = ConnectionManager.getConnection();
		
			String values = "Select user_name from login Where user_name ='"+username+"';";
		 s=con.createStatement();  
		 ResultSet rs=s.executeQuery(values); 
		
		if(rs.next()) {
			con.close();
			return true;
		}
		else {
			con.close();
		return false;
		}
		}
		catch(Exception e){ System.out.println(e);}
		
		return false;  
	}
	public boolean emailExisitsCheck(String email)
	{
		try{
			con = ConnectionManager.getConnection(); 
		
			String values = "Select email_id from login Where email_id ='"+email+"';";
		 s=con.createStatement();  
		ResultSet rs=s.executeQuery(values); 
		
		if(rs.next()) {
			con.close();
			return true;
		}
		else {
			con.close();
		return false;
		}
		}
		catch(Exception e){ System.out.println(e);}
		
		return false;  
	}
	public boolean teamNameExisitsCheck(String teamName,int tableOption)
	{
		try{
			con = ConnectionManager.getConnection(); 
			String values = "Select team_name from team Where team_name ='"+teamName+"'and created_by ='" +Global.userName+ "';";
			
		if(tableOption==2)
		{
			values = "Select team_name from deleted_team Where team_name ='"+teamName+"'and created_by ='" +Global.userName+ "';";
		}
		 s=con.createStatement();  
		ResultSet rs=s.executeQuery(values); 
		
		if(rs.next()) {
			con.close();
			return true;
		}
		else {
			con.close();
		return false;
		}
		}
		catch(Exception e){ System.out.println(e);}
		
		return false;  
	}
	
}

