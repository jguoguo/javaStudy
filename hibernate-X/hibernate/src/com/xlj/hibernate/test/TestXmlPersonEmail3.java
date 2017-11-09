package com.xlj.hibernate.test;

import java.util.List;

import org.hibernate.Session;

import com.xlj.hibernate.bean.Person3;
import com.xlj.hibernate.util.HibernateXMLUtil;

public class TestXmlPersonEmail3 {
	public static void main(String[] args){
		Person3 person=new Person3();
		person.setName("Jane");
		
		person.getEmails().add("yahoo@yahoo.com.cn");//ֱ�����String����
		person.getEmails().add("163@163.com");
		
		Session session=HibernateXMLUtil.getSessionFactory().openSession();//�����Ự
		session.beginTransaction();//��������
		session.persist(person);//����Person����,���Զ���������Email����
		
		List list=session.createQuery("select p from Person3 p left join fetch p.emails e"
					+" where e like '%@yahoo.com.cn' ").list();
		for(Person3 p:(List<Person3>)list){
			System.out.println("Person:"+p.getName());
			for(String e:p.getEmails()){
				System.out.println("\tEmail:"+e);
			}
		}
		session.delete(person);//ɾ��Person���󣬻��Զ�����ɾ��Email����
		session.getTransaction().commit();//�ύ����
		session.close();
	}
}
