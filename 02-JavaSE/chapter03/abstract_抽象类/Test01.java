/*
1.如何定义抽象类
	class关键字前加abstract
2.抽象类无法被实例化
3.虽然抽象类没有办法实例化，但是抽象类也有构造方法，该构造方法是给子类创建对象用的
4.抽象类中可以定义抽象方法
	抽象方法的语法：在方法的修饰符列表中添加abstract关键字，并且抽象方法应该以”;“结束，不能带有"()"
	例如：public abstract void m1();
5.抽象类中不一定有抽象方法，但是有抽象方法必须是抽象类
6.一个非抽象的类继承抽象类，必须将抽象类中的抽象方法覆盖，实现，重写。
*/
public abstract class Test01
{
	//构造方法
	Test01()
	{
		System.out.println("A......");
	}
	//抽象方法
	public abstract void m1();
	public static void main(String[] args)
	{
		//抽象类无法被实例化
		//Test01 a=new Test01();
		//多态
		Test01 a = new B();//父类型对象指向子类型构造方法
	}
}
class B extends Test01
{
	B()
	{
		super();//父类的构造方法虽然调用了，但是并没有调用创建父类对象
		System.out.println("B......");
	}
	public void m1(){};
}