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
		person.getEmails().add(email);//添加到Person对象中
		
		email=new Email();
		email.setEmail("163@163.com");
		person.getEmails().add(email);
		
		Session session=HibernateUtil.getSessionFactory().openSession();//开启一个Hibernate对话
		session.beginTransaction();//开始事务
		session.persist(person);//保存Person对象，会自动级联保存Email对象
		
		List list=session.createQuery("select p from Person2 p left join fetch p.emails e "+
								"where e.email like '%@yahoo.com.cn' ").list();
		for(Person2 p:(List<Person2>)list){
			System.out.println("Person:"+p.getName());
			for(Email e:p.getEmails()){
				System.out.println("\tEmail:"+e.getEmail());
			}
		}
		session.delete(person);//删除Person对象，会自动级联删除属于它的Email记录
		session.getTransaction().commit();
		session.close();
	}
}
