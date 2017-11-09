package com.bjpowernode.usermgr.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bjpowernode.usermgr.dao.UserDao;
import com.bjpowernode.usermgr.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	public void add(User user) {
		getHibernateTemplate().save(user);
		
	}

}
