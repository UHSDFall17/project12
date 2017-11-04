package board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sqlStatements.TeamSqlQueries;

public class Team {

	String teamname;
	String teamdesc;
	TeamSqlQueries sqlObj=new TeamSqlQueries();
	
	public void getInputForCreateTeam()
	{
		Scanner inputReader = new Scanner (System.in);
		System.out.println("Please enter Team Name:");
		 teamname  = inputReader.nextLine();
		System.out.println("Please enter Team Description(optional):");
	      teamdesc  = inputReader.nextLine();
	      inputReader.close();
	}
	
	public void team()
	{		
		try {
		Scanner inputReader = new Scanner (System.in);
		System.out.println("Select the options below \n 1.Create New Team \n 2.View Team List \n 3.View Team Information \n 4. Edit Team Profile \n 5. Logout");
		int option = inputReader.nextInt();
		switch(option)
		{
		case 1:createTeam();
		break;
		case 2:teamList();
		break;
		}
		
		team();
		inputReader.close();
		}
		catch(Exception e){ System.out.println(e);} 
	}
	public void createTeam()
	{		
		try {
		Scanner inputReader = new Scanner (System.in);		
		System.out.println("Press/n 1.General Team /n  2.Business Team ");
		int option = inputReader.nextInt();
		if (option == 1) 
			System.out.println("---Create Team---");							
		else if (option == 2) 
			System.out.println("---Create Business Team---");					 			
		getInputForCreateTeam();
		sqlObj.createTeam(teamname, teamdesc, option);	  
		System.out.println(teamname + "Team created Successfully");
		inputReader.close();
		}
		catch(Exception e){ System.out.println(e);} 
	}
	public void teamList()
	{		
		try {
		Scanner inputReader = new Scanner (System.in);				
		List<String> teamList = new ArrayList<String>();
		teamList = sqlObj.listTeams();
		for(int i=0;i<teamList.size();i++)
		{
			  System.out.println(i+1 +". " + teamList.get(i));
		}
		
		inputReader.close();
		}
		catch(Exception e){ System.out.println(e);} 
	}
}
