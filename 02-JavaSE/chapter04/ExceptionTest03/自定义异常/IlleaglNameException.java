/*
	�Զ��塰��Ч�����쳣��
	1.����ʱ�쳣��ֱ�Ӽ̳�Exception
	2.����ʱ�쳣��ֱ�Ӽ̳�RuntimeException
*/
public class IlleaglNameException extends Exception{
	//�����쳣һ���ṩ�������췽��
	public IlleaglNameException(){}
	public IlleaglNameException(String msg){
		super(msg);	
	}
}