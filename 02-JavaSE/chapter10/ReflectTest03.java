/*
	��ȡClass ���͵Ķ���֮�󣬿��ԲŴ�����"��"�Ķ���
*/
import java.util.*;
import java.text.*;
public class ReflectTest03{
	public static void main(String[] args) throws Exception{
		Class c=Class.forName("Employee");
		//������class��������ʾ�����һ����ʵ��
		Object o=c.newInstance();//����Employee
		System.out.println(o);
		
		
		Class c1=Class.forName("java.util.Date");
		Object o1=c1.newInstance();
		if(o1 instanceof Date){
			Date t=(Date)o1;
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(t));
		}
	}
}