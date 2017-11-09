import java.util.*;
public class CollectionTest01{
	public static void main(String[] args){
		//1.��������
		//����Collection�ǽӿڣ��޷�ֱ�Ӵ������󣬿��Դ�������
		Collection c=new ArrayList();//��̬
		//2.���Ԫ��
		c.add(1);//JDK5.0֮���Զ�װ��
		c.add(new Integer(100));
		
		Object o=new Object();
		c.add(o);//Collection����ֻ�ܵ����洢Ԫ�أ�����ֻ�ܴ洢��������
		
		Customer cus=new Customer("JACK",20);
		c.add(cus);
		System.out.println(c.isEmpty());
		//3.��ȡԪ�صĸ���
		System.out.println(c.size());
		
		//4.�����ת����Object���͵�����
		Object[] objs=c.toArray();
		for(int i=0;i<objs.length;i++){
			System.out.println(objs[i]);	
		}
		
		//5.���
		c.clear();
		System.out.println(c.size());
		System.out.println(c.isEmpty());
	}
}

class Customer{
	String name;
	int age;
	Customer(String name,int age){
		this.name=name;
		this.age=age;
	}
	//��дObject�е�toString����
	public String toString(){
		return "Customer[name="+name+"],[age="+age+"]";
	}
}