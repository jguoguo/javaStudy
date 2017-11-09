/*
	以java.lang.Integer;类型为例
*/
public class IntegerTest02{
	public static void main(String[] args){
		//获取int类型的最大值和最小值
		System.out.println("int最小值："+Integer.MIN_VALUE);
		System.out.println("int最大值："+Integer.MAX_VALUE);
		
		//创建Integer类型的对象
		Integer i1=new Integer(10);
		Integer i2=new Integer("123");
		System.out.println(i1);	
		System.out.println(i2);
	}
}