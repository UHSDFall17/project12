package board;

import java.util.HashMap;
import java.util.List;
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
    
    public TeamDetails()
    {
    	teamname = "";
    	teamdesc = "";
    
    }
    public void setTeamName(String teamname) {
        this.teamname = teamname;
     }

     public String getTeamName() {
        return teamname;
     }
     
      public void setTeamDesc(String teamdesc) {
          this.teamdesc = teamdesc;
       }
      
       public String getTeamDesc() {
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
       public List<String> getTeamList() {
           return teamList;
        }
       public void setMemberName(String memberName) {
           this.memberName = memberName;
        }

        public String getMemberName() {
           return memberName;
        }
        public void setOption(int option) {
            this.option = option;
         }

         public int getOption() {
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
}
