package login;

import java.util.Scanner;

public class UserInfo {
	private String username;
	private String email;
	public String password;
	public String confirmPassword;
	public String userType;
	public String orgName;
	private Scanner inputReader = new Scanner(System.in);

	public UserInfo() {
		username = "";
		email = "";
		password="";
		confirmPassword="";
		userType="2";
		orgName="";
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getUserName() {
		System.out.println("Enter user name:");
		username = inputReader.nextLine().trim();
		return username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		System.out.println("Enter your EmailID:");
		email = inputReader.nextLine().trim();
		return email;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		System.out.println("Enter Password:");
		password = inputReader.nextLine().trim();
		return password;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getConfirmPassword() {
		System.out.println("Re-Enter your Password:");
		confirmPassword = inputReader.nextLine().trim();
		return confirmPassword;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserType() {
		System.out.println("Are you a corporate user? Enter 1. Yes 2. No");
		userType = inputReader.nextLine().trim();
		return userType;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgName() {
		System.out.println("Enter the Organisation Name:");
		orgName = inputReader.nextLine().trim();
		return orgName;
	}
}
