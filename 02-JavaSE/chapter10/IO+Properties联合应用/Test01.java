/*
	�����ļ�������Ҫ��
		key��value֮�����ʹ�á��ո񡱣���ð�š�,"�Ⱥ�"
		������ո񡱣���ð�š�,"�Ⱥ�"���У�����ǰ����Ϊ�ָ���
*/

import java.io.*;
import java.util.*;
public class Test01{
	public static void main(String[] args) throws Exception{
		//1.�������Զ���
		Properties p=new Properties();//��mapһ����ֻ����key��valueֻ�ܴ洢�ַ�������
																	//key�����ظ������key�ظ���value����
		//2.����������
		FileInputStream fis=new FileInputStream("dbinfo");
		//3.��fis���е��������ݼ��ص����Զ�����
		p.load(fis);
		//4.�ر���
		fis.close();
		//5.ͨ��key��ȡvalue
		String v=p.getProperty("username");
		System.out.println(v);
	}
}