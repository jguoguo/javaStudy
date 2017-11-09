package com.bjpowernode.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import junit.framework.TestCase;

/**
 * ²éÑ¯¹ýÂËÆ÷
 * @author Administrator
 *
 */
public class FilterQueryTest extends TestCase {
	public void testQuery1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();

			session.enableFilter("testFilter")
						.setParameter("myid", 10);
			List students=session.createQuery("from Student").list();
			for(Iterator itr=students.iterator();itr.hasNext();){
				Student stu=(Student)itr.next();
				System.out.println(stu.getName());
			}
			session.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached×´Ì¬
	}
}
