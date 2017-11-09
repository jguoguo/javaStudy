/*
	java.io.InputStream;
		java.io.FileInputStream;文件字节输入流
		按照字节方式读取文件
*/
import java.io.*;
public class FileInputStreamTest01{
	public static void main(String[] args){
		FileInputStream fis=null;
		try{
				//1.要读取某文件，先与这个文件创建一个“输入流”
			String filePath="temp01";//相对路径，相对当前而言，在当前路径下找
		//String filePath="E:\\course\\JavaProjects\\02-JavaSE\\chapter08\\temp01";
		//String filePath="E:/course/JavaProjects/02-JavaSE/chapter08/temp01";
			 fis=new FileInputStream(filePath);
			 
			//2.开始读
			int i1=fis.read();
			int i2=fis.read();
			int i3=fis.read();
			int i4=fis.read();
			int i5=fis.read();
			int i6=fis.read();
			int i7=fis.read();
			System.out.println(i7);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			//为了保证流一定会释放，所以在finally语句块中执行
			if(fis!=null){
				try{
					fis.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}

		
	}
}