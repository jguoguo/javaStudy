/*
	��ȡclass��������ַ�ʽ
*/
import java.util.*;
public class ReflectTest01{
	public static void main(String[] args) throws Exception{
		//��һ�ַ�ʽ
		Class c1=Class.forName("Employee");//c1���ñ����ڴ��ַָ����еĶ��󣬸ö���������Employee������
		
		//�ڶ��ַ�ʽ
		//java��ÿ�����Ͷ���class����
		Class c2=Employee.class;
		
		//�����ַ�ʽ
		//java�������κ�һ��java������getClass����
		Employee e=new Employee();
		Class c3=e.getClass();//c3������ʱ��
		
		//��ΪEmployee�������JVM��ֻ��һ��������c1,c2,c3���ڴ��ַ����ͬ��
		System.out.println(c1==c2);
		System.out.println(c2==c3);
		
		Class c4=Date.class();//c4����Date�����
		Class c5=Class.forName("java.util.Date");//����д��ȫ��
		Date d=new Date();
		Class c6=d.getClass();
	}
}