package com.xlj.spring.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class DaoRun {
	public static void main(String[] args){
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		IPersonDao personDao=(IPersonDao)factory.getBean("personDao");//»ñÈ¡Dao
		
		Person person=new Person();
		person.setName("xlj");
		person.setAge(30);
		person.setSex("ÄÐ");
		person.setBirthday(new Date());
		personDao.addPerson(person);
		System.out.println("Count:"+personDao.getPersonsCount());
		
		System.out.println(personDao.getPersonName(1));
		List<Person> personList=personDao.listPersons();
		
		for(Person p:personList){
			System.out.println("Name:"+p.getName());
		}
		
	}
}
