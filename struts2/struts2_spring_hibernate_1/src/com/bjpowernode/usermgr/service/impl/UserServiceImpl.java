package com.bjpowernode.usermgr.service.impl;

import com.bjpowernode.usermgr.dao.UserDao;
import com.bjpowernode.usermgr.domain.User;
import com.bjpowernode.usermgr.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void add(User user) {
		userDao.add(user);
	}

}
