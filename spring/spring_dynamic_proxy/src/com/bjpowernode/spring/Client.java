package com.bjpowernode.spring;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecurityHandle hander=new SecurityHandle();
		//���ɴ���
		UserManager userManager=(UserManager)hander.createProxyInstance(new UserManagerImpl());
		userManager.addUser("����", "123");
	}

}
