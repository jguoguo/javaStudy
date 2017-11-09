/*
	关于java 中的可变长参数
*/
import java.util.*;
public class Test01{
	public static void m1(int... a){//m1方法在调用的时候，传递的实参可以是0~N个
		System.out.println("Test");
	}
	//如果可以精确匹配的方法，则调用该方法，不会再去执行可变长参数的那个方法
	public static void m1(int i){
		System.out.println(i);
	}
	public static void m2(String...args){
		for(int i=0;i<args.length;i++){
			System.out.println(args[i]);
		}
	}
	//可变长参数只能出现一次，并且只能出现在所有参数的最后为止
	//public static void m4(String...a,int i){}
	public static void m4(int i,String...a){}
	public static void m3(Class...args) throws Exception{
		for(int i=0;i<args.length;i++){
			Class c=args[i];
			System.out.println(c.newInstance());
		}
	}
	public static void main(String[] args) throws Exception{
		m1();
		m1(1);
		m1(1,2);
		m1(3,4,5,6,7);
		m2("体育","音乐","旅游","美食");
		String[] s={"体育","音乐","旅游","美食"};
		m2(s);
		m3(Date.class,Employee.class);
	}
}