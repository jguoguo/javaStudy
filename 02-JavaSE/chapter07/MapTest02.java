/*
	HashMapĬ�ϳ�ʼ������Ϊ16��Ĭ�ϼ�������Ϊ0.75
	HashTableĬ�ϳ�ʼ����Ϊ11��Ĭ�ϼ�����ΪΪ0.75
	java.util.Properties;Ҳ����key��value��ɣ�����key��value�����ַ�������
*/
import java.util.*;
public class MapTest02{
	public static void main(String[] args){
		//1.�������������
		Properties p=new Properties();
		//2.��
		p.setProperty("driver","oracle.");
		p.setProperty("username","xielijiang");
		p.setProperty("password","123456.");
		p.setProperty("url","jd.");
		//3.ȡ
		String v1=p.getProperty("driver");
		String v2=p.getProperty("username");
		String v3=p.getProperty("password");
		String v4=p.getProperty("url");
		
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
	}
}