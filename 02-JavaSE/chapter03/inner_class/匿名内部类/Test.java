/*
	�����ڲ��ָࣺ������û������
	
*/
public class Test{
	public static void t(CustomerService cs){
		cs.logout();
	}
	public static void main(String[] args){
		//����t����
		//t(new CustomerServiceImpl());
		
		//ʹ�������ڲ���ķ�ʽִ��t����
		t(new CustomerService(){
			public void logout(){
				System.out.println("qqqqq");	
			}
		//�����ڲ�����ŵ㣺�ٶ���һ����
		//ȱ�㣺�޷��ظ�ʹ�ã�
		});
	}
}
//�ӿ�
interface CustomerService{
	void logout();
}

//��дһ����ʵ��CustomerService�ӿ�
//class CustomerServiceImpl implements CustomerService{
//	public void logout(){
//		System.out.println("qqqqq");
//	}
//}