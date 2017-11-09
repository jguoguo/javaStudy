package com.bjpowernode.hibernate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class InitData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtils.getSession();
			tx=session.beginTransaction();
			
			for(int i=0;i<10;i++){
				Classes classes=new Classes();
				classes.setName("班级"+i);
				session.save(classes);
				for(int j=0;j<10;j++){
					Student student=new Student();
					student.setName("班级"+i+"的学生"+j);
					student.setClasses(classes);
					session.save(student);
				}
				
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

	}
	
}
