package sqlStatements;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import trello.ConnectionManager;

public class CardSqlQueries {
	private Connection con;
	private Statement s = null;
	private Scanner input = new Scanner(System.in);


	public void listAllCards(String listname) {
		try{
			con = ConnectionManager.getConnection();	
			s=con.createStatement(); 
			ResultSet rs = s.executeQuery("SELECT * FROM cards WHERE lists = '" + listname + "'");
			while(rs.next()){
		         String cards = rs.getString("card_name");
		         System.out.println("Cards: " + cards);
		    }	
		}      
		catch(Exception e){ System.out.println(e);}
	}
	
	public void listCardsWithDates(String listname) {
		try {
			con = ConnectionManager.getConnection();
			s = con.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM cards WHERE lists = '" + listname +"' AND due_date IS NOT NULL");
			while(rs.next()) {
				String cards = rs.getString("card_name");
				System.out.println("Cards: " + cards);
			}	
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void listList() {
		try {
			ArrayList<String> list = new ArrayList<String>();
			con = ConnectionManager.getConnection();
			s = con.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM cards");
			while(rs.next()) {
				String cardList  = rs.getString("lists");
				if(!list.contains(cardList)) {
					list.add(cardList);
					System.out.println("List: " + cardList);
				}
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void createCard(String listname, String cardname, String description, String comments, String date) {
		try {
			String statement;
			con = ConnectionManager.getConnection();
			if(date == null) {
				statement = "INSERT INTO cards (lists, card_name, description, comments, due_date) " 
						+ "VALUES ('" + listname + "', '" + cardname + "', '"+ description + "', '" + comments + "', NULL)";
			}
			else {
				statement = "INSERT INTO cards (lists, card_name, description, comments, due_date) " 
						+ "VALUES ('" + listname + "', '" + cardname + "', '"+ description + "', '" + comments + "', '"+ date + "')";
			}
			s = con.createStatement();
			s.executeUpdate(statement); 
			System.out.println("Created Card Successfully.");
		}
		catch (Exception e) { 
			System.out.println(e);
		}
	}
	
	
	public void modifyCard(String listname, String cardname, int choice) {
		String newCardName, newDescription, newComments, newDate;
		try {
			con = ConnectionManager.getConnection();
			s = con.createStatement();
			switch(choice) {
			case 1:
				System.out.println("Enter a new card name: ");
				newCardName = input.nextLine();
				s.executeUpdate("UPDATE cards SET card_name = '" + newCardName + "' WHERE lists = '"+ listname + "' AND card_name = '" + cardname +"'");
				break;
			case 2:
				System.out.println("Enter a new description: ");
				newDescription = input.nextLine();
				s.executeUpdate("UPDATE cards SET description = '" + newDescription + "' WHERE lists = '"+ listname + "' AND card_name = '" + cardname +"'");
				break;
			case 3:
				System.out.println("Enter new comments: ");
				newComments = input.nextLine();
				s.executeUpdate("UPDATE cards SET comments = '" + newComments + "' WHERE lists = '"+ listname + "' AND card_name = '" + cardname +"'");
				break;
			case 4:
				System.out.println("Enter the new date in YYYY-MM-DD form: ");
				newDate = input.nextLine();
				s.executeUpdate("UPDATE cards SET due_date = '" + newDate + "' WHERE lists = '"+ listname + "' AND card_name = '" + cardname +"'");
				break;
			}
			System.out.println("Modified Card Succcessfully");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
