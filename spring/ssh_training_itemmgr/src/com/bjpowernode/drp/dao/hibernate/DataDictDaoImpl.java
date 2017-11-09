package com.bjpowernode.drp.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bjpowernode.drp.dao.DataDictDao;
import com.bjpowernode.drp.domain.ItemCategory;
import com.bjpowernode.drp.domain.ItemUnit;

public class DataDictDaoImpl extends HibernateDaoSupport implements DataDictDao {

	@Override
	public List<ItemCategory> getItemCategoryList() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from ItemCategory");
	}

	@Override
	public List<ItemUnit> getItemUnitList() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from ItemUnit");
	}

}
