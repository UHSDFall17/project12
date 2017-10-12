package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Team {

	public void team()
	{
		
		try {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://50.62.176.51/Trello","trello","Team12"); 
		Statement s = null;
		
		Scanner inputReader = new Scanner (System.in);
		System.out.println("---Create Team---");
		System.out.println("Please enter Team Name:");
		String teamname  = inputReader.nextLine();
		System.out.println("Please enter Team Description(optional):");
		String teamdesc  = inputReader.nextLine();
		String values = "INSERT INTO team (team_name,team_desc) " + "VALUES ('" +teamname+ "', '" +teamdesc+"')";
		s = con.createStatement();
		s.executeUpdate(values);  
		System.out.println(teamname + "Team created Successfully");
		inputReader.close();
		}
		catch(Exception e){ System.out.println(e);} 
	}
}
