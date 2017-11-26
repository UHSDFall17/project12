package sqlStatements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import trello.ConnectionManager;

public class CardSqlQueries {
	private Connection con;
	private String listnames1;


	public void listCards(String cardnames) {
		this.listnames1 = cardnames;
		try{
			con = ConnectionManager.getConnection();	
			Statement s=con.createStatement(); 
			ResultSet rs=s.executeQuery("SELECT * FROM cards WHERE lists ='" +listnames1+ "'");
			while(rs.next()){
		         String cards = rs.getString("card_name");
		         System.out.println("Cards: " + cards);
		    	  	}	
		      }      
		catch(Exception e){ System.out.println(e);}
	}
	
}
