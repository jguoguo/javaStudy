package com.bjpowernode.hibernate;

import java.sql.Date;

import org.hibernate.Session;

import junit.framework.TestCase;

public class BaseMappingTest extends TestCase {
	public void testSave1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			User1 user=new User1();
			user.setName("����");
			user.setPassword("123");
			user.setCreateTime(new Date(new java.util.Date().getTime()));
			user.setExpireTime(new Date(new java.util.Date().getTime()));
			session.save(user);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	public void testSave2(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			User2 user=new User2();
			user.setName("����");
			user.setPassword("123");
			user.setCreateTime(new Date(new java.util.Date().getTime()));
			user.setExpireTime(new Date(new java.util.Date().getTime()));
			session.save(user);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
}
