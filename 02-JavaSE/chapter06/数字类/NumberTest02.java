/*
	java.math.BigDecimal
		�����;�ȷ�ȸߣ��ʺ����������
*/
import java.math.BigDecimal;
public class NumberTest02{
	public static void main(String[] args){
		//����BigDecimal����
		BigDecimal v1=new BigDecimal(10);
		BigDecimal v2=new BigDecimal(20);
		
		BigDecimal v3=v1.add(v2);
		System.out.println(v3);
	}
}