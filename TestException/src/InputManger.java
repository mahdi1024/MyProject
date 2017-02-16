import java.util.Scanner;

public class InputManger {

	private int a;
	private String str;
	private Scanner scan = new Scanner(System.in);

	public void setNumber() {
		System.out.println("Please enter number of word:");
		while (a < 1) {
			try {
				a = Integer.parseInt(scan.nextLine());
				if (a < 1) {
					System.out.println("Number is incorrect!!!");
					System.out.println("Please enter positive number!");
				}
			} catch (Exception e) {
				System.out.println("Number is incorrect!!!");
				System.out.println("Please enter a number!");
			}
		}
	}

	public void setName(int i) {
		System.out.println("Please enter name " + (i) + ":");
		try {
			str = scan.nextLine();
			if (str.isEmpty()) {
				System.out.println("You should enter name!!!");
				this.setName(i);
			}
			for (int j = 0; j < str.length(); j++) {
				boolean b = Character.isLetter(str.charAt(j));
				if (b) {

				} else if (str.substring(j, j + 1).equals(" ") && j > 0) {
					if (str.substring(j + 1, j + 2).equals(" ")) {
						System.out.println("Name is incorrect!!!");
						this.setName(i);
						// break;
					}

				} else {
					System.out.println("Name is incorrect!!!");
					this.setName(i);
					// break;
				}
			}
		} catch (Exception e1) {
			System.out.println("Name is incorrect!!!");
		}

	}

	public String getNames() {
		return str;
	}

	public int getNumberStudent() {
		return a;
	}
}
