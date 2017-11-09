/*
	SortedSet集合使用泛型
*/
import java.util.*;
public class GenericTest04{
	public static void main(String[] args){
		SortedSet<Manager> ss=new TreeSet<Manager>();
		
		Manager m1=new Manager(1000.0);
		Manager m2=new Manager(1500.0);
		Manager m3=new Manager(1300.0);
		ss.add(m1);
		ss.add(m2);
		ss.add(m3);
		Iterator<Manager> it =ss.iterator();
		while(it.hasNext()){
			Manager m=it.next();
			m.work();
		}
	}
}
class Manager implements Comparable<Manager>{
	double sal;
	Manager(double sal){
		this.sal=sal;	
	}
	public String toString(){
		return sal+"";
	}
	public void work(){
		System.out.println("工作，工资"+sal+"月");
	}
	public int compareTo(Manager m){
		double sall1=this.sal;
		double sall2=m.sal;
		if(sall1>sall2){
			return 1;
		}else if(sall1<sall2){
			return -1;
		}
		return 0;
	}
}
