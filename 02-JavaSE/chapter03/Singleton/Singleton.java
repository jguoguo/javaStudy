/*
ʵ�ֵ���ģʽ
����ģʽҪ�죺
1.���췽��˽�л�
2.�����ṩһ�������ľ�̬�Ļ�ȡ��ǰ����ķ�����
3.�ṩһ����ǰ���͵ľ�̬����

����ģʽ��Ϊ���֣�
����ʽ����:������ؽ׶ξʹ����˶���
����ʽ�������õ������ʱ��Żᴴ������
*/
public class Singleton
{
	//��̬����
	private static Singleton s;
	//�����췽��˽�л�
	private Singleton(){}
	//�����ṩһ�������ľ�̬�Ļ�ȡ��ǰ���Ͷ���ķ���
	public static Singleton getInstance()
	{
		if(s==null)
		{
			Singleton s=new Singleton();
		}
		return s;
	}
}