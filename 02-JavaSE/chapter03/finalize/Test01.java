public class Test01
{
	public static void main(String[] args)
	{
		Person p1=new Person();
		p1=null;//û��������ָ�������ȴ����ա�
		//����Աֻ��"����"������������������
		System.gc();//ǿ��������������
	}
}
class Person
{
	public void finalize() throws Throwable
	{
		System.out.println(this+"���Ͼ�Ҫ�������ˣ�");
		//�������ٴ�����ָ��ö��󣬸ö������������ݣ����ᱻ��������������
		Person p=this;
	}
}