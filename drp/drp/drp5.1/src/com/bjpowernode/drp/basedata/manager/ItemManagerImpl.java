package com.bjpowernode.drp.basedata.manager;

import java.sql.Connection;

import com.bjpowernode.drp.basedata.dao.ItemDao;
import com.bjpowernode.drp.basedata.dao.ItemDaoFactory;
import com.bjpowernode.drp.basedata.dao.ItemDaoFactory4Oracle;
import com.bjpowernode.drp.basedata.domain.Item;
import com.bjpowernode.drp.util.ApplicationException;
import com.bjpowernode.drp.util.BeanFactory;
import com.bjpowernode.drp.util.DbUtil;
import com.bjpowernode.drp.util.PageModel;
import com.bjpowernode.drp.util.XmlConfigReader;

public class ItemManagerImpl implements ItemManager {

	private ItemDao itemDao=null;
	public ItemManagerImpl(){
		itemDao=(ItemDao)BeanFactory.getInstance().getDaoObject(ItemDao.class);
	}
	/**
	 * 添加物料
	 */
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
		//从配置文件中读取具体类
		Connection conn=null;
		try{
			conn=DbUtil.getConnection();
			itemDao.delItem(conn, itemNos);	
		}finally{
			DbUtil.close(conn);
		}// TODO Auto-generated method stub

	}

	/**
	 * 修改物料信息
	 */
	@Override
	public void modifyItem(Item item) {
		// TODO Auto-generated method stub
		Connection conn=null;
		try{
			conn=DbUtil.getConnection();
			itemDao.modifyItem(conn, item);	
		}finally{
			DbUtil.close(conn);
		}
	}

	@Override
	public Item findItemById(String itemNo) {
		Connection conn=null;
		try{
			conn=DbUtil.getConnection();
			return itemDao.findItemById(conn, itemNo);
		}finally{
			DbUtil.close(conn);
		}
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
	@Override
	public void uploadFile(String itemNo, String fileName) {
		Connection conn=null;
		try{
			conn=DbUtil.getConnection();
			Item item=itemDao.findItemById(conn, itemNo);
			item.setFileName(fileName);
			itemDao.modifyItem(conn, item);
		}catch(Exception e){
			throw new ApplicationException("上传物料图片失败");
		}finally{
			DbUtil.close(conn);
		}
		
	}

}
