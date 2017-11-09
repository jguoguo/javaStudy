public class ArrayTest06{
	public static void main(String[] args){
		//第一种方式
		int[] a={1,2,3,4};
		m1(a);
		//第二种方法
		m1(new int[]{12,23,45,65});
	}
	public static void m1(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}
}