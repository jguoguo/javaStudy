/*
	java�а��ֻ����������Ͷ�Ӧ�İ�װ����
		������������    ��װ����
		byte						java.lang.Byte
		short						java.lang.Short
		int							java.lang.Integer
		long						java.lang.long;
		float						java.lang.Float
		double					java.lang.Double
		boolean					java.lang.Boolean
		char						java.lang.Character
	
*/
public class IntegerTest01{
	//���󣺹涨m1�������Խ���java���κ�һ����������
	//m1������������byte���͵����ݣ����Խ�byte�����Ȱ�װ��java.lang.Byte,�ٴ�����
	public staitc void m1(Object o){
		System.out.println(o);
	}
	public static void main(String[] args){
		//������������
		byte b=10;
		//��������
		Byte b1=new Byte(b);
		m1(b1);
	}
}