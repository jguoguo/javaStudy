import java.util.*;
public class CollectionTest01{
	public static void main(String[] args){
		//1.创建集合
		//由于Collection是接口，无法直接创建对象，可以创建子类
		Collection c=new ArrayList();//多态
		//2.添加元素
		c.add(1);//JDK5.0之后，自动装箱
		c.add(new Integer(100));
		
		Object o=new Object();
		c.add(o);//Collection集合只能单个存储元素，并且只能存储引用类型
		
		Customer cus=new Customer("JACK",20);
		c.add(cus);
		System.out.println(c.isEmpty());
		//3.获取元素的个数
		System.out.println(c.size());
		
		//4.将结合转换成Object类型的数组
		Object[] objs=c.toArray();
		for(int i=0;i<objs.length;i++){
			System.out.println(objs[i]);	
		}
		
		//5.清空
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
	//重写Object中的toString方法
	public String toString(){
		return "Customer[name="+name+"],[age="+age+"]";
	}
}