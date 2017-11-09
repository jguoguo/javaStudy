/*
	�����̶߳�1����������ݲ���
*/
public class Test01{
	public static void main(String[] args) throws Exception{
		Num num=new Num(1);
		Thread t1=new Thread(new PrintOdd(num));
		t1.setName("t1");
		Thread t2=new Thread(new PrintEven(num));
		t2.setName("t2");
		t1.start();
		Thread.sleep(1000);
		t2.start();
	}
}
class Num{
	int count;
	Num(int count){
		this.count=count;
	}
	//��ӡ�����ķ���
	public synchronized void printOdd(){
		System.out.println(Thread.currentThread().getName()+"-->"+(count++));
		this.notifyAll();
		try{
			this.wait();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//��ӡż���ķ���
	public synchronized void printEven(){
		System.out.println(Thread.currentThread().getName()+"-->"+(count++));
		this.notifyAll();
		try{
			this.wait();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
//�߳�1
class PrintOdd implements Runnable{
	Num num;
	PrintOdd(Num num){
		this.num=num;
	}
	public void run(){
		while(true){
			num.printOdd();
		}
	}	
}
//�߳�2
class PrintEven implements Runnable{
	Num num;
	PrintEven(Num num){
		this.num=num;
	}	
	public void run(){
		while(true){
			num.printEven();
		}	
	}
}