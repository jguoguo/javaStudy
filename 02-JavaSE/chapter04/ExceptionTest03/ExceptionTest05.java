/*
�����쳣�ĵڶ��ַ�ʽ����׽�� try...catch...
	�﷨��
	try{
	���ܳ����쳣�Ĵ��룻
	}
	catch(�쳣����1 ����){
	�����쳣�Ĵ��룻
	}
	catch(�쳣����2 ����){
	�����쳣�Ĵ��룻
	}...
	1.catch�������д�����
	2.���Ǵ��ϵ���catch�������С�����쳣�������ͽ��в�׽
	
*/
import java.io.*;
public class ExceptionTest05{
	public static void main(String[] args){
		//catch����д��������Ǳ�����ϵ��£� ��С����
		//����ִ�е��˴�������FileNotFoundException���͵��쳣��
		//JVM���Զ�����һ��FileNotFoundException���͵Ķ��󣬽��ö�����ڴ��ַ��ֵ��catch����е�e����
		try{
			FileInputStream fis=new FileInputStream();
			fis.read();
		}catch(FileNotFoundException e){
			
		}catch(IOException e)
		
	}
}