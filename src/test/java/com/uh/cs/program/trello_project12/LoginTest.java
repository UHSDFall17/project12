package com.uh.cs.program.trello_project12;

import junit.framework.TestCase;
import login.Login;


public class LoginTest extends TestCase {
	public LoginTest( String testName )
    {
        super( testName );
    }
	@org.junit.Test
	public void test_LoginCheck()
	{
		Login obj = new Login();
		obj.setusername("naresh123");
		obj.setpassword ( "test");
		boolean expectation = true;
		boolean result = obj.loginCheck();
		assertEquals(expectation, result);
	}
    
}
