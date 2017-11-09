package com.bjpowernode.pattern;

public class Client {
	public static void main(String[] args){
		//取得海尔的电视
		TV tv=TVFactory.createTV(TVFactory.HAIER);
		tv.turnOn();
	}
}
