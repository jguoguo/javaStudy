package com.bjpowernode.pattern;

public class Client {
	public static void main(String[] args){
		//��ȡ�����Ĺ���
		TVFactory factory=new TVFactory4Haier();
		TV tv=factory.createTV();
		tv.turnOn();
	}
}
