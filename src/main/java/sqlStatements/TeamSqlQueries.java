package sqlStatements;

import java.sql.Connection;
import java.sql.Statement;

import trello.ConnectionManager;

public class TeamSqlQueries {
	private Connection con;
	Statement s = null;
	public void createTeam(String teamname,String teamdesc,int option )
	{
		try{
		con = ConnectionManager.getConnection();
		String values="";
		if (option == 1) 
		{
			 values = "INSERT INTO team (team_name,team_desc) " + "VALUES ('" +teamname+ "', '" +teamdesc+"')";			
		}
		
		else if (option == 2) 
		{
			 values = "INSERT INTO business_team (team_name,team_desc) " + "VALUES ('" +teamname+ "', '" +teamdesc+"')";			
		}
		s = con.createStatement();
		s.executeUpdate(values);  
		con.close();
		}
		catch(Exception e){ System.out.println(e);}
	}
}
