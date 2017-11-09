public class OuterClass{
	//方法
	public void m1(){
		//局部变量
		final int i=10;
		
		class InnerClass{
			//内部类不能有静态声明
			//成员方法
			public void m2(){
				System.out.println(i);
			}
		}
		
		//调用m2
		InnerClass inner=new InnerClass();
		inner.m2();
	}
	
	//入口
	public static void main(String[] args){
		OuterClass oc =new OuterClass();
		oc.m1();
	}
}