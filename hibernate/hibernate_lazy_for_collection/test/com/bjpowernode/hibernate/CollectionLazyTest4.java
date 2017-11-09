package com.bjpowernode.hibernate;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;


/**
 * ��<class>��ǩ�ϵ�lazy��Ϊfalse,����Ĭ��
 * @author Administrator
 *
 */
public class CollectionLazyTest4 extends TestCase {
	
	
	public void testLoad1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			//�ᷢ��sql
			Classes classes=(Classes)session.load(Classes.class, 1);
			//���ᷢ��sql
			System.out.println("classes.name="+classes.getName());
			//���ᷢ��sql
			Set students=classes.getStudents();
			//�ᷢ��sql
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
		//detached״̬
	}
	
	
	public void testLoad2(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			//���ᷢ��sql
			Classes classes=(Classes)session.load(Classes.class, 1);
			//�ᷢ��sqL
			System.out.println("classes.name="+classes.getName());
			//���ᷢ��sql
			Set students=classes.getStudents();
			//�ᷢ��һ�����ܵ�sql,��select count(id) from t_student where classesid =?
			//���鼯���ϵ�lazy����Ϊextra
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
		//detached״̬
	}
}