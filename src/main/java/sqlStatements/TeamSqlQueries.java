package sqlStatements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import trello.ConnectionManager;
import sqlStatements.CommonSqlQueries;
import global.Global;

public class TeamSqlQueries {
	private Connection con;
	Statement s = null;
	CommonSqlQueries sqlObj = new CommonSqlQueries();
	 List<String> teams = new ArrayList<String>();
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
			 values = "INSERT INTO team (team_name,team_desc,created_by) " + "VALUES ('" +teamname+ "', '" +teamdesc+"', '" +Global.userName+"')";			
		}		
		else if (option == 2 && !teamExistsCheck) 
		{
			 values = "INSERT INTO business_team (team_name,team_desc,created_by) " + "VALUES ('" +teamname+ "', '" +teamdesc+"', '" +Global.userName+"')";			
		}
		s = con.createStatement();
		s.executeUpdate(values);  
		con.close();
		return true;
		}
		catch(Exception e){ System.out.println(e);}
		return false;
	}
	
	public List<String> listTeams() {
		
		try{
			con = ConnectionManager.getConnection();	
			Statement s=con.createStatement(); 
			String team;
			ResultSet rs=s.executeQuery("SELECT * FROM team WHERE created_by ='" +Global.userName+ "'");
			while(rs.next()){
		        team = rs.getString("team_name");
		        
		        teams.add(team);		         
		    	  	}
			return teams;
		      }
		      
		catch(Exception e){ System.out.println(e);}
		return null;
	}
}
