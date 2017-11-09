package com.bjpowernode.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import junit.framework.TestCase;

/**
 * 连接查询
 * @author Administrator
 *
 */
public class JoinQueryTest extends TestCase {
	
	//内连接
	public void testQuery1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			List students=session.createQuery("select c.name,s.name from Student s join s.classes c")
						.list();
			for(Iterator itr=students.iterator();itr.hasNext();){
				Object[] obj=(Object[])itr.next();
				System.out.println(obj[0]+","+obj[1]);
			}
			session.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached状态
	}
	
	//外连接，左连接
	public void testQuery2(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();

			List students=session.createQuery("select c.name,s.name from Student s left join s.classes c")
					.list();
			for(Iterator itr=students.iterator();itr.hasNext();){
				Object[] obj=(Object[])itr.next();
				System.out.println(obj[0]+","+obj[1]);
			}
			session.getTransaction().commit();

		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached状态
	}
	
	//外连接，左连接
	public void testQuery3(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();

			List students=session.createQuery("select c.name,s.name from Student s right join s.classes c")
					.list();
			for(Iterator itr=students.iterator();itr.hasNext();){
				Object[] obj=(Object[])itr.next();
				System.out.println(obj[0]+","+obj[1]);
			}
			session.getTransaction().commit();

		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached状态
	}
}
