package com.bjpowernode.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeanFactory factory=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserManager userManager=(UserManager)factory.getBean("userManager");
		userManager.delUser(123);
		userManager.findUserById(1);
	}

}
