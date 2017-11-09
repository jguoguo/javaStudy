
/*
关于Object中的equals方法
 Object中的equals方法：
 public boolean equals(Object obj)
 {
 	return (this==obj);
 }
 o1.equals(o2);o1是this,o2是obj
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
	//object中的equals方法比较的是内存地址
	//在现实的业务逻辑中，不应该比较内存地址，应该比较内容
	//所以Object中的equals方法也要重写。
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