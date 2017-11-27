package sqlStatements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		boolean teamExistsCheck = sqlObj.TeamNameExisitsCheck(teamname,1);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String createDate =dateFormat.format(date).toString(); 
		if(teamExistsCheck)
		{
			return false;
		}
		else if (!teamExistsCheck) 
		{
			 values = "INSERT INTO team (team_name,team_desc,created_by,team_type,created_date) " + "VALUES ('" +teamname+ "', '" +teamdesc+"', '" +Global.userName+"','" +option+"','" +createDate+"')";			
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
			if(option ==1){
				 rs=s.executeQuery("SELECT * FROM team WHERE created_by ='" +Global.userName+ "'");
			}
			else if(option ==2){
				 rs=s.executeQuery("SELECT * FROM deleted_team WHERE created_by ='" +Global.userName+ "'");
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
		boolean teamExistsCheck = sqlObj.TeamNameExisitsCheck(teamName,1);
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
			boolean teamExistsCheck = sqlObj.TeamNameExisitsCheck(teamName,1);
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
				teamDetails.put("created_date", rs.getString("created_date"));
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
	
	boolean teamExistsCheck = sqlObj.TeamNameExisitsCheck(teamDetails.get("team_name"),1);
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
public boolean deleteTeam(String teamname)
{
	try{
	boolean teamExistsCheck = sqlObj.TeamNameExisitsCheck(teamname,1);
	System.out.println(teamExistsCheck);
	if(!teamExistsCheck)
	{
		return false;
	}
	else if (teamExistsCheck) 
	{
		inserToDeleteTable(teamname,2); 
		deleteFromTable(teamname,2);
	}
	return true;
	}
	catch(Exception e){ System.out.println(e);}
	return false;
}

public boolean restoreTeam(String teamname)
{
	try{
	boolean teamExistsCheck = sqlObj.TeamNameExisitsCheck(teamname,2);
	if(!teamExistsCheck)
	{
		return false;
	}
	else if (teamExistsCheck) 
	{
		inserToDeleteTable(teamname,1); 
		deleteFromTable(teamname,1);
	}
	return true;
	}
	catch(Exception e){ System.out.println(e);}
	return false;
}

public boolean inserToDeleteTable(String teamname, int option)
{
	try{
	con = ConnectionManager.getConnection();
	String values="";
	if(option==1)//restore
	{
		 values= "INSERT INTO team(team_name,team_members,team_desc,access_mode,created_by,"
				+ "created_date,team_type) SELECT team_name,team_members,team_desc,access_mode,created_by,"
				+ "created_date,team_type from deleted_team WHERE team_name ='" +teamname+ "'";	
	}
	else if(option==2)//delete
	{
		 values= "INSERT INTO deleted_team(team_name,team_members,team_desc,access_mode,created_by,"
				+ "created_date,team_type) SELECT team_name,team_members,team_desc,access_mode,created_by,"
				+ "created_date,team_type from team WHERE team_name ='" +teamname+ "'";	
	}
					
	s = con.createStatement();
	s.executeUpdate(values);  
	con.close();
	return true;
	}
	catch(Exception e){ System.out.println(e);}
	return false;
}
public boolean deleteFromTable(String teamname,int option)
{
	try{
	con = ConnectionManager.getConnection();
	String values="";
	if(option==1)
	{
		 values= "DELETE from deleted_team WHERE team_name ='" +teamname+ "'";
	}
	else if(option==2)
	{
		 values= "DELETE from team WHERE team_name ='" +teamname+ "'";
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
