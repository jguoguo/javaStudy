public class Test01
{
	public static void main(String[] args)
	{
		Object o=new Object();
		String oStr=o.toString();
		System.out.println(oStr);
		
		Person p2=new Person("л����",27);
		//print�������������������һ���������ͣ���Ĭ�ϵ��ø����͵�toString
		System.out.println(p2);
	}	

}
class Person
{
	String name;
	int age;
	Person(String name,int age)
	{
		this.name=name;
		this.age=age;
	}	
	//��дtoString����
	public String toString()
	{
		return "name:"+name+"age:"+age;
	}
}