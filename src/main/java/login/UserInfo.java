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
		System.out.println("Enter your name:");
		username = inputReader.nextLine();
		return username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		System.out.println("Enter your EmailID:");
		email = inputReader.nextLine();
		return email;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		System.out.println("Enter Password:");
		password = inputReader.nextLine();
		return password;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getConfirmPassword() {
		System.out.println("Re-Enter your Password:");
		confirmPassword = inputReader.nextLine();
		return confirmPassword;
	}
}
