package com.bjpowernode.hibernate;

import java.util.Iterator;

import org.hibernate.Session;

import junit.framework.TestCase;

public class AreaTest extends TestCase {

	public void testSave1() {
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			Area a1 = new Area();
			a1.setName("所有区域");
			session.save(a1);
			
			Area a2 = new Area();
			a2.setName("东北区");
			a2.setParent(a1);
			session.save(a2);

			Area a21 = new Area();
			a21.setName("吉林省");
			a21.setParent(a2);
			session.save(a21);

			Area a22 = new Area();
			a22.setName("黑龙江省");
			a22.setParent(a2);
			session.save(a22);

			Area a23 = new Area();
			a23.setName("辽宁省");
			a23.setParent(a2);
			session.save(a23);
			
			Area a3 = new Area();
			a3.setName("华北区");
			a3.setParent(a1);
			session.save(a3);
			
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			HibernateUtils.closeSession(session);
		}
	}
	
	public void testShowArea() {
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			Area area = (Area)session.load(Area.class, 2);
			testShowArea(area);
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			HibernateUtils.closeSession(session);
		}
	}
	
	private void testShowArea(Area area) {
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			System.out.println(area.getName());
			for (Iterator iter=area.getChildren().iterator(); iter.hasNext();) {
				Area child = (Area)iter.next();
				//递归调用
				testShowArea(child);
			}
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			HibernateUtils.closeSession(session);
		}		
	}
}
