package com.bjpowernode.hibernate;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;

public class SessionTest extends TestCase {
	//����uuid�������ɲ���
	public void testSave1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			//Transient״̬
			User1 user=new User1();
			user.setName("����");
			user.setPassword("123");
			user.setCreateTime(new Date(new java.util.Date().getTime()));
			user.setExpireTime(new Date(new java.util.Date().getTime()));
			session.save(user);
			
			session.flush();
			//�ύ����
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached״̬
	}
	//����native�������ɲ���
	public void testSave2(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();

			//Transient״̬
			User2 user=new User2();
			user.setName("����");
			user.setPassword("123");
			user.setCreateTime(new Date(new java.util.Date().getTime()));
			user.setExpireTime(new Date(new java.util.Date().getTime()));
			session.save(user);

			session.flush();
			//�ύ����
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached״̬
	}
	//����uuid�������ɲ��ԣ�����ʧ�ܣ���Ϊ�����
	public void testSave3(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			//Transient״̬
			User1 user=new User1();
			user.setName("����");
			user.setPassword("123");
			user.setCreateTime(new Date(new java.util.Date().getTime()));
			user.setExpireTime(new Date(new java.util.Date().getTime()));
			session.save(user);
			//��user�����session���������session��EntityEnties���
			session.evict(user);
			session.flush();
			//�ύ����
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached״̬
	}
	
	//����uuid�������ɲ���
	public void testSave4(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			//Transient״̬
			User1 user=new User1();
			user.setName("����");
			user.setPassword("123");
			user.setCreateTime(new Date(new java.util.Date().getTime()));
			user.setExpireTime(new Date(new java.util.Date().getTime()));
			session.save(user);
			
			session.flush();
			//��user�����session���������session��EntityEnties���
			session.evict(user);
			
			//�ύ����
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached״̬
	}
	
	//����native�������ɲ���
	public void testSave5(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			//Transient״̬
			User2 user=new User2();
			user.setName("����111");
			user.setPassword("123");
			user.setCreateTime(new Date(new java.util.Date().getTime()));
			user.setExpireTime(new Date(new java.util.Date().getTime()));
			session.save(user);
			

			//��user�����session���������session��EntityEnties���
			session.evict(user);
			
			//�ύ����
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached״̬
	}
	
	
	//����assigned�������ɲ���
	public void testSave6(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			//Transient״̬
			User3 user=new User3();
			user.setId("001");
			user.setName("����");
			
			session.save(user);
			
			user.setName("����");
			session.update(user);
			
			User3 user3=new User3();
			user3.setId("002");
			user3.setName("����");
			session.save(user3);
			
			//��ִ������insert
			//��ִ��update
			//�ύ����
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached״̬
	}
	
	//����assigned�������ɲ���
	public void testSave7(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			//Transient״̬
			User3 user=new User3();
			user.setId("003");
			user.setName("����");
			
			session.save(user);
			
			user.setName("����");
			session.update(user);
			
			session.flush();
			
			User3 user3=new User3();
			user3.setId("004");
			user3.setName("����");
			session.save(user3);
			
			//��ִ������insert
			//��ִ��update
			//�ύ����
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached״̬
	}
}
