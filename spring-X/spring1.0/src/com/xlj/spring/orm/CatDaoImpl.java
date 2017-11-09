package com.xlj.spring.orm;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CatDaoImpl  implements ICatDao {
	
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void createCat(Cat cat) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.save(cat);
		//this.getHibernateTemplate().persist(cat);
	}

	@Override
	public List<Cat> listCats() {
		Session session = sessionFactory.openSession();
		return session.createQuery("select c from Cat c").list();
		//return this.getHibernateTemplate().find("select c from Cat c");
	}

	@Override
	public int getCatsCount() {
		Session session = sessionFactory.openSession();
		return session.createQuery("select count(c) from Cat c").executeUpdate();
		//Number n=(Number)this.getSession(true).createQuery("select count(c) from Cat c");
		//return n.intValue();
	}

	@Override
	public Cat findCatByName(String name) {
		Session session = sessionFactory.openSession();
		List<Cat> catList=session.createQuery("select c from Cat c where c.name=?").setParameter(1, name).list();
		//List<Cat> catList=this.getHibernateTemplate().find("select c from Cat c where c.name=?",name);
		if(catList.size()>0){//如果有数据
			return catList.get(0);//返回第一条数据
		}
		return null;
	}

}
