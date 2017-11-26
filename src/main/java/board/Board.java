package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import board.Cards;
import global.Global;
import sqlStatements.BoardSqlQueries;
import trello.App;
import trello.ConnectionManager;

public class Board {
	private Connection con = null;
	Scanner inputReader = new Scanner (System.in);
	BoardSqlQueries sqlObj = new BoardSqlQueries();
	String boardname,boardname1;int value ;
	WelcomeBoard wb = new WelcomeBoard();
	
public void option() {
	do {
	System.out.println("Select the options below \n 1.Create Board \n 2. Display Boards \n 3. Star Board \n 4. Go Back");
	value = inputReader.nextInt();
	inputReader.nextLine();
	switch (value) {
	case 1:
		board();
		break;
	case 2:
		displayBoards();
		break;
	case 3:
		starBoard();
	case 4:
		wb.welcome();
		break;
	default:
		System.out.println("invalid option");
		break;
	}
	}while (value != 4);
}
	
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
	else {
		System.out.println("Please enter a valid option");
	}
	}
	catch(Exception e){ System.out.println(e);} 
}

public void displayBoards() {
	sqlObj.viewboards();
	starBoard();

	System.out.println("Do you wish to open board");

	String open = inputReader.nextLine();
	if (open.equals("yes")) {
		System.out
				.println("Please enter the name of the board which you wish to open");
		boardname = inputReader.nextLine();
		openBoard(boardname);
	} else
		System.out.print("Back functionality");
	
	Cards card = new Cards();
	card.cardDetails();
}

private void openBoard(String boardname2) {
	this.boardname1 = boardname2;
	sqlObj.listCards(boardname1);
	
}

private void starBoard() {
	System.out.println("Do you wish to Star any of your boards");
	String option = inputReader.nextLine();
	if (option.equals("yes")) {
		System.out
				.println("Please enter the name of the board which you wish to star");
		boardname = inputReader.nextLine();
		sqlObj.starIt(boardname);
	} else
		System.out.println("No star operation");
}

}