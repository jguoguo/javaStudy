import java.io.*;
public class FileInputStreamTest05{
	public static void main(String[] args) throws Exception{
		//1.������
		FileInputStream fis=new FileInputStream("temp01");
		System.out.println(fis.available());//7
		System.out.println(fis.read());
		//int available();��������ʣ��Ĺ����ֽ���
		System.out.println(fis.available());//6
		
		fis.skip(2);
		System.out.println(fis.read());
		//�ر�
		fis.close();
	}
}