package trello;

import java.util.Scanner;

import login.Login;
import login.Register;
import login.FAQ;

/**
Software Design, Trello Project 
Team 12
*/
public class App 
{
	private static int value;
 	 
	
   public static void main( String[] args )
   {
	   System.out.println("Welcome to Trello");
	   System.out.println("=================");
	   options();
    }

public static void options() {
	do {
		Scanner inputReader = new Scanner(System.in);
		System.out.println("\n Enter 1 to Login \n Enter 2 to Register \n Enter 3 for New Password\n Enter 4 for Help/FAQ \n Enter 5 to Exit \n Answer: ");    
     	value = inputReader.nextInt();
     	switch (value) {
     		case 1:
     			Login user = new Login();
     			user.loginPage();
     			break;
     		case 2: 
     			Register newuser = new Register();
       			newuser.register();
       			break;
     		case 3:
     			Login user1 = new Login();
     			user1.forgotPassword();
     			break;
     		case 4:
     			FAQ faq = new FAQ();
     			faq.start();
     			break;
     		case 5:
    	 		System.out.println("Terminataing the program");
    	 		Runtime.getRuntime().exit(0); 
    	 		break;
     		default:
     			System.out.println("The selection was invalid!");
     			break;
     	}
     	inputReader.close();
     }while(value!= 5);
}
}