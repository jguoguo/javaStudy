package com.bjpowernode.pattern;

public class Client {
	public static void main(String[] args){
		//ȡ�ú����ĵ���
		TV tv=TVFactory.createTV(TVFactory.HAIER);
		tv.turnOn();
	}
}
