package board;

import java.util.Scanner;
import sqlStatements.NotificationSqlQueries;

public class Notifications {
	NotificationSqlQueries notify = new NotificationSqlQueries();
	public void recentNotificaions() {
		notify.notification();
		System.out.println("Do you wish to see all Notifications");
		Scanner inputReader = new Scanner (System.in);
		String option = inputReader.nextLine();
		if(option.equals("yes")) {
			notify.viewAllNotifications();
		}
	}
}
