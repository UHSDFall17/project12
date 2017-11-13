package board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import sqlStatements.TeamSqlQueries;

public class Team {

	 String teamname;
	 String teamdesc;	
	TeamSqlQueries sqlObj=new TeamSqlQueries();
	List<String> members = new ArrayList<String>();
	Scanner inputReader= new Scanner (System.in);
	
	public void getInputForCreateTeam()
	{		
		System.out.println("Please enter Team Name:");
		 teamname  = inputReader.nextLine();
		System.out.println("Please enter Team Description(optional):");
	      teamdesc  = inputReader.nextLine();		  
	}
	
	public void team()
	{		
		try {			
		System.out.println("Select the options below \n 1.Create New Team \n 2.View Team List \n 3.Add Members to Team \n 4.View Team Information \n 5. Edit Team Profile \n 6. Logout");
		int option = inputReader.nextInt();
		inputReader.nextLine();
		switch(option)
		{
		case 1:createTeam();
		break;
		case 2:teamList();
		break;
		case 3:addMembersToTeam();
		break;
		case 4:viewTeamInfo();
		break;
		}		
		}
		catch(Exception e){ System.out.println(e);} 
	}
	public void createTeam()
	{		
		try {		
		System.out.println("Press/n 1.General Team /n  2.Business Team ");
		int option = inputReader.nextInt();
		inputReader.nextLine();
		if (option == 1) 
			System.out.println("---Create Team---");							
		else if (option == 2) 
			System.out.println("---Create Business Team---");					 			
		getInputForCreateTeam();
		sqlObj.createTeam(teamname, teamdesc, option);	  
		System.out.println(teamname + "Team created Successfully");
		
		}
		catch(Exception e){ System.out.println(e);} 
	}
	public void teamList()
	{		
		try {					
		List<String> teamList = new ArrayList<String>();
		System.out.println("Press/n 1.General Team /n  2.Business Team ");
		int option = inputReader.nextInt();
		inputReader.nextLine();		
		teamList = sqlObj.listTeams(option);
		for(int i=0;i<teamList.size();i++)
		{
			  System.out.println(i+1 +". " + teamList.get(i));
		}
		
		}
		catch(Exception e){ System.out.println(e);} 
	}
	public void memberInput()
	{
		try{			
			String memberName;
			System.out.println("Enter Member Name:");
			memberName  = inputReader.nextLine();
		members.add(memberName);			
		}
		catch(Exception e){ System.out.println(e);}
	}
	public void addMembersToTeam()
	{		
		try {	
			System.out.println("Press/n 1.General Team /n  2.Business Team ");
			int option = inputReader.nextInt();
			inputReader.nextLine();	
			System.out.println("Enter Team Name:");
			String teamName  = inputReader.nextLine();
		memberInput();
		int optionsToAdd;
		do
		{
			for(int i=0;i<members.size();i++)
			{
				  System.out.println(i+1 +". " + members.get(i));
			}
			
			System.out.println("Press 1.Add More Members 2.Confirm Members");
			optionsToAdd=inputReader.nextInt();
			inputReader.nextLine();
			if(optionsToAdd==2)	
			{
				boolean result=sqlObj.addMembersToTeam(members,teamName,option);
				if(!result)
					System.out.println("Username does not exixts in the database");
				else
					System.out.println("Members added to the team");
				break;	
			}
						
			memberInput();
		}while(optionsToAdd!=2);
		
		}
		catch(Exception e){ System.out.println(e);} 
	}
	public void viewTeamInfo()
	{		
		try {	
			System.out.println("Press/n 1.General Team /n  2.Business Team ");
			int option = inputReader.nextInt();
			inputReader.nextLine();	
			System.out.println("Enter Team Name:");
			String teamName  = inputReader.nextLine();
			HashMap<String, String> teamDetails= new HashMap<String, String>();
			teamDetails = sqlObj.teamInfo(option, teamName);
		if(teamDetails!=null)
		{
			System.out.println("-----Team Information---");
			System.out.println("Team Name: "+ teamDetails.get("team_name"));
			System.out.println("Team Description: "+ teamDetails.get("team_desc"));
			String lastChar =teamDetails.get("team_members").substring(teamDetails.get("team_members").length() - 1);
			String membernames;
			if(lastChar.trim().equals(","))
			{
				membernames =teamDetails.get("team_members").substring(0,teamDetails.get("team_members").length() - 1);
			}
			else
			{
				membernames=teamDetails.get("team_members");
			}
			System.out.println("Team Members: "+membernames );
			System.out.println("Admin: "+ teamDetails.get("created_by"));
			if(teamDetails.get("access_mode") == null ||teamDetails.get("access_mode") == "" )
					{
				teamDetails.put("access_mode","Public");
					}
			System.out.println("Accessibilty: "+ teamDetails.get("access_mode"));
			System.out.println("------------------------");
		}
		else
		{
			System.out.println("Error!");
		}
		}
		catch(Exception e){ System.out.println(e);} 
	}
}
