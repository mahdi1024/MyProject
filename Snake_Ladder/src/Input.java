
import java.util.Scanner;

public class Input {
	Scanner scan = new Scanner(System.in);
	private String str;
	private int[] ladder = new int[2];
	static int nL;
	private int[] snake = new int[2];
	static int nS;

	public void setNumberLadder() {
		System.out.println("Please inter number of ladders: ");
		nL = scan.nextInt();
		System.out.println("Please inter peculiarities ladders:\nexample 20 56");
		}
	
	public int getNumberLadder(){
		return nL;
	}
	
	public void setLadder(){
		for (int i = 0; i < ladder.length; i++) {
			ladder[i] = scan.nextInt();
		}
		while(ladder[0] >= ladder[1] || ladder[0] < 1 || ladder[1] < 1){
			System.out.println("Please inter peculiarities ladders with this example 20 56");
			this.setLadder();
		}
	}
	
	public int[] getLadder(){
		return ladder;
	}
	
	public void setNumberSnake() {
		System.out.println("Please inter number of snake: ");
		nS = scan.nextInt();
		System.out.println("Please inter peculiarities snake:\nexample 45 20");
		}
	
	public int getNumberSnake(){
		return nS;
	}
	
	public void setSnake(){
		for (int i = 0; i < snake.length; i++) {
			snake[i] = scan.nextInt();
		}
		while(snake[0] <= snake[1] || snake[0] < 1 || snake[1] < 1){
			System.out.println("Please inter peculiarities snakes with this example 70 56");
			this.setSnake();
		}
	}
	
	public int[] getSnake(){
		return snake;
	}
	public void setPlay() {
		str = scan.next();
		while (!str.equals("r1") && !str.equals("r2") && !str.equals("print")){
			System.out.println("Please inter r1 or r2 or print");
			str = scan.next();
		}
	}
	
	public String getPlay(){
		return str;
	}
	
}
