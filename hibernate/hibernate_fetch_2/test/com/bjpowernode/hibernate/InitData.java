package com.bjpowernode.hibernate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;

import com.bjpowernode.hibernate.Classes;
import com.bjpowernode.hibernate.HibernateUtils;
import com.bjpowernode.hibernate.Student;

public class InitData {

	public static void main(String[] args) {
			Session session = HibernateUtils.getSession();

			try {
				session.beginTransaction();

				for(int i=0; i<10; i++){
				
					Classes classes = new Classes();
					classes.setName("�༶"+i);
					session.save(classes);
					
					for(int j=0; j<10; j++){
						Student student = new Student();
						student.setName("�༶"+i+"��ѧ��"+j);
						
						//���ڴ��н�����studentָ��classes������
						student.setClasses(classes);
						session.save(student);
					}
				}
				session.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			} finally{
				HibernateUtils.closeSession(session);
			}
		}	
		
}
