public class IntegerTest06{
	public static void main(String[] args){
		Integer i1=new Integer(10);
		Integer i2=new Integer(10);
		//���ﲻ�����Զ�����
		System.out.println(i1==i2);//false
		
		//�Ƚ�����Integer���͵������Ƿ���ȣ������á�==��
		//Integer�Ѿ���д��Object�е�equals����
		System.out.println(i1.equals(i2));//true;
		
		//�ص㣺
		Integer i3=128;
		Integer i4=128;
		//����ĵ�ͬ��
		//Integer i3=new Integer(128);
		//Integer i4=new Integer(128);
		System.out.println(i3==i4);//false
		
		//ע�����³���
		//�����������(-128~127)֮�䣬java��������һ�������ͳ�����"
		//�����ͳ�����ֻ�洢-128~127֮�������
		Integer i5=127;//������򲻻��ڶ��д������󣬻�ֱ�Ӵ����ͳ���������
		Integer i6=127;
		System.out.println(i5==i6);//true
		
		
		Integer i7=-128;
		Integer i8=-128;
		System.out.println(i7==i8);//true
		
		Integer i9=-129;
		Integer i10=-129;
		System.out.println(i9==i10);//false
	}
}