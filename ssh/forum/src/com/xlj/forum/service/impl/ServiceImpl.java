package com.xlj.forum.service.impl;

import java.util.List;

import com.xlj.forum.bean.BaseBean;
import com.xlj.forum.dao.IDao;
import com.xlj.forum.service.IService;

public abstract class ServiceImpl<T extends BaseBean> implements IService<T> {
	
	protected IDao<T> dao;//DAO对象
	
	public IDao<T> getDao() {
		return dao;
	}

	public void setDao(IDao<T> dao) {
		this.dao = dao;
	}

	@Override
	public T find(Class<T> clazz, int id) {
		return dao.find(clazz, id);
	}

	@Override
	public abstract void create(T baseBean);//创建实体，需要子类实现

	@Override
	public void save(T baseBean) {
		dao.save(baseBean);
	}

	@Override
	public void delete(T baseBean) {
		baseBean.setDeleted(true);//设置删除标志位
		dao.save(baseBean);//保存
	}

	@Override
	public List<T> list(String hql) {
		return dao.list(hql);
	}

	@Override
	public int getTotalCount(String hql, Object... params) {//查询总数
		return dao.getTotalCount(hql, params);//调用Dao
	}

	@Override
	public List<T> list(String hql, int firstResult, int maxSize,
			Object... params) {//分页实体
		return dao.list(hql, firstResult, maxSize, params);
	}

}
