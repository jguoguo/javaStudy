package com.xlj.hibernate.test;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import com.xlj.hibernate.bean.Email;
import com.xlj.hibernate.bean.Person2;
import com.xlj.hibernate.util.HibernateSessionFactory;

public class TestLazyInitializationException {
	static int createdId=0;
	
	static{//����ص�ʱ�򱣴�һ��Person
		Person2 person=new Person2();
		person.setName("Jane");
		
		Email email=new Email();
		email.setEmail("yahoo@yahoo.com.cn");
		person.getEmails().add(email);
		
		Session session=HibernateSessionFactory.getSession();//��ʼ�Ự
		session.beginTransaction();//��������
		
		session.persist(person);
		createdId=person.getId();
		session.getTransaction().commit();//�ύ����
		session.close();
	}
	
	public static void main(String[] args){
		Session session=HibernateSessionFactory.getSession();//ֻ��ѯ���ÿ�������
		Person2 p=(Person2)session.get(Person2.class, createdId);//��ѯ
		session.close();//�رջỰ
		try{
			List<Email> list=p.getEmails();//�������ݣ������׳��쳣
			System.out.println(p.getName()+"�ĵ����ʼ���");
			for(Email mail:list){
				System.out.println("\t"+mail.getEmail());
			}
		}catch(Exception e){
			String title=e.getClass().getName();//������Ϣ
			String msg=e.getMessage().replace(",", ",\r\n").replace(":", ":\r\n");
			JOptionPane.showMessageDialog(null, msg,title,JOptionPane.ERROR_MESSAGE);
		}
	}
}
