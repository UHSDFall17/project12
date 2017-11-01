package board;

import java.util.Scanner;

import trello.App;

public class WelcomeBoard {
	int value;
	public void welcome()
	{
		
    	do {
    		System.out.println("Select the options below \n 1.Create Board \n 2.Create Team \n 3.Create Business Board \n 4. Logout");
    		Scanner inputReader = new Scanner(System.in);
        	value = inputReader.nextInt();
    	switch(value)
    	{
    	case 1: Board b = new Board();
		b.board();
		break;
    	case 2: Team t = new Team();
		t.team();
		break;
    	case 3:Board c = new Board();
		c.board();
		break;
    	case 4: 
    		App a = new App();
    		a.options();
		break;
    	default: System.out.println("invalid option");
    	break;
    	}
    	}	while(value != 4);
    
	}
	}
	
