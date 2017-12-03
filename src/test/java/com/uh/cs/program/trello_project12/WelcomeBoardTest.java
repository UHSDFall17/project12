package com.uh.cs.program.trello_project12;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import board.WelcomeBoard;

import static org.junit.Assert.*;

public class WelcomeBoardTest
{

	@Test
	public void test_method_welcome_0_branch_0()
	{
		WelcomeBoard instance = new WelcomeBoard();
		instance.welcome();		
		assertEquals("1", instance);
		
	}
}
