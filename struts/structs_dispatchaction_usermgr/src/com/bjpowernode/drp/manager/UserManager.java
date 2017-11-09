package com.bjpowernode.drp.manager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.bjpowernode.drp.DBUtil;
import com.bjpowernode.drp.dao.UserDao;
import com.bjpowernode.drp.dao.UserDaoFactory;
import com.bjpowernode.drp.model.User;

/**
 * 对用户完成增删改查的管理类，采用单例模式实现
 * @author Administrator
 *
 */
public class UserManager {
	private static UserManager instance=new UserManager();
	private UserDao userDao=null;
	private UserManager(){
		userDao=UserDaoFactory.getInstance().createUserDao();
	}
	public static UserManager getInstance(){
		return instance;
	}
	/**
	 * 增加用户
	 */
	public void addUser(User user){
		Connection conn=null;
		try{
			conn=DBUtil.getConn();
			userDao.addUser(conn, user);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn);
		}
	}
	/**
	 * 根据用户代码查询
	 * @param userId
	 * @return
	 */
	public User findUserById(String userId){
		User user=null;
		try{
			user=userDao.findUserById(userId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}
	/**
	 * 查找所有用户
	 * @return
	 */
	public List findAllUserList(){
		List userList=new ArrayList();
		try{
			userList=userDao.findAllUserList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return userList;
	}
	/**
	 * 根据UserId的集合进行删除
	 * @param userIdList
	 */
	public void deleteUsers(String[] userIdList){
		Connection conn=null;
		try{
			conn=DBUtil.getConn();
			userDao.deleteUsers(conn, userIdList);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn);
		}
	}
	
	public void modifyUser(User user){
		Connection conn=null;
		try{
			conn=DBUtil.getConn();
			userDao.modifyUser(conn, user);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.closeConn(conn);
		}
	}
}
