package com.xlj.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateXMLUtil {
	private static final SessionFactory sessionFactory;//��̬ģʽ��SessionFactory
	static{
		try{
			sessionFactory=new Configuration().configure("hibernate_xml.cfg.xml").buildSessionFactory();
		}catch(Throwable ex){
			System.err.println("Initial SessionFactory creation failed."+ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
