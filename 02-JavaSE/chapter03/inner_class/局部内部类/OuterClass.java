public class OuterClass{
	//����
	public void m1(){
		//�ֲ�����
		final int i=10;
		
		class InnerClass{
			//�ڲ��಻���о�̬����
			//��Ա����
			public void m2(){
				System.out.println(i);
			}
		}
		
		//����m2
		InnerClass inner=new InnerClass();
		inner.m2();
	}
	
	//���
	public static void main(String[] args){
		OuterClass oc =new OuterClass();
		oc.m1();
	}
}