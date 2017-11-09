package com.xlj.hibernate.test;

import java.util.List;

import org.hibernate.Session;

import com.xlj.hibernate.bean.Email;
import com.xlj.hibernate.bean.Person2;
import com.xlj.hibernate.util.HibernateSessionFactory;
import com.xlj.hibernate.util.HibernateUtil;

public class TestAnnotationPersonEamil {
	public static void main(String[] args){
		Person2 person=new Person2();
		person.setName("Jane");
		Email email=new Email();
		email.setEmail("yahoo@yahoo.com.cn");
		person.getEmails().add(email);//��ӵ�Person������
		
		email=new Email();
		email.setEmail("163@163.com");
		person.getEmails().add(email);
		
		Session session=HibernateUtil.getSessionFactory().openSession();//����һ��Hibernate�Ի�
		session.beginTransaction();//��ʼ����
		session.persist(person);//����Person���󣬻��Զ���������Email����
		
		List list=session.createQuery("select p from Person2 p left join fetch p.emails e "+
								"where e.email like '%@yahoo.com.cn' ").list();
		for(Person2 p:(List<Person2>)list){
			System.out.println("Person:"+p.getName());
			for(Email e:p.getEmails()){
				System.out.println("\tEmail:"+e.getEmail());
			}
		}
		session.delete(person);//ɾ��Person���󣬻��Զ�����ɾ����������Email��¼
		session.getTransaction().commit();
		session.close();
	}
}
