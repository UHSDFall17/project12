package login;

import java.util.Scanner;

import board.WelcomeBoard;
import sqlStatements.CommonSqlQueries;
import sqlStatements.RegisterStatements;
import validations.Validation;

public class Register {
	public String username ;
	public String email;
	public String password;
	public String confirmPassword;
	Validation val = new Validation();
	CommonSqlQueries sqlObj = new CommonSqlQueries();
	RegisterStatements registerObj = new RegisterStatements();
	
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
			Scanner inputReader = new Scanner (System.in);
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
						boolean usernameCheck=sqlObj.UserNameExisitsCheck(username);
						boolean emailCheck=sqlObj.EmailExisitsCheck(email);
						if(!usernameCheck && !emailCheck ){
							registerObj.registerUser(username,password,email);
							System.out.println("Updated Successfully");
							
							WelcomeBoard b = new WelcomeBoard();
							b.welcome();
						}
						else if(usernameCheck)
						{
							System.out.println("Username already exists in the database");
							register();
						}
						else if(emailCheck)
						{
							System.out.println("Email Id already exists in the database");
							register();
						}
					 inputReader.close();
			
				
		}
		catch(Exception e){ System.out.println(e);}	  
	}
}
