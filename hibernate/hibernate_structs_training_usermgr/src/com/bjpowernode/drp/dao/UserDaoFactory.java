package com.bjpowernode.drp.dao;

import java.sql.Connection;
import java.util.List;

import com.bjpowernode.drp.dao.impl.UserDao4MySqlImpl;
import com.bjpowernode.drp.model.User;
/**
 * 工厂类，负责动态装载UserDao4MySqlImpl类
 *
 */
public class UserDaoFactory  {
	private static UserDaoFactory instance;
	private UserDao userDao;
	private UserDaoFactory(){
		//注意：可以从配置文件中动态状态UserDao4MySql实现类
		userDao=new UserDao4MySqlImpl();
	}
	public static synchronized UserDaoFactory getInstance(){
		if(instance == null){
			instance =new UserDaoFactory();
		}
		return instance;
	}
	/**
	 * 创建UserDao对象
	 */
	public UserDao createUserDao(){
		return userDao;
	}
}
