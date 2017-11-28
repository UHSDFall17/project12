package com.uh.cs.program.trello_project12;

import sqlstatements.RegisterStatements;
import junit.framework.TestCase;
import login.UserInfo;


public class LoginTest extends TestCase {
	public LoginTest( String testName )
    {
        super( testName );
    }
	//@org.junit.Test
	public void test_LoginCheck()
	{
		RegisterStatements regObj = new RegisterStatements();
		UserInfo userObj = new UserInfo();
		userObj.setUserName("raji");
		userObj.setPassword ( "pass");
		boolean expectation = true;
		boolean result = regObj.loginCheck(userObj.getNameForTest(),userObj.getPasswordForTest());
		assertEquals(expectation, result);
	}
    
}
