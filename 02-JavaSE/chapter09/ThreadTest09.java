/*
	如何正确的更好的终止一个正在执行的线程
	需求：线程启动5s之后终止
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