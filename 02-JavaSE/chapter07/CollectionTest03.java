/*
	boolean contains(Object o);判断集合中是否包含某个元素
	boolean remove(Object 0);删除集合中某个元素
	存储在集合中的元素要重写equals方法
*/
import java.util.*;
public class CollectionTest03{
	public static void main(String[] args){
		//创建集合
		Collection c=new ArrayList();
		//创建两个Integer 类型的对象
		Integer i1=new Integer(10);
		//添加元素
		c.add(i1);
		//判断集合中是否包含i1
		System.out.println(c.contains(i1));
		
		//创建Integer类型的对象
		Integer i2=new Integer(10);
		//contains方法底层调用的是equals方法，如果equals返回true,就是包含
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
	//重写equals方法
	//需求规定:如果编号和姓名都相同则表示同一个manager
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