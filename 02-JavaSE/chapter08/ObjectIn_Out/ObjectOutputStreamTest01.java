/*
	java.io.ObjectOutputStream;序列化JAVA对象到硬盘
	java.io.ObjtctInputStream;将硬盘中的数据"反序列化"到JVM内存
*/

import java.io.*;
public class ObjectOutputStreamTest01{
	public static void main(String[] args) throws Exception{
		//1.创建User对象
		User u1=new User("谢利江");
		//2.创建
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("temp06"));
		//3.写
		oos.writeObject(u1);
		//刷新
		oos.flush();
		//关闭
		oos.close();
	}
}