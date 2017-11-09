package com.bjpowernode.drp.manager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.bjpowernode.drp.HibernateUtils;
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
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			userDao.addUser(session, user);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	/**
	 * 根据用户代码查询
	 * @param userId
	 * @return
	 */
	public User findUserById(String userId){
		User user=null;
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			user=userDao.findUserById(session,userId);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		return user;
	}
	/**
	 * 查找所有用户
	 * @return
	 */
	public List findAllUserList(){
		List userList=new ArrayList();
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			userList=userDao.findAllUserList(session);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		return userList;
	}
	/**
	 * 根据UserId的集合进行删除
	 * @param userIdList
	 */
	public void deleteUsers(String[] userIdList){
		Connection conn=null;
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			userDao.deleteUsers(session, userIdList);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	public void modifyUser(User user){
		Connection conn=null;
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			userDao.modifyUser(session, user);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
}
