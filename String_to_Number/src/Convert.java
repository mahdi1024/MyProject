
public class Convert {
	static String[] lets = 
		{"yek","do","se","chahar","panj","shesh","haft","hasht","noh","dah",
		"yazdah","davazdah","sizdah","chahardah","panzdah","shanzdah","hefdah","hejdah","nozdah"
		,"bist","si","chehel","panjah","shast","haftad","hashtad","navad","sad"};
	static long[] nums = 
		{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90,100};
	private String[] let;
	private long num;
//	private int[] x = new int[3];
	private String str;
	
	public String getStr(){
		return str;
	}
	
	public long getNum(){
		return num;
	}
	
//	public int[] getx(){
//		return x;
//	}
	
	public Convert(long num){
		this.num = num;
		long[] r = new long[3];
		r[0] = (this.num/100)*100;
		r[1] = (this.num%100)/10*10;
		r[2] = this.num%10;
		int j = 0;
		for (int i = 0; i < r.length; i++){
			if (r[i] != 0){
				j++;
			}
		}	
		long[] s = new long[j];
		for (int z = 0; z < r.length; z++) {
			if (z < s.length && r[z] == 0){
				s[z] = r[z+1];
				r[z+1] = 0;
			}else if(z < s.length){
				s[z] = r[z];
			}
		}
//		for(int y=0 ; y < s.length ; y++)
//			x[y] = (int)s[y] ;
		for (int y = 0; y < nums.length; y++) {
			if( num == nums[y]){
				let = new String[1];
				let[0] = lets[y];
				return;
			}
		}
		if (j == 2){
			let = new String[2];
			for (int t = 0; t < nums.length; t++) {	
				if ( nums[t] == s[0]){
					let[0] = lets[t];
					for (int k = 0; k < nums.length; k++) {
						if( nums[k] == s[1]){
							let[1] = lets[k];
						}
					}
				}	
			}	
		}
		if (j == 3){
			if (s[0] == 100){
				long a = this.num % 100;
//				x[0] = (int) a;
				for (int i = 0; i < nums.length; i++) {	
					if ( nums[i] == a){
						let = new String[2];
						let[0] = lets[27];
						let[1] = lets[i];
						return;
					}else {
						let = new String[3];
						let[0] = lets[27];
						for (int t = 0; t < nums.length; t++) {	
							if ( nums[t] == s[1]){
								let[1] = lets[t];
								for (int k = 0; k < nums.length; k++) {
									if( nums[k] == s[2]){
										let[2] = lets[k];
									}
								}
							}	
						}
					}
				}	
			}
		}		
//		return let;
	}
	
	public Convert(String str){
		this.str = str;
		String[] a = str.split(" o ");
		let = new String[a.length];
		for (int i = 0; i < a.length; i++) {
			let[i]= a[i];
		}
		for (int i = 0; i < let.length; i++) {
			for (int j = 0; j < lets.length; j++) {
				if(lets[j].equals(let[i]) ){
					num += nums[j];
				}
			}
		}
	}
	
	public void convertPlus(){
		str = let[0];
		if (let.length > 0){
			for (int i = 0 ; i<let.length-1 ; i++)
				str = str + " o " + let[i+1];
		}	
	}
	
//	public long convert(String[] a){
//		strnum = a;
//		int realnum = 0;
//		for (int i = 0 ; i<strnum.length ; i++){
//			switch (i){
//				case 2:
//					for (int j=0 ; j<9 ; j++)
//						if (let[j] == strnum[i])
//							realnum = realnum + j;
//				case 1:
//					for (int j=0 ; j<9 ; j++){
//						if (let[j] == strnum[i])
//							realnum = realnum + j;
//					}
//					
//			}
//		}
//		return realnum;
//	}
	
//	public String[] convert(int num){
//		realnum = num;
//		long[] r = new long[3];
//		r[0] = num % 10;
//		r[1] = (num / 10) % 10;
//		r[2] = num / 100 ;
//		for(int y=0 ; y < 3 ; y++)
//			x[y] = (int)r[y] ;
//		if (num >0 && num <= 20){
//			strnum = new String[1];
//			int a = (int)(num - 1);
//			strnum [0] = let[a];
//		}else if(num >100 && num <= 120){
//			strnum = new String[2];
//			int a = (int)(num - 101);
//			strnum [1] = let[a];
//			strnum [0] = let [27];
//		}else if (num >20 && num<100){
//			if ((num%10)!=0 ){
//				strnum = new String[2];
//				for (int j=1 ; j>=0 ; j--){
//					switch (j){
//					case 1 :
//						strnum [0] = let [x[1]+17];
//					case 0 :
//						strnum [1] = let [x[0]-1];
//					}	
//				}
//			}else {
//				strnum = new String[1];
//				strnum [0] = let [x[1]+17];
//			}
//		}else if (num == 100){
//			strnum = new String[1];
//			strnum [0] = let [27];
//		}else if (num > 120 && num < 151){
//			if ((num%10)!=0 ){
//				strnum = new String[3];
//				for (int j=2 ; j>=0 ; j--){
//					switch (j){
//					case 2 :
//						strnum [0] = let [27];
//					case 1 :
//						strnum [1] = let [x[1]+17];
//					case 0 :
//						strnum [2] = let [x[0]-1];
//					}	
//				}
//			}else {
//				strnum = new String[2];
//				for (int j=1 ; j>=0 ; j--){
//					switch (j){
//					case 0 :
//						strnum [1] = let [x[1]+17];
//					case 1 :
//						strnum [0] = let [27];
//					}	
//				}
//			}
//		}else{
//			strnum = new String[1];
//			strnum[0] = "number out of range.";
//		}
//		str = strnum [0];
//		if (strnum.length > 0)
//			for (int i = 0 ; i<strnum.length-1 ; i++)
//				str = str + " o " + strnum[i+1];
//		return strnum;
//	}
}
