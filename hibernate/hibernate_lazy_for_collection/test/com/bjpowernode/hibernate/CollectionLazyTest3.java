package com.bjpowernode.hibernate;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;


/**
 * 将<set>标签上的lazy改为extra,其他默认
 * @author Administrator
 *
 */
public class CollectionLazyTest3 extends TestCase {
	
	
	public void testLoad1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			//不会发出sql
			Classes classes=(Classes)session.load(Classes.class, 1);
			//会发出sql
			System.out.println("classes.name="+classes.getName());
			//不会发出sql
			Set students=classes.getStudents();
			//会发出sql
			for(Iterator iter=students.iterator();iter.hasNext();){
				Student student=(Student)iter.next();
				System.out.println("student.name="+student.getName());
			}
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
	
	
	public void testLoad2(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			//不会发出sql
			Classes classes=(Classes)session.load(Classes.class, 1);
			//会发出sqL
			System.out.println("classes.name="+classes.getName());
			//不会发出sql
			Set students=classes.getStudents();
			//会发出一条智能的sql,如select count(id) from t_student where classesid =?
			//建议集合上的lazy设置为extra
			System.out.println("count="+students.size());
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
