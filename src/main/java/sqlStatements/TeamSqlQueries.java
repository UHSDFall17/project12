package sqlStatements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import trello.ConnectionManager;
import sqlStatements.CommonSqlQueries;
import global.Global;
import board.Team;

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
	
	public List<String> listTeams(int option) {
		
		try{
			con = ConnectionManager.getConnection();	
			Statement s=con.createStatement(); 
			String team;
			ResultSet rs = null;
			 if (option == 1) 
			{
				  rs=s.executeQuery("SELECT * FROM team WHERE created_by ='" +Global.userName+ "'");			
			}		
			else if (option == 2 ) 
			{
				 rs=s.executeQuery("SELECT * FROM business_team WHERE created_by ='" +Global.userName+ "'");			
			}
			
			while(rs.next()){
		        team = rs.getString("team_name");		        
		        teams.add(team);		         
		    	  	}
			return teams;
		      }
		      
		catch(Exception e){ System.out.println(e);}
		return null;
	}
	public boolean addMembersToTeam(List<String> members,String teamName,int option)
	{
		try{
			
		con = ConnectionManager.getConnection();
		String values="";
		String names="";
		for(int i=0;i<members.size();i++)
		{
			boolean nameExistsCheck = sqlObj.UserNameExisitsCheck(members.get(i));			
			if(nameExistsCheck)
			{
				names += members.get(i)+",";	
			}
			else 
			{
				return false;	
			}		
			 
		}
		 if (option == 1) 
			{
			 values="UPDATE team SET team_members = '" +names+ "' WHERE team_name ='" +teamName+ "'";			
			}		
			else if (option == 2 ) 
			{
				values="UPDATE business_team SET team_members = '" +names+ "' WHERE team_name ='" +teamName+ "'";			
			}
		
		System.out.println(names);
		s = con.createStatement();
		s.executeUpdate(values);  
		con.close();
		return true;
		}
		catch(Exception e){ System.out.println(e);}
		return false;
	}
public HashMap<String, String> teamInfo(int option,String teamName) {
		
		try{
			con = ConnectionManager.getConnection();	
			Statement s=con.createStatement(); 
			HashMap<String, String> teamDetails= new HashMap<String, String>();
			ResultSet rs = null;
			 if (option == 1) 
			{
				  rs=s.executeQuery("SELECT * FROM team WHERE team_name ='" +teamName+ "'");			
			}		
			else if (option == 2 ) 
			{
				 rs=s.executeQuery("SELECT * FROM business_team WHERE team_name ='" +teamName+ "'");			
			}
			
			while(rs.next()){
				teamDetails.put("team_name", rs.getString("team_name"));
				teamDetails.put("team_desc", rs.getString("team_desc"));
		        //teamObj.teamname= rs.getString("team_name");	
		       // teamObj.teamdesc= rs.getString("team_desc");
		        return teamDetails;
		      }
		}
		      
		catch(Exception e){ System.out.println(e);}
		return null;
	}
}
