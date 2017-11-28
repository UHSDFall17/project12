package board;

import java.util.Scanner;

import sqlStatements.CardSqlQueries;
import board.Board;
import board.WelcomeBoard;



public class Cards {
	
	private Scanner input = new Scanner (System.in);
	private CardSqlQueries sqlObj = new CardSqlQueries();	
	
	public void menu() {
		System.out.println("------Viewing Lists/Cards------\n");
		sqlObj.listList();
		System.out.println("Please enter the name of the list to access the cards: ");
		String listname = input.nextLine();
		String answer;

		System.out.println("The list " + listname + " and all the cards can now be accessed.\n" + "Please choose an option from below.");
		do {
			System.out.println("1) Display all existing cards.\n"
					+ "2) Display existing cards "
					+ "3) Create a new card.\n"
					+ "4) Modify an existing card.\n"
					+ "5) View a different list.\n"
					+ "6) View a different board.\n"
					+ "7) Go back to the welcome board.\n"
					+ "Enter the number for the option that you want: ");
			chooseOption(listname, input.nextInt());
			System.out.println("Do you wish to go over the options again? Y/N: ");
			answer = input.nextLine();
		}while("Y".equals(answer));
		System.out.println("Sending you back to the welcome board.");
		WelcomeBoard wb = new WelcomeBoard();
		wb.welcome();
	}
	
	private void chooseOption(String listname, int number) {
		String cardname;
		String description;
		String comments;
		String date;
		switch(number) {
		case 1:
			sqlObj.listAllCards(listname);
			break;
		case 2:
			sqlObj.listCardsWithDates(listname);
			break;
		case 3:
			System.out.println("Please enter the card name: ");
			cardname = input.nextLine();
			System.out.println("Please enter a description of the card: ");
			description = input.nextLine();
			System.out.println("Enter any comments for the card: ");
			comments = input.nextLine();
			System.out.println("Assign a due date for this card? Y/N: ");
			String answer = input.nextLine();
			if("Y".equals(answer)) {
				System.out.println("Enter the due date in 'YYYYY-MM-DD' form: ");
				date = input.nextLine();
			}
			else {
				date = null;
			}
			sqlObj.createCard(listname, cardname, description, comments, date);
			break;
		case 4:
			System.out.println("Provide the card name that you wish to modify: ");
			cardname = input.nextLine();
			System.out.println("What part do you wish to modify?\n"
					+ "1) The card name.\n"
					+ "2) The card description.\n"
					+ "3) The card comments.\n"
					+ "4) The card due date.\n"
					+ "5) Mark card as finished/not finished.\n"
					+ "Enter a number: ");
			sqlObj.modifyCard(listname, cardname, input.nextInt());
			break;
		case 5:
			menu();
			break;
		case 6:
			Board b = new Board();
			b.option();
			break;
		case 7:
			WelcomeBoard wb = new WelcomeBoard();
			wb.welcome();
			break;
		default:
			System.out.println("Invalid option.");
			break;
		}	
	}
}
