package com.bjpowernode.spring.manager;

import com.bjpowernode.spring.dao.UserDao;
import com.bjpowernode.spring.dao.UserDao4MySqlImpl;

public class UserManagerImpl implements UserManager {
	private UserDao userDao;
	
	
//	public UserManagerImpl(UserDao userDao) {
//		this.userDao = userDao;
//	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}



	@Override
	public void addUser(String username, String password) {
		// TODO Auto-generated method stub
		//�����ǵ�Ӧ�ó�������񣨶��󣩶�λ
		userDao.addUser(username, password);
	}

}
