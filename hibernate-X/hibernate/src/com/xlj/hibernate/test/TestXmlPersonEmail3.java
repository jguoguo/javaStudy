package com.xlj.hibernate.test;

import java.util.List;

import org.hibernate.Session;

import com.xlj.hibernate.bean.Person3;
import com.xlj.hibernate.util.HibernateXMLUtil;

public class TestXmlPersonEmail3 {
	public static void main(String[] args){
		Person3 person=new Person3();
		person.setName("Jane");
		
		person.getEmails().add("yahoo@yahoo.com.cn");//直接添加String类型
		person.getEmails().add("163@163.com");
		
		Session session=HibernateXMLUtil.getSessionFactory().openSession();//开启会话
		session.beginTransaction();//开启事务
		session.persist(person);//保存Person对象,会自动级联保存Email对象
		
		List list=session.createQuery("select p from Person3 p left join fetch p.emails e"
					+" where e like '%@yahoo.com.cn' ").list();
		for(Person3 p:(List<Person3>)list){
			System.out.println("Person:"+p.getName());
			for(String e:p.getEmails()){
				System.out.println("\tEmail:"+e);
			}
		}
		session.delete(person);//删除Person对象，会自动级联删除Email数据
		session.getTransaction().commit();//提交事务
		session.close();
	}
}
