import java.util.*;
import java.text.*;
public class TimerTest01{
	public static void main(String[] args) throws Exception{
		//1.创建定时器
		Timer t=new Timer();
		//2.指定定时任务
		LogTimer lt=new LogTimer();
		Date sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").parse("2015-01-27 22:42:00 00");
		t.schedule(lt,sdf,10*1000);
	}
}
class LogTimer extends TimerTask{
	public void run(){
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
	}
}