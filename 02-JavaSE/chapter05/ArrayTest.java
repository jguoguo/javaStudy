/*
	Arrays是SUN提供的一个工具类
*/
import java.util.Arrays;
public class ArrayTest{
	public static void main(String[] args){
		int[] a={3,1,6,2,5};
		//排序
		Arrays.sort(a);
		//输出
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}	
	}	
}