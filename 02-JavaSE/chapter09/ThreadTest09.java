/*
	�����ȷ�ĸ��õ���ֹһ������ִ�е��߳�
	�����߳�����5s֮����ֹ
*/
public class ThreadTest09{
	public static void main(String[] args)throws Exception{
		Processor p=new Processor();
		Thread t=new Thread(p);
		t.setName("t");
		t.start();
		Thread.sleep(5000);
		p.run=true;
	}
}
class Processor implements Runnable{
	public boolean run=false;
	public void run(){
		for(int i=0;i<10;i++){
			//System.out.println(run);
			if(run){
					System.out.println(Thread.currentThread().getName()+"--->"+i);
			}else{	
				try{
				Thread.sleep(1000);
				}catch(Exception e){
				}
			}
		}
	}
}