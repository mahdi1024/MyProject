
public class Cell {
	private String str;
	private int n;
	
	public void setTypeCell(String str){
		this.str = str;
//		System.out.print(str);
	}
	
	public String getTypeCell(){
		return str;
	}
	
	public void setNumberCell(int a){
		n = a;
//		System.out.print(" " + n);
	}
	
	public int getNumberCell(){
		return n;
	}
}
