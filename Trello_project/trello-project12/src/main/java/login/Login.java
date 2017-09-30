package login;

import java.util.Scanner;
import java.sql.*;

import board.Board;
import board.WelcomeBoard;

public class Login {

	
	public void login()
	{ 
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://50.62.176.51/Trello","trello","Team12");   
			
			
			Scanner inputReader = new Scanner (System.in);
			System.out.println("---Login Form---");
			System.out.println("Please enter your username:");
			String username  = inputReader.nextLine();
			System.out.println("Please enter your password");
			String password = inputReader.nextLine();
			
			String values = "Select user_name,password from login Where user_name ='"+username+"' and password = '" +password+"';";
			Statement s=con.createStatement();  
			ResultSet rs=s.executeQuery(values); 
			
			if(rs.next()) {
				System.out.println("Successful Login");
				WelcomeBoard b = new WelcomeBoard();
				b.welcome();
			}
			else {
			System.out.println("Invalid Login");
			}    
			
			con.close();
		}
		catch(Exception e){ System.out.println(e);}  
			 
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
			String username = input.nextLine();
			
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
				login();
			}
			else
				restart();
		}
		catch(Exception e) { 
			System.out.println(e);
		}
	}
}
