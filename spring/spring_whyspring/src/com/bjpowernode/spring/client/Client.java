package com.bjpowernode.spring.client;

import com.bjpowernode.spring.dao.UserDao;
import com.bjpowernode.spring.dao.UserDao4MySqlImpl;
import com.bjpowernode.spring.manager.UserManager;
import com.bjpowernode.spring.manager.UserManagerImpl;

public class Client {
	public static void main(String[] args){
		//�����ǵ�Ӧ�ó�������񣨶��󣩶�λ
		UserManager usermanager=new UserManagerImpl();
		usermanager.addUser("1", "2");
	}
}
