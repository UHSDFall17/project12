package board;

import java.util.ArrayList;
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
			String teamName  = inputReader.nextLine();
		memberInput();
		int option;
		do
		{
			for(int i=0;i<members.size();i++)
			{
				  System.out.println(i+1 +". " + members.get(i));
			}
			
			System.out.println("Press 1.Add More Members 2.Confirm Members");
			option=inputReader.nextInt();
			inputReader.nextLine();
			if(option==2)	
			{System.out.println("loop");
				boolean result=sqlObj.addMembersToTeam(members,teamName);
				if(!result)
					System.out.println("Username does not exixts in the database");
				break;	
			}
						
			memberInput();
		}while(option!=2);
		
		}
		catch(Exception e){ System.out.println(e);} 
	}
}
