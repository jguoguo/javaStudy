//2.泛型语法如何实现
//泛型是一个编译阶段的语法
//在编译阶段统一集合中的类型
import java.util.*;
public class GenericTest02{
	public static void main(String[] args){
		//创建一个List集合，只能存储字符串类型
		List<String> strs=new ArrayList<String>();
		//添加元素
		strs.add("JACK");
		strs.add("SUN");
		strs.add("KING");
		strs.add("SMITH");
		
		//遍历
		Iterator<String> it=strs.iterator();
		while(it.hasNext()){
			String s=it.next();
			System.out.println(s);
		}
	}
}