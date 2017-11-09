/*
	HashMap默认初始化容量为16，默认加载因子为0.75
	HashTable默认初始容量为11，默认加载因为为0.75
	java.util.Properties;也是由key和value组成，但是key和value都是字符串类型
*/
import java.util.*;
public class MapTest02{
	public static void main(String[] args){
		//1.创建属性类对象
		Properties p=new Properties();
		//2.存
		p.setProperty("driver","oracle.");
		p.setProperty("username","xielijiang");
		p.setProperty("password","123456.");
		p.setProperty("url","jd.");
		//3.取
		String v1=p.getProperty("driver");
		String v2=p.getProperty("username");
		String v3=p.getProperty("password");
		String v4=p.getProperty("url");
		
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
	}
}