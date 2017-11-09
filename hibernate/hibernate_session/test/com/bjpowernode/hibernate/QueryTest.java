package com.bjpowernode.hibernate;

import java.util.Iterator;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;

import junit.framework.TestCase;

public class QueryTest extends TestCase {
	//查询所有数据
	public void testQuery1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			Query query=session.createQuery("from User");
			List userList=query.list();
			for(Iterator iter=userList.iterator();iter.hasNext();){
				User user=(User)iter.next();
				System.out.println("name="+user.getName());
			}
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	//分页查询
	public void testQuery2(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			Query query=session.createQuery("from User");
			query.setFirstResult(0);
			query.setMaxResults(2);
			List userList=query.list();
			for(Iterator iter=userList.iterator();iter.hasNext();){
				User user=(User)iter.next();
				System.out.println("name="+user.getName());
			}
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
}
