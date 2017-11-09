/*
	注意：存储在Map集合key部分的元素同时重写hashCode和equals方法
*/
import java.util.*;
public class MapTest01{
	public static void main(String[] args){
		//1.创建Map集合
		Map persons=new HashMap();//HashMap的默认初始化容量为16，默认加载因子是0.75
		//存储键值对
		persons.put("10000","JACK");
		persons.put("10001","JACK");
		persons.put("10002","SUN");
		persons.put("10003","KING");
		persons.put("10004","JACK");
		persons.put("10000","LUCY");
		//3.判断键值对的个数
		//Map中的key是无序不可重复的，和HashSet相同
		System.out.println(persons.size());
		//4.判断集合中是否包含这样的key
		System.out.println(persons.containsKey("10000"));
		//5.判断集合中是否包含这样的Value
		//注意：Map中如果key重复了，value采用的是“覆盖”
		System.out.println(persons.containsValue("LUCY"));
		
		//6.通过key获取value
		String k="10001";
		Object value=persons.get(k);
		System.out.println(value);
		
		//7.通过key删除键值对
		persons.remove("10000");
		System.out.println(persons.size());
		
		//8.获取所有的value
		Collection values=persons.values();
		Iterator it =values.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		//9.获取所有的Key
		//以下程序演示遍历Map集合
		Set keys=persons.keySet();
		Iterator it2=keys.iterator();
		
		while(it2.hasNext()){
			Object id=it2.next();
			Object name=persons.get(id);
			System.out.println(id+"-->"+name);
		}
		
		//10.entrySet
		//将Map转换成set集合
		Set entrySet=persons.entrySet();
		Iterator it3=entrySet.iterator();
		while(it3.hasNext()){
			System.out.println(it3.next());
		}
	}
}