package com.xlj.hibernate.test;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import com.xlj.hibernate.bean.Email;
import com.xlj.hibernate.bean.Person2;
import com.xlj.hibernate.util.HibernateSessionFactory;

public class TestLazyInitializationException {
	static int createdId=0;
	
	static{//类加载的时候保存一个Person
		Person2 person=new Person2();
		person.setName("Jane");
		
		Email email=new Email();
		email.setEmail("yahoo@yahoo.com.cn");
		person.getEmails().add(email);
		
		Session session=HibernateSessionFactory.getSession();//开始会话
		session.beginTransaction();//开启事务
		
		session.persist(person);
		createdId=person.getId();
		session.getTransaction().commit();//提交事务
		session.close();
	}
	
	public static void main(String[] args){
		Session session=HibernateSessionFactory.getSession();//只查询不用开启事务
		Person2 p=(Person2)session.get(Person2.class, createdId);//查询
		session.close();//关闭会话
		try{
			List<Email> list=p.getEmails();//加载数据，将会抛出异常
			System.out.println(p.getName()+"的电子邮件：");
			for(Email mail:list){
				System.out.println("\t"+mail.getEmail());
			}
		}catch(Exception e){
			String title=e.getClass().getName();//错误信息
			String msg=e.getMessage().replace(",", ",\r\n").replace(":", ":\r\n");
			JOptionPane.showMessageDialog(null, msg,title,JOptionPane.ERROR_MESSAGE);
		}
	}
}
