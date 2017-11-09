/*
	ÉîÈëfinally¿é
*/
public class ExceptionTest09{
	
	public static void main(String[] args){
		int i=m1();
		System.out.println(i);
	}
	public static int m1(){
		int i=10;
		try{
			return i;
		}finally{
			i++;
			System.out.println("m1µÄi="+i);
		}
	}
}