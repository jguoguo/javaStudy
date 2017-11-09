/*

*/
public class ArrayTest03{
	public static void main(String[] args){
		Object[] objs=new Object[3];
		for(int index=0;index<objs.length;index++){
			Object o=objs[index];
			//o.toString();//注意空指针异常，因为引用类型的数组默认值是null
			System.out.println(o);
		}
	}
}