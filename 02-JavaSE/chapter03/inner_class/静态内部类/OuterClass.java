public class OuterClass
{
	//静态变量
	private static String s1="A";
	//成员变量
	private String s2="B";
	
	//静态方法
	private static void m1()
	{
		System.out.println("static's m1 method execute");
	}
	private void m2()
	{
		System.out.println("m2 method execute");
	}
	
	//静态内部类
	//可以用访问控制权限的修饰符修饰
	//public,private,protected,缺省
	static class InnerClass
	{
		//静态方法
		public static void m3()
		{
			System.out.println(s1);
			m1();
			//System.out.println(s2);//不能访问非静态成员变量和方法
			//m2();
		}
		//成员方法
		public void m4()
		{
			System.out.println(s1);
			m1();
			//System.out.println(s2);
			//m2();
		}
	}
	public static void main(String[] args)
	{
		//执行m3
		OuterClass.InnerClass.m3();
		//执行m4
		InnerClass inner=new OuterClass.InnerClass();
		inner.m4();
	}
}