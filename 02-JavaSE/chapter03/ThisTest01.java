/*
   this �ؼ���
   1.this��ʲô��
   2.this��������Щ�ط���
*/
public class ThisTest01{
	
	public static void main(String[] args)
	{
		//��������
		MyDate t1=new MyDate(2014,11,25);
		System.out.println(t1.year+"��"+t1.month+"��"+t1.day+"��");
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