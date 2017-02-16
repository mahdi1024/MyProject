
public class Main {
	public static void main(String[] args){
		NumberString a = new NumberString(7);
		NumberString b = new NumberString("yek");
		NumberString add = a.add(b);
//		System.out.println(a.toInteger());
		NumberString c = new NumberString(a);
//		b.mult(a);
		a.setNumber(12);
		c.sub(a);
		a.setNumber(111);
		a.mult(b);
		System.out.println(add.toNumberString());
		System.out.println(b.toInteger());
		System.out.println(b.toNumberString());
		System.out.println(c.toInteger());
		System.out.println(a.toNumberString());
	}
}
