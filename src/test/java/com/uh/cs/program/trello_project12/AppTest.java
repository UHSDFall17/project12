package com.uh.cs.program.trello_project12;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import login.Login;
import login.Register;
import validations.Validation;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	Validation val = new Validation();
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
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
    
    @org.junit.Test
   	public void test_Username_Alphabets_Only()
   	{
   		Register obj = new Register();
   		obj.username = "naresh";   		
   		boolean expectation = true;
   		boolean result = val.checkNamevalidity(obj.username);
   		assertEquals(expectation, result);
   	}
    
    @org.junit.Test
   	public void test_Email_pattern()
   	{
   		Register obj = new Register();
   		obj.email = "naresh@g.com";   		
   		boolean expectation = true;
   		boolean result = val.checkEmailvalidity(obj.email);
   		assertEquals(expectation, result);
   	}
    
    @org.junit.Test
   	public void test_Password_ConfirmPassword_match()
   	{
   		Register obj = new Register();
   		obj.password = "test";  
   		obj.confirmPassword="test";
   		boolean expectation = true;
   		boolean result = obj.password.equals(obj.confirmPassword);
   		assertEquals(expectation, result);
   	}
    
    @org.junit.Test
  	public void test_Registeration_UserName_Check()
  	{
  		Register obj = new Register();
  		obj.username = "raji";
  		boolean expectation = true;
  		boolean result = obj.UserNameExisitsCheck();
  		assertEquals(expectation, result);
  	}
    
    @org.junit.Test
  	public void test_Registeration_EmailID_Check()
  	{
  		Register obj = new Register();
  		obj.email = "raji@gmail.com";
  		boolean expectation = true;
  		boolean result = obj.EmailExisitsCheck();
  		assertEquals(expectation, result);
  	}
    
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
