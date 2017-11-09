/*
处理异常有两种方式：
	1.声明抛出throws
	2.捕捉  try....catch
	以下程序演示第一种方式：声明抛出
*/
import java.io.*;
public class ExceptionTest03{
	public static void main(String[] args) throws FileNotFoundException{
		//public static void main(String[] args) throws IOException{
		//public static void main(String[] args) throws Exception{
		//创建文件输入流，读取文件
		//java编译器不是那么智能，因为FileInputStream这个构造方法在声明的为止上使用
		//throw FileNotFoundException
		FileInputStream fis=new FileInputStream("c:/ab.txt");
	}
}