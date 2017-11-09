package com.bjpowernode.drp.dao;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Session;

import com.bjpowernode.drp.model.User;

/**
 * �û���ɾ�Ĳ�Dao��ӿ�
 * */
public interface UserDao {
	/**
	 * �����û�
	 * @param conn
	 * @param user
	 */
	public void addUser(Session session,User user);
	/**
	 * ����userId�ļ���ɾ���û�
	 * @param conn
	 * @param userList
	 */
	public void deleteUsers(Session session,String[] userList);
	/**
	 * �޸��û�
	 * @param conn
	 * @param user
	 */
	public void modifyUser(Session session,User user);
	/**
	 * �����û�Id��ѯ�û�
	 * @param userId
	 * @return
	 */
	public User findUserById(Session session,String userId);
	/**
	 * ���������û�
	 * @return
	 */
	public List findAllUserList(Session session);
}
