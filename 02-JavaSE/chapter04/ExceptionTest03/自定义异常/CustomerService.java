//顾客相关的业务
public class CustomerService{
	//对外提供一个注册的方法
	public void register(String name) throws IlleaglNameException{
		if(name.length()<6){
			//手动抛出异常
			throw new IlleaglNameException("用户名长度不能少于6");
		}
			//如果代码能执行到此处，证明用户名是合法的
		System.out.println("注册成功！");
	}

	
}