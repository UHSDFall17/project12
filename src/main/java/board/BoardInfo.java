package board;

import java.util.Scanner;

public class BoardInfo {
	private Scanner inputReader = new Scanner(System.in);
	private String boardtitle,teamname,starboard,starBoardName,openBoardName,openBoardOption,restoreBoardName;
	
	BoardInfo(){
		boardtitle="";
		teamname="";
		starboard ="";
		starBoardName="";
		openBoardName="";
		openBoardOption="";
		restoreBoardName="";
	}
	
	public void setBoardTitle(String boardtitle) {
		this.boardtitle = boardtitle;
	}

	public String getBoardTitle() {
		boardtitle= inputReader.nextLine();
		return boardtitle;
	}
	
	public void setTeamName(String teamname) {
		this.teamname = teamname;
	}
	public String getTeamName() {
		teamname= inputReader.nextLine();
		return teamname;
	}
	public void setStarBoard(String teamname) {
		this.starboard = teamname;
	}
	public String getStarBoard() {
		starboard= inputReader.nextLine();
		return starboard;
	}
	public void setstarBoardName(String starBoardName) {
		this.starBoardName = teamname;
	}
	public String getstarBoardName() {
		starBoardName= inputReader.nextLine();
		return starBoardName;
	}
	public void setopenBoardName(String openBoardName) {
		this.openBoardName = openBoardName;
	}
	public String getopenBoardName() {
		openBoardName = inputReader.nextLine();
		return openBoardName;
	}
	public void setopenBoardOption(String openBoardOption) {
		this.openBoardOption = openBoardOption;
	}
	public String getopenBoardOption() {
		openBoardOption = inputReader.nextLine();
		return openBoardOption;
	}
	
	public void setrestoreBoardName(String restoreBoardName) {
		this.restoreBoardName = restoreBoardName;
	}
	public String getrestoreBoardName() {
		restoreBoardName = inputReader.nextLine();
		return restoreBoardName;
	}
	
}

