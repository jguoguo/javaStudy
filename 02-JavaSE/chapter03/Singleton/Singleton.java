/*
实现单例模式
单例模式要领：
1.构造方法私有化
2.对外提供一个公开的静态的获取当前对象的防腐层
3.提供一个当前类型的静态变量

单例模式分为两种：
饿汗式单例:在类加载阶段就创建了对象
懒汉式单例：用到对象的时候才会创建对象
*/
public class Singleton
{
	//静态变量
	private static Singleton s;
	//将构造方法私有化
	private Singleton(){}
	//对外提供一个公开的静态的获取当前类型对象的方法
	public static Singleton getInstance()
	{
		if(s==null)
		{
			Singleton s=new Singleton();
		}
		return s;
	}
}