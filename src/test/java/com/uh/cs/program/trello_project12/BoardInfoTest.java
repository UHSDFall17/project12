package com.uh.cs.program.trello_project12;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import board.BoardInfo;

import static org.junit.Assert.*;

public class BoardInfoTest
{

	@Test
	public void test_method_BoardInfo_0_branch_0()
	{
		BoardInfo instance = new BoardInfo();		
		assertEquals("", instance);
		
	}

	@Test
	public void test_method_setBoardTitle_1_branch_0()
	{
		BoardInfo instance = new BoardInfo();		
		instance.setBoardTitle("Test");
				assertEquals("Test", instance);
		
	}


	@Test
	public void test_method_getBoardTitle_2_branch_0()
	{
		BoardInfo instance = new BoardInfo();		
		Object expResult = "Test" ;
		Object result = instance.getBoardTitle();
		assertEquals(expResult, result);		
		assertEquals(expResult, instance);
		
	}

	@Test
	public void test_method_setTeamName_3_branch_0()
	{
		BoardInfo instance = new BoardInfo();		
		instance.setTeamName("TestTeam");		
		assertEquals("TestTeam", instance);
		
	}


	@Test
	public void test_method_getTeamName_4_branch_0()
	{
	
		BoardInfo instance = new BoardInfo();		
		Object expResult = "TestTeam";
		Object result = instance.getTeamName();
		assertEquals(expResult, result);		
		assertEquals(expResult, instance);
		
	}

	/*
	 * Testing Conditon(s): Default
	 */
	@Test
	public void test_method_setStarBoard_5_branch_0()
	{
		BoardInfo instance = new BoardInfo();		
		instance.setStarBoard("TestBoard0");
		
		assertEquals("TestBoard0", instance);
		
	}


	@Test
	public void test_method_getStarBoard_6_branch_0()
	{
		BoardInfo instance = new BoardInfo();		
		Object expResult = "TestBoard0";
		Object result = instance.getStarBoard();
		assertEquals(expResult, result);		
		assertEquals(expResult, instance);
		
	}


	@Test
	public void test_method_setstarBoardName_7_branch_0()
	{
		BoardInfo instance = new BoardInfo();		

		instance.setstarBoardName("TEstBoard1");
		
		//Check Test Verification Points
		assertEquals("TEstBoard1", instance);
		
	}


	@Test
	public void test_method_getstarBoardName_8_branch_0()
	{
		BoardInfo instance = new BoardInfo();		
		Object expResult = "TEstBoard1";
		Object result = instance.getstarBoardName();
		assertEquals(expResult, result);		
		assertEquals(expResult, instance);
		
	}


	@Test
	public void test_method_setopenBoardName_9_branch_0()
	{
		BoardInfo instance = new BoardInfo();		
		instance.setopenBoardName("TestBoard2");
		assertEquals("TestBoard2", instance);
		
	}


	@Test
	public void test_method_getopenBoardName_10_branch_0()
	{
		BoardInfo instance = new BoardInfo();		
		Object expResult = "TestBoard2";
		Object result = instance.getopenBoardName();		
		assertEquals(expResult, result);
		assertEquals(expResult, instance);
		
	}


	@Test
	public void test_method_setopenBoardOption_11_branch_0()
	{
		BoardInfo instance = new BoardInfo();		
		instance.setopenBoardOption("TestBoardOption");
		
		//Check Test Verification Points
		assertEquals("TestBoardOption", instance);
		
	}


	@Test
	public void test_method_getopenBoardOption_12_branch_0()
	{		
		BoardInfo instance = new BoardInfo();				
		Object expResult = "TestBoardOption";
		Object result = instance.getopenBoardOption();
		assertEquals(expResult, result);		
		assertEquals("TestBoardOption", instance);
		
	}

	@Test
	public void test_method_setrestoreBoardName_13_branch_0()
	{
		BoardInfo instance = new BoardInfo();		
		instance.setrestoreBoardName("TestBoard");
		assertEquals("TestBoard", instance);
		
	}


	@Test
	public void test_method_getrestoreBoardName_14_branch_0()
	{
		BoardInfo instance = new BoardInfo();		
		Object expResult = "TestBoard";
		Object result = instance.getrestoreBoardName();
		
		//Check Return value
		assertEquals(expResult, result);
		
		//Check Test Verification Points
		assertEquals("TestBoard", instance);
		
	}

}
