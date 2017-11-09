
import java.io.*;
import java.util.*;
public class Test01{
	public static void main(String[] args) throws Exception{
		//1.创建属性对象
		Properties p=new Properties();
		//2.创建输入流
		FileInputStream fis=new FileInputStream("classInfo.properties");
		//3.导入属性文件
		p.load(fis);
		String s=p.getProperty("className");
		System.out.println(s);
		
		Class c=Class.forName(s);
		Object o=c.newInstance();
		System.out.println(o);
	}
}