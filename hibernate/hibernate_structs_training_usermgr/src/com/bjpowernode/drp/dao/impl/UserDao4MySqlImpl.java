package com.bjpowernode.drp.dao.impl;


import java.util.List;

import org.hibernate.Session;

import com.bjpowernode.drp.dao.UserDao;
import com.bjpowernode.drp.model.User;

/**
 * 用户增删改查Dao层MySql实现
 *
 */
public class UserDao4MySqlImpl implements UserDao {
	
	/**
	 * 增加用户
	 */
	@Override
	public void addUser(Session session, User user) {
		session.save(user);
	}

	/**
	 * 根据userId的集合删除用户
	 */
	@Override
	public void deleteUsers(Session session, String[] userList) {
		for(int i=0;i<userList.length;i++){
			User user=(User)session.load(User.class , userList[i]);
			session.delete(user);
		}
		
	}
	/**
	 * 修改用户信息
	 */
	@Override
	public void modifyUser(Session session, User user) {
		
		session.update(user);
	}

	
	/**
	 * 根据用户ID查找用户
	 */
	@Override
	public User findUserById(Session session,String userId) {
		
		return (User)session.get(User.class, userId);
	}
	/**
	 * 查找所有用户
	 */
	@Override
	public List findAllUserList(Session session) {
		return session.createQuery("from User").list();
	}
}
