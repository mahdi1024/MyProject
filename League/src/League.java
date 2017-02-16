
public class League {
	private int teams;
	private int matchs;
	private Team[] table;
	private Team[] sort;
	private Match[] match;
	Input input = new Input();
//	match = new Match();
	
	public void setLeageTeam(){
		table = new Team[teams];
		for (int i=0 ; i<teams ; i++){
			table[i] = new Team();
			table[i].setName();
		}	
	}
	
	public void setNumberofTeams(){
		input.setNumberTeam();
		teams = input.getNumberTeam();
	}
	
	public int getNumberofTeams(){
		return teams;
	}
	
	public void setNumberofMatch(){
		input.setNumberMatch();
		matchs = input.getNumberMatch();
	}
	
	public int getNumberofMatch(){
		return matchs;
	}
	public void setLeagueMatch(){
		match = new Match[matchs];
		for (int i=0 ; i<match.length ; i++){
			match[i] = new Match();
			match[i].setResult();
			match[i].matchResult();
			for (int j=0 ; j<teams ; j++){
				if (table[j].getName().equals(match[i].getTeam1())){
					table[j].setGf(match[i].getG_team1());
					table[j].setGa(match[i].getG_team2());
					table[j].setScore(match[i].getS_team1());
					table[j].setGd();
					table[j].setMatch();
				}else if (table[j].getName().equals(match[i].getTeam2())){
					table[j].setGf(match[i].getG_team2());
					table[j].setGa(match[i].getG_team1());
					table[j].setScore(match[i].getS_team2());
					table[j].setGd();
					table[j].setMatch();
				}
			}
		}	
	}
	
	public Team[] getLeague(){
		return table;
	}
	
	public Match[] getMatchs(){
		return match;
	}
	
	public Team[] leagueTable(){
		sort = table;
		for (int i = (teams-1); i >= 0; i--){
		      for (int j = 1; j <= i; j++){
		         if (sort[j-1].getScore() < sort[j].getScore()){
		             Team temp = sort[j-1];
		             sort[j-1] = sort[j];
		             sort[j] = temp;
		         }
		      }
		}
		for (int i = (teams-1); i >= 0; i--){
		      for (int j = 1; j <= i; j++){
		    	  if(sort[j-1].getScore() == sort[j].getScore()){
		    		  if(sort[j-1].getGf() < sort[j].getGf()){
		    			  Team temp = sort[j-1];
		    			  sort[j-1] = sort[j];
		    			  sort[j] = temp;
		    		  }
		    	  }
		      }
		}
		return sort;
	}
	
}
