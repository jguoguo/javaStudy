/*
�����쳣�����ַ�ʽ��
	1.�����׳�throws
	2.��׽  try....catch
	���³�����ʾ��һ�ַ�ʽ�������׳�
*/
import java.io.*;
public class ExceptionTest03{
	public static void main(String[] args) throws FileNotFoundException{
		//public static void main(String[] args) throws IOException{
		//public static void main(String[] args) throws Exception{
		//�����ļ�����������ȡ�ļ�
		//java������������ô���ܣ���ΪFileInputStream������췽����������Ϊֹ��ʹ��
		//throw FileNotFoundException
		FileInputStream fis=new FileInputStream("c:/ab.txt");
	}
}