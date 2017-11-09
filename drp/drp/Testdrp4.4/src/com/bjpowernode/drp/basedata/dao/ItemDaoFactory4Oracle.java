package com.bjpowernode.drp.basedata.dao;


public class ItemDaoFactory4Oracle implements ItemDaoFactory {

	@Override
	public ItemDao createItemDao() {
		return new ItemDao4OracleImpl();
	}

}
