
/*
����Object�е�equals����
 Object�е�equals������
 public boolean equals(Object obj)
 {
 	return (this==obj);
 }
 o1.equals(o2);o1��this,o2��obj
 ==
*/
public class Test01
{
	public static void main(String[] args)
	{
		Object o1=new Object();
		Object o2=new Object();
		boolean b1=o1.equals(o2);
	}
}
class Star{
	int id;
	String name;
	public Star(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	//object�е�equals�����Ƚϵ����ڴ��ַ
	//����ʵ��ҵ���߼��У���Ӧ�ñȽ��ڴ��ַ��Ӧ�ñȽ�����
	//����Object�е�equals����ҲҪ��д��
	public boolean equals(Object obj)
	{
		Star s=(Star)obj;
		if(s.instanceof(obj))
		{
			if((s.id==this.id)&&s.name.equals(this.name))
			{
				return true;
			}
		}
		return false;
	}
}