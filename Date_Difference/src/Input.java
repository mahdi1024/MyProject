
import java.util.Scanner;

public class Input {
	Scanner scan = new Scanner(System.in);
	private int[] fd = new int[3];
	private int[] sd = new int[3];
	
	public void setFristDate(){
		System.out.println("Please enter first date:\nexample 95 11 22");
		for (int i = 0; i < fd.length; i++) {
			fd[i] = scan.nextInt();
		}
		while(fd[1] > 12 || fd[1] < 1){
			System.out.print("Please enter Month betwin 1-12\nagain ");
			this.setFristDate();
		}
		for (int i = 0; i < 13; i++) {
			if (fd[1] <= 6){
				while(fd[2] > 31 || fd[2] < 1){
					System.out.print("Please enter Day betwin 1-31\nagain ");
					this.setFristDate();
				}
			}
			if (fd[1] <= 12 && fd[1] > 6){
				while(fd[2] > 30 || fd[2] < 1){
					System.out.print("Please enter Day betwin 1-30\nagain ");
					this.setFristDate();
				}
			}
		}
	}
	
	public int[] getFristDate(){
		return fd;
	}
	
	public void setSecendDate(){
		System.out.println("Please enter secend date:\nexample 57 11 22");
		for (int i = 0; i < sd.length; i++) {
			sd[i] = scan.nextInt();
		}
		while(sd[1] > 12 || sd[1] < 1){
			System.out.print("Please enter Month betwin 1-12\nagain ");
			this.setSecendDate();
		}
		for (int i = 0; i < 13; i++) {
			if (sd[1] <= 6){
				while(sd[2] > 31 || sd[2] < 1){
					System.out.print("Please enter Day betwin 1-31\nagain ");
					this.setSecendDate();
				}
			}
			if (sd[1] <= 12 && sd[1] > 6){
				while(sd[2] > 30 || sd[2] < 1){
					System.out.print("Please enter Day betwin 1-30\nagain ");
					this.setSecendDate();
				}
			}
		}
	}
	
	public int[] getSecendDate(){
		return sd;
	}
	
}
