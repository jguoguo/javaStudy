package com.bjpowernode.hibernate;

import org.hibernate.Session;

import junit.framework.TestCase;

public class ClientTest extends TestCase {

//	public void testSave1() {
//		Session session = null;
//		try {
//			session = HibernateUtils.getSession();
//			session.beginTransaction();
//			
//			ClientLevel cl = (ClientLevel)session.load(ClientLevel.class, "c01");
//			Client c1 = new Client();
//			c1.setName("所有区域");
//			c1.setClientLevel(cl);
//			session.save(c1);
//
//			ClientLevel cl = new ClientLevel();
//			cl.setId("a01");
//			session.save(cl);
//			
//			
//			Client c2 = new Client();
//			c2.setName("东北区");
//			c2.setParent(c1);
//			c2.setClientLevel(cl);
//			session.save(c2);
//			
//			session.getTransaction().commit();
//		}catch(Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}finally {
//			HibernateUtils.closeSession(session);
//		}
//	}	
		
}
