package com.bjpowernode.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;


/**
 * 设置<many-to-one>上的lazy为false，其他不变
 * @author Administrator
 *
 */
public class SingleEndLazyTest2 extends TestCase {
	public void testLoad1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			//不会发出sql
			User user=(User)session.load(User.class, 1);
			//会发出两条sql，分别加载用户和组
			System.out.println("user.name="+user.getName());
			//不会发出sql
			Group group=user.getGroup();
			//不会发出sql
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
