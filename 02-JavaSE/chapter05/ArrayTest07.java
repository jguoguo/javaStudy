/*
	关于main方法中的参数列表String[] args
	1.String[] args是专门用来接收命令行参数的
	2.例如：java ArrayTest07 abc def aaa
		JVM调用ArrayTest07类的main方法之前，
		先将“abc def aaa”这个字符串以“空格”的方式分割，然后存储在String数组中
*/
public class ArrayTest07{
	public static void main(String[] args){
		//System.out.println("String类型的数组中元素的个数是："+args.length);	
		//需求说明：运行该软件的时候必须提供用户名和密码
		//格式： java ArrayTest07 username password
		//如果用户没有输入足够的参数，则退出系统
		if(args.length!=2){
			System.out.println("要想使用该系统，必须这样输入：java ArrayTest07 username password");
		}else{
			//参数提供正确，如果用户名是admin,密码是123则登陆成功
			String username=args[0];
			String password=args[1];
			//字符串比较用equals
			if("admin".equals(username) && "123".equals(password)){//这种方法可以避免空指针异常
				System.out.println("登陆成功，欢迎["+username+"]回来");
			}
			else{
				System.out.println("登陆失败");
			}
		}

	}
}