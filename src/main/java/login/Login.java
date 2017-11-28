package login;

import java.util.Scanner;
import java.sql.*;

import board.WelcomeBoard;
import trello.ConnectionManager;
import global.Global;
import sqlStatements.RegisterStatements;

public class Login {
	private String username;
	private String password;
	private Connection con = null;
	Scanner inputReader = new Scanner(System.in);
	RegisterStatements loginObj = new RegisterStatements();
	UserInfo userObj = new UserInfo();

	public void loginPage() {

		try {
			System.out.println("---Login Form---");
			username = userObj.getUserName();
			password = userObj.getPassword();
			boolean loginResult = loginObj.loginCheck(username,password);
			if (loginResult) {
				Global.userName = username;
				System.out.println("Welcome \t" +Global.userName);
				WelcomeBoard b = new WelcomeBoard();
				b.welcome();
			} else {
				System.out.println("Invalid Login");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}



	public void restart() {
		System.out.println("Entry does not match.");
		forgotPassword();
	}

	public void forgotPassword() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://50.62.176.51/Trello", "trello", "Team12");

			Scanner input = new Scanner(System.in);
			username = userObj.getUserName();

			String values = "SELECT user_name FROM login Where user_name = '"
					+ username + "';";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(values);

			if (rs.next()) {
				System.out.println("Entry matches. ");
				password = userObj.getPassword();

				values = "UPDATE login (user_name,password) " + "VALUES ('"
						+ username + "', '" + password + "')";
				s = con.createStatement();
				s.executeUpdate(values);
				System.out.println("Updated Successfully");

				input.close();
				con.close();
				loginPage();
			} else
				restart();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
