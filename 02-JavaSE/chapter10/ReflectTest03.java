/*
	获取Class 类型的对象之后，可以才创建该"类"的对象
*/
import java.util.*;
import java.text.*;
public class ReflectTest03{
	public static void main(String[] args) throws Exception{
		Class c=Class.forName("Employee");
		//创建此class对象所表示的类的一个新实例
		Object o=c.newInstance();//调用Employee
		System.out.println(o);
		
		
		Class c1=Class.forName("java.util.Date");
		Object o1=c1.newInstance();
		if(o1 instanceof Date){
			Date t=(Date)o1;
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(t));
		}
	}
}