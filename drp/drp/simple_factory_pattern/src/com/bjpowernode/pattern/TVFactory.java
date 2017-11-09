package com.bjpowernode.pattern;

//���ù�������Ʒ����ϸ������
//������Ʒ�����ı䲻��Կͻ����Ӱ��
public class TVFactory {
	public static final String HAIER="����";
	public static final String ChangHong="����";
	public static TV createTV(String type){
		TV tv=null;
		if(HAIER.equals(type)){
			tv=new HaierTV();
		}else if(ChangHong.equals(type)){
			tv=new ChangHongTV();
		}else{
			throw new RuntimeException("�޷�����!");
		}
		return tv;
	}
}
