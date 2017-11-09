/*
	属性文件中数据要求：
		key和value之间可以使用“空格”，“冒号”,"等号"
		如果“空格”，“冒号”,"等号"都有，按最前的作为分隔符
*/

import java.io.*;
import java.util.*;
public class Test01{
	public static void main(String[] args) throws Exception{
		//1.创建属性对象
		Properties p=new Properties();//和map一样，只不过key和value只能存储字符串类型
																	//key不能重复，如果key重复则value覆盖
		//2.创建输入流
		FileInputStream fis=new FileInputStream("dbinfo");
		//3.将fis流中的所有数据加载到属性对象中
		p.load(fis);
		//4.关闭流
		fis.close();
		//5.通过key获取value
		String v=p.getProperty("username");
		System.out.println(v);
	}
}