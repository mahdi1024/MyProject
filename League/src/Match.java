
public class Match {
	private String[] input_result;
	private String team1;
	private String team2;
	private int g_team1;
	private int g_team2;
	private int s_team1;
	private int s_team2;
	
//	private int n_matchs;
	Input input = new Input();
	
//	public void setNumberofMatch(){
//		input.setNumberMatch();
//		n_matchs = input.getNumberMatch();
//	}
	
	public void setResult(){
		input.setMatch();
		input_result = input.getMatch();
	}
	
	public String[] getResult(){
		return input_result;
	}
	
	public void matchResult(){
		String[] a = input_result;
		for(int i=0 ; i<4 ; i++){
			if (i == 0){
				team1 = a[0];
			}else if(i == 1){
				team2 = a[1];
			}else if(i == 2){
				g_team1 = Integer.parseInt(a[2]);
			}else if(i == 3){
				g_team2 = Integer.parseInt(a[3]);
			}
		}
		if (g_team1 > g_team2){
			s_team1 = 3;
			s_team2 = 0;
		}else if (g_team1 == g_team2){
			s_team1 = 1;
			s_team2 = 1;
		}else{
			s_team1 = 0;
			s_team2 = 3;
		}
	}

	public String getTeam1() {
		return team1;
	}

	public String getTeam2() {
		return team2;
	}

	public int getG_team1() {
		return g_team1;
	}

	public int getG_team2() {
		return g_team2;
	}

	public int getS_team1() {
		return s_team1;
	}

	public int getS_team2() {
		return s_team2;
	}
	
}
