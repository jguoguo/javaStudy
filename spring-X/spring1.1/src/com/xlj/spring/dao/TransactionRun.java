package com.xlj.spring.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TransactionRun {
	private IPersonDao personDao;

	public IPersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(IPersonDao personDao) {
		this.personDao = personDao;
	}
	
	public void run(){
		Person person=new Person();
		person.setName("事务回滚");
		person.setAge(30);
		person.setSex("男");
		person.setBirthday(new Date());
		
		personDao.addPerson(person);
		System.out.println("Count:"+personDao.getPersonsCount());
		
		System.out.println(personDao.getPersonName(Integer.MAX_VALUE));//抛出异常
		List<Person> personList=personDao.findAllPersons();//查询所有的Person
		
		for(Person p:personList){
			System.out.println("Name:"+p.getName());
		}
	}
	
	public static void main(String[] args) {

		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"applicationContext.xml"));

		TransactionRun transactionRun = (TransactionRun) factory
				.getBean("transactionRun");

		transactionRun.run();
		
	}

}
