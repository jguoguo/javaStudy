/*
	获取自1970年1月1日  00时00分00秒 000毫秒  到当前的毫秒数
	
*/
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class DateTest01{
	public static void main(String[] args) throws Exception{
		long now=System.currentTimeMillis();
		System.out.println(now);
		Date nowTime=new Date();
		System.out.println(nowTime);
		//1.创建化日期格式对象
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss:SSS");
		//2.开始格式化
		String strTime=sdf.format(nowTime);
		System.out.println(strTime);
		
		String sTime="2008年08月08日 08:08:08:000";
		//将String日期转换成日期类型Date
		//1.创建日期格式化对象
		SimpleDateFormat ssdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss:SSS");
		//2.将字符串转换成日期类型
		Date t=ssdf.parse(sTime);
		System.out.println(t);
		
		//获取系统当前日历
		Calendar c=Calendar.getInstance();
		//查看当前日历的“星期几”
		int i=c.get(Calendar.DAY_OF_WEEK);
		System.out.println(i);
	}	
}