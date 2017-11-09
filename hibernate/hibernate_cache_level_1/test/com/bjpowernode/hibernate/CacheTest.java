package com.bjpowernode.hibernate;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import junit.framework.TestCase;

public class CacheTest extends TestCase {
	
	/**
	 * 在同一个session中发出两次load查询，查询实体
	 */
	public void testLoad1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			Student student=(Student)session.load(Student.class, 1);
			System.out.println("student.name="+student.getName());
			//不会发出查询语句，load使用缓存
			student=(Student)session.load(Student.class, 1);
			System.out.println("student.name="+student.getName());
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	/**
	 * 在同一个session中发出两次get查询，查询实体
	 */
	public void testLoad2(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			Student student=(Student)session.get(Student.class, 1);
			System.out.println("student.name="+student.getName());
			//不会发出查询语句，load使用缓存
			student=(Student)session.get(Student.class, 1);
			System.out.println("student.name="+student.getName());
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	/**
	 * 在同一个session中发出两次iterator查询，查询实体
	 */
	public void testLoad3(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			Iterator iter=session.createQuery("from Student s where s.id<5").iterate();
			while(iter.hasNext()){
				Student student=(Student)iter.next();
				System.out.println("student.name="+student.getName());
			}
			
			System.out.println("-----------------------");
			//它会发出查询id的语句，但不会发出根据id查询学生的语句，因为iterator使用缓存
			iter=session.createQuery("from Student s where s.id<5").iterate();
			while(iter.hasNext()){
				Student student=(Student)iter.next();
				System.out.println("student.name="+student.getName());
			}
			
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	/**
	 * 在同一个session中发出两次iterator查询，查询普通属性
	 */
	public void testLoad4(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			Iterator iter=session.createQuery("select s.name from Student s where s.id<5").iterate();
			while(iter.hasNext()){
				String name=(String)iter.next();
				System.out.println("student.name="+name);
			}
			
			System.out.println("-----------------------");
			//iterator查询普通属性，一级缓存不会缓存，所以发出查询语句
			//一级缓存是缓存实体对象
			iter=session.createQuery("select s.name from Student s where s.id<5").iterate();
			while(iter.hasNext()){
				String name=(String)iter.next();
				System.out.println("student.name="+name);
			}
			
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	/**
	 * 在两个session中发出load查询
	 */
	public void testLoad5(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			Student student=(Student)session.load(Student.class, 1);
			System.out.println("student.name="+student.getName());
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//会发出查询语句，session间不能共享一级缓存数据
			//因为它会伴随着session的消亡而消亡
			Student student=(Student)session.load(Student.class, 1);
			System.out.println("student.name="+student.getName());
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	/**
	 * 在同一个session中先调用save，再调用load查询刚刚save的数据
	 * save支持缓存，会往内存中存一份
	 */
	public void testLoad6(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			Student student=new Student();
			student.setName("张三");
			Serializable id = session.save(student);
			student=(Student)session.load(Student.class, id);
			//不会发出查询语句，因为save支持缓存
			System.out.println("student.name="+student.getName());
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		
	}
	/**
	 * 大批量数据添加
	 */
	public void testLoad7(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			for(int i=0;i<100;i++){
				Student student=new Student();
				student.setName("张三"+i);
				session.save(student);
				//每20条更新一次，这样的话缓存不会溢出
				if(i % 20==0){
					session.flush();
					//清除缓存的内容
					session.clear();
				}
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
