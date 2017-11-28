package sqlstatements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import trello.ConnectionManager;

public class NotificationSqlQueries {
	private Connection con;
	public void notification()
	{
		try{
		con = ConnectionManager.getConnection();	
		Statement s=con.createStatement(); 
		
		   System.out.println("Notification ");
		      System.out.println("--------------");
		      ResultSet rs1=s.executeQuery("SELECT comment FROM users LIMIT 2");
		      while(rs1.next()){
		    	  String comments = rs1.getString("comment");
		    	  System.out.println(comments);
		      }
		      
		      ResultSet rs2=s.executeQuery("SELECT comment FROM users LIMIT 2");
		      while(rs2.next()){
		    	  String comments = rs2.getString("comment");
		    	  System.out.println(comments);
		      }
	      }

		
		catch(Exception e){ System.out.println(e);}
	}
	public void viewAllNotifications() {
		try{
			con = ConnectionManager.getConnection();	
			Statement s=con.createStatement(); 
			
			   System.out.println("Notification ");
			      System.out.println("--------------");
			      ResultSet rs1=s.executeQuery("SELECT comments FROM board");
			      while(rs1.next()){
			    	  String comments = rs1.getString("boardname");
			    	  System.out.println(comments);
			      }
			      
			      ResultSet rs2=s.executeQuery("SELECT comments FROM cards");
			      while(rs2.next()){
			    	  String comments = rs2.getString("boardname");
			    	  System.out.println(comments);
			      }
		      }
		catch(Exception e){ System.out.println(e);}
		
	}
}
