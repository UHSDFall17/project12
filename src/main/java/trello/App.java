package trello;

import java.util.Scanner;

import login.Login;
import login.Register;

/**
 Software Design, Trello Project 
 Team 12
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Welcome to Trello \n Enter 1 to Login \n Enter 2 to register \n Enter 3 for New Password\n");
    	Scanner inputReader = new Scanner(System.in);
    	int value = inputReader.nextInt();
    	if (value == 1) {
    Login user = new Login();
     user.loginPage();
    	}
    	else if (value == 2) {
      Register newuser = new Register();
      newuser.register();
    }
    	else if(value == 3) {
    		Login user = new Login();
    		user.forgotPassword();
    		inputReader.close();
    	}
    	else 
    		System.out.println("Please enter a valid option");
}
}

