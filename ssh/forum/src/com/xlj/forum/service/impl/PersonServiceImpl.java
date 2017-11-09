package com.xlj.forum.service.impl;

import java.util.List;

import com.xlj.forum.bean.Person;
import com.xlj.forum.service.IPersonService;
import com.xlj.forum.struts.util.MD5Util;

public class PersonServiceImpl<T extends Person> extends ServiceImpl<T> implements IPersonService<T>{

	@Override
	public T findPersonByAccount(String account) {//�����˺Ų�ѯPerson
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
	public void create(T person) {//����Person
		if(findPersonByAccount(person.getAccount())!=null){//���ͬ�˺�ʵ���Ƿ����
			throw new RuntimeException("�˺�"+person.getAccount()+"�Ѿ����ڡ�");
		}
		person.setPassword(MD5Util.calc(person.getPassword()));//�������
		this.getDao().create(person);//����
	}



}
