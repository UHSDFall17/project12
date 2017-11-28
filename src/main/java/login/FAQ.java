package login;

import java.util.Scanner;
import trello.App;
import login.Register;
import login.Login;

public class FAQ {
	private Scanner input = new Scanner(System.in);

	public void start() {
		System.out
				.println("----Help/FAQ----\n" + "What do you need help with?");
		questions();
	}

	public void questions() {
		
		System.out.println("1) What is trello?");
		System.out
				.println("2) What do I need to provide in order to register?");
		System.out
				.println("3) How do I reset my password if I have forgotten it?");
		System.out.println("4) Go back to the main menu.");
		System.out
				.println("Enter a number for the question that you wish to view: ");
		answers(input.nextInt());
	}

	public void answers(int response) {
		switch (response) {
		case 1:
			System.out
					.println("Trello is the easy, free, flexible, and visual way to manage your projects and organize everything.\n"
							+ "Back to the questions.\n");
			questions();
			break;
		case 2:
			System.out
					.println("Besides Trello being free to use, users need to provide an email, username, and password.\n"
							+ "Do you want to register now? Y/N : ");
			String answer = input.next();
			if ( "Y".equals(answer)) {
				Register newuser = new Register();
				newuser.register();
			} else {
				System.out.println("Back to the questions.\n");
				questions();
			}
			break;
		case 3:
			System.out
					.println("Transferring you to the reset password process...\n");
			Login login = new Login();
			login.forgotPassword();
			break;
		case 4:
			App.main(null);
			break;
		default:
			System.out.println("Invalid choice. Please choose again.\n"
					+ "------------------------------------\n");
			questions();
			break;
		}
	}
}
