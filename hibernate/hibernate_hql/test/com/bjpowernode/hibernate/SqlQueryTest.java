package com.bjpowernode.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import junit.framework.TestCase;

public class SqlQueryTest extends TestCase {
	public void testQuery1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			//可以采用拼字符串的方式传递参数
			List list=session.createSQLQuery("select * from t_student").list();
			for(Iterator itr=list.iterator();itr.hasNext();){
				Object[] obj=(Object[])itr.next();
				System.out.println(obj[0]+","+obj[1]);
			}
			session.getTransaction().commit();
			
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtils.closeSession(session);
		}
		//detached状态
	}
}
