public class MyArrays{
	public static void main(String[] args){
		int[] a={1,3,4,5,7,8,9,10,23,25,29};
		int destElement=100;
		//Ҫ���a�����в���10���Ԫ�ص��±�
		int index=binarySearch(a,destElement);
		System.out.println((index==-1)?"������":destElement+"�������е��±�Ϊ:"+index);
	}
	//�۰���ҵĺ����㷨
	public static int binarySearch(int[] a,int destElement){
		int begin=0;
		int end=a.length-1;
		
		
		while(begin<=end){
			int mid=(begin+end)/2;
			if(a[mid]==destElement){
				return mid;
			}
			else if(a[mid]>destElement){
				end=mid-1;
			}
			else if(a[mid]<destElement){
				begin=mid+1;
			}	
		}
		return -1;
	}
}