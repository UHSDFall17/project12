package login;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import board.WelcomeBoard;
import sqlStatements.RegisterStatements;
import validations.Validation;
import login.UserInfo;

public class Register {
	private String username;
	private String email;
	private String password;
	private String confirmPassword;
	private String userType;
	private String orgName=null;
	private Validation val = new Validation();
	RegisterStatements registerObj = new RegisterStatements();
	Scanner inputReader = new Scanner(System.in);
	UserInfo userObj = new UserInfo();

	public void requiredValidation(int input) {
		String printString = "";
		switch (input) {
		case 1:
			printString = "Name is Required";
			break;
		case 2:
			printString = "Email is Required";
			break;
		case 3:
			printString = "Password is Required";
			break;
		case 4:
			printString = "ConfirmPassword is Required";
			break;
		case 5:
			printString = "Email Id is Invalid";
			break;
		case 6:
			printString = "Name should contain only Numbers";
			break;
		case 7:
			printString = "Password and Confirm password does not match";
			break;
		case 8:
			printString = "Organisation Name is Required";
			break;
		}
		System.out.println(printString + "!. Try Again");
		register();
	}

	public void getInputValues() {
		try {
			System.out.println("---Registration Form---");
			username = userObj.getUserName();
			if (username.length() == 0) {
				requiredValidation(1);
			} else if (!val.checkNamevalidity(username)) {
				requiredValidation(6);
			}
			email = userObj.getEmail();
			if (email.length() == 0) {
				requiredValidation(2);
			} else if (!val.checkEmailvalidity(email)) {
				requiredValidation(5);
			}
			password = userObj.getPassword();
			if (password.length() == 0) {
				requiredValidation(3);
			}
			confirmPassword = userObj.getConfirmPassword();
			if (confirmPassword.length() == 0) {
				requiredValidation(3);
			} else if (!password.equals(confirmPassword)) {
				requiredValidation(7);
			}
			userType = userObj.getUserType();
			if(userType.equals("") || userType.equals(null))
			{
				userType="2";
			}
			if(userType.equals("1")){
				orgName=userObj.getOrgName();
				if(userType.equals("") || userType.equals(null))
				{
					requiredValidation(8);
				}
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void register() {
		try {
			getInputValues();
			System.out.println("Name:" + username + " Email ID:" + email);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String comment="Registered into trello on"+dateFormat.format(date);			
			int result = registerObj.registerUser(username, password, email,userType,orgName,comment);
			String printValues = "";
			switch (result) {
			case 0:
				System.out.println("Updated Successfully");
				WelcomeBoard b = new WelcomeBoard();
				b.welcome();
				break;
			case 1:
				printValues = "Username already exists in the database";
				break;
			case 2:
				printValues = "Email Id already exists in the database";
				break;
			default:
				printValues = "Email Id already exists in the database";
				break;
			}
			System.out.println(printValues);
			register();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
