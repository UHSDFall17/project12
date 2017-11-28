package board;

import global.Global;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sqlstatements.TeamSqlQueries;
import trello.App;

public class WelcomeBoard {
	private Scanner inputReader = new Scanner(System.in);
	private Team teamObj = new Team();
	private TeamDetails teamDetailsObj = new TeamDetails();
	private TeamSqlQueries teamSqlObj = new TeamSqlQueries();

	public void welcome() {
		int value;
		do {
			if (( !"".equals(Global.userType))
					&& "1".equals(Global.userType)) {
				System.out
						.println("Select the options below \n 1.Board \n 2.Team \n 3. Notification \n 4. Restore Deleted Items \n 5. Logout");
			} else {
				System.out
						.println("Select the options below \n 1.Board \n 2.Team \n 3. Notification \n 4. Logout");
			}
			value = inputReader.nextInt();
			inputReader.nextLine();
			switch (value) {
			case 1:
				Board b = new Board();
				b.option();
				break;
			case 2:
				Team t = new Team();
				t.team();
				break;
			case 3:
				Notifications nuser = new Notifications();
				nuser.recentNotificaions();
				break;
			case 4:
				restoreOptions();
				break;
			case 5:				
				App.options();
				break;
			default:
				System.out.println("invalid option");
				break;
			}
		} while (value != 4);

	}

	public void restoreOptions() {
		if ((!"".equals(Global.userType))
				&& "1".equals(Global.userType)) {
			System.out.println("Enter 1.Restore Team 2.Restore Board");
			int option = inputReader.nextInt();
			inputReader.nextLine();
			switch (option) {
			case 1:
				restoreTeam();
				break;
			case 2:
				Board b = new Board();
				b.restoreBoard();
				break;
			default:
				System.out.println("Enter valid option");
				break;
			}

		} else {
			App.options();
		}		
	}
	public void restoreTeam()
	{
		List<String> teamList = new ArrayList<String>();
		teamList = teamSqlObj.listTeams(2);		
		
		if(teamList.isEmpty())
		{
			System.out.println("No teams found");
		}
		else
		{
			teamDetailsObj.printTeamList(2);
			teamObj.restoreTeam();
		}
		
	}
}
