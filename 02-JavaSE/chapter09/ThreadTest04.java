/*
	��������
			1.��ȡ��ǰ�̶߳���Thread.currentThread();
			2.���߳�����t.setName();
			3.��ȡ�̵߳�����t.getName();
*/
public class ThreadTest04{
	public static void main(String[] args){
		//��λ�ȡ��ǰ�̶߳���
		Thread t=Thread.currentThread();
		//��ȡ�߳�����
		System.out.println(t.getName());
		
		Thread t1=new Thread(new Processor());
		//���߳�����
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