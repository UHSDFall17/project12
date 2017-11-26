package login;

import java.util.Scanner;
import java.sql.*;

import board.WelcomeBoard;
import trello.ConnectionManager;
import global.Global;

public class Login {
	private String username;
	private String password;
	private Connection con = null;
	Scanner inputReader = new Scanner(System.in);
	UserInfo userObj = new UserInfo();

	public void loginPage() {

		try {
			System.out.println("---Login Form---");
			username = userObj.getUserName();
			password = userObj.getPassword();
			boolean loginResult = loginCheck();
			if (loginResult) {
				System.out.println("Successful Login");
				Global.userName = username;
				WelcomeBoard b = new WelcomeBoard();
				b.welcome();
			} else {
				System.out.println("Invalid Login");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public boolean loginCheck() {
		try {
			con = ConnectionManager.getConnection();

			String values = "Select user_name,password,user_type from login Where user_name ='"
					+ username + "' and password = '" + password + "';";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(values);

			if (rs.next()) {
				Global.userType = rs.getString("user_type");
				con.close();
				return true;
			} else {
				con.close();
				return false;
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return false;
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
