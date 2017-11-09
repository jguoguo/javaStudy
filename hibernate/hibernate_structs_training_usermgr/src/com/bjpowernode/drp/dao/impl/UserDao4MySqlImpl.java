package com.bjpowernode.drp.dao.impl;


import java.util.List;

import org.hibernate.Session;

import com.bjpowernode.drp.dao.UserDao;
import com.bjpowernode.drp.model.User;

/**
 * �û���ɾ�Ĳ�Dao��MySqlʵ��
 *
 */
public class UserDao4MySqlImpl implements UserDao {
	
	/**
	 * �����û�
	 */
	@Override
	public void addUser(Session session, User user) {
		session.save(user);
	}

	/**
	 * ����userId�ļ���ɾ���û�
	 */
	@Override
	public void deleteUsers(Session session, String[] userList) {
		for(int i=0;i<userList.length;i++){
			User user=(User)session.load(User.class , userList[i]);
			session.delete(user);
		}
		
	}
	/**
	 * �޸��û���Ϣ
	 */
	@Override
	public void modifyUser(Session session, User user) {
		
		session.update(user);
	}

	
	/**
	 * �����û�ID�����û�
	 */
	@Override
	public User findUserById(Session session,String userId) {
		
		return (User)session.get(User.class, userId);
	}
	/**
	 * ���������û�
	 */
	@Override
	public List findAllUserList(Session session) {
		return session.createQuery("from User").list();
	}
}
