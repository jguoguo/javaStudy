package com.bjpowernode.drp.dao;

import java.sql.Connection;
import java.util.List;

import com.bjpowernode.drp.dao.impl.UserDao4MySqlImpl;
import com.bjpowernode.drp.model.User;
/**
 * �����࣬����̬װ��UserDao4MySqlImpl��
 *
 */
public class UserDaoFactory  {
	private static UserDaoFactory instance;
	private UserDao userDao;
	private UserDaoFactory(){
		//ע�⣺���Դ������ļ��ж�̬״̬UserDao4MySqlʵ����
		userDao=new UserDao4MySqlImpl();
	}
	public static synchronized UserDaoFactory getInstance(){
		if(instance == null){
			instance =new UserDaoFactory();
		}
		return instance;
	}
	/**
	 * ����UserDao����
	 */
	public UserDao createUserDao(){
		return userDao;
	}
}
