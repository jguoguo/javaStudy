package com.bjpowernode.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import junit.framework.TestCase;

/**
 * 实体对象查询
 * @author Administrator
 *
 */
public class SimpleObjectQueryTest1 extends TestCase {
	
	public void testQuery1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//返回Student对象的集合
			//可以忽略select关键字
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
		//detached状态
	}
	
	public void testQuery2(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//返回Student对象的集合
			//可以忽略select关键字，可以加别名
			List students=session.createQuery("from Student s").list();
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
		//detached状态
	}
	
	public void testQuery3(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//返回Student对象的集合
			//可以忽略select关键字，可以采用as命名别名
			List students=session.createQuery("from Student as s").list();
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
		//detached状态
	}
	
	public void testQuery4(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//返回Student对象的集合
			//如果使用select查询实体对象，必须使用别名
			List students=session.createQuery("select s from Student s").list();
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
		//detached状态
	}
	
	public void testQuery5(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//不支持select * from，这种语法
			List students=session.createQuery("select * from Student s").list();
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
		//detached状态
	}
	
}
