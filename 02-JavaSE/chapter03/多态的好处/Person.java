/*
*/
public class Person
{
	public void feed(Animal d)
	{
		d.eat();
	}
	//以上的代码得出：Person类型的扩展能力太差
	//尽量不要面向具体编程，面向父类型编程，面向抽象编程
}