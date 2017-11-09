package com.bjpowernode.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;

public class LazyForClassTest extends TestCase {
	public void testLoad1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			//���ᷢ��sql
			User user=(User)session.load(User.class, 1);
			//���ᷢ��sql
			System.out.println("user.id="+user.getId());
			//�ᷢ��sql
			System.out.println("user.name="+user.getName());
			///���ᷢ��sql
			System.out.println("user.password="+user.getPassword());
			
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
	
	public void testLoad2(){
		Session session=null;
		Transaction tx=null;
		User user=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			//���ᷢ��sql
			user=(User)session.load(User.class, 1);
			
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		//������ȷ������׳�LazyInitializationException�쳣
		//ԭ������session�Ѿ��ر�
		//hibernate��lazy���Ա�����session��״̬����Ч
		System.out.println("user.name="+user.getName());
	}
}
