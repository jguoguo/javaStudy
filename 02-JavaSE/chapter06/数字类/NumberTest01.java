/*
	�������ָ�ʽ��:java.text.DecimalFormat;
	���ָ�ʽԪ�أ�
					#	��������
					,	ǧ��λ
					.	С����
					0	������0
*/

import java.text.DecimalFormat;
public class NumberTest01{
	public static void main(String[] args){
		//1.�������ָ�ʽ������
		//���󣺼���ǧ��λ
		DecimalFormat df=new DecimalFormat("###,###");
		
		//��ʼ��ʽ��
		//Number-->String
		System.out.println(df.format(123456));//"1,234,567"
		
		//���󣺼���ǧ��λ������2λС��
		DecimalFormat df1=new DecimalFormat("###,###.##");
		System.out.println(df1.format(12345123));
	}
}