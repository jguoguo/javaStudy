//�˿���ص�ҵ��
public class CustomerService{
	//�����ṩһ��ע��ķ���
	public void register(String name) throws IlleaglNameException{
		if(name.length()<6){
			//�ֶ��׳��쳣
			throw new IlleaglNameException("�û������Ȳ�������6");
		}
			//���������ִ�е��˴���֤���û����ǺϷ���
		System.out.println("ע��ɹ���");
	}

	
}