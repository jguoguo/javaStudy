/*
�������ȡ����͸��ӿ�
*/
import java.lang.String;
public class ReflectTest10{
	public static void main(String[] args) throws Exception{
		Class c=Class.forName("java.lang.String");
		//��ȡ����
		Class superClass=c.getSuperclass();
		System.out.println(superClass.getName());
		//��ȡ���ӿ�
		Class[] ins=c.getInterfaces();
		for(Class in:ins){
			System.out.println(in.getName());	
		}
	}
}