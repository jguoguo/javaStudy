/*
	����main�����еĲ����б�String[] args
	1.String[] args��ר���������������в�����
	2.���磺java ArrayTest07 abc def aaa
		JVM����ArrayTest07���main����֮ǰ��
		�Ƚ���abc def aaa������ַ����ԡ��ո񡱵ķ�ʽ�ָȻ��洢��String������
*/
public class ArrayTest07{
	public static void main(String[] args){
		//System.out.println("String���͵�������Ԫ�صĸ����ǣ�"+args.length);	
		//����˵�������и������ʱ������ṩ�û���������
		//��ʽ�� java ArrayTest07 username password
		//����û�û�������㹻�Ĳ��������˳�ϵͳ
		if(args.length!=2){
			System.out.println("Ҫ��ʹ�ø�ϵͳ�������������룺java ArrayTest07 username password");
		}else{
			//�����ṩ��ȷ������û�����admin,������123���½�ɹ�
			String username=args[0];
			String password=args[1];
			//�ַ����Ƚ���equals
			if("admin".equals(username) && "123".equals(password)){//���ַ������Ա����ָ���쳣
				System.out.println("��½�ɹ�����ӭ["+username+"]����");
			}
			else{
				System.out.println("��½ʧ��");
			}
		}

	}
}