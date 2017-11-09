package com.xlj.forum.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xlj.forum.dao.IDao;

public class DaoImpl<T> extends HibernateDaoSupport implements IDao<T> {
	
	@SuppressWarnings("unchecked")
	@Override
	public T find(Class<T> clazz, int id) {//根据id查找实体
		return (T)getHibernateTemplate().get(clazz, id);//使用Template
	}

	@Override
	public void create(T baseBean) {//创建实体
		getHibernateTemplate().persist(baseBean);//
	}

	@Override
	public void save(T baseBean) {
		getHibernateTemplate().save(baseBean);
	}

	@Override
	public void delete(T baseBean) {//删除实体
		getHibernateTemplate().delete(baseBean);//使用template
	}

	@SuppressWarnings("unchecked")
	public List<T> list(String hql) {//列出所有实体
		return getHibernateTemplate().find(hql);
	}

	@Override
	public int getTotalCount(String hql, Object... params) {//查询总数
		Query query=createQuery(hql);
		for(int i=0;params!=null && i<params.length;i++){
			query.setParameter(i+1, params[i]);//设置参数	
		}
		Object obj=createQuery(hql).uniqueResult();//查询总数
		
		return ((Long)obj).intValue();//返回总数
	}

	@SuppressWarnings("unchecked")
	public List<T> list(String hql, int firstResult, int maxSize,Object... params) {//查询分页实体
		Query query=createQuery(hql);//创建Query
		for(int i=0;params!=null && i<params.length;i++){
			query.setParameter(i+1, params[i]);//设置参数
		}
		List<T> list=createQuery(hql).setFirstResult(firstResult).setMaxResults(maxSize).list();//查询结果
		return list;
	}

	@Override
	public Query createQuery(String hql) {//创建query
		return getSession().createQuery(hql);
	}

}
