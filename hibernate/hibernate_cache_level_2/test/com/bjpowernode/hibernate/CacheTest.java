package com.bjpowernode.hibernate;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Session;

import junit.framework.TestCase;


public class CacheTest extends TestCase {

	
	/**
	 * ������������
	 * ������session�з���load��ѯ
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

			//���ᷢ����ѯ��䣬��Ϊ�����˶������棬session���Թ�����������е�����
			//���������ǽ��̼��Ļ���
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
	 * ������������
	 * ������session�з���get��ѯ
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
			//���ᷢ����ѯ��䣬��Ϊ�����˶������棬session���Թ�����������е�����
			//���������ǽ��̼��Ļ���
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
	 * ������������
	 * ������session�з���load��ѯ������sessionFactory�����������
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
		//�����������
		//HibernateUtils.getSessionFactory().evict(Student.class);
		HibernateUtils.getSessionFactory().evict(Student.class,1);//�����������
		
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//�ᷢ����ѯ��䣬��Ϊ���������е����ݱ������
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
	 * ������������
	 * һ������Ͷ�������Ľ���
	 */
	public void testCache4(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//��ֹ��һ����������ݷŵ�����������
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

			//�ᷢ����ѯ��䣬��Ϊ��ֹ��һ������Ͷ�������Ľ���
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
	 * �������������
	 */
	public void testCache(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//��ֹһ������Ͷ������潻��
			session.setCacheMode(CacheMode.IGNORE);
			
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
