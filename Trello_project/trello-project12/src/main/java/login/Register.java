package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Register {
	
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
		case 4: System.out.println ("Email Id is Invalid!. Try Again");
		register();
		case 5: System.out.println ("Name should contain only Numbers!. Try Again");
		register();
		break;
		}
	}
	public boolean checkEmailvalidity(String emailaddress){
	    String email_regex = "[A-Z]+[a-zA-Z_]+@\b([a-zA-Z]+.){2}\b?.[a-zA-Z]+";
	   boolean b = emailaddress.matches(email_regex);
	   return b;
	}
	public boolean checkNamevalidity(String name){
	    String name_regex = "[a-zA-Z]+";
	   boolean b = name.matches(name_regex);
	   return b;
	}
	public void register()
	{
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://50.62.176.51/Trello","trello","Team12");
			Statement s = null;
			
			Scanner inputReader = new Scanner (System.in);
			System.out.println("---Registration Form---");
			System.out.println("Please enter your name:");
			String username  = inputReader.nextLine();
			 if (username.length()==0)
		    {
				 RequiredValidation(1);
		    }
			 else if (!checkNamevalidity(username)){
				 RequiredValidation(5);
			 }				 
				System.out.println("Please enter your emailID:");
				String email  = inputReader.nextLine();
				 if (email.length()==0)
				    {
						 RequiredValidation(2);
				    }
				 else if(!checkEmailvalidity(email))
				 {
					 RequiredValidation(4);
		              } 
				System.out.println("Please enter your desired password");
				String password = inputReader.nextLine();
				 if (password.length()==0)
				    {
						 RequiredValidation(3);
				    }
				inputReader.close();
				System.out.println("Name:"+ username + "Email ID:"+email);
				
				String values = "INSERT INTO login (user_name,password) " + "VALUES ('" +username+ "', '" +password+"')";
				s = con.createStatement();
				s.executeUpdate(values);  
				System.out.println("Updated Successfully");
			 
			
	}
		catch(Exception e){ System.out.println(e);}  
}

}
