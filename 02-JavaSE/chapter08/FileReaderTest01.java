/*
	java.io.Reader;
		java.io.InputStreamReader;ת����(�ֽ�������-->�ַ���������
			java.io.FileReader;�ļ��ַ�������
*/
import java.io.*;
public class FileReaderTest01{
	public static void main(String[] args){
		FileReader fr=null;
		try{
			fr = new FileReader("FileOutputStreamTest01.java");
			char[] chars=new char[512];
			int temp=0;
			while((temp=fr.read(chars))!=-1){
				System.out.println(new String(chars,0,temp));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(fr!=null){
				try{
					fr.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}	
}