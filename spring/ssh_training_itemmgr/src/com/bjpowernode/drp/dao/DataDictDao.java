package com.bjpowernode.drp.dao;

import java.util.List;

import com.bjpowernode.drp.domain.ItemCategory;
import com.bjpowernode.drp.domain.ItemUnit;

public interface DataDictDao {
	/**
	 * ȡ�������������б�
	 */
	public List<ItemCategory> getItemCategoryList();
	
	/**
	 * ȡ�õ�λ�б�
	 */
	public List<ItemUnit> getItemUnitList();
}
