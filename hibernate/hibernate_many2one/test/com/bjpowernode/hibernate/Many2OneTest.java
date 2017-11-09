package com.bjpowernode.hibernate;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;

public class Many2OneTest extends TestCase {
	//testSave1���л����
	public void testSave1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			Group group=new Group();
			group.setName("�����ڵ�");
			
			User user1=new User();
			user1.setName("����");
			user1.setGroup(group);
			
			User user2=new User();
			user2.setName("����");
			user2.setGroup(group);
			
			session.save(user1);
			session.save(user2);
			//��������ʱ��������TransientObjectException
			//��ΪGroupΪTransient״̬��û�б�session���������ݿ���û��ƥ�������
			//��UserΪPersistent״̬����������ʱhibernate�ڻ������޷��ҵ�Group����
			//���ۣ�Persistent״̬�Ķ���������Transient״̬�Ķ���
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
	
	//���Ա���ɹ�
	public void testSave2(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			Group group=new Group();
			group.setName("�����ڵ�");
			session.save(group);
			
			User user1=new User();
			user1.setName("����");
			user1.setGroup(group);
			
			User user2=new User();
			user2.setName("����");
			user2.setGroup(group);
			
			session.save(user1);
			session.save(user2);
			//������ȷ�ı�������
			//��ΪGroup��User����Persistent״̬�Ķ���
			//������hibernate������ʱ��session�п����ҵ���������
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
	
	//���Ա���ɹ�
	public void testSave3(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();

			Group group=new Group();
			group.setName("�����ڵ�");

			User user1=new User();
			user1.setName("����");
			user1.setGroup(group);

			User user2=new User();
			user2.setName("����");
			user2.setGroup(group);

			session.save(user1);
			session.save(user2);
			//����û���׳�TransientObjectException�쳣
			//��Ϊʹ���˼�������
			//hibernate�����ȱ���User�Ĺ�������Group
			//Group��User�Ͷ���Persistent����
			//��User.hbm.xml�����ӣ�cascade="save-update"
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
	
	
	public void testLoad1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();

			User user=(User)session.load(User.class, 3);
			System.out.println("user.name="+user.getName());
			System.out.println("user.group.name"+user.getGroup().getName());
			


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
