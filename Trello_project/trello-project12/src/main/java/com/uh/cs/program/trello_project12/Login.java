package com.uh.cs.program.trello_project12;

import java.util.Scanner;

public class Login {

	
	public void login()
	{
		Scanner inputReader = new Scanner (System.in);
		System.out.println("Please enter your username:");
		String username  = inputReader.nextLine();
		System.out.println("Please enter your password");
		String password = inputReader.nextLine();
		inputReader.close();
		
		if (username.equals("trello") && password.equals("team12")) {
			System.out.println("Successful Login");	
		}
		else {
			System.out.println("Incorrect Username / Password");
		}
		
	}
}
