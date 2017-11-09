package com.bjpowernode.pattern;

public class Client {
	public static void main(String[] args){
		//获取海尔的工厂
		TVFactory factory=new TVFactory4Haier();
		TV tv=factory.createTV();
		tv.turnOn();
	}
}
