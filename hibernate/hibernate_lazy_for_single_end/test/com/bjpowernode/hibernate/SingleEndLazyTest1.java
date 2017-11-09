package com.bjpowernode.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;


/**
 * ����Ĭ��
 * @author Administrator
 *
 */
public class SingleEndLazyTest1 extends TestCase {
	public void testLoad1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			//���ᷢ��sql
			User user=(User)session.load(User.class, 1);
			//�ᷢ��sql
			System.out.println("user.name="+user.getName());
			//���ᷢ��sql��ֻ��ʹ�ô���
			Group group=user.getGroup();
			//�ᷢ��sql
			System.out.println("user.group.name="+group.getName());
			


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
