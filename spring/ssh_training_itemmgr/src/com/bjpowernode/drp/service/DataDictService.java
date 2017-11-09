package com.bjpowernode.drp.service;

import java.util.List;

import com.bjpowernode.drp.domain.ItemCategory;
import com.bjpowernode.drp.domain.ItemUnit;

public interface DataDictService {

	
	/**
	 * 取得物料类别代码列表
	 */
	public List<ItemCategory> getItemCategoryList();
	
	/**
	 * 取得单位列表
	 */
	public List<ItemUnit> getItemUnitList();
}
