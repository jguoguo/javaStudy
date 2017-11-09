/*
	字符串常用的方法
*/
public class StringTest06{
	public static void main(String[] args){
		//1.char charAt(int index)
		String s1="我是王勇，是坏人";
		char c1=s1.charAt(2);
		System.out.println(c1);//王
		
		//2.boolean endsWith(String endstr)
		System.out.println("HelloWorld.java".endsWith("java"));
		
		//3.boolean equalsIgnoreCase(String anotherString)
		System.out.println("abc".equalsIgnoreCase("ABC"));		
	}
}