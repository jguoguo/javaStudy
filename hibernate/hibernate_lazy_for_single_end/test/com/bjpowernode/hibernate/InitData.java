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
			group.setName("动力节点");
			session.save(group);
			
			User user1=new User();
			user1.setName("张三");
			user1.setGroup(group);
			
			User user2=new User();
			user2.setName("李四");
			user2.setGroup(group);
			
			session.save(user1);
			session.save(user2);
			//可以正确的保存数据
			//因为Group和User都是Persistent状态的对象
			//所以在hibernate清理缓存时在session中可以找到关联对象
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
