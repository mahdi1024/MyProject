
import java.util.Scanner;

public class Input {
	Scanner scan = new Scanner(System.in);
	private String team_name;
	static int n_team ;
//	static int i ;
	static int n_match;
//	static int k;
	private String[] match = new String[4];

	public void setNumberTeam() {
		System.out.println("Please inter number of teams: ");
		n_team = scan.nextInt();
		System.out.println("Please inter teams: ");
//		i = n_team ;
		}
	
	public int getNumberTeam(){
		return n_team;
	}
	
	public void setTeamName(){
//		int j = n_team - i + 1;
//		System.out.println("Please inter name of team " + j + ":");
		team_name = scan.next();
//		i--;
	}
	
	public String getTeamName(){
		return team_name;
	}
	
	public void setNumberMatch() {
		System.out.println("Please inter number of match: ");
		n_match = scan.nextInt();
//		k = n_match ;
		System.out.println("match format example: sepahan piroozi 2 1");
		System.out.println("Please inter Matchs: ");
	}
	
	public int getNumberMatch(){
		return n_match;
	}
	
	public void setMatch(){
//		int l = n_match - k + 1;
//		System.out.println("Please inter match " + l + ":");
		for (int i=0 ; i<4 ; i++){
			match[i] = scan.next();
		}	
//		k--;
	}
	
	public String[] getMatch(){
		return match;
	}


}
