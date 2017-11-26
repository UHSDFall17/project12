package board;

import global.Global;

import java.util.Scanner;

import trello.App;

public class WelcomeBoard {
	int value;
	Scanner inputReader = new Scanner(System.in);
	Board b = new Board();

	public void welcome() {

		do {
			if((!Global.userType.equals(null)|| !Global.userType.equals("")) && Global.userType.equals("1"))
			{
				System.out.println("Select the options below \n 1.Create Board \n 2.Team \n 3.Create Business Board \n 4. Display Boards \n 5. Notification \n 6. Restore Deleted Boards \n 7. Logout");
			}
			else
			{
			System.out.println("Select the options below \n 1.Board \n 2.Team \n 3. Notification \n 4. Logout");
			}
			value = inputReader.nextInt();
			inputReader.nextLine();
			switch (value) {
			case 1:
				b.option();
				break;
			case 2:
				Team t = new Team();
				t.team();
				break;
			case 3:
				Notifications nuser = new Notifications();
				nuser.recentNotificaions();
			case 4:
				if((!Global.userType.equals(null)|| !Global.userType.equals("")) && Global.userType.equals("1"))
				{}
				else
				{
				App a = new App();
				a.options();
				}
				break;
			default:
				System.out.println("invalid option");
				break;
			}
		} while (value != 4);

	}


	
}
