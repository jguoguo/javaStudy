package com.bjpowernode.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import junit.framework.TestCase;

public class SimpleObjectQueryTest2 extends TestCase {
	public void testQuery1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();

			//采用list查询实体对象会发出一条查询语句，取得实体对象数据
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
			/**
			 * 迭代会出现n+1问题，所谓的n+1指的是发出了N+1条sql语句
			 * 1:发出一条查询id列表的语句
			 * 
			 * N:根据id发出N条sql语句，加载相关的对象
			 * Hibernate: select student0_.id as id0_0_, student0_.name as name0_0_, 
			 * student0_.createDate as createDate0_0_, student0_.classesid as classesid0_0_ 
			 * from t_student student0_ where student0_.id=?无业游民0
			 * 
			 */
			Iterator itr=session.createQuery("from Student").iterate();
			while(itr.hasNext()){
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
			//采用list查询实体对象会发出一条查询语句，取得实体对象数据
			List students=session.createQuery("from Student").list();
			for(Iterator itr=students.iterator();itr.hasNext();){
				Student stu=(Student)itr.next();
				System.out.println(stu.getName());
			}
			System.out.println("---------------------------------");
			/**
			 * 避免了n+1问题
			 * 因为执行list操作后，会将数据放到session的缓存中（一级缓存），所以采用Iterator的时候
			 * 首先会发出一条查询id列表的语句，再根据id到缓存中加载相应的数据，如果缓存中存在与之匹配的数据
			 * 则不再发出根据id查询的sql语句，直接使用缓存中的数据
			 * 
			 * Iterator方法如果缓存中存在数据，它可以提高性能，否则出现N+1问题
			 */
			Iterator itr=session.createQuery("from Student").iterate();
			while(itr.hasNext()){
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
			//采用list查询实体对象会发出一条查询语句，取得实体对象数据
			List students=session.createQuery("from Student").list();
			for(Iterator itr=students.iterator();itr.hasNext();){
				Student stu=(Student)itr.next();
				System.out.println(stu.getName());
			}
			System.out.println("---------------------------------");
			/**
			 * 在默认情况下，每次执行list查询实体对象都会发出查询语句，除非配置了查询缓存
			 * 虽然一级缓存(session)中存在数据，但list不用，所以仍然发出查询语句
			 * 
			 * 其实list就是只向缓存中放入数据，而不利用缓存中的数据
			 */
			students=session.createQuery("from Student").list();
			for(Iterator itr=students.iterator();itr.hasNext();){
				Student stu=(Student)itr.next();
				System.out.println(stu.getName());
			}
			System.out.println("---------------------------------");
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
