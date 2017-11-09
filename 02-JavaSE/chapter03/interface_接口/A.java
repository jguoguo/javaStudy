/*
接口也是一种引用类型，可以等同看做类
1.如何定义接口，语法：
     [修饰符] interface 接口名{}
2.接口中只能出现：常量、抽象方法
3.接口其实是一个特殊的抽象类，特殊在接口是完全抽象的
4.接口中没有构造方法，无法被实例化
5.接口和接口之间可以多继承
6.一个类可以实现多个接口，（这里的“实现”可以等同看做“继承”）
7.一个非抽象的类可以实现接口，需要将接口中所有的方法“实现/重写/覆盖”
*/
public interface A
{
	//常量(必须用public static final修饰)
	public static final String SUCCESS="success";
	public static final double PI=3.14;
	
	//public static final是可以省略的
	byte MAX_VALUE=127;
	//抽象方法(接口中所有的抽象方法都是public abstact)
	public abstract void m1();
	void m2();
}
interface B
{
	void m1();
}
interface C
{
	void m2();
}
interface D
{
	void m3();
}
interface E extends B,C,D
{
	void m4();
}
//implement和extends意义相同
class F implements B,C
{
	public void m1()
	{
	}
	public void m2()
	{}
}