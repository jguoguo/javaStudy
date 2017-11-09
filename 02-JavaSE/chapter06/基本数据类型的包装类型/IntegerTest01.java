/*
	java中八种基本数据类型对应的包装类型
		基本数据类型    包装类型
		byte						java.lang.Byte
		short						java.lang.Short
		int							java.lang.Integer
		long						java.lang.long;
		float						java.lang.Float
		double					java.lang.Double
		boolean					java.lang.Boolean
		char						java.lang.Character
	
*/
public class IntegerTest01{
	//需求：规定m1方法可以接收java中任何一种数据类型
	//m1方法如果想接收byte类型的数据，可以将byte类型先包装成java.lang.Byte,再传参数
	public staitc void m1(Object o){
		System.out.println(o);
	}
	public static void main(String[] args){
		//基本数据类型
		byte b=10;
		//引用类型
		Byte b1=new Byte(b);
		m1(b1);
	}
}