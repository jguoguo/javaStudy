/*
	����Integer�г��õķ���
	
*/
public class IntegerTest03{
	public static void main(String[] args){
		//int-->Integer
		//������������-->��������
		Integer i1=new Integer(10);
		
		//��Integer-->int 
		int i2=i1.intValue();
		System.out.println(i2+1);
		
		//��Ҫ��static int pareInt(String s)
		int age=Integer.parseInt("25");
		System.out.println(age+1);
		
		//��Ҫ��static double parseDouble(String s)
		double price=Double.parseDouble("3.0");
		System.out.println(price+1.0);
		
		//��int���͵�ʮ����ת����2����
		String s1=Integer.toBinaryString(10);
		System.out.println(s1);
		//��int���͵�ʮ����ת����16����
		String s2=Integer.toHexString(10);
		System.out.println(s2);
		//��int���͵�ʮ����ת����8����
		String s3=Integer.toOctalString(10);
		System.out.println(s3);
		
		
	}
}