/*
	��java.lang.Integer;����Ϊ��
*/
public class IntegerTest02{
	public static void main(String[] args){
		//��ȡint���͵����ֵ����Сֵ
		System.out.println("int��Сֵ��"+Integer.MIN_VALUE);
		System.out.println("int���ֵ��"+Integer.MAX_VALUE);
		
		//����Integer���͵Ķ���
		Integer i1=new Integer(10);
		Integer i2=new Integer("123");
		System.out.println(i1);	
		System.out.println(i2);
	}
}