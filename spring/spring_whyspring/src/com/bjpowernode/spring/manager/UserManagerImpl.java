package com.bjpowernode.spring.manager;

import com.bjpowernode.spring.dao.UserDao;
import com.bjpowernode.spring.dao.UserDao4MySqlImpl;

public class UserManagerImpl implements UserManager {

	@Override
	public void addUser(String username, String password) {
		// TODO Auto-generated method stub
		//�����ǵ�Ӧ�ó�������񣨶��󣩶�λ
		UserDao userDao=new UserDao4MySqlImpl();
		userDao.addUser(username, password);
	}

}
