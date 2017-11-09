package com.bjpowernode.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;

public class InitData extends TestCase {
	public void testSave1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			User user=new User();
			user.setName("ÕÅÈý");
			user.setPassword("123");
			user.setCreateTime(new Date());
			user.setExpireTime(new Date());
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
		//detached×´Ì¬
	}
}
