package com.xlj.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import com.xlj.hibernate.util.HibernateSessionFactory;
import com.xlj.hibernate.util.HibernateUtil;

public class BaseDao<T> {
	public void create(T object){
		Session session=HibernateUtil.getSessionFactory().openSession();//����һ��Hibernate�Ự
		try{
			session.beginTransaction();//��������
			session.persist(object);//�����󱣴�����ݿ�
			session.getTransaction().commit();//�ύ����
		}catch(Exception e){
			session.getTransaction().rollback();//������쳣�׳�����ع�����
		}finally{
			session.close();//�ر�Hibernate�Ự
		}
	}
	
	public void update(T object){//�������ݿ�
		Session session=HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();//��������
			session.update(object);//����object��Ӧ��������
			session.getTransaction().commit();//�ύ����
		}catch(Exception e){
			session.getTransaction().rollback();//������쳣�׳�����ع�����
		}finally{
			session.close();
		}
	}
	//�����ݿ���ɾ��
	public void delete(T object){
		Session session=HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();//��������
			session.delete(object);//ɾ��object��Ӧ��������
			session.getTransaction().commit();//�ύ����
		}catch(Exception e){
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
	}
	
	/**
	 * ���ҵ���Entity Bean
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T find(Class<? extends T> clazz, Serializable id) {

		Session session = HibernateSessionFactory.getSessionFactory()
				.openSession();
		try {
			session.beginTransaction();
			return (T) session.get(clazz, id);
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<T> list(String hql){
		Session session=HibernateSessionFactory.getSessionFactory().openSession();
		try{
			session.beginTransaction();//��������
			return session.createQuery(hql).list();
		}finally{
			session.getTransaction().commit();//�ύ����
			session.close();//�ر�Hibernate�Ự
		}
	}
}
