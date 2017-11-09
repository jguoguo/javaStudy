/*
	BufferedReader
	InputStreamReader
*/
import java.io.*;
public class BufferedReaderTest02{
	public static void main(String[] args) throws Exception{
		//�������л��������ַ�������
		FileInputStream fis=new FileInputStream("BufferedReaderTest02.java");
		//ת����(���ֽ���ת�����ַ���)
		InputStreamReader isr=new InputStreamReader(fis);
		BufferedReader br=new BufferedReader(isr);
		
		String str=null;
		while((str=br.readLine())!=null){
			System.out.println(str);
		}
		
		//�ر�
		br.close();
	}
}