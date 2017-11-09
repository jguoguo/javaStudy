package com.bjpowernode.pattern;

public class Client {
	public static void main(String[] args){
		UserManager userManager=new UserManagerImpl();
		userManager.addUser("0001", "ÕÅÈı");
	}
}
