package com.bjpowernode.spring.client;

import com.bjpowernode.spring.dao.UserDao;
import com.bjpowernode.spring.dao.UserDao4MySqlImpl;
import com.bjpowernode.spring.manager.UserManager;
import com.bjpowernode.spring.manager.UserManagerImpl;

public class Client {
	public static void main(String[] args){
		//由我们的应用程序负责服务（对象）定位
		UserManager usermanager=new UserManagerImpl();
		usermanager.addUser("1", "2");
	}
}
