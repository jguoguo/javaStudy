package com.xlj.forum.service.impl;

import com.xlj.forum.bean.Category;
import com.xlj.forum.service.ICategoryService;

public class CategoryServiceImpl<T extends Category> extends ServiceImpl<T> implements
		ICategoryService<T> {

	@Override
	public void create(T category) {
		if(dao.createQuery("from Category c where c.name=:name and c.deleted=false ").setParameter("name", category.getName()).list().size()>0){
			throw new RuntimeException("��� "+category.getName()+"�Ѿ�����");
		}
		dao.create(category);
	}

}
