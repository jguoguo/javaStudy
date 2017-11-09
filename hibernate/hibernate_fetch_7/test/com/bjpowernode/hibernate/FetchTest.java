package com.bjpowernode.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.bjpowernode.hibernate.Classes;
import com.bjpowernode.hibernate.HibernateUtils;
import com.bjpowernode.hibernate.Student;

import junit.framework.TestCase;

public class FetchTest extends TestCase {

	public void testFetch1() {
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			
			List classesList = session.createQuery("select c from Classes c").list();

			//´íÎó	
			//List classesList = session.createQuery("select c from Classes c join fetch c.students s").list();
			
			//ÕýÈ·
			//List classesList = session.createQuery("select s from Student s join fetch s.classes c").list();

			for (Iterator iter1=classesList.iterator(); iter1.hasNext();) {
				Classes classes = (Classes)iter1.next();
				System.out.println(classes.getName());
				for (Iterator iter=classes.getStudents().iterator(); iter.hasNext();) {
					Student student = (Student)iter.next();
					System.out.println(student.getName());
				}
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
