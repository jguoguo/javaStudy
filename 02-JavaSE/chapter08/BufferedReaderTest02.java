/*
	BufferedReader
	InputStreamReader
*/
import java.io.*;
public class BufferedReaderTest02{
	public static void main(String[] args) throws Exception{
		//创建带有缓冲区的字符输入流
		FileInputStream fis=new FileInputStream("BufferedReaderTest02.java");
		//转换流(将字节流转换成字符流)
		InputStreamReader isr=new InputStreamReader(fis);
		BufferedReader br=new BufferedReader(isr);
		
		String str=null;
		while((str=br.readLine())!=null){
			System.out.println(str);
		}
		
		//关闭
		br.close();
	}
}