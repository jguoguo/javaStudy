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
 * ���û������ɾ�Ĳ�Ĺ����࣬���õ���ģʽʵ��
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
	 * �����û�
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
	 * �����û������ѯ
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
	 * ���������û�
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
	 * ����UserId�ļ��Ͻ���ɾ��
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
