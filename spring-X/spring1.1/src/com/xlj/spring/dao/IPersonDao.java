package com.xlj.spring.dao;

import java.util.List;

public interface IPersonDao {				//Person的DAO接口
	public String getPersonName(Integer id);//根据Id获取Person姓名
	public void addPerson(Person person);	//添加Person对象
	public int getPersonsCount();			//返回所有Person的数目
	public List<Person> listPersons();		//返回所有的Person
	public List findAllPersons();
}
