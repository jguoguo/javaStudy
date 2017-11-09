/*
关于java语言中向上转型和向下转型
1.向上转型(upcasting):子-->父
2.向下转型(downcasting):父-->子
注意：无论是向上转型还是向下转型，两个类之间必须要有继承关系
*/

public class Test02
{
	public static void main(String[] args)
	{
		//向上转型又被称作：自动类型转化
		//父类型的引用指向子类型对象
		//程序分为两个阶段：编译阶段，运行阶段
		//程序编译阶段只知道a1是一个Animal类型
		//程序在运行的时候堆中的实际对象是Cat类型
		Animal a1=new Cat();
		//程序在编译阶段a1被编译器看做Animal类型
		//所以程序在编译阶段a1引用绑定的是Animal类中的cat方法（静态绑定）
		//程序在运行的时候堆中的对象实际上是Cat类型，而Cat类型已经重写了eat方法
		//所以程序在运行阶段对象的绑定的方法是Cat中的eat方法（动态绑定）
		a1.eat();
		
		
		//向下转型：强制类型转换
		Animal a2=new Cat();
		//要执行move方法，怎么做？
		//只能强制类型转换，需要加强制类型转换符
		Cat c1=(Cat)a2;
		c1.move();
		
		//在做强制类型转换的时候程序是存在风险的！
		//为了避免ClassCastExtception的发生，java引入了intstance0f
		/*
		用法：
			1.instanceof运算符的运算结果是boolean类型
			2.(引用 instanceof 类型)--->true/false
			例如：
			
			a3 instanceof Cat
		*/
		
		//Animal a3=new Dog();向上转型
		//强制类型转换
		//Cat c2=(Cat)a3;//java.lang.ClassCastException
		
		Animal a3=new Dog();
		if(a3 instanceof Cat)
		{
			Cat c2=(Cat)a3;
		}
	}
}