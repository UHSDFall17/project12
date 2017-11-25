package login;

import java.util.Scanner;

public class UserInfo {
	private String username;
	private String email;
	public String password;
	public String confirmPassword;
	Scanner inputReader = new Scanner(System.in);

	public UserInfo() {
		username = "";
		email = "";
		password="";
		confirmPassword="";
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getUserName() {
		System.out.println("Enter User Name:");
		username = inputReader.nextLine();
		return username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		System.out.println("Please enter Team Description(optional):");
		email = inputReader.nextLine();
		return email;
	}
}
