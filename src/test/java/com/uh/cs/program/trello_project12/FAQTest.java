package com.uh.cs.program.trello_project12;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import login.FAQ;

import static org.junit.Assert.*;

public class FAQTest
{

	@Test
	public void test_method_start_0_branch_0()
	{

		FAQ instance = new FAQ();

		instance.start();

		assertEquals("----Help/FAQ----\\n\" + \"What do you need help with?", instance);
		
	}

}
