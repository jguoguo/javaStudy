/*
	关于getMessage和printStackTrace方法的应用
*/
import java.io.*;
public class ExceptionTest07{
	public static void main(String[] args)
	{
		try{
			FileInputStream fis=new FileInputStream("abc");
		}catch(FileNotFoundException e){
	//打印异常堆栈信息
	//一般情况下都会使用该方式去调试程序
		e.printStackTrace();
		}
			System.out.println("ABC");
	}
}