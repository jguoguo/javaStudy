package com.bjpowernode.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.bjpowernode.hibernate.HibernateUtils;
import com.bjpowernode.hibernate.Student;

import junit.framework.TestCase;

public class FetchTest extends TestCase {

	public void testFetch1() {
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			
			List students = session.createQuery("select s from Student s  where s.id in(:ids)")
						.setParameterList("ids", new Object[]{1, 11, 21, 31, 41, 51, 61, 71, 81, 91})
						.list();
			
			//可以使用fetch预抓取Classes，解决N+1问题
			//
			//Hibernate: select student0_.id as id1_0_, classes1_.id as id0_1_, 
			//student0_.name as name1_0_, student0_.classesid as classesid1_0_, classes1_.name as name0_1_ 
			//from t_student student0_ inner join t_classes classes1_ on student0_.classesid=classes1_.id 
			//where student0_.id in (? , ? , ? , ? , ? , ? , ? , ? , ? , ?)
//			List students = session.createQuery("select s from Student s join fetch s.classes  where s.id in(:ids)")
//			.setParameterList("ids", new Object[]{1, 11, 21, 31, 41, 51, 61, 71, 81, 91})
//			.list();
			
			for (Iterator iter=students.iterator(); iter.hasNext();) {
				Student student = (Student)iter.next();
				System.out.println(student.getName());
				System.out.println(student.getClasses().getName());
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
