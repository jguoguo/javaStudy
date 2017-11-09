package com.xlj.forum.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xlj.forum.dao.IDao;

public class DaoImpl<T> extends HibernateDaoSupport implements IDao<T> {
	
	@SuppressWarnings("unchecked")
	@Override
	public T find(Class<T> clazz, int id) {//����id����ʵ��
		return (T)getHibernateTemplate().get(clazz, id);//ʹ��Template
	}

	@Override
	public void create(T baseBean) {//����ʵ��
		getHibernateTemplate().persist(baseBean);//
	}

	@Override
	public void save(T baseBean) {
		getHibernateTemplate().save(baseBean);
	}

	@Override
	public void delete(T baseBean) {//ɾ��ʵ��
		getHibernateTemplate().delete(baseBean);//ʹ��template
	}

	@SuppressWarnings("unchecked")
	public List<T> list(String hql) {//�г�����ʵ��
		return getHibernateTemplate().find(hql);
	}

	@Override
	public int getTotalCount(String hql, Object... params) {//��ѯ����
		Query query=createQuery(hql);
		for(int i=0;params!=null && i<params.length;i++){
			query.setParameter(i+1, params[i]);//���ò���	
		}
		Object obj=createQuery(hql).uniqueResult();//��ѯ����
		
		return ((Long)obj).intValue();//��������
	}

	@SuppressWarnings("unchecked")
	public List<T> list(String hql, int firstResult, int maxSize,Object... params) {//��ѯ��ҳʵ��
		Query query=createQuery(hql);//����Query
		for(int i=0;params!=null && i<params.length;i++){
			query.setParameter(i+1, params[i]);//���ò���
		}
		List<T> list=createQuery(hql).setFirstResult(firstResult).setMaxResults(maxSize).list();//��ѯ���
		return list;
	}

	@Override
	public Query createQuery(String hql) {//����query
		return getSession().createQuery(hql);
	}

}
