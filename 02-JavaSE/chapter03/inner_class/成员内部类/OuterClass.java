public class OuterClass
{
	//��̬����
	private static String s1="A";
	//��Ա����
	private String s2="B";
	
	//��̬����
	private static void m1()
	{
		System.out.println("static's m1 method execute");
	}
	private void m2()
	{
		System.out.println("m2 method execute");
	}
	
	//��Ա�ڲ���
	//�����÷��ʿ���Ȩ�޵����η�����
	//public,private,protected,ȱʡ
	class InnerClass
	{
		//��Ա����
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
		//ִ��m4
		OuterClass oc=new OuterClass();
		InnerClass inner=oc.new InnerClass();
		inner.m4();
	}
}