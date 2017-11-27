package board;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;
import sqlStatements.CardSqlQueries;
import board.Board;
import board.WelcomeBoard;



public class Cards {
	
	Scanner input = new Scanner (System.in);
	ResultSet rs;
	CardSqlQueries sqlObj = new CardSqlQueries();
	String cardname, description, comments;
	
	
	public void menu() {
		System.out.println("------Viewing Lists/Cards------\n");
		sqlObj.listList();
		System.out.println("Please enter the name of the list to access the cards: ");
		String listname = input.nextLine();
		String answer;

		System.out.println("The list " + listname + " and all the cards can now be accessed.\n" + "Please choose an option from below.");
		do {
			System.out.println("1) Display the existing cards.\n"
					+ "2) Create a new card.\n"
					+ "3) Modify an existing card.\n"
					+ "4) View a different list.\n"
					+ "5) View a different board.\n"
					+ "6) Go back to the welcome board.\n"
					+ "Enter the number for the option that you want: ");
			chooseOption(listname, input.nextInt());
			System.out.println("Do you wish to go over the options again? Y/N: ");
			answer = input.nextLine();
		}while(answer == "Y" || answer == "y");
		System.out.println("Sending you back to the welcome board.");
		WelcomeBoard wb = new WelcomeBoard();
		wb.welcome();
	}
	
	private void chooseOption(String listname, int number) {
		switch(number) {
		case 1:
			sqlObj.listCards(listname);
			break;
		case 2:
			System.out.println("Please enter the card name: ");
			this.cardname = input.nextLine();
			System.out.println("Please enter a description of the card: ");
			this.description = input.nextLine();
			System.out.println("Enter any comments for the card: ");
			this.comments = input.nextLine();
			sqlObj.createCard(listname, this.cardname, this.description, this.comments);
			break;
		case 3:
			System.out.println("Provide the card name that you wish to modify: ");
			this.cardname = input.nextLine();
			System.out.println("What part do you wish to modify?\n"
					+ "1) The card name.\n"
					+ "2) The card description.\n"
					+ "3) The card comments.\n"
//					+ "4) Finished or not finished.\n"
					+ "Enter a number: ");
			int answer = input.nextInt();
			sqlObj.modifyCard(listname, this.cardname, answer);
			break;
		case 4:
			menu();
			break;
		case 5:
			Board b = new Board();
			b.option();
			break;
		case 6:
			WelcomeBoard wb = new WelcomeBoard();
			wb.welcome();
			break;
		default:
			System.out.println("Invalid option.");
			break;
		}	
	}
}
