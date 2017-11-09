/*
	获取class对象的三种方式
*/
import java.util.*;
public class ReflectTest01{
	public static void main(String[] args) throws Exception{
		//第一种方式
		Class c1=Class.forName("Employee");//c1引用保存内存地址指向堆中的对象，该对象代表的是Employee整个类
		
		//第二种方式
		//java中每个类型都有class属性
		Class c2=Employee.class;
		
		//第三种方式
		//java语言中任何一个java对象都有getClass方法
		Employee e=new Employee();
		Class c3=e.getClass();//c3是运行时类
		
		//因为Employee这个类在JVM中只有一个，所有c1,c2,c3的内存地址是相同的
		System.out.println(c1==c2);
		System.out.println(c2==c3);
		
		Class c4=Date.class();//c4代表Date这个类
		Class c5=Class.forName("java.util.Date");//必须写类全名
		Date d=new Date();
		Class c6=d.getClass();
	}
}