/*
	��ȡ��1970��1��1��  00ʱ00��00�� 000����  ����ǰ�ĺ�����
	
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
		//1.���������ڸ�ʽ����
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss:SSS");
		//2.��ʼ��ʽ��
		String strTime=sdf.format(nowTime);
		System.out.println(strTime);
		
		String sTime="2008��08��08�� 08:08:08:000";
		//��String����ת������������Date
		//1.�������ڸ�ʽ������
		SimpleDateFormat ssdf=new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss:SSS");
		//2.���ַ���ת������������
		Date t=ssdf.parse(sTime);
		System.out.println(t);
		
		//��ȡϵͳ��ǰ����
		Calendar c=Calendar.getInstance();
		//�鿴��ǰ�����ġ����ڼ���
		int i=c.get(Calendar.DAY_OF_WEEK);
		System.out.println(i);
	}	
}