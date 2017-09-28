package login;

import java.util.Scanner;
import java.sql.*;
import board.Board;

public class Login {

	
	public void login()
	{ 
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://50.62.176.51/Trello","trello","Team12");   
			
			
			Scanner inputReader = new Scanner (System.in);
			System.out.println("Please enter your username:");
			String username  = inputReader.nextLine();
			System.out.println("Please enter your password");
			String password = inputReader.nextLine();
			
			String values = "Select user_name,password from login Where user_name ='"+username+"' and password = '" +password+"';";
			Statement s=con.createStatement();  
			ResultSet rs=s.executeQuery(values); 
			
			if(rs.next()) {
				System.out.println("Successful Login");
				Board b = new Board();
				b.board();
			}
			else {
			System.out.println("Invalid Login");
			}    
			
			con.close();
		}
		catch(Exception e){ System.out.println(e);}  
			 
	}
}
