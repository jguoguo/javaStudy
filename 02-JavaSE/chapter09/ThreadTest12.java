/*
	t1��t2
	�첽���ģ�ͣ�t1�߳�ִ��t1�ģ�t2�߳�ִ��t2�ģ������߳�֮��˭Ҳ����˭
	ͬ�����ģ�ͣ�t1�̺߳�t2�߳�ִ�У���t1�̱߳����t2�߳�ִ�н���֮��t1�̲߳���ִ��,����ͬ�����ģ��
	
	ʲôʱ��Ҫͬ���أ�ΪʲôҪ�����߳�ͬ���أ�
		1.Ϊ�����ݵİ�ȫ������Ӧ�ó����ʹ���ʵͣ�����Ϊ�˱�֤�����ǰ�ȫ�ģ���������߳�ͬ������
			�߳�ͬ�������ǳ������ˣ���ͬ�����߳�
		2.ʲô������Ҫʹ���߳�ͬ����
			��һ�������Ƕ��̻߳���
			�ڶ������̻߳�������ͬһ������
			�����������������漰���޸Ĳ���
			
		���³�������̰߳�ȫ����
*/
public class ThreadTest12{
	public static void main(String[] args){
		Acount act=new Acount("act-001",5000);
		Processor p1=new Processor(act);
		Processor p2=new Processor(act);
		Thread t1=new Thread(p1);
		Thread t2=new Thread(p2);
		
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
		System.out.println("ȡ��1000.0�ɹ������Ϊ��"+act.getBalance());
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
		double after=balance-act;
		try{Thread.sleep(1000);}catch(Exception e){}
		setBalance(after);
	}
}