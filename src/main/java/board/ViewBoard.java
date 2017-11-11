package board;


import java.util.Scanner;

import sqlStatements.BoardSqlQueries;

public class ViewBoard {

	BoardSqlQueries sqlObj=new BoardSqlQueries();
	String boardname;	String boardname1;
	Scanner inputReader = new Scanner (System.in);
		public void displayBoards() {
			sqlObj.viewboards();
			starBoard();
			
			
			System.out.println("Do you wish to open board");
			
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
			this.boardname1 = boardname2;
			sqlObj.listCards(boardname1);
			
		}


		private void starBoard() {
			System.out.println("Do you wish to Star any of your boards");			
			String option = inputReader.nextLine();
			if(option.equals("yes")) {
			System.out.println("Please enter the name of the board which you wish to star");
			boardname = inputReader.nextLine();
			sqlObj.starIt(boardname);
			}
			else
				System.out.println("No star operation");
		}
		
	}
	

