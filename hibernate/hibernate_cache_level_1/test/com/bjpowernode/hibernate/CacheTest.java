package com.bjpowernode.hibernate;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import junit.framework.TestCase;

public class CacheTest extends TestCase {
	
	/**
	 * ��ͬһ��session�з�������load��ѯ����ѯʵ��
	 */
	public void testLoad1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			Student student=(Student)session.load(Student.class, 1);
			System.out.println("student.name="+student.getName());
			//���ᷢ����ѯ��䣬loadʹ�û���
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
	 * ��ͬһ��session�з�������get��ѯ����ѯʵ��
	 */
	public void testLoad2(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			Student student=(Student)session.get(Student.class, 1);
			System.out.println("student.name="+student.getName());
			//���ᷢ����ѯ��䣬loadʹ�û���
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
	 * ��ͬһ��session�з�������iterator��ѯ����ѯʵ��
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
			//���ᷢ����ѯid����䣬�����ᷢ������id��ѯѧ������䣬��Ϊiteratorʹ�û���
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
	 * ��ͬһ��session�з�������iterator��ѯ����ѯ��ͨ����
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
			//iterator��ѯ��ͨ���ԣ�һ�����治�Ỻ�棬���Է�����ѯ���
			//һ�������ǻ���ʵ�����
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
	 * ������session�з���load��ѯ
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
			//�ᷢ����ѯ��䣬session�䲻�ܹ���һ����������
			//��Ϊ���������session������������
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
	 * ��ͬһ��session���ȵ���save���ٵ���load��ѯ�ո�save������
	 * save֧�ֻ��棬�����ڴ��д�һ��
	 */
	public void testLoad6(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			Student student=new Student();
			student.setName("����");
			Serializable id = session.save(student);
			student=(Student)session.load(Student.class, id);
			//���ᷢ����ѯ��䣬��Ϊsave֧�ֻ���
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
	 * �������������
	 */
	public void testLoad7(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			for(int i=0;i<100;i++){
				Student student=new Student();
				student.setName("����"+i);
				session.save(student);
				//ÿ20������һ�Σ������Ļ����治�����
				if(i % 20==0){
					session.flush();
					//������������
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
