/*
	java.io.Writer;
		java.io.OutputStreamWriter;转换流（字节输出流-->字符输出流）
			java.io.FileWriter;文件字符输出流
*/
import java.io.*;
public class FileWriterTest01{
	public static void main(String[] args) throws Exception{
		FileWriter fw=new FileWriter("temp03",true);
		
		fw.write("谢利江");
		char[] chars={'我','是','中','国','人','！'};
		fw.write(chars,0,5);
		//刷新
		fw.flush();
		//关闭
		fw.close();
	}
}