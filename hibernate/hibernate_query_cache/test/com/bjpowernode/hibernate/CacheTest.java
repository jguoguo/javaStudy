package com.bjpowernode.hibernate;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Session;

import junit.framework.TestCase;


public class CacheTest extends TestCase {

	
	/**
	 * 开启查询缓存，关闭二级缓存，采用query.list()查询普通属性
	 * 在一个session中发出query.list()查询
	 */
	public void testCache1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			List names=session.createQuery("select s.name from Student s")
						.setCacheable(true)
						.list();
			for(int i=0;i<names.size();i++){
				String name=(String)names.get(i);
				System.out.println(name);
			}
			System.out.println("---------------------------");
			//不会发出查询语句，因为启用查询缓存
			names=session.createQuery("select s.name from Student s")
					.setCacheable(true)
					.list();
			for(int i=0;i<names.size();i++){
				String name=(String)names.get(i);
				System.out.println(name);
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
	 * 开启查询缓存，关闭二级缓存，采用query.list()查询普通属性
	 * 在两个session中发出query.list()查询
	 */
	public void testCache2(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			List names=session.createQuery("select s.name from Student s")
						.setCacheable(true)
						.list();
			for(int i=0;i<names.size();i++){
				String name=(String)names.get(i);
				System.out.println(name);
			}
			
			
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		System.out.println("---------------------------");
		
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//不会发出查询语句，因为查询缓存和session的生命周期没有关系
			List names=session.createQuery("select s.name from Student s")
						.setCacheable(true)
						.list();
			for(int i=0;i<names.size();i++){
				String name=(String)names.get(i);
				System.out.println(name);
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
	 * 开启查询缓存，关闭二级缓存，采用query.iterator()查询普通属性
	 * 在两个session中发出query.iterator()查询
	 */
	public void testCache3(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			Iterator iter=session.createQuery("select s.name from Student s")
						.setCacheable(true)
						.iterate();
			while(iter.hasNext()){
				String name=(String)iter.next();
				System.out.println(name);
			}
			
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		System.out.println("---------------------------");
		
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//会发出查询语句，query.iterate查询普通属性不会使用查询缓存
			//查询缓存只对query.list()起作用
			Iterator iter=session.createQuery("select s.name from Student s")
						.setCacheable(true)
						.iterate();
			while(iter.hasNext()){
				String name=(String)iter.next();
				System.out.println(name);
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
	 * 关闭查询缓存，关闭二级缓存，采用query.list()查询普通属性
	 * 在两个session中发出query.list()查询
	 */
	public void testCache4(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			List students=session.createQuery("select s from Student s")
						.list();
			for(int i=0;i<students.size();i++){
				Student student=(Student)students.get(i);
				System.out.println(student.getName());
			}
			
			
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		System.out.println("---------------------------");
		
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			//会发出查询语句，默认query.list()每次执行都会发出查询语句
			List students=session.createQuery("select s from Student s")
							.list();
			for(int i=0;i<students.size();i++){
				Student student=(Student)students.get(i);
				System.out.println(student.getName());
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
	 * 开启查询缓存，关闭二级缓存，采用query.list()查询普通属性
	 * 在两个session中发出query.list()查询
	 */
	public void testCache5(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			List students=session.createQuery("select s from Student s")
						.setCacheable(true)
						.list();
			for(int i=0;i<students.size();i++){
				Student student=(Student)students.get(i);
				System.out.println(student.getName());
			}
			
			
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		System.out.println("---------------------------");
		
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			//会发出n条查询语句，因为开启了查询缓存，关闭了二级缓存，那么查询缓存就会缓存实体对象的id
			//第二次执行query.list(),将查询缓存中的id依次取出，分别到一级缓存、二级缓存中查找相应的实体对象
			//如果存在就使用缓存中的实体对象，否则根据id发出查询学生的语句
			List students=session.createQuery("select s from Student s")
						.setCacheable(true)
						.list();
			for(int i=0;i<students.size();i++){
				Student student=(Student)students.get(i);
				System.out.println(student.getName());
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
	 * 开启查询缓存，开启二级缓存，采用query.list()查询普通属性
	 * 在两个session中发出query.list()查询
	 */
	public void testCache6(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			List students=session.createQuery("select s from Student s")
						.setCacheable(true)
						.list();
			for(int i=0;i<students.size();i++){
				Student student=(Student)students.get(i);
				System.out.println(student.getName());
			}
			
			
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		System.out.println("---------------------------");
		
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//不再发出查询语句，因为配置了二级缓存和查询缓存
			List students=session.createQuery("select s from Student s")
						.setCacheable(true)
						.list();
			for(int i=0;i<students.size();i++){
				Student student=(Student)students.get(i);
				System.out.println(student.getName());
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
