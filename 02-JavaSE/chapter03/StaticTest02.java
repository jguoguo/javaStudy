/*
����ʵ������
*/
public class StaticTest02
{
	//��̬����
	static
	{
		System.out.println("A");
	}
	//ʵ������
	{
		System.out.println("1");
	}
	{
		System.out.println("2");
	}
	{
		System.out.println("3");
	}
	public static void main(String[] args)
	{
		new StaticTest02();
	}
}