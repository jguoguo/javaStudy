/*
	java.io.ObjectOutputStream;���л�JAVA����Ӳ��
	java.io.ObjtctInputStream;��Ӳ���е�����"�����л�"��JVM�ڴ�
*/

import java.io.*;
public class ObjectOutputStreamTest01{
	public static void main(String[] args) throws Exception{
		//1.����User����
		User u1=new User("л����");
		//2.����
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("temp06"));
		//3.д
		oos.writeObject(u1);
		//ˢ��
		oos.flush();
		//�ر�
		oos.close();
	}
}