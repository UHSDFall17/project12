package login;

import java.util.Scanner;

public class Login {

	
	public void login()
	{
		Scanner inputReader = new Scanner (System.in);
		System.out.println("Please enter your username:");
		String username  = inputReader.nextLine();
		System.out.println("Please enter your password");
		String password = inputReader.nextLine();
	
		
		if (username.equals("trello") && password.equals("team12")) {
			System.out.println("Successful Login");	
		}
		else {
			System.out.println("Incorrect Username / Password");
		}
		
	}
}
