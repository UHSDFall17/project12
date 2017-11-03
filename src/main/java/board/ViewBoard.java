package board;


import java.util.Scanner;

import sqlStatements.BoardSqlQueries;

public class ViewBoard {

	BoardSqlQueries sqlObj=new BoardSqlQueries();
	String boardname;
		public void displayBoards() {
			sqlObj.viewboards();
			startBoard();
			
			
			System.out.println("Do you wish to open board");
			Scanner inputReader = new Scanner (System.in);
			String open = inputReader.nextLine();
			if(open.equals("yes")) {
				System.out.println("Please enter the name of the board which you wish to open");
				boardname = inputReader.nextLine();
				openBoard(boardname);
			}
			else
				System.out.print("Back functionality");
		}
		
		
		private void openBoard(String boardname2) {
			System.out.println("Method to display cards");
			
		}


		private void startBoard() {
			System.out.println("Do you wish to Star any of your boards");
			Scanner inputReader = new Scanner (System.in);
			String option = inputReader.nextLine();
			if(option.equals("yes"))
			System.out.println("Please enter the name of the board which you wish to star");
			else
				System.out.println("No star operation");
		}
		
	}
	

