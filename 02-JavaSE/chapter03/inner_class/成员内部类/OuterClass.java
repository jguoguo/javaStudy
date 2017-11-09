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
	
	//成员内部类
	//可以用访问控制权限的修饰符修饰
	//public,private,protected,缺省
	class InnerClass
	{
		//成员方法
		public void m4()
		{
			System.out.println(s1);
			m1();
			System.out.println(s2);
			m2();
		}
	}
	public static void main(String[] args)
	{
		//执行m4
		OuterClass oc=new OuterClass();
		InnerClass inner=oc.new InnerClass();
		inner.m4();
	}
}