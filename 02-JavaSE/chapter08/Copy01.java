/*
	关于文件复制粘贴
*/
import java.io.*;
public class Copy01{
	public static void main(String[] args) throws Exception{
		//创建输入流
		FileInputStream fis=new FileInputStream("FileOutputStreamTest01.java");
		//创建输出流
		FileOutputStream fos=new FileOutputStream("c:/FileOutputStreamTest01.java");
		//复制文件
		byte[] bytes=new byte[1024];
		int temp = 0;
		while((temp=fis.read(bytes))!=-1){
			fos.write(bytes,0,temp);
		}
		//刷新
		fos.flush();
		//关闭
		fis.close();
		fos.close();
	}
}