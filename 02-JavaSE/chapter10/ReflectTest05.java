import java.lang.reflect.*;
public class ReflectTest05 {
	public static void main(String[] args) throws Exception{
		//��ȡ��
		Class c=Class.forName("User");
		//��ȡid����
		Field idF=c.getDeclaredField("id");
		//��ȡ��ĳ���ض����Կ������� set,get
		Object o=c.newInstance();
		//���Ʒ�װ
		idF.setAccessible(true);//ʹ�÷�����ƿ��Դ��Ʒ�װ��
		//��o�����id���Ը��ơ�110��
		idF.set(o,"110");
		//get
		System.out.println(idF.get(o));
	}
}