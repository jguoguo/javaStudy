/*

*/
public class ArrayTest03{
	public static void main(String[] args){
		Object[] objs=new Object[3];
		for(int index=0;index<objs.length;index++){
			Object o=objs[index];
			//o.toString();//ע���ָ���쳣����Ϊ�������͵�����Ĭ��ֵ��null
			System.out.println(o);
		}
	}
}