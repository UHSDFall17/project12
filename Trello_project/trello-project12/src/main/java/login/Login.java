package login;

import java.util.Scanner;
import java.sql.*;

public class Login {

	
	public void login()
	{ 
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://50.62.176.51/Trello","trello","Team12");   
			Statement s=con.createStatement();  
			ResultSet rs=s.executeQuery("select * from login");  
			
			Scanner inputReader = new Scanner (System.in);
			System.out.println("Please enter your username:");
			String username  = inputReader.nextLine();
			System.out.println("Please enter your password");
			String password = inputReader.nextLine();
		
			
			if(rs.next()) {
				
			if (username.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
				System.out.println("Successful Login");	
			}
			else {
			System.out.println("Invalid Login");
			}    
			}
			con.close();
		}
		catch(Exception e){ System.out.println(e);}  
			 
	}
}
