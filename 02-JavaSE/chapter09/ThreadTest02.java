/*
	��Java������ʵ�ֶ��̵߳ĵ�һ�ַ�ʽ��
		��һ�����̳�java.lang.Thread
		�ڶ�������дrun����
		
		����֪ʶ�㣺
			��ζ����̣߳�
			��δ����̣߳�
			��������̣߳�
*/
public class ThreadTest02{
	public static void main(String[] args){
		//�����߳�
		Thread t=new Processor();
		//����
		t.start();//��δ���ִ��˲�����������JVM�ٷ���һ���µ�ջ��t�߳�
							//run����Ҫ����Ա�ֶ����ã�ϵͳ�߳�����֮���Զ�����run����
		//t.run();//������ͨ�������ã�����������ֻ��һ���̣߳�run��������֮�����������ܼ���ִ��
		//��δ��������߳�������
		for(int i=0;i<10;i++){
			System.out.println("main-->"+i);
		}
		//���˶��߳�֮��main��������ֻ�����߳�ջ��û���˷���ջ֡��
		//���������̻߳�������ջ�л���ջ֡
		//main����������������ܻ�������
	}
}
class Processor extends Thread{
	public void run(){
		for(int i=0;i<30;i++){
			System.out.println("run-->"+i);
		}
	}
}