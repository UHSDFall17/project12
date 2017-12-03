package com.uh.cs.program.trello_project12;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import login.Register;
import static org.junit.Assert.*;

public class RegisterTest
{

	@Test
	public void test_method_RequiredValidation_0_branch_0()
	{		
		Register instance = new Register(); 
		instance.requiredValidation(1);
		assertEquals("1", instance);
		
	}

	@Test
	public void test_method_getInputValues_1_branch_0()
	{
		Register instance = new Register(); 
		instance.getInputValues();		
		assertEquals("test", instance);	
	}


	@Test
	public void test_method_getInputValues_1_branch_1()
	{

				Register instance = new Register(); 
				instance.getInputValues();
				assertEquals("test@gmail.com", instance);
		
	}


	@Test
	public void test_method_getInputValues_1_branch_2()
	{

				Register instance = new Register(); 
		instance.getInputValues();		
		assertEquals("test", instance);
		
	}


	@Test
	public void test_method_getInputValues_1_branch_3()
	{
		
				Register instance = new Register();  
		instance.getInputValues();		
		assertEquals("test", instance);
		
	}


	@Test
	public void test_method_getInputValues_1_branch_4()
	{
				Register instance = new Register();  
		instance.getInputValues();
		assertEquals("2", instance);
		
	}

	/*
	 * Testing Conditon(s): else: Not (email.length() == 0), else: Not (!val.checkEmailvalidity(email))
	 */
	@Test
	public void test_method_getInputValues_1_branch_5()
	{
				Register instance = new Register(); 
		instance.getInputValues();
		assertEquals("", instance);
		
	}


	@Test
	public void test_method_getInputValues_1_branch_6()
	{

				Register instance = new Register();  
		instance.getInputValues();		
		assertEquals("", instance);
		
	}


	@Test
	public void test_method_getInputValues_1_branch_7()
	{
		Register instance = new Register(); 
		instance.getInputValues();		
		assertEquals("", instance);
		
	}


	@Test
	public void test_method_getInputValues_1_branch_8()
	{
				Register instance = new Register();  
		instance.getInputValues();		
		assertEquals("", instance);
		
	}


	@Test
	public void test_method_getInputValues_1_branch_9()
	{
		Register instance = new Register();  
		instance.getInputValues();		
		assertEquals("", instance);
		
	}

	@Test
	public void test_method_getInputValues_1_branch_10()
	{
				Register instance = new Register(); 
		instance.getInputValues();
		assertEquals("", instance);
		
	}


	@Test
	public void test_method_getInputValues_1_branch_11()
	{
	    Register instance = new Register();  		
		instance.getInputValues();
		assertEquals("", instance);
		
	}


	@Test
	public void test_method_getInputValues_1_branch_12()
	{
		Register instance = new Register();
		instance.getInputValues();		
		assertEquals("", instance);
		
	}

	@Test
	public void test_method_register_2_branch_0()
	{
		Register instance = new Register();		
		instance.register();
		assertEquals("0", instance);
		
	}


}
