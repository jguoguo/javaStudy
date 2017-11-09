/*
	set集合：HashSet
	
	1.HashSet底层实际上是HashMap,HashMap底层采用了哈希表数据结构。
	2.哈希表又叫散列表，哈希表底层是一个数组，这个数组中每一个元素是一个单向链表。
		每个单向链表都有一个独一无二的hash值，代表数组的下标。在某个单向链表中的每
		节点上的hash值是相等的。hash值实际上是key调用hashCode方法，在通过“hash function”转换成的值
	3.如何向哈希表中添加元素：
		先调用被存储的key的hashCode方法，经过某个算法得出hash值，如果在
		这个哈希表中不存在这个hash值，则直接加入元素，如果该hash值已经
		存在，继续调用key之间的equals方法，如果equals方法返回false,则将
		该元素添加，如果equals方法返回true，则放弃添加该元素
	4.HashSet其实是HashMap中的key部分。HashSet有什么特点，HashMap中的key应该具有相同的特点
	5.HashMap和HashSet初始容量都是16，默认加载因子是0.75
*/
import java.util.*;
public class SetTest01{
	public static void main(String[] args){
		//创建Set集合
		Set s=new HashSet();
		//无序不可重复
		s.add(1);
		s.add(1);
		
		s.add(100);
		s.add(85);
		s.add(88);
		//遍历
		Iterator it=s.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}