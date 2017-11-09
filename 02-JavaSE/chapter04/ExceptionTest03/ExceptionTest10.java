/*
	finally语句块是一定会执行，所以通常在程序中
	为了保证某资源一定会释放，所以一般在finally语句中释放资源
*/
import java.io.*;
public class ExceptionTest10{
	public static void main(String[] args){
		//必须在外边声明
		FileInputStream fis=null;
		try{
			fis=new FileInputStream(".java");
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}finally{
			//为了保证资源一定会释放
			if(fis!=null)
			{
				try{
					fis.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
}