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
			classes.setName("�����ڵ�");
			session.save(classes);
			
			
			Student student1=new Student();
			student1.setName("����");
			student1.setClasses(classes);
			session.save(student1);
			
			Student student2=new Student();
			student2.setName("����");
			student2.setClasses(classes);
			session.save(student2);
			
			//���Գɹ���������
			//���ǻᷢ�������update�����ά�ֹ�ϵ
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
