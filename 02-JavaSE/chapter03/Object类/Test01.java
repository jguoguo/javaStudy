public class Test01
{
	public static void main(String[] args)
	{
		Object o=new Object();
		String oStr=o.toString();
		System.out.println(oStr);
		
		Person p2=new Person("谢利江",27);
		//print方法后面括号中如果是一个引用类型，会默认调用该类型的toString
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
	//重写toString方法
	public String toString()
	{
		return "name:"+name+"age:"+age;
	}
}