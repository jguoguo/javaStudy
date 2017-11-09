package com.bjpowernode.drp.service.impl;


import java.util.List;

import com.bjpowernode.drp.AppException;
import com.bjpowernode.drp.dao.DataDictDao;
import com.bjpowernode.drp.domain.ItemCategory;
import com.bjpowernode.drp.domain.ItemUnit;
import com.bjpowernode.drp.service.DataDictService;

public class DataDictServiceImpl implements DataDictService {
	
	private DataDictDao dataDictDao;
	public void setDataDictDao(DataDictDao dataDictDao) {
		this.dataDictDao = dataDictDao;
	}

	/**
	 * 取得物料类别代码列表
	 */
	@Override
	public List<ItemCategory> getItemCategoryList() {
		try{
			return dataDictDao.getItemCategoryList();
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("查询物料类别失败");
		}

	}

	@Override
	public List<ItemUnit> getItemUnitList() {
		try{
			return dataDictDao.getItemUnitList();
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("查询物料单位失败");
		}

	}

}
