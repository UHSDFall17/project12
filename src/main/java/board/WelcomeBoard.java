package board;

import java.util.Scanner;

import trello.App;

public class WelcomeBoard {
	int value;
	Scanner inputReader = new Scanner(System.in);
	public void welcome()
	{
		
    	do {
    		System.out.println("Select the options below \n 1.Create Board \n 2.Team \n 3.Create Business Board \n 4. Display Boards \n 5. Logout");
    		
        	value = inputReader.nextInt();
        	inputReader.nextLine();
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
    	case 4: ViewBoard vb = new ViewBoard();
    	vb.displayBoards();
    	case 5: 
    		App a = new App();
    		a.options();
		break;
    	default: System.out.println("invalid option");
    	break;
    	}
    	}	while(value != 5);
    
	}
	}
	
