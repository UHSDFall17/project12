package sqlStatements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import trello.ConnectionManager;

public class BoardSqlQueries {
	private Connection con;
	Statement s = null;String name,starred;String lists;
	private String boardnames1;
	private String starboard;
	public void viewboards()
	{
		try{
		con = ConnectionManager.getConnection();	
		Statement s=con.createStatement(); 
		
		   System.out.println("Starred Board");
		      System.out.println("--------------");
		      ResultSet rs1=s.executeQuery("SELECT * FROM board WHERE starred = '1'");
		      while(rs1.next()){
		    	  starred = rs1.getString("boardname");
		    	  System.out.println("Boardname: " + starred);
		      }
		      
		System.out.println("Personal Board");
		System.out.println("--------------");
		ResultSet rs=s.executeQuery("SELECT * FROM board");
	      
			while(rs.next()){
	         name = rs.getString("boardname");
	         System.out.println("Boardname: " + name);
	      }
	    
	      }

		
		catch(Exception e){ System.out.println(e);}
	}
	
	
	
	
	
	public void listCards(String boardnames) {
		this.boardnames1 = boardnames;
		try{
			con = ConnectionManager.getConnection();	
			Statement s=con.createStatement(); 
			ResultSet rs=s.executeQuery("SELECT * FROM board WHERE boardname ='" +boardnames1+ "'");
			while(rs.next()){
		         lists = rs.getString("list");
		         System.out.println("List: " + lists);
		    	  	}	
		      }
		      
		catch(Exception e){ System.out.println(e);}
	}





	public void starIt(String boardname) {
		this.starboard = boardname;
		try{
			con = ConnectionManager.getConnection();	
			Statement s=con.createStatement(); 
			s.executeUpdate("UPDATE board SET starred = '1' WHERE boardname ='" +starboard+ "'");
				System.out.println("Starred Successfully");
		      }
		catch(Exception e){ System.out.println(e);}
		
	}
	
}
