/*
	关于JDK 5.0新特性：泛型（编译器概念）
	1.为什么引入泛型？
		1.可以统一集合中的数据类型
		2.可以减少强制类型转换
	2.泛型语法如何实现？
	3.泛型的优点和缺点？
		优点：统一类型，减少强制类型转换
		缺点：只能存储一种类型
		
	以下程序没有使用泛型，缺点？
		如果集合不使用泛型，则集合中的元素类型不统一
		在遍历集合的时候，只能拿出来Object类型，需要做大量的强制类型转换
*/
import java.util.*;
public class GenericTest01{
	public static void main(String[] args){
		//创建一个集合，存储A,B,C 
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