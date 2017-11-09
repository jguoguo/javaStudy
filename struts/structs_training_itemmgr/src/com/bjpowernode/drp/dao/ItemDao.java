package com.bjpowernode.drp.dao;

import java.sql.Connection;

import com.bjpowernode.drp.PageModel;
import com.bjpowernode.drp.domain.Item;

public interface ItemDao {
	/**
	 * �������
	 * @param conn
	 * @param item
	 */
	public void addItem(Connection conn,Item item);
	/**
	 * ����id��ѯ
	 * @param conn
	 * @param itemNO
	 * @return
	 */
	public Item findItemById(Connection conn,String itemNO);
	/**
	 * ��ҳ��ѯ
	 * @param conn
	 * @param queryString
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageModel findAllItem(Connection conn,String queryString, int pageNo, int pageSize);
	/**
	 * �޸�����
	 * @param conn
	 * @param item
	 */
	public void modifyItem(Connection conn,Item item);
	
	/**
	 * ɾ������
	 * @param conn
	 * @param itemNos
	 */
	public void delItem(Connection conn,String[] itemNos);
	
	/**
	 * �����ϴ�ͼƬ
	 * @param conn
	 * @param itemNo
	 * @param uploadFileName
	 */
	public void modifyUploadFileNameField(Connection conn,String itemNo, String uploadFileName);
}
