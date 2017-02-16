
public class Team {
	private String name;
	private int score;
	private int gf;
	private int ga;
	private int gd;
	private int match;
	Input input = new Input(); 
	
	public String getName() {
		return name;
	}
	
	public void setName() {
		input.setTeamName();
		this.name = input.getTeamName();
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int s) {
		score = score + s;
	}
	
	public int getGf() {
		return gf;
	}
	
	public void setGf(int gout) {
		gf = gf + gout;
	}
	
	public int getGa() {
		return ga;
	}
	
	public void setGa(int gin) {
		ga = ga + gin;
	}
	
	public int getGd() {
		return gd;
	}
	
	public void setGd() {
		gd = gf - ga;
	}
	
	public void setMatch(){
		match = match + 1 ;
	}
	
	public int getMatch(){
		return match;
	}
}
