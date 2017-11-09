package com.bjpowernode.hibernate;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.TestCase;

public class One2ManyTest extends TestCase {
	//运行不成功
	public void testSave1(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			Student student1=new Student();
			student1.setName("张三");
			
			Student student2=new Student();
			student2.setName("李四");
		
			Classes classes=new Classes();
			classes.setName("动力节点");
			
			Set students=new HashSet();
			students.add(student1);
			students.add(student2);
			
			//抛出TransientObjectException
			//因为Student不是Persistent状态的对象，是Transient状态的对象
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
		//detached状态
	}
	
	public void testSave2(){
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			Student student1=new Student();
			student1.setName("张三");
			session.save(student1);
			
			Student student2=new Student();
			student2.setName("李四");
			session.save(student2);
		
			Classes classes=new Classes();
			classes.setName("动力节点");
			
			Set students=new HashSet();
			students.add(student1);
			students.add(student2);
			
			//可以成功保存数据
			//但是会发出多余的update语句来维持关系
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
		//detached状态
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
		//detached状态
	}
}
