package com.bjpowernode.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class InitData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
	}

}
