package com.bjpowernode.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;

public class ComponentTest extends TestCase {
	public void testSave1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			//建立User实体类
			User user=new User();
			user.setName("张三");
			//建立Contact值类，值类通常从属于实体类
			Contact userContact=new Contact();
			userContact.setEmail("email");
			userContact.setAddress("address");
			userContact.setZipCode("zipCode");
			userContact.setContactTel("contactTel");
			user.setUserContact(userContact);
			
			session.save(user);
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
	
	public void testLoad1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			User user=(User)session.load(User.class, 1);
			System.out.println(user.getName());
			System.out.println(user.getUserContact().getAddress());
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
