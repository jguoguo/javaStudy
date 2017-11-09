/*
	t1和t2
	异步编程模型：t1线程执行t1的，t2线程执行t2的，两个线程之间谁也不等谁
	同步编程模型：t1线程和t2线程执行，当t1线程必须等t2线程执行结束之后，t1线程才能执行,这是同步编程模型
	
	什么时候要同步呢？为什么要引入线程同步呢？
		1.为了数据的安全。尽管应用程序的使用率低，但是为了保证数据是安全的，必须加入线程同步机制
			线程同步机制是程序变成了（等同）单线程
		2.什么条件下要使用线程同步？
			第一：必须是多线程环境
			第二：多线程环境共享同一个数据
			第三：共享的数据涉及到修改操作
			
		以下采用同步机制
*/
public class ThreadTest13{
	public static void main(String[] args){
		Acount act=new Acount("act-001",5000);
		Processor p=new Processor(act);
		Thread t1=new Thread(p);
		Thread t2=new Thread(p);
		
		t1.start();
		t2.start();
	}
}
class Processor implements Runnable{
	Acount act;
	Processor(Acount act){
		this.act=act;
	}
	public void run(){
		act.withdraw(1000);
		System.out.println("取款1000.0成功，余额为："+act.getBalance());
	}
}
class Acount{
	String actname;
	double balance;
	Acount(String actname,double balance){
		this.actname=actname;
		this.balance=balance;
	}
	public void setActName(String actname){
		this.actname=actname;
	}
	public void setBalance(double balance){
		this.balance=balance;
	}
	public String getActName(){
		return actname;
	}
	public double getBalance(){
		return balance;
	}
	public void withdraw(double act){
		
		//把需要同步的代码，放到同步语句块中
		
		/*
			原理：t1线程和t2线程
			t1线程执行到此处，遇到synchronized关键字，就会去找this的对象锁
			如果找到this对象锁，则进入同步语句块中执行程序。当同步语句块中的代码执行结束之后，
			t1线程归还this的对象锁
			
			在t1线程执行同步语句块的过程中，如果t2线程也过来执行以下代码，也遇到
			synchronized关键字，所以也去找this的对象锁，但是该对象锁被t1线程持有，
			只能在这等待this对象的归还
		*/
		synchronized(this){
			double after=balance-act;
			try{Thread.sleep(1000);}catch(Exception e){}
			setBalance(after);
		}
		
	}
}