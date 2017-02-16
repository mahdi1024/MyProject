
public class Ladder {
	private int sL;
	private int eL;
	private Input input = new Input();
	
	public void setLadder(){
		input.setLadder();
		int[] a = input.getLadder(); 
		sL = a[0];
		eL = a[1];
//		System.out.println(sL +" "+ eL);
		}
	
	public int getStartLadder(){
		return sL;
	}
	
	public int getEndLadder(){
		return eL;
	}
}
