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
	
	//��̬�ڲ���
	//�����÷��ʿ���Ȩ�޵����η�����
	//public,private,protected,ȱʡ
	static class InnerClass
	{
		//��̬����
		public static void m3()
		{
			System.out.println(s1);
			m1();
			//System.out.println(s2);//���ܷ��ʷǾ�̬��Ա�����ͷ���
			//m2();
		}
		//��Ա����
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
		//ִ��m3
		OuterClass.InnerClass.m3();
		//ִ��m4
		InnerClass inner=new OuterClass.InnerClass();
		inner.m4();
	}
}