package board;

import java.util.Scanner;

import board.Cards;
import sqlStatements.BoardSqlQueries;

public class Board {
	private Scanner inputReader = new Scanner(System.in);
	private BoardSqlQueries sqlObj = new BoardSqlQueries();
	private String boardname;	
	private WelcomeBoard wb = new WelcomeBoard();
	private BoardInfo boardinfo = new BoardInfo();
	private Cards card = new Cards();

	public void option() {
		int value;
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
				break;
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

		System.out.println("Create Board \n Enter the title of the board");
		String title = boardinfo.getBoardTitle();
		System.out.println("Enter the team name to assign");
		String team_name = boardinfo.getTeamName();
		sqlObj.createBoard(title,team_name);
	}

	public void displayBoards() {
		sqlObj.viewboards();
		starBoard();

		System.out.println("Do you wish to open board");

		String open = boardinfo.getopenBoardOption();
		if ("yes".equals(open)) {
			System.out.println("Please enter the name of the board which you wish to open");
			boardname = boardinfo.getopenBoardName();
			openBoard(boardname);
		} else
			System.out.print("Back functionality");

		card.menu();
	}

	private void openBoard(String boardname2) {		
		sqlObj.listCards(boardname2);

	}

	private void starBoard() {
		System.out.println("Do you wish to Star any of your boards");
		String option = boardinfo.getStarBoard();
		if ("yes".equals(option)) {
			System.out.println("Please enter the name of the board which you wish to star");
			boardname = boardinfo.getstarBoardName();
			sqlObj.starIt(boardname);
		} else
			System.out.println("No star operation");
	}

	public void restoreBoard() {
			sqlObj.viewDeletedBoards();
			System.out.println("Enter the name of the deleted board which you wish to restore");
			String restoreBoardName = boardinfo.getrestoreBoardName();
			sqlObj.restoreBoards(restoreBoardName);	
	}
}