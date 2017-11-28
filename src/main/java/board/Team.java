package board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import board.TeamDetails;
import sqlstatements.TeamSqlQueries;

public class Team {

	public String teamname;
	public String teamdesc;
	public String memberName;
	public int option;
	private TeamSqlQueries sqlObj = new TeamSqlQueries();	
	private Scanner inputReader = new Scanner(System.in);	
	private TeamDetails teamObj = new TeamDetails();

	public void team() {
		try {
			System.out
					.println("Select the options below \n 1.Create New Team \n 2.View Team List \n 3.Add Members to Team \n 4.View Team Information \n 5. Edit Team Profile \n 6. Delete Team");
			option = teamObj.getOption();
			switch (option) {
			case 1:
				createTeam();
				break;
			case 2:
				teamObj.printTeamList(1);
				break;
			case 3:
				addMembersToTeam();
				break;
			case 4:
				viewTeamInfo();
				break;
			case 5:
				editTeamInfo();
				break;
			case 6:
				deleteTeam();
				break;
			default:System.out.println("Invlaid Option");
				break;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void createTeam() {
		try {
			System.out.println("Press/n 1.General Team /n  2.Business Team ");
			option = teamObj.getOption();
			if (option == 1)
				System.out.println("---Create Team---");
			else if (option == 2)
				System.out.println("---Create Business Team---");
			teamname = teamObj.getTeamName();
			teamdesc = teamObj.getTeamDesc();
			teamObj.setOption(option);
			teamObj.createTeam();
			System.out.println(teamname + " created Successfully");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void addMembersToTeam() {
		try {
		 List<String> members = new ArrayList<String>();
			teamname = teamObj.getTeamName();
			teamObj.addMembers();
			members = teamObj.getMembers();
			do {
				teamObj.printTeamMembers();
				System.out
						.println("Press 1.Add More Members 2.Confirm Members");
				option = inputReader.nextInt();
				inputReader.nextLine();
				if (option == 2) {
					boolean result = sqlObj.addMembersToTeam(members, teamname);
					if (!result)
						System.out
								.println("Username does not exixts in the database");
					else
						System.out.println("Members added to the team");
					break;
				}
				teamObj.addMembers();
			} while (option != 2);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void viewTeamInfo() {
		try {
			teamname = teamObj.getTeamName();
			teamObj.printTeamDetails();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deleteTeam() {
		try {
			List<String> teamList = new ArrayList<String>();
			teamList = sqlObj.listTeams(1);
			if (teamList.isEmpty()) {
				System.out.println("No teams found");
			} else {
				teamObj.printTeamList(1);
				teamname = teamObj.getTeamName();
				boolean result = sqlObj.deleteTeam(teamname);
				if (result) {
					System.out.println(teamname + " deleted Successfully");
				} else {
					System.out.println("Error in deleting");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void restoreTeam() {
		try {

			teamname = teamObj.getTeamName();
			boolean result = sqlObj.restoreTeam(teamname);
			if (result) {
				System.out.println(teamname + " restored Successfully");
			} else {
				System.out.println("Error in deleting");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void editTeamInfo() {
		try {
			HashMap<String, String> teamDetails = new HashMap<String, String>();
			viewTeamInfo();
			String editedValues = "";
			String printEditLabels = "";
			String editLabels = "";
			boolean result;
			while (option != 5) {
				System.out
						.println("Press the numbers associated with the labels to edit the values");
				System.out
						.println("1.Team Name 2.Team Description 3. Accessibility 4.Team Type 5.Back to Team option");

				option = teamObj.getOption();
				if (option == 5) {
					break;
				}
				switch (option) {
				case 1:
					printEditLabels = "Enter New Team Name";
					editLabels = "team_name_edited";
					break;
				case 2:
					printEditLabels = "Enter New Description Name";
					editLabels = "team_desc_edited";
					break;
				case 3:
					printEditLabels = "Change accessibility. Enter 1 for public 2 for private";
					editLabels = "access_mode_edited";
					break;
				case 4:
					printEditLabels = "Change Team Type. Enter 1 for Normal 2 for Business";
					editLabels = "team_type_edited";
					break;
				default:System.out.println("Invlaid Option");
					break;
				}
				System.out.println(printEditLabels);
				editedValues = inputReader.nextLine();
				teamObj.putTeamDetails(editLabels, editedValues);
				teamDetails = teamObj.getTeamDetails();
				result = sqlObj.editTeamInfo(option, teamDetails);
				if (result) {
					if (option == 1) {
						teamObj.setTeamName(teamDetails.get("team_name_edited"));
					} else {
						teamObj.setTeamName(teamDetails.get("team_name"));
					}
					teamObj.printTeamDetails();
					System.out.println("Updated successully");
				} else {
					System.out.println("Error in Updation");
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
