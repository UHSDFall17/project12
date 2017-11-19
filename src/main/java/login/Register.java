package login;

import java.util.Scanner;

import board.WelcomeBoard;
import sqlStatements.RegisterStatements;
import validations.Validation;

public class Register {
	public String username ;
	public String email;
	public String password;
	public String confirmPassword;
	Validation val = new Validation();
	RegisterStatements registerObj = new RegisterStatements();
	Scanner inputReader= new Scanner (System.in);
	
	public void RequiredValidation(int input)
	{
	String printString="";
		switch(input)
		{
		case 1: printString="Name is Required";			
		break;
		case 2:printString="Email is Required";
		break;
		case 3:printString="Password is Required";
		break;
		case 4:printString="ConfirmPassword is Required";
		break;
		case 5:printString="Email Id is Invalid";
		break; 
		case 6:printString="Name should contain only Numbers";
		break;
		case 7: printString="Password and Confirm password does not match";
		break;
		}
		System.out.println (printString+"!. Try Again");
		register();
	}
	
	public void getInputValues(){
		try
		{
			System.out.println("---Registration Form---");
			System.out.println("Please enter your name:");
			 username  = inputReader.nextLine();
			 if (username.length()==0)
		    {
				 RequiredValidation(1);
		    }
			 else if (!val.checkNamevalidity(username)){
				 RequiredValidation(6);
			 }				 
				System.out.println("Please enter your emailID:");
				 email  = inputReader.nextLine();
				 if (email.length()==0)
				    {
						 RequiredValidation(2);
				    }
				 else if(!val.checkEmailvalidity(email))
				 {
					 RequiredValidation(5);
		              } 
				System.out.println("Please enter your password");
				 password = inputReader.nextLine();
				 if (password.length()==0)
				    {
						 RequiredValidation(3);
				    }
				 System.out.println("Please confirm your password");
					 confirmPassword = inputReader.nextLine();
					 if (confirmPassword.length()==0)
					    {
							 RequiredValidation(3);
					    }
					 else if(!password.equals(confirmPassword))
					 {
						 RequiredValidation(7);
					 }
		}
		catch(Exception e){ System.out.println(e);}	  
	}
	
	public void register()
	{
		try{  												
			getInputValues();
			System.out.println("Name:"+ username + " Email ID:"+email);
			int result =registerObj.registerUser(username,password,email);
			String printValues="";
			switch(result)
			{
			case 0: System.out.println("Updated Successfully");
			WelcomeBoard b = new WelcomeBoard();
			b.welcome();
			break;
			case 1: printValues="Username already exists in the database";
			break;
			case 2: printValues="Email Id already exists in the database";
			break;
			default:printValues="Email Id already exists in the database";
			break;
			}						
			System.out.println(printValues);
			register();
				
		}
		catch(Exception e){ System.out.println(e);}	  
	}
}
