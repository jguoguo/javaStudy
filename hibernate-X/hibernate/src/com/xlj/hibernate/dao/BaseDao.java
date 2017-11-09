package com.xlj.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import com.xlj.hibernate.util.HibernateSessionFactory;
import com.xlj.hibernate.util.HibernateUtil;

public class BaseDao<T> {
	public void create(T object){
		Session session=HibernateUtil.getSessionFactory().openSession();//开启一个Hibernate会话
		try{
			session.beginTransaction();//开启事务
			session.persist(object);//将对象保存进数据库
			session.getTransaction().commit();//提交事务
		}catch(Exception e){
			session.getTransaction().rollback();//如果有异常抛出，则回滚事务
		}finally{
			session.close();//关闭Hibernate会话
		}
	}
	
	public void update(T object){//更新数据库
		Session session=HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();//开启事务
			session.update(object);//更新object对应的数据行
			session.getTransaction().commit();//提交事务
		}catch(Exception e){
			session.getTransaction().rollback();//如果有异常抛出，则回滚事务
		}finally{
			session.close();
		}
	}
	//从数据库中删除
	public void delete(T object){
		Session session=HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();//开启事务
			session.delete(object);//删除object对应的数据行
			session.getTransaction().commit();//提交事务
		}catch(Exception e){
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
	}
	
	/**
	 * 查找单个Entity Bean
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T find(Class<? extends T> clazz, Serializable id) {

		Session session = HibernateSessionFactory.getSessionFactory()
				.openSession();
		try {
			session.beginTransaction();
			return (T) session.get(clazz, id);
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<T> list(String hql){
		Session session=HibernateSessionFactory.getSessionFactory().openSession();
		try{
			session.beginTransaction();//开启事务
			return session.createQuery(hql).list();
		}finally{
			session.getTransaction().commit();//提交事务
			session.close();//关闭Hibernate会话
		}
	}
}
