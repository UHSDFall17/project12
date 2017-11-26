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
	Scanner inputReader = new Scanner(System.in);
	BoardSqlQueries sqlObj = new BoardSqlQueries();
	String boardname, boardname1;
	int value;
	WelcomeBoard wb = new WelcomeBoard();

	public void option() {
		do {
			System.out.println(
					"Select the options below \n 1.Create Board \n 2. Display Boards \n 3. Star Board \n 4. Go Back");
			value = inputReader.nextInt();
			inputReader.nextLine();
			switch (value) {
			case 1:
				createBoard();
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
		} while (value != 4);
	}

	public void createBoard() {

		System.out.println("Creeate Board \n Enter the title of the board");
		String title = inputReader.nextLine();
		System.out.println("Enter the team name to assign");
		String team_name = inputReader.nextLine();
		sqlObj.createBoard(title,team_name);
	}

	public void displayBoards() {
		sqlObj.viewboards();
		starBoard();

		System.out.println("Do you wish to open board");

		String open = inputReader.nextLine();
		if (open.equals("yes")) {
			System.out.println("Please enter the name of the board which you wish to open");
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
			System.out.println("Please enter the name of the board which you wish to star");
			boardname = inputReader.nextLine();
			sqlObj.starIt(boardname);
		} else
			System.out.println("No star operation");
	}

}