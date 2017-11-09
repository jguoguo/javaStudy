public class Test01
{
	public static void main(String[] args)
	{
		Person p1=new Person();
		p1=null;//没有引用再指向它，等待回收。
		//程序员只能"建议"垃圾回收器回收垃圾
		System.gc();//强制运行垃圾回收
	}
}
class Person
{
	public void finalize() throws Throwable
	{
		System.out.println(this+"马上就要被回收了！");
		//让引用再次重新指向该对象，该对象不是垃圾数据，不会被垃圾回收器回收
		Person p=this;
	}
}