package com.xlj.spring.example;

public class ServiceImpl implements IService{
	
	private IDao dao;//����һ��IDao����
	public IDao getDao() {
		return dao;
	}
	public void setDao(IDao dao) {
		this.dao = dao;
	}
	@Override
	public void service(String name) {
		System.out.println(dao.sayHello(name));
	}

}
