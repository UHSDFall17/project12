package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Board {
public void board() {
	System.out.println("Creeate Board \n Enter the title of the board");
	Scanner inputReader = new Scanner (System.in);
	//String title = inputReader.nextLine();
	try {
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
	"jdbc:mysql://50.62.176.51/Trello","trello","Team12");  
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
	}
	
	/*else if(input.equals("no")){
		
	}*/
	else {
		System.out.println("Please enter a valid option");
	}
	inputReader.close();
}
	catch(Exception e){ System.out.println(e);} 
}
}
