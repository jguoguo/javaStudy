/*

*/
public class ThreadTest17{
	public static void main(String[] args) throws Exception{
		Thread t1=new Thread(new Processor());
		Thread t2=new Thread(new Processor());
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		Thread.sleep(1000);
		t2.start();
	}
}
class Processor implements Runnable{
	public void run(){
		if("t1".equals(Thread.currentThread().getName())){
			MyClass.m1();
			
		}
		if("t2".equals(Thread.currentThread().getName())){
			MyClass.m2();
		}
	}
}
class MyClass{
	//synchronized��ӵ���̬�����ϣ��߳�ִ�д˷�����ʱ����ҵ�����
	public synchronized static void m1(){
		try{Thread.sleep(10000);}catch(Exception e){}
		System.out.println("m1....");
	}
	public synchronized static void m2(){
		System.out.println("m2....");
	}
}