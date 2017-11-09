package com.bjpowernode.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import junit.framework.TestCase;
/**
 * 对象导航查询
 * @author Administrator
 *
 */
public class ObjectNavQueryTest extends TestCase {
	public void testQuery1(){
		Session session=null;
		try{
			session=HibernateUtils.getSession();
			session.beginTransaction();
			
			List students=session.createQuery("from Student s where s.classes.name like '班级2'")
						.list();
			for(Iterator itr=students.iterator();itr.hasNext();){
				Student stu=(Student)itr.next();
				System.out.println(stu.getName());
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
