/*
	int read(byte[] bytes)
	��ȡ֮ǰ���ڴ���׼��һ��byte���飬ÿ�ζ�ȡ����ֽڴ洢��byte������
	һ�ζ�ȡ����ֽڣ����ǵ��ֽڶ�ȡ��
	Ч�ʸ�
	
*/
import java.io.*;
public class FileInputStreamTest03{
	public static void main(String[] args) throws Exception{
		//1.����������
		FileInputStream fis=new FileInputStream("temp01");
		
		//��ʼ��
		byte[] bytes=new byte[3];
		//int read(byte[] bytes);�÷������ص�int���͵�ֵ������ǣ���ζ�ȡ�˶��ٸ��ֽ�
		int i1=fis.read(bytes);
		//��byte����ת�����ַ���
		System.out.println(new String(bytes));
		int i2=fis.read(bytes);
		System.out.println(new String(bytes));
		int i3=fis.read(bytes);
		System.out.println(new String(bytes,0,i3));
		int i4=fis.read(bytes);
		
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println(i4);
		
		//�ر�
		fis.close();
		
	}
}