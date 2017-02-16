
public class Player {
	private int p;
	private String name;
	
	public void setPlacePlayer(int p){
		System.out.println(p);
		this.p = this.p + p;
		if (this.p > 100){
			this.p = this.p - p;
		}
//		System.out.println(p);
	}
	
	public int getPlacePlayer(){
		return p;
	}
	
	public Player(String str){
		name = str;
	}
	
	public String getNamePlayer(){
		return name;
	}
	
	public void goFirst(){
		p = 0;
	}
	
	public void snakeBite(int p){
		this.p = p;
	}
	
	public void climbLadder(int p){
		this.p = p;
	}
}
