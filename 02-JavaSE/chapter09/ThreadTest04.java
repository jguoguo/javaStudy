/*
	三个方法
			1.获取当前线程对象Thread.currentThread();
			2.给线程起名t.setName();
			3.获取线程的名字t.getName();
*/
public class ThreadTest04{
	public static void main(String[] args){
		//如何获取当前线程对象
		Thread t=Thread.currentThread();
		//获取线程名字
		System.out.println(t.getName());
		
		Thread t1=new Thread(new Processor());
		//给线程起名
		t1.setName("t1");
		System.out.println(t1.getName());
		Thread t2=new Thread(new Processor());
		t2.setName("t2");
		System.out.println(t2.getName());
	}
}
class Processor implements Runnable{
	public void run(){
		Thread t=Thread.currentThread();
		System.out.println(t.getName());
	}
}