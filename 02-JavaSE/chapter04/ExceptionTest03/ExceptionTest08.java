/*
	关于finally语句块
	1.finally语句块可以直接和try语句块联用
	2.try...catch...finally也可以
*/
import java.io.*;
public class ExceptionTest08{
	public static void main(String[] args) throws FileNotFoundException{
/*		try{
			System.out.println("AAA");
			return;
		}finally{
			//会执行
			System.out.println("Test");	
		}
*/
/*		try{
			FileInputStream fis=new FileInputStream("Test2");
			//不会执行
			System.out.println("TTTT");
		}finally{
			//会执行
			System.out.println("AAAA");
		}
*/	
		try{
			System.exit(0);
		}finally{
			System.out.println("AAAAA");
		}
	}
}