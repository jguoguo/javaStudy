package com.bjpowernode.hibernate;

import java.util.Iterator;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;

//�����Բ�ѯ
public class SimplePropertyQueryTest extends TestCase {
	public void testQuery1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//���ؽ���������б�Ԫ�����ͺ�ʵ�����е���������һ��
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
		//detached״̬
	}
	
	public void testQuery2(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//��ѯ������ԣ����ض������鼯��
			//����Ԫ�ص��������ѯ����������һ��
			//����ĳ�����select�в�ѯ�����Ը���һ��
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
		//detached״̬
	}
	
	//������Բ�ѯ������Student
	public void testQuery3(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//����ʹ��hql����Student
			//��Ҫ�ṩ���캯��
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
		//detached״̬
	}
	
	//����ʹ�ñ���
	public void testQuery4(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//����ʹ�ñ���
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
		//detached״̬
	}
	
	//����ʹ�ñ���
	public void testQuery5(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//���Բ���as��������
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
		//detached״̬
	}
}
