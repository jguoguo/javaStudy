package com.bjpowernode.drp.basedata.manager;

import java.sql.Connection;

import com.bjpowernode.drp.basedata.dao.ItemDao;
import com.bjpowernode.drp.basedata.dao.ItemDaoFactory;
import com.bjpowernode.drp.basedata.dao.ItemDaoFactory4Oracle;
import com.bjpowernode.drp.basedata.domain.Item;
import com.bjpowernode.drp.util.DbUtil;
import com.bjpowernode.drp.util.PageModel;
import com.bjpowernode.drp.util.XmlConfigReader;

public class ItemManagerImpl implements ItemManager {

	ItemDao itemDao=null;
	public ItemManagerImpl(){
		String className=XmlConfigReader.getInstance().getDaoFactory("item-dao-factory");
		ItemDaoFactory factory=null;
		try {
			factory=(ItemDaoFactory) Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		itemDao=factory.createItemDao();
	}
	@Override
	public void addItem(Item item) {
		//从配置文件中读取具体类
		Connection conn=null;
		try{
			conn=DbUtil.getConnection();
			itemDao.addItem(conn, item);	
		}finally{
			DbUtil.close(conn);
		}

	}

	@Override
	public void delItem(String[] itemNos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyItem(Item item) {
		// TODO Auto-generated method stub

	}

	@Override
	public Item findItemById(String itemNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageModel fingItemList(int pageNo, int pageSize, String condation) {
		//从配置文件中读取具体类
		Connection conn=null;
		try{
			conn=DbUtil.getConnection();
			return itemDao.fingItemList(conn, pageNo, pageSize, condation);	
		}finally{
			DbUtil.close(conn);
		}
	}

}
