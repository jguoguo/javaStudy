/*
	Arrays��SUN�ṩ��һ��������
*/
import java.util.Arrays;
public class ArrayTest{
	public static void main(String[] args){
		int[] a={3,1,6,2,5};
		//����
		Arrays.sort(a);
		//���
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}	
	}	
}