/*
	让SortedSet集合做到排序还有另一个方式
	单独编写一个比较器
*/
import java.util.*;
public class SortedSetTest03{
	public static void main(String[] args){
		SortedSet p=new TreeSet(new ProductCompare());
		Product p1 = new Product(3.4);
		Product p2 = new Product(4.0);
		Product p3 = new Product(3.0);
		Product p4 = new Product(2.0);
		Product p5 = new Product(5.0);
		
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		p.add(p5);
		
		Iterator i=p.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
}
class Product{
	double price;
	Product(double price){
		this.price=price;
	}
	public String toString(){
		return price+"";
	}
}
//单独编写一个比较器
class ProductCompare implements Comparator{
	public int compare(Object o1,Object o2){
		double price1=((Product)o1).price;
		double price2=((Product)o2).price;
		if(price1==price2){
			return 0;
		}else if(price1>price2){
			return 1;
		}else{
			return -1;
		}
		
	}
}