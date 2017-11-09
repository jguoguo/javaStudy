package com.bjpowernode.hibernate;

import org.hibernate.Session;

import com.bjpowernode.hibernate.Classes;
import com.bjpowernode.hibernate.HibernateUtils;
import com.bjpowernode.hibernate.Student;

import junit.framework.TestCase;

public class FetchTest extends TestCase {

	public void testFetch1() {
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			
			Student student = (Student)session.load(Student.class, 1);
			System.out.println("student.name=" + student.getName());
			
			Classes classes = student.getClasses();
			System.out.println("classes.name=" + classes.getName());
			
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			HibernateUtils.closeSession(session);
		}
	}
	
	
	public void testFetch2() {
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			
			Student student = (Student)session.get(Student.class, 1);
			System.out.println("student.name=" + student.getName());
			
			Classes classes = student.getClasses();
			System.out.println("classes.name=" + classes.getName());
			
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			HibernateUtils.closeSession(session);
		}
	}

	public void testFetch3() {
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			
			Student student = (Student)session.createQuery("select s from Student s join fetch s.classes where  s.id=1").list().get(0);
			//如果数据量比较大，会出现n+1问题
			//Student student = (Student)session.createQuery("select s from Student s join s.classes where  s.id=1").list().get(0);
			System.out.println("student.name=" + student.getName());
			
			Classes classes = student.getClasses();
			System.out.println("classes.name=" + classes.getName());
			
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			HibernateUtils.closeSession(session);
		}
	}
	
}
