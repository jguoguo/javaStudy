package com.bjpowernode.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;

public class InitData extends TestCase {
	public void testSave1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			Classes classes=new Classes();
			classes.setName("动力节点");
			session.save(classes);
			
			
			Student student1=new Student();
			student1.setName("张三");
			student1.setClasses(classes);
			session.save(student1);
			
			Student student2=new Student();
			student2.setName("李四");
			student2.setClasses(classes);
			session.save(student2);
			
			//可以成功保存数据
			//但是会发出多余的update语句来维持关系
			session.save(classes);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtils.closeSession(session);
		}
		
	}
}
