package login;

import java.util.Scanner;

import board.WelcomeBoard;
import global.Global;
import sqlstatements.CommonSqlQueries;
import sqlstatements.RegisterStatements;

public class Login {
	private String username;
	private String password;
	public Scanner inputReader = new Scanner(System.in);
	private RegisterStatements loginObj = new RegisterStatements();
	private CommonSqlQueries sqlObj = new CommonSqlQueries();
	private UserInfo userObj = new UserInfo();

	public void loginPage() {

		try {
			System.out.println("---Login Form---");
			username = userObj.getUserName();
			password = userObj.getPassword();
			boolean loginResult = loginObj.loginCheck(username, password);
			if (loginResult) {
				Global.userName = username;
				System.out.println("Welcome \t" + Global.userName);
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
			username = userObj.getUserName();
			boolean result = sqlObj.UserNameExisitsCheck(username);
			System.out.println(result);
			if (result) {
				System.out.println("Entry matches. ");
				password = userObj.getPassword();
				loginObj.forgotPassword(username, password);
				System.out.println("Updated Successfully");
				loginPage();
			} else
				restart();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
