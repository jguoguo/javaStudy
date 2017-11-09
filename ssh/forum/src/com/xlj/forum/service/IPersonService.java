package com.xlj.forum.service;

import com.xlj.forum.bean.Person;

public interface IPersonService<T extends Person>  extends IService<T>{

	/*根据账号查找用户*/
	public T findPersonByAccount(String account);
	
	/*根据账号、密码查找用户*/
	public T getPerson(String account,String password);
}
