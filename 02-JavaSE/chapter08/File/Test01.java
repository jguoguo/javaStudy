/*
	java.io.File;
		1.File������޹أ�����ͨ����������ļ��Ķ���д
		2.File���ļ���Ŀ¼·�����ĳ����ʾ��ʽ
		File�������Ӳ���ϵ�Directory��file
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