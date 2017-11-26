package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import board.Cards;

import trello.ConnectionManager;

public class Board {
	private Connection con = null;
	Scanner inputReader = new Scanner (System.in);
	
public void board() {
	
	
	System.out.println("Creeate Board \n Enter the title of the board");
	String title = inputReader.nextLine();
	try {
		con = ConnectionManager.getConnection();
	Statement s=con.createStatement();  
	ResultSet rs=s.executeQuery("Select team_name from team");
	if(rs.next() != true) {
		System.out.println("There are no teams,Do you wish to create one");
	}
	else {
	System.out.println("Would you like to select the team for the Board \n Type 'yes' to select team \n Type 'no' to proceed further ");
	}
	String input = inputReader.nextLine();
	if(input.equals("yes")) {
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
		Team t = new Team();
		t.team();
		
	}
	
	
	/*else if(input.equals("no")){
		
	}*/
	else {
		System.out.println("Please enter a valid option");
	}
}
	catch(Exception e){ System.out.println(e);} 
}


}
