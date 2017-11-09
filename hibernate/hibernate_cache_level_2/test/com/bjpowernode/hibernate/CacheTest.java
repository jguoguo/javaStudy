package com.bjpowernode.hibernate;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Session;

import junit.framework.TestCase;


public class CacheTest extends TestCase {

	
	/**
	 * 开启二级缓存
	 * 在两个session中发出load查询
	 */
	public void testCache1(){
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

			//不会发出查询语句，因为配置了二级缓存，session可以共享二级缓存中的数据
			//二级缓存是进程级的缓存
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
	 * 开启二级缓存
	 * 在两个session中发出get查询
	 */
	public void testCache2(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			Student student=(Student)session.get(Student.class, 1);
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
			//不会发出查询语句，因为配置了二级缓存，session可以共享二级缓存中的数据
			//二级缓存是进程级的缓存
			Student student=(Student)session.get(Student.class, 1);
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
	 * 开启二级缓存
	 * 在两个session中发出load查询，采用sessionFactory管理二级缓存
	 */
	public void testCache3(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			Student student=(Student)session.get(Student.class, 1);
			System.out.println("student.name="+student.getName());
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		//管理二级缓存
		//HibernateUtils.getSessionFactory().evict(Student.class);
		HibernateUtils.getSessionFactory().evict(Student.class,1);//清除二级缓存
		
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//会发出查询语句，因为二级缓存中的数据被清除了
			Student student=(Student)session.get(Student.class, 1);
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
	 * 开启二级缓存
	 * 一级缓存和二级缓存的交互
	 */
	public void testCache4(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//禁止将一级缓存的数据放到二级缓存中
			session.setCacheMode(CacheMode.IGNORE);
			Student student=(Student)session.get(Student.class, 1);
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

			//会发出查询语句，因为禁止了一级缓存和二级缓存的交互
			Student student=(Student)session.get(Student.class, 1);
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
	public void testCache(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//禁止一级缓存和二级缓存交互
			session.setCacheMode(CacheMode.IGNORE);
			
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
