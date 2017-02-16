
public class Snake {
	private int sS;
	private int eS;
	Input input = new Input();
	
	public void setSnake(){
		input.setSnake();
		int[] a = input.getSnake(); 
		sS = a[0];
		eS = a[1];
//		System.out.println(sS + " " + eS);
		}
	
	public int getStartSnake(){
		return sS;
	}
	
	public int getEndSnake(){
		return eS;
	}
}
