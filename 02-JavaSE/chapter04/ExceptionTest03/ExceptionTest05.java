/*
处理异常的第二种方式：捕捉， try...catch...
	语法：
	try{
	可能出现异常的代码；
	}
	catch(异常类型1 变量){
	处理异常的代码；
	}
	catch(异常类型2 变量){
	处理异常的代码；
	}...
	1.catch语句块可以写多个。
	2.但是从上到下catch，必须从小类型异常到大类型进行捕捉
	
*/
import java.io.*;
public class ExceptionTest05{
	public static void main(String[] args){
		//catch可以写多个，但是必须从上到下， 从小到大
		//程序执行到此处发生了FileNotFoundException类型的异常；
		//JVM会自动创建一个FileNotFoundException类型的对象，将该对象的内存地址赋值给catch语句中的e变量
		try{
			FileInputStream fis=new FileInputStream();
			fis.read();
		}catch(FileNotFoundException e){
			
		}catch(IOException e)
		
	}
}