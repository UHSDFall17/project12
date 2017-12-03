package com.uh.cs.program.trello_project12;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import login.UserInfo;

import static org.junit.Assert.*;

public class UserInfoTest
{
	

	@Test
	public void test_method_UserInfo_0_branch_0()
	{		
		UserInfo instance = new UserInfo();	
		assertEquals("", instance);
		
	}


	@Test
	public void test_method_setUserName_1_branch_0()
	{	
	UserInfo instance = new UserInfo();
		
		
		instance.setUserName("test");
		
		
		assertEquals("test", instance);
		
	}

	@Test
	public void test_method_getUserName_2_branch_0()
	{		
		UserInfo instance = new UserInfo();	
		Object expResult = true ;
		Object result = instance.getUserName();
		assertEquals(expResult, result);		
		assertEquals(expResult, instance);
		
	}

	@Test
	public void test_method_setEmail_3_branch_0()
	{		
		UserInfo instance = new UserInfo();	
		instance.setEmail("test@gmail.com");
		assertEquals("test@gmail.com", instance);
		
	}

	@Test
	public void test_method_getEmail_4_branch_0()
	{
		UserInfo instance = new UserInfo();
		
		Object expResult = true ;
		Object result = instance.getEmail();
		
		assertEquals(expResult, result);
		
		
		assertEquals(expResult, instance);
		
	}


	@Test
	public void test_method_setPassword_5_branch_0()
	{
		
		UserInfo instance = new UserInfo();
		
		
		instance.setPassword("test");
		
		
		assertEquals("test", instance);
		
	}

	
	@Test
	public void test_method_getPassword_6_branch_0()
	{
		System.out.println("Now Testing Method:getPassword Branch:0");
		
		UserInfo instance = new UserInfo();
		
		Object expResult = true;
		Object result = instance.getPassword();
		
		assertEquals(expResult, result);
		
		
		assertEquals(expResult, instance);
		
	}


	@Test
	public void test_method_setConfirmPassword_7_branch_0()
	{
		System.out.println("Now Testing Method:setConfirmPassword Branch:0");
		
		UserInfo instance = new UserInfo();
		
		
		instance.setConfirmPassword("test");
		
		
		assertEquals("test", instance);
		
	}


	@Test
	public void test_method_getConfirmPassword_8_branch_0()
	{
		
		UserInfo instance = new UserInfo();
				Object expResult =true ;
		Object result = instance.getConfirmPassword();
		
		assertEquals(expResult, result);
		
		
		assertEquals(expResult, instance);
		
	}


	@Test
	public void test_method_setUserType_9_branch_0()
	{
		
		UserInfo instance = new UserInfo();
		
		
		instance.setUserType("2");
		
		
		assertEquals("2", instance);
		
	}

	@Test
	public void test_method_getUserType_10_branch_0()
	{
		
		UserInfo instance = new UserInfo();
		
		Object expResult = true;
		Object result = instance.getUserType();
		
		assertEquals(expResult, result);
		
		
		assertEquals( "2", instance);
		
	}

}
