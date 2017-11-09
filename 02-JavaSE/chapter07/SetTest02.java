/*
	������Set�����д洢��Ԫ�أ���Ԫ�ص�hashCode��equals����
	HashMap����һ��put������put(key,value)key�����򲻿��ظ���
	���ۣ��洢��HashSet���ϻ���HashMap����Key���ֵ�Ԫ�أ���Ҫͬʱ����HashCode��equals����
*/
import java.util.*;
public class SetTest02{
	public static void main(String[] args){
		//��������
		Set es=new HashSet();
		Employee e1=new Employee("1000","JACK");
		Employee e2=new Employee("1001","KING");
		Employee e3=new Employee("2000","SCOTT");
		Employee e4=new Employee("2001","SUN");
		Employee e5=new Employee("3000","JIM");
		Employee e6=new Employee("3001","COOK");
		
		//���Ԫ��
		es.add(e1);
		es.add(e2);
		es.add(e3);
		es.add(e4);
		es.add(e5);
		es.add(e6);
		
		System.out.println(es.size());
	}
}
//������ʵ��ҵ���߼���֪���ù�˾Ա������ǣ�1000 -9999
class Employee{
	//���
	String no;
	//����
	String name;
	Employee(String no,String name){
		this.no=no;
		this.name=name;
	}
	//��дequals����
	//���Ա����ź�������ͬ����Ϊͬһ������
	public boolean equals(Object o){
		if(this==o){
			return true;
		}
		if(o instanceof Employee){
			Employee e=(Employee)o;
			if(e.no.equals(this.no) && e.name.equals(this.name)){
				return true;
			}
		}
		return false;
	}
	//��дHashCode����
	public int hashCode(){
		//��Ա����ŷ���
		return no.hashCode9();	
	}
}