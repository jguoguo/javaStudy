package com.xlj.forum.service;

import java.util.List;

import org.hibernate.Query;

public interface IService<T> {
	public T find(Class<T> clazz,int id);//����id����ʵ��
	public void create(T baseBean);//����ʵ��
	public void save(T baseBean);//����ʵ��
	public void delete(T baseBean);//ɾ��ʵ��
	public List<T> list(String hql);//��ѯʵ��
	public int getTotalCount(String hql,Object...params);//��ѯ����
	public List<T> list(String hql,int firstResult,int maxSize,Object...params);//��ѯĳҳʵ��
}