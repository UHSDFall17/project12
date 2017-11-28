package com.uh.cs.program.trello_project12;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import login.Register;
import validations.Validation;
import sqlStatements.CommonSqlQueries;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	private Validation val = new Validation();
	private CommonSqlQueries sqlobj = new CommonSqlQueries();
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
   	public void testUsernameAlphabetsOnly()
   	{
   		Register obj = new Register();
   		obj.username = "naresh";   		
   		boolean expectation = true;
   		boolean result = val.checkNamevalidity(obj.username);
   		assertEquals(expectation, result);
   	}
    
    @org.junit.Test
   	public void testEmailpattern()
   	{
   		Register obj = new Register();
   		obj.email = "naresh@g.com";   		
   		boolean expectation = true;
   		boolean result = val.checkEmailvalidity(obj.email);
   		assertEquals(expectation, result);
   	}
    
    @org.junit.Test
   	public void testPasswordConfirmPasswordmatch()
   	{
   		Register obj = new Register();
   		obj.password = "test";  
   		obj.confirmPassword="test";
   		boolean expectation = true;
   		boolean result = obj.password.equals(obj.confirmPassword);
   		assertEquals(expectation, result);
   	}
    
    @org.junit.Test
  	public void testRegisterationUserNameCheck()
  	{
  		Register obj = new Register();
  		obj.username = "raji";
  		boolean expectation = true;
  		boolean result = sqlobj.userNameExisitsCheck(obj.username);
  		assertEquals(expectation, result);
  	}
    
    @org.junit.Test
  	public void testRegisterationEmailID_Check()
  	{
  		Register obj = new Register();
  		obj.email = "raji@gmail.com";
  		boolean expectation = true;
  		boolean result = sqlobj.emailExisitsCheck(obj.email);
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
        
    }
}
