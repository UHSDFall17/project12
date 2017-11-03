package board;

import java.util.Scanner;
import sqlStatements.TeamSqlQueries;

public class Team {

	String teamname;
	String teamdesc;
	TeamSqlQueries sqlObj=new TeamSqlQueries();
	
	public void getInput()
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
		System.out.println("Press 1. for general team /n Press 2. for business team ");
		int option = inputReader.nextInt();
		if (option == 1) 
			System.out.println("---Create Team---");							
		else if (option == 2) 
			System.out.println("---Create Business Team---");					 			
		getInput();
		sqlObj.createTeam(teamname, teamdesc, option);	  
		System.out.println(teamname + "Team created Successfully");
		inputReader.close();
		}
		catch(Exception e){ System.out.println(e);} 
	}
}
