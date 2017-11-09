package com.bjpowernode.spring.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjpowernode.spring.dao.UserDao;
import com.bjpowernode.spring.dao.UserDao4MySqlImpl;
import com.bjpowernode.spring.manager.UserManager;
import com.bjpowernode.spring.manager.UserManagerImpl;

public class Client {
	public static void main(String[] args){
		
		BeanFactory factory=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserManager userManager=(UserManager)factory.getBean("userManager");
		userManager.addUser("1","2");
	}
}
