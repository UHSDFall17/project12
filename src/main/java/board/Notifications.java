package board;

import java.util.Scanner;
import sqlStatements.NotificationSqlQueries;

public class Notifications {
	NotificationSqlQueries notify = new NotificationSqlQueries();
	WelcomeBoard wb = new WelcomeBoard();
	Scanner inputReader = new Scanner (System.in);
	public void recentNotificaions() {
		notify.notification();
		System.out.println("Do you wish to see all Notifications");
		
		String option = inputReader.nextLine();
		if(option.equals("yes")) {
			notify.viewAllNotifications();
		}
		else {
			wb.welcome();
		}
	}
}
