/*
	java.io.InputStream;
		java.io.FileInputStream;�ļ��ֽ�������
		�����ֽڷ�ʽ��ȡ�ļ�
*/
import java.io.*;
public class FileInputStreamTest01{
	public static void main(String[] args){
		FileInputStream fis=null;
		try{
				//1.Ҫ��ȡĳ�ļ�����������ļ�����һ������������
			String filePath="temp01";//���·������Ե�ǰ���ԣ��ڵ�ǰ·������
		//String filePath="E:\\course\\JavaProjects\\02-JavaSE\\chapter08\\temp01";
		//String filePath="E:/course/JavaProjects/02-JavaSE/chapter08/temp01";
			 fis=new FileInputStream(filePath);
			 
			//2.��ʼ��
			int i1=fis.read();
			int i2=fis.read();
			int i3=fis.read();
			int i4=fis.read();
			int i5=fis.read();
			int i6=fis.read();
			int i7=fis.read();
			System.out.println(i7);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			//Ϊ�˱�֤��һ�����ͷţ�������finally������ִ��
			if(fis!=null){
				try{
					fis.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}

		
	}
}