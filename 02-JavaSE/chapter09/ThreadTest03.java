/*
	java��ʵ���̵߳ĵڶ��ַ�ʽ��
		��һ����дһ����ʵ��java.lang.Runnable�ӿ�
		�ڶ�����ʵ��run����
*/
public class ThreadTest03{
	public static void main(String[] args){
		//�����߳�
		Thread t=new Thread(new Processor());
		//����
		t.start();
	}
}
//���ַ�ʽ���Ƽ��ģ���Ϊһ����ʵ�ֽӿ�֮�Ᵽ������ļ̳�
class Processor implements Runnable{
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("run-->"+i);	
		}
	}
}