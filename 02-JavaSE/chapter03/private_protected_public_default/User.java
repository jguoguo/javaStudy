package com;
/*
关于访问控制权限修饰符：修饰类，修饰方法，修饰变量
private 只能在本类中访问
public 可以在任意位置访问

protected: 本类，同一个包下可以，不同包下不行,但是子类中可以
缺省:      本类，同一个包下可以，不同包下不行
*/
class User
{
	protected String name;
	//缺省
	int age;
}
class Test01
{
	public static void main(String[] arags)
	{
		User u=new User();
	}
}