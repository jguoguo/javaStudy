/*

*/
import java.io.*;
public class BufferedReaderTest01{
	public static void main(String[] args) throws Exception{
		//创建一个带有缓冲区的字符输入流
		BufferedReader br=new BufferedReader(new FileReader("BufferedReaderTest01.java"));
		//根据流出现的位置，流又可以分为，包装流或者处理流 和节点流
		//FileReader fr是一个节点流
		//BufferedReader br 是一个包装流，或者处理流
		String temp=null;
		while((temp=br.readLine())!=null){//br.readLine()方法赌气一行，但是结尾没有换行符
			System.out.println(temp);
		}
		//关闭
		//注意：关闭的时候只需要关闭最外层的包装流，（这里有一个装饰着模式）
		br.close();
	}
}