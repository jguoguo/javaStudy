package com.bjpowernode.drp.service;

import java.util.List;

import com.bjpowernode.drp.domain.ItemCategory;
import com.bjpowernode.drp.domain.ItemUnit;

public interface DataDictService {

	
	/**
	 * ȡ�������������б�
	 */
	public List<ItemCategory> getItemCategoryList();
	
	/**
	 * ȡ�õ�λ�б�
	 */
	public List<ItemUnit> getItemUnitList();
}
