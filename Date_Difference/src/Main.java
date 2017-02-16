
public class Main {
	public static void main(String[] args) {
		int[] a = calculator();
		System.out.print("Difference between your dates is:\n" + a[0] + " years and " + a[1] + " month and " + a[2] + " dates.");
	}
	
	static int[] calculator(){
		Input input = new Input();
		input.setFristDate();
		int[] a = input.getFristDate();
		input.setSecendDate();
		int[] b = input.getSecendDate();
		int[] dif = new int[3];
		if (a[2] >= b[2]){
			dif[2] = a[2] - b[2];
		}else {
			if(a[1]<=7 && a[1] != 1){
				a[1] -= 1;
				a[2] += 31;
				dif[2] = a[2] - b[2];
			}else {
				a[1] -= 1;
				a[2] += 30;
				dif[2] = a[2] - b[2];
			}
		}
		if (a[1] >= b[1]){
			dif[1] = a[1] - b[1];
		}else {
			a[0] -= 1;
			a[1] += 12;
			dif[1] = a[1] - b[1];	
		}
		dif[0] = a[0] - b[0];
		if(a[0] < b[0]){
			System.out.println("You must enter newer date frist.");
			dif = calculator();
		}
		return dif;
	}
}
