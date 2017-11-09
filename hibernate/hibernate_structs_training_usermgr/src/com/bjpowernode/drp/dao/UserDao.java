package com.bjpowernode.drp.dao;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Session;

import com.bjpowernode.drp.model.User;

/**
 * 用户增删改查Dao层接口
 * */
public interface UserDao {
	/**
	 * 增加用户
	 * @param conn
	 * @param user
	 */
	public void addUser(Session session,User user);
	/**
	 * 根据userId的集合删除用户
	 * @param conn
	 * @param userList
	 */
	public void deleteUsers(Session session,String[] userList);
	/**
	 * 修改用户
	 * @param conn
	 * @param user
	 */
	public void modifyUser(Session session,User user);
	/**
	 * 根据用户Id查询用户
	 * @param userId
	 * @return
	 */
	public User findUserById(Session session,String userId);
	/**
	 * 查找所有用户
	 * @return
	 */
	public List findAllUserList(Session session);
}
