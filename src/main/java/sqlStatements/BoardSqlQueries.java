package sqlStatements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import trello.ConnectionManager;

public class BoardSqlQueries {
	private Connection con;
	Statement s = null;
	String name, starred;
	String lists;
	private String boardnames1;
	private String starboard;

	public void viewboards() {
		try {
			con = ConnectionManager.getConnection();
			Statement s = con.createStatement();

			System.out.println("Starred Board");
			System.out.println("--------------");
			ResultSet rs1 = s.executeQuery("SELECT * FROM board WHERE starred = '1'");
			while (rs1.next()) {
				starred = rs1.getString("boardname");
				System.out.println("Boardname: " + starred);
			}

			System.out.println("Personal Board");
			System.out.println("--------------");
			ResultSet rs = s.executeQuery("SELECT * FROM board");

			while (rs.next()) {
				name = rs.getString("boardname");
				System.out.println("Boardname: " + name);
			}

		}

		catch (Exception e) {
			System.out.println(e);
		}
	}

	public void listCards(String boardnames) {
		this.boardnames1 = boardnames;
		try {
			con = ConnectionManager.getConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM board WHERE boardname ='" + boardnames1 + "'");
			while (rs.next()) {
				lists = rs.getString("list");
				System.out.println("List: " + lists);
			}
		}

		catch (Exception e) {
			System.out.println(e);
		}
	}

	public void starIt(String boardname) {
		this.starboard = boardname;
		try {
			con = ConnectionManager.getConnection();
			Statement s = con.createStatement();
			s.executeUpdate("UPDATE board SET starred = '1' WHERE boardname ='" + starboard + "'");
			System.out.println("Starred Successsfully");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public void createBoard(String title,String team_name) {
		try {
			con = ConnectionManager.getConnection();
			String values = "INSERT INTO baord (boardname,team_name) " + "VALUES ('" +title+ "', '" +team_name+"')";
			s = con.createStatement();
			s.executeUpdate(values); 
			System.out.println("Created Board Successfully");
		}catch (Exception e) { System.out.println(e);}
		}


	public void restoreBoards(String restoreBoardName) {
		try {
			con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			String check = "SELECT boardname FROM deleted_boards WHERE boardname ='" + restoreBoardName + "'";
			ResultSet rs = st.executeQuery(check);
			if(rs.next()) {
			st.executeUpdate("INSERT INTO board (boardname,list,starred,team_name) SELECT boardname,list,starred,team_name FROM deleted_boards WHERE boardname ='" + restoreBoardName + "'");
			st.executeUpdate("DELETE FROM deleted_boards WHERE boardname ='" + restoreBoardName + "'");
			System.out.println("Board Restored Successfully");}
			else {System.out.println("There are no such boards");}
	}catch (Exception e) { System.out.println(e);}
}

	public void viewDeletedBoards() {
		try {
		con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		String displayDeleted = "SELECT * FROM deleted_boards";
		ResultSet rs = st.executeQuery(displayDeleted);
		while (rs.next()) {
			String deletedBoardName = rs.getString("boardname");
			System.out.println("Deleted Board: " + deletedBoardName);
		}
		}catch (Exception e) { System.out.println(e);}
	}
}
