package com.bjpowernode.hibernate;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;

public class One2ManyTest extends TestCase {
	//���в��ɹ�
	public void testSave1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			Student student1=new Student();
			student1.setName("����");
			
			Student student2=new Student();
			student2.setName("����");
		
			Classes classes=new Classes();
			classes.setName("�����ڵ�");
			
			Set students=new HashSet();
			students.add(student1);
			students.add(student2);
			
			//�׳�TransientObjectException
			//��ΪStudent����Persistent״̬�Ķ�����Transient״̬�Ķ���
			session.save(classes);
			classes.setStudents(students);
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
	
	public void testSave2(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			Student student1=new Student();
			student1.setName("����");
			session.save(student1);
			
			Student student2=new Student();
			student2.setName("����");
			session.save(student2);
		
			Classes classes=new Classes();
			classes.setName("�����ڵ�");
			
			Set students=new HashSet();
			students.add(student1);
			students.add(student2);
			
			//���Գɹ���������
			//���ǻᷢ�������update�����ά�ֹ�ϵ
			session.save(classes);
			classes.setStudents(students);
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
	
	
	public void testLoad1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			Classes classes=(Classes)session.load(Classes.class, 1);
			System.out.println("classes.name="+classes.getName());
			Set students=classes.getStudents();
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
}
