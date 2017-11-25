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
		boolean teamExistsCheck = sqlObj.TeamNameExisitsCheck(teamname);
		if(teamExistsCheck)
		{
			return false;
		}
		else if (!teamExistsCheck) 
		{
			 values = "INSERT INTO team (team_name,team_desc,created_by,team_type) " + "VALUES ('" +teamname+ "', '" +teamdesc+"', '" +Global.userName+"','" +option+"')";			
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
			ResultSet rs = null;			 
				  rs=s.executeQuery("SELECT * FROM team WHERE created_by ='" +Global.userName+ "'");													
			while(rs.next()){
		        team = rs.getString("team_name");		        
		        teams.add(team);		         
		    	  	}
			return teams;
		      }
		      
		catch(Exception e){ System.out.println(e);}
		return null;
	}
	public boolean addMembersToTeam(List<String> members,String teamName)
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
		boolean teamExistsCheck = sqlObj.TeamNameExisitsCheck(teamName);
		if(!teamExistsCheck)
		{
			return false;
		}
		else if (teamExistsCheck) 
		{
			values="UPDATE team SET team_members = '" +names+ "' WHERE team_name ='" +teamName+ "'";			
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
public HashMap<String, String> teamInfo(String teamName) {
		
		try{
			con = ConnectionManager.getConnection();	
			Statement s=con.createStatement(); 
			HashMap<String, String> teamDetails= new HashMap<String, String>();
			ResultSet rs = null;		
			boolean teamExistsCheck = sqlObj.TeamNameExisitsCheck(teamName);
			if(!teamExistsCheck)
			{
				return null;
			}
			else if (teamExistsCheck) 
			{
				rs=s.executeQuery("SELECT * FROM team WHERE team_name ='" +teamName+ "'");			
			}	
				  								
			
			while(rs.next()){
				teamDetails.put("team_name", rs.getString("team_name"));
				teamDetails.put("team_desc", rs.getString("team_desc"));
				teamDetails.put("team_members", rs.getString("team_members"));
				teamDetails.put("access_mode", rs.getString("access_mode"));
				teamDetails.put("created_by", rs.getString("created_by"));
				teamDetails.put("team_type", rs.getString("team_type"));
				//teamDetails.put("created_date", rs.getString("created_date"));
		        return teamDetails;
		      }
		}
		      
		catch(Exception e){ System.out.println(e);}
		return null;
	}
public boolean editTeamInfo(Integer option,HashMap<String, String> teamDetails)
{
	try{
		
	con = ConnectionManager.getConnection();
	String values="";
	String partofQuery="";	
	
	boolean teamExistsCheck = sqlObj.TeamNameExisitsCheck(teamDetails.get("team_name"));
	if(!teamExistsCheck)
	{
		return false;
	}
	else if (teamExistsCheck) 
	{
		switch(option)
		{
		case 1:partofQuery= "team_name='"+teamDetails.get("team_name_edited")+"'";
		break;
		case 2:partofQuery= "team_desc='"+teamDetails.get("team_desc_edited")+"'";
		break;
		case 3:partofQuery= "access_mode='"+teamDetails.get("access_mode_edited")+"'";
		break;
		case 4:partofQuery= "team_type='"+teamDetails.get("team_type_edited")+"'";
		break;
		}
		values="UPDATE team SET "+partofQuery+" WHERE team_name ='" +teamDetails.get("team_name")+ "'";			
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
