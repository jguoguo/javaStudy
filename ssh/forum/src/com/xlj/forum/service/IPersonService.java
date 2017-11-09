package com.xlj.forum.service;

import com.xlj.forum.bean.Person;

public interface IPersonService<T extends Person>  extends IService<T>{

	/*�����˺Ų����û�*/
	public T findPersonByAccount(String account);
	
	/*�����˺š���������û�*/
	public T getPerson(String account,String password);
}
