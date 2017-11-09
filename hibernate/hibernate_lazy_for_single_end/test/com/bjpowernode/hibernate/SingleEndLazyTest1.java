package com.bjpowernode.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;


/**
 * 保持默认
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
			//不会发出sql
			User user=(User)session.load(User.class, 1);
			//会发出sql
			System.out.println("user.name="+user.getName());
			//不会发出sql，只会使用代理
			Group group=user.getGroup();
			//会发出sql
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
		//detached状态
	}
}
