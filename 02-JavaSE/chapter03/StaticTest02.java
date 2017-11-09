/*
¹ØÓÚÊµÀıÓï¾ä¿é
*/
public class StaticTest02
{
	//¾²Ì¬Óï¾ä¿é
	static
	{
		System.out.println("A");
	}
	//ÊµÀıÓï¾ä¿é
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