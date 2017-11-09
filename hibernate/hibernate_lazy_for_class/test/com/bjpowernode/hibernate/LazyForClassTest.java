package com.bjpowernode.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;

public class LazyForClassTest extends TestCase {
	public void testLoad1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			//不会发出sql
			User user=(User)session.load(User.class, 1);
			//不会发出sql
			System.out.println("user.id="+user.getId());
			//会发出sql
			System.out.println("user.name="+user.getName());
			///不会发出sql
			System.out.println("user.password="+user.getPassword());
			
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
	
	public void testLoad2(){
		Session session=null;
		Transaction tx=null;
		User user=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			//不会发出sql
			user=(User)session.load(User.class, 1);
			
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//不能正确输出，抛出LazyInitializationException异常
		//原因在于session已经关闭
		//hibernate的lazy策略必须在session打开状态下有效
		System.out.println("user.name="+user.getName());
	}
}
