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
	HashMap<String, String> teamDetails= new HashMap<String, String>();
	
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
		case 5:editTeamInfo();
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
		teamList = sqlObj.listTeams();
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
			System.out.println("Enter Team Name:");
			teamname  = inputReader.nextLine();
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
				boolean result=sqlObj.addMembersToTeam(members,teamname);
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
			System.out.println("Enter Team Name:");
			teamname  = inputReader.nextLine();			
			getTeamInfo(teamname);
		}
		catch(Exception e){ System.out.println(e);} 
	}
	public void getTeamInfo(String TeamName)
	{
		try
		{
			teamDetails = sqlObj.teamInfo(TeamName);
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
				if(teamDetails.get("access_mode") == null ||teamDetails.get("access_mode") == "" ||teamDetails.get("access_mode").equals("1"))
						{
					teamDetails.put("access_mode","Public");
						}
				else 
				{
					teamDetails.put("access_mode","Private");
				}
				System.out.println("Accessibilty: "+ teamDetails.get("access_mode"));
				
				if(teamDetails.get("team_type").equals("1"))
				{
			teamDetails.put("team_type","Normal Team");
				}
				else if(teamDetails.get("team_type").equals("2"))
				{
			teamDetails.put("team_type","Business Team");
				}
				System.out.println("Team Type: "+ teamDetails.get("team_type"));
				System.out.println("------------------------");
			}
			else
			{
				System.out.println("Error!");
			}
		}
		catch(Exception e){ System.out.println(e);} 
	}
	public void editTeamInfo()
	{		
		try {				
			viewTeamInfo();
			Integer optionToEdit=0;
			String editedValues;
			//String TeamName=teamDetails.get("team_name");
			boolean result;
			while(optionToEdit!=5)
			{
				System.out.println("Press the numbers associated with the labels to edit the values");
				System.out.println("1.Team Name 2.Team Description 3. Accessibility 4.Team Type 5.Back to Team option");
				
				optionToEdit = inputReader.nextInt();
				inputReader.nextLine();
			switch(optionToEdit)
			{
			case 1:System.out.println("Enter New Team Name");
			editedValues=inputReader.nextLine();		
			teamDetails.put("team_name_edited",editedValues);
			result=sqlObj.editTeamInfo(optionToEdit,teamDetails);
			if(result){
				getTeamInfo(teamDetails.get("team_name_edited"));
				System.out.println("Updated successully");
			}
			else
			{
				System.out.println("Error in Updation");
			}
			break;
			case 2:System.out.println("Enter New Team Description");
			editedValues=inputReader.nextLine();		
			teamDetails.put("team_desc_edited",editedValues);
			 result=sqlObj.editTeamInfo(optionToEdit,teamDetails);
			if(result){
				getTeamInfo(teamDetails.get("team_name"));
				System.out.println("Updated successully");
			}
			else
			{
				System.out.println("Error in Updation");
			}
			break;
			case 3:System.out.println("Change accessibility. Enter 1 for public 2 for private");
			editedValues=inputReader.nextLine();		
			teamDetails.put("access_mode_edited",editedValues);
			result=sqlObj.editTeamInfo(optionToEdit,teamDetails);
			if(result){
				getTeamInfo(teamDetails.get("team_name"));
				System.out.println("Updated successully");
			}
			else
			{
				System.out.println("Error in Updation");
			}
			break;
			case 4:System.out.println("Change Team Type. Enter 1 for Normal 2 for Business");
			editedValues=inputReader.nextLine();			
			teamDetails.put("team_type_edited",editedValues);
			sqlObj.editTeamInfo(optionToEdit,teamDetails);
			result=sqlObj.editTeamInfo(optionToEdit,teamDetails);
			if(result){
				getTeamInfo(teamDetails.get("team_name"));
				System.out.println("Updated successully");
			}
			else
			{
				System.out.println("Error in Updation");
			}			break;
			}
			}
			
		}
		catch(Exception e){ System.out.println(e);} 
	}
}
