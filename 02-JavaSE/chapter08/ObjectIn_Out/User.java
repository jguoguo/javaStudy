/*
��ʶ�ӿڵ����ã��𵽱�ʶ������
JVM��������ö���ʵ����ĳ����ʶ�ӿڣ�������������
*/

import java.io.Serializable;//�ýӿ���һ���������л��ġ�
														//�ýӿ�û���κη�������һ����ʶ�ӿ�
														//�������Ľӿڻ��У�java.lang.Cloneable���ɿ�¡��

public class User implements Serializable{
	String name;
	User(String name){
		this.name=name;
	}
	public String toString(){
		return "Username["+name+"]";
	}
}

