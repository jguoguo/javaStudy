/*
	java.util.Set;
		java.util.SortedSet:���򲻿��ظ������Ǵ��ȥ��Ԫ�ؿ��԰���Ԫ�ش�С˳���Զ�����
			java.util.TreeSet;
*/
import java.util.*;
import java.text.*;
public class SortedSetTest01{
	
	public static void main(String[] args) throws Exception {
		//��������
		SortedSet ss=new TreeSet();
		
		//���Ԫ��
		ss.add(10);
		ss.add(20);
		ss.add(15);
		ss.add(30);
		ss.add(25);
		ss.add(9);
		//����
		Iterator it=ss.iterator();
		while(it.hasNext()){
			Object element = it.next();
			System.out.println(element);
		}
		
		//String
		SortedSet str = new TreeSet();
		str.add("JACK");
		str.add("SUN");
		str.add("COOK");
		str.add("LUCY");
		str.add("KING");
		
		//����
		it=str.iterator();
		while(it.hasNext()){
			Object element = it.next();
			System.out.println(element);
		}
		
		//Date
		String str1="2008-08-08";
		String str2="2009-08-08";
		String str3="2008-09-08";
		String str4="2008-08-09";
		String str5="20012-08-08";
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date t1=sdf.parse(str1);
		Date t2=sdf.parse(str2);
		Date t3=sdf.parse(str3);
		Date t4=sdf.parse(str4);
		Date t5=sdf.parse(str5);
		
		SortedSet d1=new TreeSet();
		d1.add(t1);
		d1.add(t2);
		d1.add(t3);
		d1.add(t4);
		d1.add(t5);
				//����
		it=d1.iterator();
		while(it.hasNext()){
			Object element = it.next();
			if(element instanceof Date){
				Date d=(Date)element;
				System.out.println(sdf.format(d));
			}
		}
	}
}