
public class Main {
	public static void main(String[] args){
		League iran = new League();
		iran.setNumberofTeams();;
		iran.setLeageTeam();
		iran.setNumberofMatch();
		iran.setLeagueMatch();
		
		int a = iran.getNumberofTeams();
		Team[] all = new Team[a];
		all = iran.leagueTable();
		System.out.println("Rank\tTeam\tMatch\tGD\tScore");
		
		for (int i=0 ; i<a ; i++){
			System.out.print(i+1 + "\t" + all[i].getName()+ "\t" + all[i].getMatch() + "\t" + all[i].getGd()+ "\t" + all[i].getScore());
			System.out.println();
		}
	}
}
