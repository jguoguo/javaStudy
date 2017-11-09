package com.xlj.forum.service.impl;

import java.util.List;

import com.xlj.forum.bean.Person;
import com.xlj.forum.service.IPersonService;
import com.xlj.forum.struts.util.MD5Util;

public class PersonServiceImpl<T extends Person> extends ServiceImpl<T> implements IPersonService<T>{

	@Override
	public T findPersonByAccount(String account) {//根据账号查询Person
		List<T> person=this.getDao().createQuery("select p from Person p " +
				"where lower(p.account) =lower(:account) and deleted=false")
				.setParameter("account", account.trim()).list();
		if(person.size()>0)
			return person.get(0);
		return null;
	}

	@Override
	
	public T getPerson(String account, String password) {
		List<T> list=this.getDao().createQuery(
				"select p from Person p where p.account=:account "+
				"and p.password=:password and p.deleted=false"
				).setParameter("account", account).setParameter("password", MD5Util.calc(password)).list();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void create(T person) {//创建Person
		if(findPersonByAccount(person.getAccount())!=null){//检查同账号实体是否存在
			throw new RuntimeException("账号"+person.getAccount()+"已经存在。");
		}
		person.setPassword(MD5Util.calc(person.getPassword()));//密码加密
		this.getDao().create(person);//创建
	}



}
