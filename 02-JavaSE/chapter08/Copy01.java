/*
	�����ļ�����ճ��
*/
import java.io.*;
public class Copy01{
	public static void main(String[] args) throws Exception{
		//����������
		FileInputStream fis=new FileInputStream("FileOutputStreamTest01.java");
		//���������
		FileOutputStream fos=new FileOutputStream("c:/FileOutputStreamTest01.java");
		//�����ļ�
		byte[] bytes=new byte[1024];
		int temp = 0;
		while((temp=fis.read(bytes))!=-1){
			fos.write(bytes,0,temp);
		}
		//ˢ��
		fos.flush();
		//�ر�
		fis.close();
		fos.close();
	}
}