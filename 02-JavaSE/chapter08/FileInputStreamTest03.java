/*
	int read(byte[] bytes)
	读取之前在内存中准备一个byte数组，每次读取多个字节存储到byte数组中
	一次读取多个字节，不是单字节读取了
	效率高
	
*/
import java.io.*;
public class FileInputStreamTest03{
	public static void main(String[] args) throws Exception{
		//1.创建输入流
		FileInputStream fis=new FileInputStream("temp01");
		
		//开始读
		byte[] bytes=new byte[3];
		//int read(byte[] bytes);该方法返回的int类型的值代表的是，这次读取了多少个字节
		int i1=fis.read(bytes);
		//将byte数组转换成字符串
		System.out.println(new String(bytes));
		int i2=fis.read(bytes);
		System.out.println(new String(bytes));
		int i3=fis.read(bytes);
		System.out.println(new String(bytes,0,i3));
		int i4=fis.read(bytes);
		
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println(i4);
		
		//关闭
		fis.close();
		
	}
}