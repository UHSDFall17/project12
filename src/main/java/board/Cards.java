package board;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;
import sqlStatements.CardSqlQueries;



public class Cards {
	
	Scanner inputReader = new Scanner (System.in);
	ResultSet rs;
	CardSqlQueries sqlObj = new CardSqlQueries();
	
public void cardDetails() {
	System.out.print("Enter the list name to display the card details");
	inputReader = new Scanner(System.in);
	String listname = null;
	listname = inputReader.nextLine();
	sqlObj.listCards(listname);
		
	System.out.println("Description");
	
}
}
