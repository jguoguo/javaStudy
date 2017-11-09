package com.bjpowernode.hibernate;

import java.util.Iterator;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;

//简单属性查询
public class SimplePropertyQueryTest extends TestCase {
	public void testQuery1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//返回结果集属性列表，元素类型和实体类中的属性类型一致
			List list=session.createQuery("select name from Student").list();
			for(Iterator itr=list.iterator();itr.hasNext();){
				String name=(String)itr.next();
				System.out.println(name);
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
			//查询多个属性，返回对象数组集合
			//数组元素的类型与查询的属性类型一致
			//数组的长度与select中查询的属性个数一致
			List list=session.createQuery("select id,name from Student").list();
			for(Iterator itr=list.iterator();itr.hasNext();){
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
	
	//多个属性查询，返回Student
	public void testQuery3(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//可以使用hql返回Student
			//需要提供构造函数
			List students=session.createQuery("select new Student(id,name) from Student").list();
			for(Iterator itr=students.iterator();itr.hasNext();){
				Student student=(Student)itr.next();
				System.out.println(student.getId()+","+student.getName());
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
	
	//可以使用别名
	public void testQuery4(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//可以使用别名
			List students=session.createQuery("select s.id,s.name from Student s").list();
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
	
	//可以使用别名
	public void testQuery5(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//可以采用as命名别名
			List students=session.createQuery("select s.id,s.name from Student as s").list();
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
