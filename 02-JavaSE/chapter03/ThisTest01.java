/*
   this 关键字
   1.this是什么？
   2.this能用在哪些地方？
*/
public class ThisTest01{
	
	public static void main(String[] args)
	{
		//创建对象
		MyDate t1=new MyDate(2014,11,25);
		System.out.println(t1.year+"年"+t1.month+"月"+t1.day+"日");
	}
	
}
class MyDate
{
	int year;
	int month;
	int day;
	
	//Constructor
	MyDate(){}
	MyDate(int _year,int _month,int _day)
	{
		year=_year;
		month=_month;
		day=_day;
	}
}