package board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import sqlStatements.TeamSqlQueries;

public class TeamDetails {
	private String teamname;
    private String teamdesc;
    private List<String> members;
    private HashMap<String, String> teamDetails;
    private List<String> teamList;
    private String memberName;
    private String allMemberNames;
    private int option;
    TeamSqlQueries sqlObj=new TeamSqlQueries();
    Scanner inputReader= new Scanner (System.in);
    
    public TeamDetails()
    {
    	teamname = "";
    	teamdesc = "";
    	members=new ArrayList<String>() ;
    	teamDetails=new HashMap<String, String>();
    	teamList=new ArrayList<String>();
    	memberName="";
    	allMemberNames="";
    	option=0;
    }
    public void setTeamName(String teamname) {
        this.teamname = teamname;
     }

     public String getTeamName() {
    	 System.out.println("Enter Team Name:");
		teamname  = inputReader.nextLine();	
        return teamname;
     }
     
      public void setTeamDesc(String teamdesc) {
          this.teamdesc = teamdesc;
       }
      
       public String getTeamDesc() {
    	   System.out.println("Please enter Team Description(optional):");
 	      teamdesc  = inputReader.nextLine();
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
       public void setTeamList(List<String> teamList) {
           this.teamList = teamList;
        }
       public void getTeamList() {
    	   teamList = sqlObj.listTeams();          
        }
       public void printTeamList()
       {
    	   getTeamList();
     	  for(int i=0;i<teamList.size();i++)
   		{
   			  System.out.println(i+1 +". " + teamList.get(i));
   		}
       }
       public void setMemberName(String memberName) {
           this.memberName = memberName;
        }

        public void getMemberName() {
        System.out.println("Enter Member Name:");
			memberName  = inputReader.nextLine();
          
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
          public void createTeam()
          {
          sqlObj.createTeam(teamname, teamdesc, option);
          }
          
          public void addMembers()
          { 
        	  getMemberName();
        	  members.add(memberName);
          }
          public void printTeamMembers()
          {
        	  for(int i=0;i<members.size();i++)
			{
			  System.out.println(i+1 +". " + members.get(i));
		}
          }
}
