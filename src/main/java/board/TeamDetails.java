package board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import sqlstatements.TeamSqlQueries;

public class TeamDetails {
	private String teamname;
	private String teamdesc;
	private List<String> members;
	private HashMap<String, String> teamDetails;
	private List<String> teamList;
	private String memberName;
	private String allMemberNames;
	private int option;
	private TeamSqlQueries sqlObj = new TeamSqlQueries();
	private Scanner inputReader = new Scanner(System.in);

	public TeamDetails() {
		teamname = "";
		teamdesc = "";
		members = new ArrayList<String>();
		teamDetails = new HashMap<String, String>();
		teamList = new ArrayList<String>();
		memberName = "";
		allMemberNames = "";
		option = 0;
	}

	public void setTeamName(String teamname) {
		this.teamname = teamname;
	}

	public String getTeamName() {
		System.out.println("Enter Team Name:");
		teamname = inputReader.nextLine().trim();
		return teamname;
	}

	public void setTeamDesc(String teamdesc) {
		this.teamdesc = teamdesc;
	}

	public String getTeamDesc() {
		System.out.println("Please enter Team Description(optional):");
		teamdesc = inputReader.nextLine().trim();
		return teamdesc;
	}

	public void setMembers(List<String> members) {
		this.members = members;
	}

	public List<String> getMembers() {
		return members;
	}

	public void setTeamDetails(HashMap<String, String> teamDetails) {
		this.teamDetails = teamDetails;
	}

	public HashMap<String, String> getTeamDetails() {
		return teamDetails;
	}

	public void putTeamDetails(String editLabels, String editedValues) {
		teamDetails.put(editLabels, editedValues);
	}

	public void setTeamList(List<String> teamList) {
		this.teamList = teamList;
	}

	public  void getTeamList(int option) {
		teamList = sqlObj.listTeams(option);		
	}

	public void printTeamList(int option) {
		getTeamList(option);
		if(teamList.isEmpty())
		{
			System.out.println("No teams found");
		}
		for (int i = 0; i < teamList.size(); i++) {
			System.out.println(i + 1 + ". " + teamList.get(i));
		}
		
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public void getMemberName() {
		System.out.println("Enter Member Name:");
		memberName = inputReader.nextLine().trim();
	}

	public void setOption(int option) {
		this.option = option;
	}

	public int getOption() {
		option = inputReader.nextInt();
		inputReader.nextLine();
		return option;
	}

	public void setAllMemberNames(String allMemberNames) {
		this.allMemberNames = allMemberNames;
	}

	public String getAllMemberNames() {
		return allMemberNames;
	}

	public void createTeam() {
		sqlObj.createTeam(teamname, teamdesc, option);
	}

	public void addMembers() {
		getMemberName();
		members.add(memberName);
	}

	public void printTeamMembers() {
		for (int i = 0; i < members.size(); i++) {
			System.out.println(i + 1 + ". " + members.get(i));
		}
	}

	public void printTeamDetails() {
		try {
			teamDetails = sqlObj.teamInfo(teamname);
			if (teamDetails != null) {
				System.out.println("-----Team Information---");
				System.out
						.println("Team Name: " + teamDetails.get("team_name"));
				System.out.println("Team Description: "
						+ teamDetails.get("team_desc"));
				if(teamDetails.get("team_members")!=null){
					String lastChar = teamDetails.get("team_members").substring(
							teamDetails.get("team_members").length() - 1);
					String membernames;
					if (",".equals(lastChar.trim())) {
						membernames = teamDetails.get("team_members").substring(0,
								teamDetails.get("team_members").length() - 1);
					} else {
						membernames = teamDetails.get("team_members");
					}
					System.out.println("Team Members: " + membernames);
				}
				else
				{
					System.out.println("Team Members: No Members" );
				}
				
				System.out.println("Admin: " + teamDetails.get("created_by"));
				if ( "".equals(teamDetails.get("access_mode"))
						|| "1".equals(teamDetails.get("access_mode"))) {
					teamDetails.put("access_mode", "Public");
				} else {
					teamDetails.put("access_mode", "Private");
				}
				System.out.println("Accessibilty: "
						+ teamDetails.get("access_mode"));
				System.out.println("Date Created: "
						+ teamDetails.get("created_date"));

				if (teamDetails.get("team_type").equals("1")) {
					teamDetails.put("team_type", "Normal Team");
				} else if (teamDetails.get("team_type").equals("2")) {
					teamDetails.put("team_type", "Business Team");
				}
				System.out
						.println("Team Type: " + teamDetails.get("team_type"));
				System.out.println("------------------------");
			} else {
				System.out.println("Error!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
