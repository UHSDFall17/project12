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
	static int value;
	
   public static void main( String[] args )
   {
	   System.out.println("Welcome to Trello");
	   System.out.println("=================");
	   options();
    }

public static void options() {
	do {
   	System.out.println("\n Enter 1 to Login \n Enter 2 to register \n Enter 3 for New Password\n Enter 4 for Help/FAQ");
     	Scanner inputReader = new Scanner(System.in);
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
     		System.out.println("Help/FAQ : under construction");
     case 5:
    	 System.out.println("Terminataing the program");
    	 break;
    	 default:
    		 System.out.println("The selection was invalid!");
     	}}while(value!= 4);
}
 }




