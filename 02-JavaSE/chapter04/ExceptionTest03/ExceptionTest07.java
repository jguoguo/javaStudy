/*
	����getMessage��printStackTrace������Ӧ��
*/
import java.io.*;
public class ExceptionTest07{
	public static void main(String[] args)
	{
		try{
			FileInputStream fis=new FileInputStream("abc");
		}catch(FileNotFoundException e){
	//��ӡ�쳣��ջ��Ϣ
	//һ������¶���ʹ�ø÷�ʽȥ���Գ���
		e.printStackTrace();
		}
			System.out.println("ABC");
	}
}