package com.xlj.spring.dao;

import java.util.List;

public interface IPersonDao {				//Person��DAO�ӿ�
	public String getPersonName(Integer id);//����Id��ȡPerson����
	public void addPerson(Person person);	//���Person����
	public int getPersonsCount();			//��������Person����Ŀ
	public List<Person> listPersons();		//�������е�Person
	public List findAllPersons();
}
