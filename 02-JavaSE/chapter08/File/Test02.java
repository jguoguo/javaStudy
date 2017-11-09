import java.io.*;
public class Test02{
	public static void main(String[] args){
		File f1=new File("Test02.java");
		File f2=new File("E:\\course");
		System.out.println(f1.exists());
		System.out.println(f2.exists());
		
		System.out.println(f1.getAbsoluteFile());
		System.out.println(f2.getAbsoluteFile());
		
		System.out.println(f1.getAbsolutePath());
		System.out.println(f2.getAbsolutePath());
		
		System.out.println(f1.getName());
		System.out.println(f2.getName());
		
		System.out.println(f1.getParent());
		System.out.println(f2.getParent());
		
		System.out.println(f1.getPath());
		System.out.println(f2.getPath());
	}
}