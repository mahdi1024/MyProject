public class Main {
	public static void main(String[] args) {
		InputManger input = new InputManger();
		input.setNumber();
		int n = input.getNumberStudent();
		Student[] st = new Student[n];
		for (int i = 0; i < st.length; i++) {
			st[i] = new Student();
			st[i].setNameStudent(i + 1);
		}
		System.out.println("Names that you have entered:");
		for (int i = 0; i < st.length; i++) {
			System.out.println(st[i].getNameStudent());
		}
	}
}
