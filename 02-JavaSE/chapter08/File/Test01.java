/*
	java.io.File;
		1.File类和流无关，不能通过该类完成文件的读和写
		2.File是文件和目录路径名的抽象表示形式
		File代表的是硬盘上的Directory和file
*/
import java.io.*;
public class Test01{
	public static void main(String[] args) throws Exception{
		File f1=new File("Test01.java");
		File f2=new File("E:\\course\\JavaProjects\\02-JavaSE\\chapter08\\File\\Test01.java");
		File f3=new File("E:/course");
		
		System.out.println(f1.exists());
		System.out.println(f2.exists());
		System.out.println(f3.exists());
		
		File f4=new File("C:/tt");
		System.out.println(f4.exists());
		
		if(!f4.exists()){
			//f4.mkdir();
			f4.createNewFile();
		}
		
		File f5=new File("C:/a/b/c/d/e");
		if(!f5.exists()){
			f5.mkdirs();
		}
	}
}