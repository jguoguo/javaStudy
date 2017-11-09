package com.bjpowernode.hibernate;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;

public class SessionTest extends TestCase {
	public void testSave1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			//Transient״̬
			User user=new User();
			user.setName("����");
			user.setPassword("123");
			user.setCreateTime(new Date(new java.util.Date().getTime()));
			user.setExpireTime(new Date(new java.util.Date().getTime()));
			
			//Persistent״̬
			//Persistent״̬�Ķ��󣬵���������Է����仯ʱ
			//hibernate�������棨�����ݼ��)��ʱ�򣬻�����ݿ�ͬ��
			session.save(user);
			user.setName("����");
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
	
	
	public void testSave2(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			//Transient״̬
			User user=new User();
			user.setName("����");
			user.setPassword("123");
			user.setCreateTime(new Date(new java.util.Date().getTime()));
			user.setExpireTime(new Date(new java.util.Date().getTime()));
			
			//Persistent״̬
			//Persistent״̬�Ķ��󣬵���������Է����仯ʱ
			//hibernate�������棨�����ݼ��)��ʱ�򣬻�����ݿ�ͬ��
			session.save(user);
			user.setName("����");
			//������ʾ�ĵ���updata��������Ϊ��ʱΪ�־�״̬������updateû������
			session.update(user);
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
	
	
	public void testSave3(){
		Session session=null;
		Transaction tx=null;
		User user=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			//Transient״̬
			user=new User();
			user.setName("����");
			user.setPassword("123");
			user.setCreateTime(new Date(new java.util.Date().getTime()));
			user.setExpireTime(new Date(new java.util.Date().getTime()));
			
			//Persistent״̬
			//Persistent״̬�Ķ��󣬵���������Է����仯ʱ
			//hibernate�������棨�����ݼ��)��ʱ�򣬻�����ݿ�ͬ��
			session.save(user);
			user.setName("����");
			//������ʾ�ĵ���updata��������Ϊ��ʱΪ�־�״̬������updateû������
			session.update(user);
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
		user.setName("����");
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//��detached״̬�Ķ�����������session����
			//��ʱ����Ϊpersistent״̬�Ķ���
			//persistent״̬�Ķ�����������ʱ�������ݿ�ͬ����
			session.update(user);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	public void testGet1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//get���������Ķ���Ϊ�־ö���
			//ִ��get�����Ϸ�����ѯ���
			User user=(User)session.get(User.class, "402840814c8d8947014c8d8948830001");
			System.out.println(user.getName());
			user.setName("����");
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	public void testGet2(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//get�����������ݣ���������ڷ���null
			User user=(User)session.get(User.class, "402840814c8d8947014c8d8948830001");
			System.out.println(user.getName());
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	//���ڶ��󣬿��Բ�ѯ������
	public void testload1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//�������Ϸ�����ѯ��䣬��Ϊload֧��lazy(�ӳټ���)
			//ʲô��lazy?ֻ������ʹ����������ʱ���ٴ���
			//����hibernate��˵���������ķ�����ѯ��䣬��Ҫ��Ϊ��������ܣ�lazy��hibernate�зǳ���Ҫ������
			//hibernate��lazy�����ʵ�ֵģ����ô��������Ҫ���õ���CGLIB��
			//������JDK�Ķ�̬������ΪJDK�Ķ�̬����ֻ�ܶ�ʵ���˽ӿڵ�����������CGLIB���Զ������ɴ���
			//�����õ��Ǽ̳з�ʽ
			User user=(User)session.load(User.class, "402840814c8d8947014c8d8948830001");
			System.out.println(user.getName());
			user.setName("����");
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	//��Ҫ���ҵĶ��������ݿ���û�У����׳��쳣
	public void testload2(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//����Load��ѯ���������ݣ�hibernate���׳�ObjectNotFoundException�쳣
			User user=(User)session.load(User.class, "404c8d8947014c8d8948830001");
			System.out.println(user.getName());
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	
	public void testDelete1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			User user=(User)session.load(User.class, "402840814c8d76dc014c8d76dd740001");
			//ɾ����������ô��ַ�ʽɾ�����ȼ��أ���ɾ��
			session.delete(user);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	public void testDelete2(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//�ֶ�����Detached����
			User user=new User();
			user.setId("402840814c8d8947014c8d8948830001");
			session.delete(user);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	
	public void testUpdate1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//�ֶ�����Detached����
			User user=new User();
			user.setId("402840814c8d8947014c8d8948830001");
			user.setName("����");
			session.update(user);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
	
	public void testUpdate2(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//������ô��ַ�ʽ���ȼ��أ��ٸ���
			User user=(User)session.load(User.class, "402840814c8d8947014c8d8948830001");
			user.setName("����");
			//������ʾ��update
			session.update(user);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtils.closeSession(session);
		}
	}
}
