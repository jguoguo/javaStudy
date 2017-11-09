package com.bjpowernode.drp.service;

import java.sql.Connection;

import com.bjpowernode.drp.BeanFactory;
import com.bjpowernode.drp.DBUtil;
import com.bjpowernode.drp.PageModel;
import com.bjpowernode.drp.dao.ItemDao;
import com.bjpowernode.drp.domain.Item;

/**
 * 采用单例模式实现
 * @author Administrator
 *
 */
public class ItemServiceImpl implements ItemService {

	@Override
	public void addItem(Item item) {
		Connection conn=null;
		try{
			conn=DBUtil.getConnection();
			getItemDao().addItem(conn, item);
		}catch(Exception e){
			
		}finally{
			DBUtil.close(conn);
		}
	}

	/**
	 * 分页查询
	 */
	public PageModel findAllItem(String queryString, int pageNo, int pageSize) {
		Connection conn=null;
		PageModel pageModel=null;
		try{
			conn=DBUtil.getConnection();
			pageModel=getItemDao().findAllItem(conn, queryString, pageNo, pageSize);
		}finally{
			DBUtil.close(conn);
		}
		return pageModel;
	}

	/**
	 * 修改物料
	 */
	public void modifyItem(Item item) {
		Connection conn=null;
		try{
			conn=DBUtil.getConnection();
			getItemDao().modifyItem(conn, item);
		}finally{
			DBUtil.close(conn);
		}

	}

	/**
	 * 删除物料
	 */
	public void delItem(String[] itemNos) {
		Connection conn=null;
		try{
			conn=DBUtil.getConnection();
			getItemDao().delItem(conn, itemNos);
		}finally{
			DBUtil.close(conn);
		}
	}

	/**
	 * 根据物料代码查询
	 */
	public Item findItemById(String itemNo) {
		Connection conn=null;
		Item item=null;
		try{
			conn=DBUtil.getConnection();
			item=getItemDao().findItemById(conn, itemNo);
		}finally{
			DBUtil.close(conn);
		}
		return item;
	}

	/**
	 * 保存上传文件
	 */
	public void modifyUploadFileNameField(String itemNo, String uploadFileName) {
		Connection conn=null;
		try{
			conn=DBUtil.getConnection();
			getItemDao().modifyUploadFileNameField(conn, itemNo, uploadFileName);
		}finally{
			DBUtil.close(conn);
		}
	}
	
	private ItemDao getItemDao(){
		ItemDao itemDao=(ItemDao)BeanFactory.getInstance().getBean(ItemDao.class);
		return itemDao;
	}
}
