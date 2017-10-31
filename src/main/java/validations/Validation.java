package validations;

public class Validation {
	public boolean checkEmailvalidity(String emailaddress){
	    String email_regex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	   boolean b = emailaddress.matches(email_regex);
	   return b;
	}
	public boolean checkNamevalidity(String name){
	    String name_regex = "[a-zA-Z]+";
	   boolean b = name.matches(name_regex);
	   return b;
	}
}
