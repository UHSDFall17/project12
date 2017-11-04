package sqlStatements;

import java.sql.Connection;
import java.sql.Statement;
import trello.ConnectionManager;
import sqlStatements.CommonSqlQueries;

public class TeamSqlQueries {
	private Connection con;
	Statement s = null;
	CommonSqlQueries sqlObj = new CommonSqlQueries();
	public boolean createTeam(String teamname,String teamdesc,int option )
	{
		try{
		con = ConnectionManager.getConnection();
		String values="";
		boolean teamExistsCheck = sqlObj.TeamNameExisitsCheck(teamname,option);
		if(teamExistsCheck)
		{
			return false;
		}
		else if (option == 1 && !teamExistsCheck) 
		{
			 values = "INSERT INTO team (team_name,team_desc) " + "VALUES ('" +teamname+ "', '" +teamdesc+"')";			
		}		
		else if (option == 2 && !teamExistsCheck) 
		{
			 values = "INSERT INTO business_team (team_name,team_desc) " + "VALUES ('" +teamname+ "', '" +teamdesc+"')";			
		}
		s = con.createStatement();
		s.executeUpdate(values);  
		con.close();
		return true;
		}
		catch(Exception e){ System.out.println(e);}
		return false;
	}
}
