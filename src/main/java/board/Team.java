package board;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import trello.ConnectionManager;

public class Team {

	private Connection con = null;
	String teamname;
	String teamdesc;
	String values;
	
	public void getInput()
	{
		Scanner inputReader = new Scanner (System.in);
		System.out.println("Please enter Team Name:");
		inputReader.nextLine();
		 teamname  = inputReader.nextLine();
		System.out.println("Please enter Team Description(optional):");
	      teamdesc  = inputReader.nextLine();
	      inputReader.close();
	}
	
	public void team()
	{
		
		try {
			con = ConnectionManager.getConnection();
			Statement s = null;
		
		Scanner inputReader = new Scanner (System.in);
		System.out.println("Press 1. for general team /n Press 2. for business team ");
		int option = inputReader.nextInt();
		if (option == 1) 
		{
			System.out.println("---Create Team---");
			getInput();
			 values = "INSERT INTO team (team_name,team_desc) " + "VALUES ('" +teamname+ "', '" +teamdesc+"')";			
		}
		
		else if (option == 2) {
			System.out.println("---Create Business Team---");
			getInput();
			 values = "INSERT INTO business_team (team_name,team_desc) " + "VALUES ('" +teamname+ "', '" +teamdesc+"')";			
		}
		s = con.createStatement();
		s.executeUpdate(values);  
		System.out.println(teamname + "Team created Successfully");
		inputReader.close();
		}
		catch(Exception e){ System.out.println(e);} 
	}
}
