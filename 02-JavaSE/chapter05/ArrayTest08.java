/*
	关于数组的拷贝
*/

public class ArrayTest08{
	public static void main(String[] args){
		int[] src={2,3,4,5,6};
		int[] dest={10,11,12,13,14,15,16};
		System.arraycopy(src,2,dest,3,3);
		for(int i=0;i<dest.length;i++){
			System.out.println(dest[i]);
		}
	}
}