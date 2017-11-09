/*
	匿名内部类：指的是类没有名字
	
*/
public class Test{
	public static void t(CustomerService cs){
		cs.logout();
	}
	public static void main(String[] args){
		//调用t方法
		//t(new CustomerServiceImpl());
		
		//使用匿名内部类的方式执行t方法
		t(new CustomerService(){
			public void logout(){
				System.out.println("qqqqq");	
			}
		//匿名内部类的优点：少定义一个类
		//缺点：无法重复使用！
		});
	}
}
//接口
interface CustomerService{
	void logout();
}

//编写一个类实现CustomerService接口
//class CustomerServiceImpl implements CustomerService{
//	public void logout(){
//		System.out.println("qqqqq");
//	}
//}