package com.bjpowernode.drp.service;

import java.sql.Connection;

import com.bjpowernode.drp.BeanFactory;
import com.bjpowernode.drp.DBUtil;
import com.bjpowernode.drp.PageModel;
import com.bjpowernode.drp.dao.ItemDao;
import com.bjpowernode.drp.domain.Item;

/**
 * ���õ���ģʽʵ��
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
	 * ��ҳ��ѯ
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
	 * �޸�����
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
	 * ɾ������
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
	 * �������ϴ����ѯ
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
	 * �����ϴ��ļ�
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
