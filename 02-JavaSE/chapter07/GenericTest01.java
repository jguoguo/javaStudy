/*
	����JDK 5.0�����ԣ����ͣ����������
	1.Ϊʲô���뷺�ͣ�
		1.����ͳһ�����е���������
		2.���Լ���ǿ������ת��
	2.�����﷨���ʵ�֣�
	3.���͵��ŵ��ȱ�㣿
		�ŵ㣺ͳһ���ͣ�����ǿ������ת��
		ȱ�㣺ֻ�ܴ洢һ������
		
	���³���û��ʹ�÷��ͣ�ȱ�㣿
		������ϲ�ʹ�÷��ͣ��򼯺��е�Ԫ�����Ͳ�ͳһ
		�ڱ������ϵ�ʱ��ֻ���ó���Object���ͣ���Ҫ��������ǿ������ת��
*/
import java.util.*;
public class GenericTest01{
	public static void main(String[] args){
		//����һ�����ϣ��洢A,B,C 
		Set s=new HashSet();
		A a=new A();
		B b=new B();
		C c=new C();
		
		s.add(a);
		s.add(b);
		s.add(c);
		Iterator it=s.iterator();
		while(it.hasNext()){
			Object o=it.next();
			if(o instancof A){
				A a1=(A)o;
				a1.m1();
			}else if(o instancof B){
				B b1=(B)o;
				b1.m1();
			}else 			if(o instancof C){
				C c1=(C)o;
				c1.m1();
			}
		}
	}
}
class A{
	public void m1(){
		System.out.println("A's m1...");
	}	
}
class B{
	public void m2(){
		System.out.println("B's m2...");
	}	
}
class C{
	public void m1(){
		System.out.println("C's m1...");
	}	
}