package com.bjpowernode.hibernate;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;

public class SessionTest extends TestCase {
	//测试uuid主键生成策略
	public void testSave1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			//Transient状态
			User1 user=new User1();
			user.setName("李四");
			user.setPassword("123");
			user.setCreateTime(new Date(new java.util.Date().getTime()));
			user.setExpireTime(new Date(new java.util.Date().getTime()));
			session.save(user);
			
			session.flush();
			//提交事物
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached状态
	}
	//测试native主键生成策略
	public void testSave2(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();

			//Transient状态
			User2 user=new User2();
			user.setName("李四");
			user.setPassword("123");
			user.setCreateTime(new Date(new java.util.Date().getTime()));
			user.setExpireTime(new Date(new java.util.Date().getTime()));
			session.save(user);

			session.flush();
			//提交事物
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached状态
	}
	//测试uuid主键生成策略，生成失败，因为有逐出
	public void testSave3(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			//Transient状态
			User1 user=new User1();
			user.setName("王五");
			user.setPassword("123");
			user.setCreateTime(new Date(new java.util.Date().getTime()));
			user.setExpireTime(new Date(new java.util.Date().getTime()));
			session.save(user);
			//将user对象从session中逐出，即session的EntityEnties逐出
			session.evict(user);
			session.flush();
			//提交事物
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached状态
	}
	
	//测试uuid主键生成策略
	public void testSave4(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			//Transient状态
			User1 user=new User1();
			user.setName("王五");
			user.setPassword("123");
			user.setCreateTime(new Date(new java.util.Date().getTime()));
			user.setExpireTime(new Date(new java.util.Date().getTime()));
			session.save(user);
			
			session.flush();
			//将user对象从session中逐出，即session的EntityEnties逐出
			session.evict(user);
			
			//提交事物
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached状态
	}
	
	//测试native主键生成策略
	public void testSave5(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			//Transient状态
			User2 user=new User2();
			user.setName("张三111");
			user.setPassword("123");
			user.setCreateTime(new Date(new java.util.Date().getTime()));
			user.setExpireTime(new Date(new java.util.Date().getTime()));
			session.save(user);
			

			//将user对象从session中逐出，即session的EntityEnties逐出
			session.evict(user);
			
			//提交事物
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached状态
	}
	
	
	//测试assigned主键生成策略
	public void testSave6(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			//Transient状态
			User3 user=new User3();
			user.setId("001");
			user.setName("张三");
			
			session.save(user);
			
			user.setName("王五");
			session.update(user);
			
			User3 user3=new User3();
			user3.setId("002");
			user3.setName("李四");
			session.save(user3);
			
			//先执行两个insert
			//再执行update
			//提交事物
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached状态
	}
	
	//测试assigned主键生成策略
	public void testSave7(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			//Transient状态
			User3 user=new User3();
			user.setId("003");
			user.setName("张三");
			
			session.save(user);
			
			user.setName("王五");
			session.update(user);
			
			session.flush();
			
			User3 user3=new User3();
			user3.setId("004");
			user3.setName("李四");
			session.save(user3);
			
			//先执行两个insert
			//再执行update
			//提交事物
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached状态
	}
}
