/*
	java.io.Writer;
		java.io.OutputStreamWriter;ת�������ֽ������-->�ַ��������
			java.io.FileWriter;�ļ��ַ������
*/
import java.io.*;
public class FileWriterTest01{
	public static void main(String[] args) throws Exception{
		FileWriter fw=new FileWriter("temp03",true);
		
		fw.write("л����");
		char[] chars={'��','��','��','��','��','��'};
		fw.write(chars,0,5);
		//ˢ��
		fw.flush();
		//�ر�
		fw.close();
	}
}