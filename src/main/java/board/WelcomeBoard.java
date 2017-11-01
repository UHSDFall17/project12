package board;

import java.util.Scanner;

public class WelcomeBoard {
	public void welcome()
	{
		System.out.println("Welcome to Trello... Select the options below \n 1.Create Board \n 2.Create Team \n 3.Create Business Board");
		
		Scanner inputReader = new Scanner(System.in);
    	int value = inputReader.nextInt();
    	switch(value)
    	{
    	case 1: Board b = new Board();
		b.board();
    	case 2: Team t = new Team();
		t.team();
    	case 3:Board c = new Board();
		c.board();
		default: System.out.println("invalid option");
    	}
    	inputReader.close();
	}
	
}
