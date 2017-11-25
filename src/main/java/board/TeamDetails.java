package board;

import java.util.List;

public class TeamDetails {
	private String teamname;
    private String teamdesc;
    private List<String> members;;
    
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
}