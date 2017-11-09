import java.lang.reflect.*;
public class ReflectTest05 {
	public static void main(String[] args) throws Exception{
		//获取类
		Class c=Class.forName("User");
		//获取id属性
		Field idF=c.getDeclaredField("id");
		//获取到某个特定属性可用用来 set,get
		Object o=c.newInstance();
		//打破封装
		idF.setAccessible(true);//使用反射机制可以打破封装性
		//给o对象的id属性复制“110”
		idF.set(o,"110");
		//get
		System.out.println(idF.get(o));
	}
}