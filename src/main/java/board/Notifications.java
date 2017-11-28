package board;

import java.util.Scanner;

import sqlstatements.NotificationSqlQueries;

public class Notifications {
	private NotificationSqlQueries notify = new NotificationSqlQueries();
	private WelcomeBoard wb = new WelcomeBoard();
	private Scanner inputReader = new Scanner(System.in);

	public void recentNotificaions() {
		notify.notification();
		System.out.println("Do you wish to see all Notifications");

		String option = inputReader.nextLine();
		if ("yes".equals(option)) {
			notify.viewAllNotifications();
		} else {
			wb.welcome();
		}
	}
}
