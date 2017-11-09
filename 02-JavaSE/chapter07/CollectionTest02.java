/*
	Iterator iterator();获取集合所依赖的迭代器对象
	通过迭代器中方法完成集合的迭代（遍历）
	注意：这种方式是所有集合通用的遍历方法
*/
import java.util.*;
public class CollectionTest02{
	public static void main(String[] args){
		//创建集合对象
		Collection c=new LinkedList();
		//添加元素
		c.add(100);
		c.add(3.14);
		c.add(false);
		
		//迭代、遍历
		//1.获取迭代器对象
		//不需要关心底层集合的具体类型，所有集合依赖的迭代器都实现了java.util.iterator接口
		//Iterator it=c.iterator();//迭代器是面向接口编程
															//it是引用，保存了内存地址，指向堆中的“迭代器对象”	
		//2.开始调用方法，
	//	while(it.hasNext()){
		//	Object element=it.next();
			//System.out.println(element);
		//}
		for(Iterator it=c.iterator();it.hasNext();){
			Object o=it.next();
			System.out.println(o);
		}	
	}
	
}