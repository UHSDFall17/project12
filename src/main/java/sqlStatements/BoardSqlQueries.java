package sqlStatements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import trello.ConnectionManager;

public class BoardSqlQueries {
	private Connection con;
	Statement s = null;String name;
	public void viewboards()
	{
		try{
		con = ConnectionManager.getConnection();
		System.out.println("Personal Boards");		
		Statement s=con.createStatement();  
		ResultSet rs=s.executeQuery("SELECT * FROM board");

	      while(rs.next()){
	         name = rs.getString("boardname");
	      
	         //Display values
	         System.out.println("Boardname: " + name);
	      }
	      }
	//	values = "SELECT * FROM boards"; //where (category ='starred')";			
	//	ResultSet rs1 = s.executeQuery(values);
		
		catch(Exception e){ System.out.println(e);}
	}
}
