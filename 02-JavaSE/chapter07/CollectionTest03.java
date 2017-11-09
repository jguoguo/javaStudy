/*
	boolean contains(Object o);�жϼ������Ƿ����ĳ��Ԫ��
	boolean remove(Object 0);ɾ��������ĳ��Ԫ��
	�洢�ڼ����е�Ԫ��Ҫ��дequals����
*/
import java.util.*;
public class CollectionTest03{
	public static void main(String[] args){
		//��������
		Collection c=new ArrayList();
		//��������Integer ���͵Ķ���
		Integer i1=new Integer(10);
		//���Ԫ��
		c.add(i1);
		//�жϼ������Ƿ����i1
		System.out.println(c.contains(i1));
		
		//����Integer���͵Ķ���
		Integer i2=new Integer(10);
		//contains�����ײ���õ���equals���������equals����true,���ǰ���
		System.out.println(c.contains(i2));//true
		
		Manager m1=new Manager(100,"JACK");
		c.add(m1);
		System.out.println(c.contains(m1));//true
		
		Manager m2=new Manager(100,"JACK");
		c.add(m2);
		System.out.println(c.contains(m2));
	}
}
class Manager{
	int no;
	String name;
	Manager(int no,String name){
		this.no=no;
		this.name=name;
	}
	//��дequals����
	//����涨:�����ź���������ͬ���ʾͬһ��manager
	public boolean equals(Object o){
		if(this==o)return false;
		if(o instanceof Manager){
			Manager m=(Manager)o;
			if(m.no==this.no && m.name.equals(this.name)){
				return true;
			}
		}
		return false;
	}
}