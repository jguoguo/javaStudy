package com.bjpowernode.drp.dao;

import java.sql.Connection;
import java.util.List;

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
	public void addUser(Connection conn,User user);
	/**
	 * ����userId�ļ���ɾ���û�
	 * @param conn
	 * @param userList
	 */
	public void deleteUsers(Connection conn,String[] userList);
	/**
	 * �޸��û�
	 * @param conn
	 * @param user
	 */
	public void modifyUser(Connection conn,User user);
	/**
	 * �����û�Id��ѯ�û�
	 * @param userId
	 * @return
	 */
	public User findUserById(String userId);
	/**
	 * ���������û�
	 * @return
	 */
	public List findAllUserList();
}
