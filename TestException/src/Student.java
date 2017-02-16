
public class Student {
	private String name;
	private InputManger input = new InputManger();
	
	public void setNameStudent(int i){
		input.setName(i);
		this.name = input.getNames();
	}
	
	public String getNameStudent(){
		return name;
	}
}
