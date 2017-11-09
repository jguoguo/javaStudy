/*
关于类获取父类和父接口
*/
import java.lang.String;
public class ReflectTest10{
	public static void main(String[] args) throws Exception{
		Class c=Class.forName("java.lang.String");
		//获取父类
		Class superClass=c.getSuperclass();
		System.out.println(superClass.getName());
		//获取父接口
		Class[] ins=c.getInterfaces();
		for(Class in:ins){
			System.out.println(in.getName());	
		}
	}
}