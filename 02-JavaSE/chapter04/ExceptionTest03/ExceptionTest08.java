/*
	����finally����
	1.finally�������ֱ�Ӻ�try��������
	2.try...catch...finallyҲ����
*/
import java.io.*;
public class ExceptionTest08{
	public static void main(String[] args) throws FileNotFoundException{
/*		try{
			System.out.println("AAA");
			return;
		}finally{
			//��ִ��
			System.out.println("Test");	
		}
*/
/*		try{
			FileInputStream fis=new FileInputStream("Test2");
			//����ִ��
			System.out.println("TTTT");
		}finally{
			//��ִ��
			System.out.println("AAAA");
		}
*/	
		try{
			System.exit(0);
		}finally{
			System.out.println("AAAAA");
		}
	}
}