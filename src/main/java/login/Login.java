package login;

import java.util.Scanner;
import java.sql.*;

import board.WelcomeBoard;
import trello.ConnectionManager;

public class Login {
	private String username;
	private String password;
	
	private Connection con = null;

	
	public String getusername()
	{	   
	    return username;
	}
	public void setusername(String value)
	{
	     username = value;
	}
	public String getpassword()
	{
	    return password;
	}
	public void setpassword(String value)
	{
	     password = value;
	}
	
	public void loginPage()
	{ 
		
		try{  
			
			Scanner inputReader = new Scanner (System.in);
			System.out.println("---Login Form---");
			System.out.println("Please enter your username:");
			 username  = inputReader.nextLine();
			System.out.println("Please enter your password");
			 password = inputReader.nextLine();
			
			boolean loginResult = loginCheck();
			if(loginResult)
			{
				System.out.println("Successful Login");
				WelcomeBoard b = new WelcomeBoard();
				b.welcome();
			}
			else{
				System.out.println("Invalid Login");
			}
			 
			inputReader.close();
			
		}
		catch(Exception e){ System.out.println(e);}  
			 
	}

	public boolean loginCheck()
	{
		try{
			con = ConnectionManager.getConnection();
		
		String values = "Select user_name,password from login Where user_name ='"+username+"' and password = '" +password+"';";
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
	public void restart() {
		System.out.println("Entry does not match.");
		forgotPassword();
	}
	
	public void forgotPassword() {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://50.62.176.51/Trello","trello","Team12");
			
			Scanner input = new Scanner(System.in);
			System.out.println("Enter your existing username:");
			 username = input.nextLine();
			
			String values = "SELECT user_name FROM login Where user_name = '" + username + "';";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(values);
			
			if(rs.next()) {
				System.out.println("Entry matches. Please enter a new password:");
				String password = input.nextLine();
				
				values = "UPDATE login (user_name,password) " + "VALUES ('" +username+ "', '" +password+"')";
				s = con.createStatement();
				s.executeUpdate(values);  
				System.out.println("Updated Successfully");								
				
				input.close();
				con.close();
				loginPage();
			}
			else
				restart();
		}
		catch(Exception e) { 
			System.out.println(e);
		}
	}
}
