public class ArrayTest06{
	public static void main(String[] args){
		//��һ�ַ�ʽ
		int[] a={1,2,3,4};
		m1(a);
		//�ڶ��ַ���
		m1(new int[]{12,23,45,65});
	}
	public static void m1(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}
}