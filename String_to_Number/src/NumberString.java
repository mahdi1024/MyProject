
public class NumberString {
	
//	static String[] pernum = {"yek","do","se","chahar","panj","shesh","haft","hasht","noh",
//								"dah","yazdah","davazdah","sizdah","chahardah","panzdah","shanzdah","hefdah","hejdah","nozdah"
//								,"bist","si","chehel","panjah","shast","haftad","hashtad","navad","sad"};
//	private String[] strnum;
	private long realnum;
//	NumberString s;
	private String str;
	
	
	
	public NumberString(long num){
		realnum = num;
		Convert a = new Convert(realnum);
		a.convertPlus();
		str = a.getStr();
	}
	
	public NumberString(String str){
		Convert b = new Convert (str);
		realnum = b.getNum(); 
	}
	
	public NumberString(NumberString ns){
		realnum = ns.realnum;
	}
	
	void setNumber(long num){
		realnum = num ;
	}
	
	public NumberString add(NumberString ns){
		long a = realnum + ns.realnum;
		NumberString s = new NumberString(a);		
		return s;
	}
	
	public NumberString sub(NumberString ns){
		long a = realnum - ns.realnum;
		NumberString s = new NumberString(a);
		return s;
	}
	
	public NumberString mult(NumberString ns){
		long a = realnum * ns.realnum;
		NumberString s = new NumberString(a);
		return s;
	}
	
	long toInteger (){		
		return realnum;
	}
	
	String toNumberString(){
		Convert a = new Convert(realnum);
		a.convertPlus();
		str = a.getStr();
		return str ;
	}
}
