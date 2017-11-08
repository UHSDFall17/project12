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
	
		switch(input)
		{
		case 1: System.out.println ("Name is Required!. Try Again");
		register();
		break;
		case 2: System.out.println ("Email is Required!. Try Again");
		register();
		break;
		case 3: System.out.println ("Password is Required!. Try Again");
		register();
		case 4: System.out.println ("Confirm Password is Required!. Try Again");
		register();
		case 5: System.out.println ("Email Id is Invalid!. Try Again");
		register();
		case 6: System.out.println ("Name should contain only Numbers!. Try Again");
		register();
		case 7: System.out.println ("Password and Confirm password does not match!. Try Again");
		register();
		break;
		}
	}
	
	public void getInputValues(){
		try
		{
			
		}
		catch(Exception e){ System.out.println(e);}	  
	}
	
	public void register()
	{
		try{  									
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
						
						System.out.println("Name:"+ username + "Email ID:"+email);
						int result =registerObj.registerUser(username,password,email);
						switch(result)
						{
						case 0: System.out.println("Updated Successfully");
						WelcomeBoard b = new WelcomeBoard();
						b.welcome();
						break;
						case 1: System.out.println("Username already exists in the database");
						register();
						break;
						case 2:System.out.println("Email Id already exists in the database");
						register(); 
						break;
						default:System.out.println("Email Id already exists in the database");
						register(); 
						break;							
						}						
			
				
		}
		catch(Exception e){ System.out.println(e);}	  
	}
}
