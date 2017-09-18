package login;

import java.util.Scanner;

public class Register {
	
	public void register()
	{
		Scanner inputReader = new Scanner (System.in);
		System.out.println("Please enter your name:");
		String username  = inputReader.nextLine();
		System.out.println("Please enter your emailID:");
		String email  = inputReader.nextLine();
		System.out.println("Please enter your desired password");
		String password = inputReader.nextLine();
		inputReader.close();
		
		System.out.println("Name:"+ username + "Email ID:"+email);
		
	}

}
