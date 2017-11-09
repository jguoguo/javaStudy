import java.io.*;
import java.util.*;
import java.text.*;
public class PrintStreamTest01{
	public static void main(String[] args) throws Exception{
		//默认是输出到控制台
		System.out.println("HelloWorld");
		PrintStream ps=System.out;
		ps.println("JAVA....");
		//可以改变输出方向
		System.setout(new PrintStream(new FileOutputStream("temp06")));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		System.out.println(sdf.format(new Date()));
		m1();
		System.out.println(sdf.format(new Date()));
	}
	public static void m1(){
		System.out.println("m1 method execte");	
	}
}