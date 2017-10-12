package com.uh.cs.program.trello_project12;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import login.Login;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
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
		obj.username = "naresh123";
		obj.password = "test1";
		boolean expectation = true;
		boolean result = obj.loginCheck();
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
