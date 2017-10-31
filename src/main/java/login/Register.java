package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import board.WelcomeBoard;
import trello.ConnectionManager;
import validations.Validation;

public class Register {
	public String username ;
	public String email;
	public String password;
	public String confirmPassword;
	Validation val = new Validation();
	private Connection con = null;
	
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
	
	public boolean UserNameExisitsCheck()
	{
		try{
			con = ConnectionManager.getConnection();
		
			String values = "Select user_name from login Where user_name ='"+username+"';";
		Statement s=con.createStatement();  
		ResultSet rs=s.executeQuery(values); 
		
		if(rs.next()) {
			con.close();
			return true;
		}
		else {
			con.close();
		return false;
		}
		}
		catch(Exception e){ System.out.println(e);}
		
		return false;  
	}
	
	public boolean EmailExisitsCheck()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://50.62.176.51/Trello","trello","Team12"); 
		
			String values = "Select email_id from login Where email_id ='"+email+"';";
		Statement s=con.createStatement();  
		ResultSet rs=s.executeQuery(values); 
		
		if(rs.next()) {
			con.close();
			return true;
		}
		else {
			con.close();
		return false;
		}
		}
		catch(Exception e){ System.out.println(e);}
		
		return false;  
	}
	
	public void getInputValues(){
		try
		{
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
					 inputReader.close();
		}
		catch(Exception e){ System.out.println(e);}	  
	}
	
	public void register()
	{
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://50.62.176.51/Trello","trello","Team12");
			Statement s = null;
			
			getInputValues();
				
				System.out.println("Name:"+ username + "Email ID:"+email);
				boolean usernameCheck=UserNameExisitsCheck();
				boolean emailCheck=EmailExisitsCheck();
				if(!usernameCheck && !emailCheck ){
					String values = "INSERT INTO login (user_name,password,email_id) " + "VALUES ('" +username+ "', '" +password+"','" +email+"')";
					s = con.createStatement();
					s.executeUpdate(values);  
					System.out.println("Updated Successfully");
				
					WelcomeBoard b = new WelcomeBoard();
					b.welcome();
				}
				else if(usernameCheck)
				{
					System.out.println("Username already exists in the database");
				}
				else if(emailCheck)
				{
					System.out.println("Email Id already exists in the database");
				}
				
		}
		catch(Exception e){ System.out.println(e);}	  
	}
}
