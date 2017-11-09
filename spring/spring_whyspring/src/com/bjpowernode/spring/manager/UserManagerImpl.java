package com.bjpowernode.spring.manager;

import com.bjpowernode.spring.dao.UserDao;
import com.bjpowernode.spring.dao.UserDao4MySqlImpl;

public class UserManagerImpl implements UserManager {

	@Override
	public void addUser(String username, String password) {
		// TODO Auto-generated method stub
		//由我们的应用程序负责服务（对象）定位
		UserDao userDao=new UserDao4MySqlImpl();
		userDao.addUser(username, password);
	}

}
